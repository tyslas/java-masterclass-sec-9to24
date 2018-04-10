package com.tito;

import java.util.ArrayList;

public class Customer {
  private String name;
  private ArrayList<Transaction> transactions;

  public Customer(String name) {
    this.name = name;
    this.transactions = new ArrayList<Transaction>();
  }
}
