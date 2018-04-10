package com.tito;

public class Branch {
  private String headBank;
  private String branchName;
  private String branchLocation;

  public Branch(String headBank, String branchName, String branchLocation) {
    this.headBank = headBank;
    this.branchName = branchName;
    this.branchLocation = branchLocation;
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
