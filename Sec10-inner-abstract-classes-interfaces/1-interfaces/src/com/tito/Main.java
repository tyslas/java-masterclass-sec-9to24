package com.tito;

public class Main {

  public static void main(String[] args) {
    ITelephone myPhone;
    myPhone = new DeskPhone(123456);
    myPhone.powerOn();
    myPhone.callPhone(123456);
    myPhone.answer();
  }
}
