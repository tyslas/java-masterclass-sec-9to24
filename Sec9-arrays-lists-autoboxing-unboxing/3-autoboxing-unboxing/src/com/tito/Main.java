package com.tito;

import java.lang.reflect.Array;
import java.util.ArrayList;

class IntClass {
  private int myValue;

  public IntClass(int myValue) {
    this.myValue = myValue;
  }

  public int getMyValue() {
    return myValue;
  }

  public void setMyValue(int myValue) {
    this.myValue = myValue;
  }
}
public class Main {

  public static void main(String[] args) {
    String[] strArr = new String[10];
    int[] intArr = new int[10];

    ArrayList<String> stringArrList = new ArrayList<String>();
    stringArrList.add("Allen");

//    ArrayList<int> intArrList = new ArrayList<int>(); // primitive types will cannot be used -> datatype must be a 'class' so that it can be passed as an object
    ArrayList<IntClass> intClassArrList = new ArrayList<IntClass>();
    intClassArrList.add(new IntClass(54));

    Integer integer = new Integer(54); // class Int
    Double doubleValue = new Double(5.55);

    ArrayList<Integer> intArrayList = new ArrayList<Integer>();

    for (int i = 0; i <= 10; i++) {
      intArrayList.add(Integer.valueOf(i));
    }


    for (int i = 0; i <= 10; i++) {
//      System.out.println(i + " --> " + intArrayList.get(i).intValue());
    }

    Integer myIntValue = 56; // Integer.valueOf(56)
    int myInt = myIntValue; // myIntValue.intValue()
    System.out.println("myInt: " + myInt);

    ArrayList<Double> myDoubleValues = new ArrayList<Double>();
    for (double dbl = 0.0; dbl <= 10.0; dbl += .5) {
      myDoubleValues.add(dbl);
    }

    for (int i = 0; i < myDoubleValues.size(); i++) {
      double value = myDoubleValues.get(i);
      System.out.println(i + " --> " + value);
    }
  }
}
