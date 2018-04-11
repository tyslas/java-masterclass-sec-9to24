package com.tito;

import java.util.ArrayList;

public class Branch {
  private String headBank;
  private String name;
  private String location;
  private ArrayList<Customer> customers;

  public Branch(String headBank, String branchName, String branchLocation) {
    this.headBank = headBank;
    this.name = branchName;
    this.location = branchLocation;
    this.customers = new ArrayList<Customer>();
  }

  public static Branch createBranch(String headBank, String branchName, String branchLocation) {
    return new Branch(headBank, branchName, branchLocation);
  }

  public boolean newCustomer(String customerName, double initialAmt) {
    if (findCustomer(customerName) == null) {
      this.customers.add(new Customer(customerName, initialAmt));
      return true;
    }
    return false;
  }

  public boolean addCustomerTransaction(String customerName, double amt) {
    Customer existingCustomer = findCustomer(customerName);
    if (existingCustomer != null) {
      existingCustomer.addTransaction(amt);
      return true;
    }
    return false;
  }

  private Customer findCustomer(String customerName) {
    for (int i = 0; i < customers.size(); i++) {
      Customer checkedCustomer = this.customers.get(i);
      if (checkedCustomer.getName().equals(customerName)) {
        return checkedCustomer;
      }
    }
    return null;
  }

  public String getHeadBank() {
    return headBank;
  }

  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public ArrayList<Customer> getCustomers() {
    return customers;
  }
}
