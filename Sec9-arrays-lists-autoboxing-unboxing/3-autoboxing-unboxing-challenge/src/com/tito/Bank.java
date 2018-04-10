package com.tito;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;

public class Bank {
  private String bankName;
  private String countryOfOperation;
  private ArrayList<Branch> branches;

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

  public void 

  public String getBankName() {
    return bankName;
  }

  public String getCountryOfOperation() {
    return countryOfOperation;
  }

  public ArrayList<Branch> getBranches() {
    return branches;
  }

}
