package com.tito;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo {
  public static void main(String[] args) {
    LinkedList<String> placesToVisit = new LinkedList<String>();
    placesToVisit.add("Sydney");
    placesToVisit.add("Melbourne");
    placesToVisit.add("Brisbane");
    placesToVisit.add("Perth");
    placesToVisit.add("Canberra");
    placesToVisit.add("Adelaide");
    placesToVisit.add("Darwin");

    printList(placesToVisit);

    placesToVisit.add(1, "Alice Springs");
    printList(placesToVisit);

    placesToVisit.remove(4);
    printList(placesToVisit);
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
  }
}
