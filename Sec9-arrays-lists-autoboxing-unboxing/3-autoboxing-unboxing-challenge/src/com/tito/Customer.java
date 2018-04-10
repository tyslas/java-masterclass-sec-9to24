package com.tito;

import java.util.ArrayList;

public class Customer {
  private String name;
  private ArrayList<Transaction> transactions;

  public Customer(String name, Transaction initialTransaction) {
    this.name = name;
    // saldfklsdakfh
    this.transactions = new ArrayList<Transaction>();
  }

  public static Customer createCustomer(String name, double initialTransaction) {
    Transaction transaction = new transactions.;
    return new Customer(name, transaction);
  }

  private static Transaction createNewTransaction(double transaction) {

    return createTransaction(transaction);
  }


  public String getName() {
    return name;
  }

}
