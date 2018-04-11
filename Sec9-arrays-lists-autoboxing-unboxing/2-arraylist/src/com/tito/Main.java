package com.tito;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static Scanner scanner = new Scanner(System.in);
  private static GroceryList groceryList = new GroceryList();

  public static void main(String[] args) {
    boolean quit = false;
    int choice = 0;
    printInstructions();
    while (!quit) {
      System.out.println("enter your choice: ");
      choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 0:
          printInstructions();
          break;
        case 1:
          groceryList.printGroceryList();
          break;
        case 2:
          addItem();
          break;
        case 3:
          modifyItem();
          break;
        case 4:
          removeItem();
          break;
        case 5:
          searchForItem();
          break;
        case 6:
          processArrayList();
        case 7:
          quit = true;
          break;
      }
    }
  }

  private static void processArrayList() {
    ArrayList<String> newArray = new ArrayList<String>();
    newArray.addAll(groceryList.getGroceryList());
    // or you can do this in a single line
    ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());
    // or convert to an array
    String[] myArray = new String[groceryList.getGroceryList().size()];
    myArray = groceryList.getGroceryList().toArray(myArray);
  }

  public static void printInstructions() {
    System.out.println("\npress ");
    System.out.println("\t 0 - to print choice options");
    System.out.println("\t 1 - to print the list of grocery items");
    System.out.println("\t 2 - to add an item to the list");
    System.out.println("\t 3 - to modify an item in the list");
    System.out.println("\t 4 - to remove an item from the list");
    System.out.println("\t 5 - to search for an item in the list");
    System.out.println("\t 6 - to quit the application");
  }

  public static void addItem() {
    System.out.print("please enter the grocery item: ");
    groceryList.addGroceryItem(scanner.nextLine());
  }

  public static void modifyItem() {
    System.out.println("name of item to replace: ");
    String itemNo = scanner.nextLine();
    System.out.println("enter replacement item: ");
    String newItem = scanner.nextLine();
    groceryList.modifyGroceryItem(itemNo,newItem);
  }

  public static void removeItem() {
    System.out.println("enter item name: ");
    String itemNo = scanner.nextLine();
    groceryList.removeGroceryItem(itemNo);
  }

  public static void searchForItem() {
    System.out.println("item to search for: ");
    String searchItem = scanner.nextLine();
    if (groceryList.onFile(searchItem) ) {
      System.out.println("found " + searchItem + " in our grocery list");
    } else {
      System.out.println(searchItem + " is not in the shopping list");
    }
  }
}
