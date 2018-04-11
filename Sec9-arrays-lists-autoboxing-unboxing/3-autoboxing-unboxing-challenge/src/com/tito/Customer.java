package com.tito;

import java.util.ArrayList;

public class Customer {
  private String name;
  private ArrayList<Double> transactions;
//  private ArrayList<Transaction> transactions;

  public Customer(String name, double initialAmt) {
    this.name = name;
    this.transactions = new ArrayList<Double>();
    addTransaction(initialAmt);
//    this.transactions = new ArrayList<Transaction>();
  }

  public void addTransaction(double amount) {
    this.transactions.add(amount);
  }

  public String getName() {
    return name;
  }

  public ArrayList<Double> getTransactions() {
    return transactions;
  }

  //    return createTransaction(transaction);
  //
  //  private static Transaction createNewTransaction(double transaction) {
  //
  //  }
  //    return new Customer(name, transaction);
  //    Transaction transaction = new transactions.;
//  public static Customer createCustomer(String name, double initialTransaction) {

//  }
}
