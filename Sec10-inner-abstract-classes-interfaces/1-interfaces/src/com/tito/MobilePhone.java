package com.tito;

public class MobilePhone implements ITelephone {
  private int myNumber;
  private boolean isRinging;
  private boolean isOn = false;

  public MobilePhone(int myNumber) {
    this.myNumber = myNumber;
    this.isRinging = false;
  }

  @Override
  public void powerOn() {
    isOn = true;
    System.out.println("mobile phone powered up");
  }

  @Override
  public void dial(int phoneNumber) {
    if (isOn) {
      System.out.println("now ringing " + phoneNumber + " on desktop");
    } else {
      System.out.println("phone is switched off");
    }
  }

  @Override
  public void answer() {
    if (isRinging) {
      System.out.println("answering the mobile phone (" + myNumber + ")");
      isRinging = false;
    }
  }

  @Override
  public boolean callPhone(int phoneNumber) {
    if (phoneNumber == myNumber && isOn) {
      isRinging = true;
      System.out.println("melody playing");
    } else {
      isRinging = false;
      System.out.println("mobile phone not on - or different number");
    }

    return isRinging;
  }

  @Override
  public boolean isRinging() {
    return isRinging;
  }
}

