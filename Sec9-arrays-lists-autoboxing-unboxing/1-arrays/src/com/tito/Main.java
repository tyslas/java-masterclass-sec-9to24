package com.tito;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    // Create a program using arrays that sorts a list of integers in descending order.
    // Descending order is highest value to lowest.
      // e.g. [106, 26, 81, 5, 15] -> [106, 81, 26, 15, 5]
    // Set up the program so that the numbers to sort are read in from the keyboard.
    // Implement the following methods - getIntegers, printArray, and sortIntegers
      // getIntegers returns an array of entered integers from keyboard
      // printArray prints out the contents of the array
      // sortIntegers should sort the array and return a new array containing the sorted numbers
    // you will have to figure out how to copy the array elements from the passed array into a new
    // array and sort them and return the new sorted array.

    int[] myIntArray = new int[25]; // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int i = 0; i < myIntArray.length; i++) {
      myIntArray[i] = i*10;
    }

    int[] myIntegers = getIntegers(5);
    int[] sorted = sortIntegers(myIntegers);
    printArray(myIntegers);
    printArray(sorted);

//    System.out.println("the average is " + getAverage(myIntegers));
  }

  public static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.println("element " + i + ", value is " + array[i]);
    }
  }

  public static int[] getIntegers(int number) {
    System.out.println("enter " + number + " integer values\r");
    int[] values = new int[number];

    for (int i = 0; i < values.length; i++) {
      values[i] = scanner.nextInt();
    }
    return values;
  }

  public static int[] sortIntegers(int[] arr) {
    int[] sortedArray = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      sortedArray[i] = arr[i];
    }
    boolean flag = true;
    int tmp;
    while(flag) {
      for (int i = 0; i < sortedArray.length - 1; i++) {
        if (sortedArray[i] < sortedArray[i + 1]) {
          tmp = sortedArray[i];
          sortedArray[i] = sortedArray[i + 1];
          sortedArray[i + 1] = tmp;
          flag = true;
        }
      }
    }
    return sortedArray;
  }

  public static double getAverage(int[] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    return (double) sum / (double) array.length;
  }
}
