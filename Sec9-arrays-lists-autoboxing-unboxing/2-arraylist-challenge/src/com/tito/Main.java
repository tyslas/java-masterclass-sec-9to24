package com.tito;

import java.util.Scanner;

public class Main {
  private static Scanner scanner = new Scanner(System.in);
  private static Phone myPhone = new Phone("303-438-9947");

  public static void main(String[] args) {
    // Create a program that implements a simple mobile phone with the following capabilities.
    // Able to store, modify, remove and query contact names.
    // You will want to create a separate class for Contacts (name and phone number).
    // Create a master class (MobilePhone) that holds the ArrayList of Contacts
    // The MobilePhone class has the functionality listed above.
    // Add a menu of options that are available.
    // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
    // and search/find contact.
    // When adding or updating be sure to check if the contact already exists (use name)
    // Be sure not to expose the inner workings of the Arraylist to MobilePhone
    // e.g. no ints, no .get(i) etc
    // MobilePhone should do everything with Contact objects only.

    boolean quit = false;
    startPhone();
    printActions();
    while (!quit) {
      System.out.println("enter action (6 shows available actions):");
      int action = scanner.nextInt();
      scanner.nextLine();

      switch (action) {
        case 0:
          System.out.println("\nshutting down...");
          quit = true;
          break;
        case 1:
          myPhone.printContacts();
          break;
        case 2:
          addNewContact();
          break;
        case 3:
          updateContact();
          break;
        case 4:
          removeContact();
          break;
        case 5:
          queryContact();
          break;
        case 6:
          printActions();
          break;
      }
    }
  }

  public static void startPhone() {
    System.out.println("starting phone...");
  }

  public static void printActions() {
    System.out.println("\navailable actions:\npress");
    System.out.println("\t 0 - to shutdown);
    System.out.println("\t 1 - to print contacts");
    System.out.println("\t 2 - to add a new contact");
    System.out.println("\t 3 - to update an existing a contact");
    System.out.println("\t 4 - to remove an existing contact");
    System.out.println("\t 5 - query for a contact");
    System.out.println("\t 6 - print list of available actions");
    System.out.println("choose your action");
  }

  private static void addNewContact() {
    System.out.println("enter new contact name: ");
    String name = scanner.nextLine();
    System.out.println("enter phone number: ");
    String phone = scanner.nextLine();
    Contacts newContact = Contacts.createContact(name, phone);
    if (myPhone.addContact(newContact)) {
      System.out.println("new contact added: name - " + name + ", phone - " + phone);
    } else {
      System.out.println("cannot add: " + name + " is already on file ");
    }
  }

  private static void updateContact() {
    System.out.println("enter existing contact nane");
    String name = scanner.nextLine();
    Contacts existingContactRecord = myPhone.queryContact(name);
    if (existingContactRecord == null) {
      System.out.println("contact not found");
      return;
    }

  }
}
