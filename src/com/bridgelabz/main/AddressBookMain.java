package com.bridgelabz.main;

import java.util.Scanner;

/*@desc:Main class representing the Address Book program.*/
public class AddressBookMain {
	
	
	/*
	 * @desc:Displays the contacts
	 * @params:none
	 * @retrun:none
	 */
	public static void main(String []args) {
		System.out.println("WELCOME TO ADDRESS BOOK!!");
		

		        Address address = new Address();

		        Scanner scanner = new Scanner(System.in);
		        
		        boolean addMoreContacts = true;

		        while (addMoreContacts) {
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
		        address.addContact(newContact);

	            System.out.print("Do you want to add another contact? (yes/no): ");
	            String addAnother = scanner.nextLine();

	            addMoreContacts = addAnother.equalsIgnoreCase("yes");
		        }

		        // Option to edit an existing contact
		        System.out.print("Do you want to edit an existing contact? (yes/no): ");
		        String editOption = scanner.nextLine();

		        if (editOption.equalsIgnoreCase("yes")) {
		            address.editExistingContact(scanner);
		        }
                
		        
		        // Option to delete an existing contact
		        System.out.print("Do you want to delete an existing contact? (yes/no): ");
		        String deleteOption = scanner.nextLine();

		        if (deleteOption.equalsIgnoreCase("yes")) {
		            address.deleteContactByName(scanner);
		        }

		        address.display();
		        // search contacts from the same city
		        System.out.print("Do you want to print contacts from the same city? (yes/no): ");
		        String printSameCityOption = scanner.nextLine();

		        if (printSameCityOption.equalsIgnoreCase("yes")) {
		            System.out.print("Enter city to match: ");
		            String cityToMatch = scanner.nextLine();

		            
		            address.printSameCity(cityToMatch);
		        }
                
		        // search contacts from the same state
		        System.out.print("Do you want to print contacts from the same state? (yes/no): ");
		        String printSameStateOption = scanner.nextLine();

		        if (printSameStateOption.equalsIgnoreCase("yes")) {
		            System.out.print("Enter state to match: ");
		            String stateToMatch = scanner.nextLine();

		            
		            address.printSameState(stateToMatch);
		        }
		        
		        
		        //list of person in same city or state
	
		        System.out.print("Enter city to view persons: ");
		        String cityToView = scanner.nextLine();
		        address.printPersonsByCity(cityToView);

		     
		        System.out.print("Enter state to view persons: ");
		        String stateToView = scanner.nextLine();
		        address.printPersonsByState(stateToView);

		        // Additional functionality for printing count by city and state
		        System.out.print("Enter a city to get the count of persons: ");
		        String cityToCount = scanner.nextLine();
		        address.printPersonsByCity(cityToCount);

		        System.out.print("Enter a state to get the count of persons: ");
		        String stateToCount = scanner.nextLine();
		        address.printPersonsByState(stateToCount);
		        scanner.close();
	}
 

	}
