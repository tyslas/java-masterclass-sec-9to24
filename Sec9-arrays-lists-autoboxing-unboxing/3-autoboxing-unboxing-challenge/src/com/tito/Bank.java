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

  public boolean addBranch(Branch newBranch) {
    if (findBranch(newBranch.getBranchName()) >= 0) {
      System.out.println("error: branch is already on file, cannot add duplicate");
      return false;
    }

    branches.add(newBranch);
    return true;
  }

  private int findBranch(String branchName) {
    for (int i = 0; i < this.branches.size(); i++) {
      Branch branch = this.branches.get(i);
      if (branch.getBranchName().equals(branchName)) {
        return i;
      }
    }
    return -1;
  }

  public void printBranches() {
    System.out.println("list of branches:");
    for (int i = 0; i < this.branches.size(); i++) {
      System.out.println((i + 1) + ". name: " + this.branches.get(i).getBranchName() + " - location: " + this.branches.get(i).getBranchLocation());
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


  public void printCustomers() {
    System.out.println("list of customers:");
    for (int i = 0; i < this.customers.size(); i++) {
      System.out.println((i + 1) + ". name: " + this.customers.get(i).getName());
    }
  }

  public String getBankName() {
    return bankName;
  }

  public boolean addTransaction(Transaction newTransaction) {
    transactions.add(newTransaction);
    return true;
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

  public String getCountryOfOperation() {
    return countryOfOperation;
  }

  public ArrayList<Branch> getBranches() {
    return branches;
  }

}
