package com.bridgelabz.main;

import java.util.Scanner;

/*@desc:Main class representing the Address Book program.*/
public class Main {

	/*
	 * @desc:Displays the contacts
	 * 
	 * @params:none
	 * 
	 * @retrun:none
	 */
	public static void main(String[] args) {
		System.out.println("WELCOME TO ADDRESS BOOK!!");
		AddressBook address = new AddressBook();
		// <---------------USE CASE 13-------------------->
		Scanner scanner = new Scanner(System.in);
		char choice;
		do {
			address.readContactsInFile(scanner);
			System.out.println("Do you want to add another employee? (y/n): ");
			choice = scanner.next().charAt(0);
		} while (choice == 'y' || choice == 'Y');

		address.writeContactsInFile(address.contacts);

		// <---------------USE CASE 3-------------------->
		System.out.print("Do you want to edit an existing contact? (yes/no): ");
		String editOption = scanner.nextLine();
		if (editOption.equalsIgnoreCase("yes")) {
			address.editExistingContact(scanner);
		}

		// <---------------USE CASE 4-------------------->
		// Option to delete an existing contact
		System.out.print("Do you want to delete an existing contact? (yes/no): ");
		String deleteOption = scanner.nextLine();
		if (deleteOption.equalsIgnoreCase("yes")) {
			address.deleteContactByName(scanner);
		}
		address.display();

		// <---------------USE CASE 7-------------------->
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

		// <---------------USE CASE 8&9-------------------->
		System.out.print("Enter city to view persons: ");
		String cityToView = scanner.nextLine();
		address.printPersonsByCity(cityToView);
		System.out.print("Enter state to view persons: ");
		String stateToView = scanner.nextLine();
		address.printPersonsByState(stateToView);

		// <---------------USE CASE 10-------------------->
		// Additional functionality for printing count by city and state
		System.out.print("Enter a city to get the count of persons: ");
		String cityToCount = scanner.nextLine();
		address.printPersonsByCity(cityToCount);

		System.out.print("Enter a state to get the count of persons: ");
		String stateToCount = scanner.nextLine();
		address.printPersonsByState(stateToCount);

		// <---------------USE CASE 11&12-------------------->
		System.out.print(
				"Do you want to print contacts in sorted manner using which parameter? (NAME, CITY ,STATE ,ZIP): ");
		String sortOption = scanner.nextLine();
		if (sortOption.equalsIgnoreCase("name")) {
			address.printSortedByName();
		} else if (sortOption.equalsIgnoreCase("city")) {
			address.printSortedByCity();
		}

		else if (sortOption.equalsIgnoreCase("state")) {
			address.printSortedByState();
		}

		else if (sortOption.equalsIgnoreCase("ZIP")) {
			address.printSortedByZip();
		}

		scanner.close();
	}

}