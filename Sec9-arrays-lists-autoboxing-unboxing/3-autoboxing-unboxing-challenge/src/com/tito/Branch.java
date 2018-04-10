package com.tito;

import java.util.ArrayList;

public class Branch {
  private String headBank;
  private String branchName;
  private String branchLocation;
  private ArrayList<Customer> customers;

  public Branch(String headBank, String branchName, String branchLocation) {
    this.headBank = headBank;
    this.branchName = branchName;
    this.branchLocation = branchLocation;
    this.customers = new ArrayList<Customer>();
  }

  public static Branch createBranch(String headBank, String branchName, String branchLocation) {
    return new Branch(headBank, branchName, branchLocation);
  }

  public String getHeadBank() {
    return headBank;
  }

  public String getBranchName() {
    return branchName;
  }

  public String getBranchLocation() {
    return branchLocation;
  }
}
