package com.tito;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
  private double transactionAMT;
  private String dateAndTime;

  public Transaction(double transactionAMT) {
    this.transactionAMT = transactionAMT;
    this.dateAndTime = this.getCurrDateAndTime();
  }

  private String getCurrDateAndTime() {
    DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    Date dateObj = new Date();
    String currDateAndTime = df.format(dateObj);
    System.out.println(currDateAndTime);
    return currDateAndTime;
  }

  public Transaction createTransaction(double initialTransaction) {
    return new Transaction(initialTransaction);
  }

  public double getTransactionAMT() {
    return transactionAMT;
  }

  public String getDateAndTime() {
    return dateAndTime;
  }
}
