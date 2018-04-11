package com.tito;

import java.util.ArrayList;

public class Bank {
  private String bankName;
  private String countryOfOperation;
  private ArrayList<Branch> branches;
  private ArrayList<Customer> customers;
  private ArrayList<Transaction> transactions;

  public Bank(String bankName, String countryOfOperation) {
    this.bankName = bankName;
    this.countryOfOperation = countryOfOperation;
    this.branches = new ArrayList<Branch>();
  }

  // solution implementation
  public boolean addBranch(String headBank, String branchName, String branchLocation) {
    if (findBranch(branchName) == null) {
      this.branches.add(new Branch(headBank, branchName, branchLocation));
      return true;
    }
    return false;
  }

  // my implementation
//  public boolean addBranch(Branch newBranch) {
//    if (findBranch(newBranch.getName()) >= 0) {
//      System.out.println("error: branch is already on file, cannot add duplicate");
//      return false;
//    }
//
//    branches.add(newBranch);
//    return true;
//  }

  // solution implementation
  private Branch findBranch(String branchName) {
    for (int i = 0; i < branches.size(); i++) {
      Branch checkedBranch = this.branches.get(i);
      if (checkedBranch.getName().equals(branchName)) {
        return checkedBranch;
      }
    }
    return null;
  }

  // my implementation
//  private int findBranch(String branchName) {
//    for (int i = 0; i < this.branches.size(); i++) {
//      Branch branch = this.branches.get(i);
//      if (branch.getName().equals(branchName)) {
//        return i;
//      }
//    }
//    return -1;
//  }

  public void printBranches() {
    System.out.println("list of branches:");
    for (int i = 0; i < this.branches.size(); i++) {
      System.out.println((i + 1) + ". name: " + this.branches.get(i).getName() + " - location: " + this.branches.get(i).getLocation());
    }
  }

  public boolean addCustomer(Customer newCustomer) {
    if (findCustomer(newCustomer.getName()) >= 0) {
      System.out.println("error: customer is already on file, cannot add duplicate");
      return false;
    }

    customers.add(newCustomer);
    return true;
  }

  public boolean addCustomer(String branchName, String customerName, double initialAmt) {
    Branch branch = findBranch(branchName);
    if (branch != null) {
      return branch.newCustomer(customerName, initialAmt);
    }
    return false;
  }

  private int findCustomer(String customerName) {
    for (int i = 0; i < this.customers.size(); i++) {
      Customer customer = this.customers.get(i);
      if (customer.getName().equals(customerName)) {
        return i;
      }
    }
    return -1;
  }

  public boolean listCustomers(String branchName, boolean showTransactions) {
    Branch branch = findBranch(branchName);
    if (branch != null) {
      System.out.println("customer details for branch " + branch.getName());
      ArrayList<Customer> branchCustomers = branch.getCustomers();
      for (int i = 0; i < branchCustomers.size(); i++) {
        Customer branchCustomer = branchCustomers.get(i);
        System.out.println("customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
        if (showTransactions) {
          System.out.println("transactions");
          ArrayList<Double> transactions = branchCustomer.getTransactions();
          for (int j = 0; j < transactions.size(); j++) {
            System.out.println("[" + (j + 1) + "] amount " + transactions.get(j));
          }
        }
      }
      return true;
    } else {
      return false;
    }
  }

  public void printCustomers() {
    System.out.println("list of customers:");
    for (int i = 0; i < this.customers.size(); i++) {
      System.out.println((i + 1) + ". name: " + this.customers.get(i).getName());
    }
  }

  public boolean addCustomerTransaction(String branchName, String customerName, double amt) {
    Branch branch = findBranch(branchName);
    if (branch != null) {
      return branch.addCustomerTransaction(customerName, amt);
    }
    return false;
  }

  public boolean addTransaction(Transaction newTransaction) {
    transactions.add(newTransaction);
    return true;
  }

  public String getCountryOfOperation() {
    return countryOfOperation;
  }

  public String getBankName() {
    return bankName;
  }

  public ArrayList<Branch> getBranches() {
    return branches;
  }

}
