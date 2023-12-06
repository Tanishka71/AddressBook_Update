package com.bridgelabz.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*@desc:Class representing the entire address book.
@params:ArrayList(Contacts)
@methods:non-parameterized contstructor, display, addContact,findContact, editContact, addContact,deleteContact
*/
class AddressBook {
	List<Contact> contacts;
	private Map<String, List<Contact>> cityDictionary;
	private Map<String, List<Contact>> stateDictionary;

	public AddressBook() {
		contacts = new ArrayList<>();
		cityDictionary = new HashMap<>();
		stateDictionary = new HashMap<>();
	}

	// <-------USE CASE 1----->
	/*
	 * @desc: to add individual conatcts in ArrayList
	 * 
	 * @params:Object Contact
	 * 
	 * @return:none
	 */
	public void addContact(Contact contact) {
		// Check for duplicates using Java Streams
		boolean isDuplicate = contacts.stream().anyMatch(c -> c.equals(contact));

		// Update city dictionary
		cityDictionary.computeIfAbsent(contact.getCity(), k -> new ArrayList<>()).add(contact);

		// Update state dictionary
		stateDictionary.computeIfAbsent(contact.getState(), k -> new ArrayList<>()).add(contact);

		if (!isDuplicate) {
			contacts.add(contact);
			System.out.println("Contact added successfully");
		} else {
			System.out.println("Duplicate entry. Contact not added.");
		}
	}

	// <-------USE CASE 3----->
	/*
	 * @desc:Edits an existing contact's information based on user input.
	 * 
	 * @params:Scanner
	 * 
	 * @return:none
	 */
	public void editExistingContact(Scanner scanner) {
		System.out.print("Enter the first name of the contact to edit: ");
		String firstNameToEdit = scanner.nextLine();

		System.out.print("Enter the last name of the contact to edit: ");
		String lastNameToEdit = scanner.nextLine();

		Contact existingContact = findContactByName(firstNameToEdit, lastNameToEdit);

		if (existingContact != null) {
			System.out.println("Existing Contact Details:");
			System.out.println(existingContact);
			boolean updateMore = true;
			while (updateMore) {
				// Get updated information
				System.out.println("Enter the information to update (address/city/state/zip/phone/email): ");
				String infoToUpdate = scanner.nextLine();
				switch (infoToUpdate.toLowerCase()) {
				case "address":
					System.out.print("Enter updated address: ");
					existingContact.setAddress(scanner.nextLine());
					break;
				case "city":
					System.out.print("Enter updated city: ");
					existingContact.setCity(scanner.nextLine());
					break;
				case "state":
					System.out.print("Enter updated state: ");
					existingContact.setState(scanner.nextLine());
					break;
				case "zip":
					System.out.print("Enter updated ZIP Code: ");
					existingContact.setZip(scanner.nextLine());
					break;
				case "phone":
					System.out.print("Enter updated phone number: ");
					existingContact.setPhone(scanner.nextLine());
					break;
				case "email":
					System.out.print("Enter updated email: ");
					existingContact.setEmail(scanner.nextLine());
					break;
				default:
					System.out.println("Invalid information type. No updates performed.");
				}

				System.out.print("Do you want to update anything more for this contact? (yes/no): ");
				String updateMoreOption = scanner.nextLine();
				updateMore = updateMoreOption.equalsIgnoreCase("yes");
			}

			System.out.println("Contact updated successfully");
		} else {
			System.out.println("Contact not found");
		}
	}

	// <-------USE CASE 4----->
	/*
	 * @desc:Deletes a contact from the address book by first name and last name.
	 * 
	 * @params:Scanner
	 * 
	 * @retrun:none
	 */
	public void deleteContactByName(Scanner scanner) {
		System.out.print("Enter the first name of the contact to delete: ");
		String firstNameToDelete = scanner.nextLine();

		System.out.print("Enter the last name of the contact to delete: ");
		String lastNameToDelete = scanner.nextLine();

		Contact contactToRemove = findContactByName(firstNameToDelete, lastNameToDelete);

		if (contactToRemove != null) {
			contacts.remove(contactToRemove);
			System.out.println("Contact deleted successfully");
		} else {
			System.out.println("Contact not found. Deletion failed.");
		}
	}

	// <-------USE CASE 7------>
	/*
	 * @desc:Finds a contact in the address book by first name and last name.
	 * 
	 * @params:String
	 * 
	 * @return:Object
	 */
	public Contact findContactByName(String firstName, String lastName) {
		for (Contact contact : contacts) {
			if (contact.getFname().equalsIgnoreCase(firstName) && contact.getLname().equalsIgnoreCase(lastName)) {
				return contact;
			}
		}
		return null; // Contact not found
	}

	// <-------USE CASE 8------>
	/*
	 * @desc: to print the contacts of a particular city
	 * 
	 * @params:String Contact
	 * 
	 * @return:none
	 */
	public void printSameCity(String cityContact) {

		List<Contact> sameCityContacts = contacts.stream().filter(c -> c.getCity().equals(cityContact))
				.collect(Collectors.toList());
		if (sameCityContacts.isEmpty()) {
			System.out.println("No contacts in the same city as provided contact.");
		} else {
			System.out.println("Contacts in the same city as provided contact:");
			sameCityContacts.forEach(System.out::println);
		}
	}

