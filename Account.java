/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mvc.model;

/**
 *
 * @author Admin
 */
public class Account {

    private int accountNumber;
    private String accountName;
    private int accountBalance;
    //private int depositamt;

    public Account(int accountNumber, String accountName, int accountBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

//    public int getDeposit() {
//        return depositamt;
//    }
//
//    public void setDeposit(int depositamt) {
//        this.depositamt = depositamt;
//    }

  

}
