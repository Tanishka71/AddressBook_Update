package com.bridgelabz.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



/*@desc:Class representing the entire address book.
@params:ArrayList(Contacts)
@methods:non-parameterized contstructor, display, addContact,findContact, editContact, addContact,deleteContact
*/
class Address{

    private ArrayList<Contact> contacts;

    public Address(){
        contacts = new ArrayList<Contact>();
    }
    
	/*
	 * @desc: to add individual conatcts in  ArrayList
	 * @params:Object Contact
	 * @return:none
	 */
    public void addContact(Contact contact) {
        // Check for duplicates using Java Streams
        boolean isDuplicate = contacts.stream().anyMatch(c -> c.equals(contact));

        if (!isDuplicate) {
            contacts.add(contact);
            System.out.println("Contact added successfully");
        } else {
            System.out.println("Duplicate entry. Contact not added.");
        }
    }
    
	/*
	 * @desc: to print the contacts of a particular city
	 * @params:Object Contact
	 * @return:none
	 */
    public void printSameCity(String cityContact) {

    	List<Contact> sameCityContacts=contacts.stream()
    			.filter(c -> c.getCity().equals(cityContact))
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
	 * @params:Object Contact
	 * @return:none
	 */
    public void printSameState(String stateToMatch) {

    	List<Contact> sameCityContacts=contacts.stream()
    			.filter(c -> c.getState().equals(stateToMatch))
    			.collect(Collectors.toList());
    	if (sameCityContacts.isEmpty()) {
            System.out.println("No contacts in the same city as provided contact.");
        } else {
            System.out.println("Contacts in the same city as provided contact:");
            sameCityContacts.forEach(System.out::println);
        }    
    }
    
	/*
	 * @desc: to display individual conatcts in  ArrayList
	 * @params:none
	 * @return:none
	 */
    public void display() {
        if(contacts.isEmpty()){
            System.out.println("No contacts in the address book");
        }else{
            System.out.println("Address book updated\n");
            for(Contact c : contacts){
                System.out.println(c);
                System.out.println();    
        }
        }  
    }
    
	/*
	 * @desc:Finds a contact in the address book by first name and last name.
	 * @params:String
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
   
	/*
	 * @desc:Edits an existing contact's information based on user input.
	 * @params:Scanner
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
    
    
	/*
	 * @desc:Deletes a contact from the address book by first name and last name.
	 * @params:Scanner
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
}