	/*
	 * @desc: to print the contacts of a particular address
	 * 
	 * @params:String Contact
	 * 
	 * @return:none
	 */
	public void printSameState(String stateToMatch) {
		List<Contact> sameStateContacts = contacts.stream().filter(c -> c.getState().equalsIgnoreCase(stateToMatch))
				.collect(Collectors.toList());

		if (sameStateContacts.isEmpty()) {
			System.out.println("No contacts in the same state as provided contact.");
		} else {
			System.out.println("Contacts in the same state as provided contact:");
			sameStateContacts.forEach(System.out::println);
		}
	}

	// <-----------------USE CASE 9------------------->
	/*
	 * @desc: to print the contacts of a particular CITY
	 * 
	 * @params:String Contact
	 * 
	 * @return:none
	 */
	public void printPersonsByCity(String city) {
		List<Contact> personsInCity = cityDictionary.getOrDefault(city, new ArrayList<>());
		long count = personsInCity.stream().count();

		if (count > 0) {
			System.out.println("Number of persons in the city '" + city + "': " + count);
			personsInCity.forEach(System.out::println);
		} else {
			System.out.println("No persons found in the city: " + city);
		}
	}

	/*
	 * @desc: to print the contacts of a particular STATE
	 * 
	 * @params:String Contact
	 * 
	 * @return:none
	 */
	public void printPersonsByState(String state) {
		List<Contact> personsInState = stateDictionary.getOrDefault(state, new ArrayList<>());
		long count = personsInState.stream().count();

		if (count > 0) {
			System.out.println("Number of persons in the state '" + state + "': " + count);
			personsInState.forEach(System.out::println);
		} else {
			System.out.println("No persons found in the state: " + state);
		}
	}

	/*
	 * @desc: to display individual conatcts in ArrayList
	 * 
	 * @params:none
	 * 
	 * @return:none
	 */
	public void display() {
		if (contacts.isEmpty()) {
			System.out.println("No contacts in the address book");
		} else {
			contacts.forEach(System.out::println);
		}

	}

	// <---------------USE CASE 11-------------------->
	/*
	 * @desc: to print the contacts in sorted manner for first name
	 * 
	 * @params:none
	 * 
	 * @return:none
	 */
	public void printSortedByName() {
		contacts = contacts.stream().sorted(Comparator.comparing(Contact::getFname)).collect(Collectors.toList());
		System.out.println("CONTACTS IN SORTED ORDER BY NAME ARE: ");
		display();
	}

	// <---------------USE CASE 12-------------------->
	/*
	 * @desc: to print the contacts in sorted manner for CITY
	 * 
	 * @params:none
	 * 
	 * @return:none
	 */
	public void printSortedByCity() {
		contacts = contacts.stream().sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());
		System.out.println("CONTACTS IN SORTED ORDER BY CITY ARE: ");
		display();
	}

	/*
	 * @desc: to print the contacts in sorted manner BY STATE
	 * 
	 * @params:none
	 * 
	 * @return:none
	 */
	public void printSortedByState() {
		contacts = contacts.stream().sorted(Comparator.comparing(Contact::getState)).collect(Collectors.toList());
		System.out.println("CONTACTS IN SORTED ORDER BY STATE ARE: ");
		display();
	}

	/*
	 * @desc: to print the contacts in sorted manner BY ZIP
	 * 
	 * @params:none
	 * 
	 * @return:none
	 */
	public void printSortedByZip() {
		contacts = contacts.stream().sorted(Comparator.comparing(Contact::getZip)).collect(Collectors.toList());
		System.out.println("CONTACTS IN SORTED ORDER BY STATE ARE: ");
		display();
	}

	// <---------------USE CASE 13-------------------->
	/*
	 * @desc: read the data for the file
	 * 
	 * @params:scanner input
	 * 
	 * @return:none
	 */
	public void readContactsInFile(Scanner scanner) {

		System.out.print("Enter first name: ");
		String fname = scanner.nextLine();

		System.out.print("Enter last name: ");
		String lname = scanner.nextLine();

		System.out.print("Enter address: ");
		String addressStr = scanner.nextLine();

		System.out.print("Enter city: ");
		String city = scanner.nextLine();

		System.out.print("Enter state: ");
		String state = scanner.nextLine();

		System.out.print("Enter zip: ");
		String zip = scanner.nextLine();

		System.out.print("Enter phone number: ");
		String phone = scanner.nextLine();

		System.out.print("Enter email: ");
		String email = scanner.nextLine();

		Contact newContact = new Contact(fname, lname, addressStr, city, state, zip, phone, email);
		addContact(newContact);

	}

	/*
	 * @desc: to write the contacts in the file in string form
	 * 
	 * @params:none
	 * 
	 * @return:none
	 */
	public void writeContactsInFile(List<Contact> contacts) {
		StringBuffer buffer = new StringBuffer();
		contacts.forEach(contact -> {
			String contactDataString = contact.toString().concat("\n");
			buffer.append(contactDataString);
		});
		try {
			Files.write(Paths.get("address_diary.txt"), buffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
