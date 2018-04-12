package com.tito;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
  public static void main(String[] args) {
    LinkedList<String> placesToVisit = new LinkedList<String>();
    addInOrder(placesToVisit, "Sydney");
    addInOrder(placesToVisit, "Melbourne");
    addInOrder(placesToVisit, "Brisbane");
    addInOrder(placesToVisit, "Perth");
    addInOrder(placesToVisit, "Canberra");
    addInOrder(placesToVisit, "Adelaide");
    addInOrder(placesToVisit, "Darwin");
    printList(placesToVisit);

    addInOrder(placesToVisit, "Alice Springs");
    addInOrder(placesToVisit, "Darwin");
    printList(placesToVisit);
    visit(placesToVisit);

//    placesToVisit.add("Sydney");
//    placesToVisit.add("Melbourne");
//    placesToVisit.add("Brisbane");
//    placesToVisit.add("Perth");
//    placesToVisit.add("Canberra");
//    placesToVisit.add("Adelaide");
//    placesToVisit.add("Darwin");
//
//    printList(placesToVisit);
//
//    placesToVisit.add(1, "Alice Springs");
//    printList(placesToVisit);
//
//    placesToVisit.remove(4);
//    printList(placesToVisit);
  }

  private static void printList(LinkedList<String> linkedList) {
    Iterator<String> i = linkedList.iterator();
    while (i.hasNext()) {
      System.out.println("now visiting " + i.next());
    }
    System.out.println("=======================");
  }

  private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
    ListIterator<String> stringListIterator = linkedList.listIterator();
    while (stringListIterator.hasNext()) {
      // must use the .next() to get to load the first element of stringListIterator
      int comparison = stringListIterator.next().compareTo(newCity);
      if (comparison == 0) {
        // cities are the same - don't add
        System.out.println(newCity + " is already an included destination");
        return false;
      } else if (comparison > 0) {
        // the new city will be inserted before the one that it is comparing to
        // Brisbane -> Adelaide
        stringListIterator.previous();
        stringListIterator.add(newCity);
        return true;
      } else if (comparison < 0) {
        // move on to next city
      }
    }
    stringListIterator.add(newCity);
    return true;
  }

  private static void visit(LinkedList cities) {
    Scanner scanner = new Scanner(System.in);
    boolean quit = false;
    boolean goingForward = true;
    ListIterator<String> listIterator = cities.listIterator();

    if (cities.isEmpty()) {
      System.out.println("no cities in the itinerary");
    } else {
      System.out.println("now visiting " + listIterator.next());
      printMenu();
    }
    while (!quit) {
      int action = scanner.nextInt();
      scanner.nextLine();
      switch (action) {
        case 0:
          System.out.println("holiday is over");
          quit = true;
          break;
        case 1:
          if (!goingForward) {
            if (listIterator.hasNext()) {
              listIterator.next();
            }
            goingForward = true;
          }
          if (listIterator.hasNext()) {
            System.out.println("now visiting " + listIterator.next());
          } else {
            System.out.println("reached the final city in the list already");
            goingForward = false;
          }
          break;
        case 2:
          if (goingForward) {
            if (listIterator.hasPrevious()) {
              listIterator.previous();
            }
            goingForward = false;
          }
          if (listIterator.hasPrevious()) {
            System.out.println("now visiting " + listIterator.previous());
          } else {
            System.out.println("visiting the first city in the list");
            goingForward = true;
          }
          break;
        case 3:
          printMenu();
          break;
      }
    }
  }

  private static void printMenu() {
    System.out.println("available actions: \npress ");
    System.out.println("0 - to quit\n" +
        "1 - go to next city\n" +
        "2 - go to previous city\n" +
        "3 - print menu options");
  }
}

