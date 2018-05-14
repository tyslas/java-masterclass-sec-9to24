package com.tito;

public class Main {

  public static void main(String[] args) {
    // using ITelephone instead of DeskPhone allows the variable
    // myPhone to be reassigned as a MobilePhone object
    ITelephone myPhone;
    myPhone = new DeskPhone(123456);
    myPhone.powerOn();
    myPhone.callPhone(123456);
    myPhone.answer();

    System.out.println("=========================================================");

    myPhone = new MobilePhone(24567);
    myPhone.powerOn();
    myPhone.callPhone(24567);
    myPhone.answer();
  }
}
