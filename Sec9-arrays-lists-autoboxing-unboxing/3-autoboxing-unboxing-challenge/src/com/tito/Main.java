package com.tito;

import java.util.Scanner;

public class Main {
  private static Scanner scanner = new Scanner(System.in);
  private static Branch newBranch = new Branch("First Bank", "Branch 1", "Denver, CO");
  private static Bank myBank = new Bank("First Bank", "USA");

  public static void main(String[] args) {
    // CHALLENGE:
    // You job is to create a simple banking application.
    // There should be a Bank class
    // It should have an arraylist of Branches
    // Each Branch should have an arraylist of Customers
    // The Customer class should have an arraylist of Doubles (transactions)
    // Customer:
    // Name, and the ArrayList of doubles.
    // Branch:
    // Need to be able to add a new customer and initial transaction amount.
    // Also needs to add additional transactions for that customer/branch
    // Bank:
    // Add a new branch
    // Add a customer to that branch with initial transaction
    // Add a transaction for an existing customer for that branch
    // Show a list of customers for a particular branch and optionally a list
    // of their transactions
    // Demonstration of autoboxing and unboxing in your code
    // Hint: Transactions
    // Add data validation.
    // e.g. check for existence, etc.
    // Think about where you are adding the code to perform certain actions

    Bank bank = new Bank("US Bank", "United States");

    bank.addBranch("US Bank", "Denver", "DU");
    bank.addCustomer("Denver", "Tito", 156.82);
    bank.addCustomer("Denver", "Cisco", 204.43);
    bank.addCustomer("Denver", "Zeke", 110.55);

    bank.addBranch("US Bank", "Los Angeles", "DTLA");
    bank.addCustomer("Los Angeles", "Brian", 132.68);

    bank.addCustomerTransaction("Denver", "Zeke", 83.14);
    bank.addCustomerTransaction("Denver", "Cisco", -12.58);
    bank.addCustomerTransaction("Los Angeles", "Brian", -69.72);
    bank.addCustomerTransaction("Denver", "Tito", -169.63);

    bank.listCustomers("Denver", true);
    bank.listCustomers("Los Angeles", false);

    bank.addBranch("National Bank of Australia", "Melbourne", "by the sea");
    if (!bank.addCustomer("Melbourne", "Brian", 5.53)) {
      System.out.println("error: Melbourne branch does not exist");
    }
    
    if (!bank.addBranch("US Bank", "Denver", "DU")) {
      System.out.println("Denver branch already exists");
    }

//    boolean quit = false;
//    startTerminal();
//    printActions();
//    while (!quit) {
//      System.out.println("enter action (6 shows available actions):");
//      int action = scanner.nextInt();
//      scanner.nextLine();
//
//      switch (action) {
//        case 0:
//          System.out.println("\nshutting down...");
//          quit = true;
//          break;
//        case 1:
////          addNewBranch();
//          break;
//        case 2:
//          myBank.printBranches();
//          break;
//        case 3:
////          addNewCustomer();
//          break;
//        case 4:
////          addTransaction();
//          break;
//        case 5:
//          myBank.printCustomers();
//          break;
//        case 6:
//          printActions();
//          break;
//      }
//    }
  }

//  public static void startTerminal() {
//    System.out.println("welcome to the banking terminal");
//  }
//
//  public static void printActions() {
//    System.out.println("\navailable actions:\npress");
//    System.out.println("\t 0 - to exit");
//    System.out.println("\t 1 - to add a new branch");
//    System.out.println("\t 2 - to print a list of branches");
//    System.out.println("\t 3 - to add a new customer");
//    System.out.println("\t 4 - to add transactions to an existing customer");
//    System.out.println("\t 5 - to print a list of customers");
//    System.out.println("\t 6 - print list of available actions");
//    System.out.println("choose your action");
//  }

//  private static void addNewBranch() {
//    System.out.println("enter head bank of new branch: ");
//    String headBank = scanner.nextLine();
//    System.out.println("enter branch name: ");
//    String branchName = scanner.nextLine();
//    System.out.println("enter branch location: ");
//    String branchLocation = scanner.nextLine();
//    Branch newBranch = Branch.createBranch(headBank, branchName, branchLocation);
//    if (myBank.addBranch(newBranch)) {
//      System.out.println("new branch added: name - " + branchName + ", location - " + branchLocation);
//    } else {
//      System.out.println("cannot add: " + branchName + " is already on file ");
//    }
//  }

//  private static void addNewCustomer() {
//    System.out.println("enter name: ");
//    String newName = scanner.nextLine();
//    System.out.println("enter initial deposit: ");
//    double initTransaction = Double.parseDouble(scanner.nextLine());
//    Customer newCustomer = Customer.createCustomer(newName, initTransaction);
//    if (myBank.addCustomer(newCustomer)) {
//      System.out.println("new customer added: name - " + newName + ", initial deposit - " + initTransaction);
//    } else {
//      System.out.println("error: " + newName + " is already on file, cannot add duplicate");
//    }
//  }

}
