/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mvc.controller;

import com.mycompany.mvc.model.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AccountController {

    ArrayList<Account> accounts = new ArrayList<>();
    DbConnection db = new DbConnection();

    public Account validate(int accountNumber) {
//for DBMS
        String sql = "select * from bankdb.account where accountNumber=" + accountNumber + ":";
        ResultSet rs = db.select(sql);
        try {
            while (rs.next()) {
                Account acc = new Account(rs.getInt(1), rs.getString(2), rs.getInt(3));
                return acc;
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

//for array list
//        for (Account acc : accounts) {
//            if (acc.getAccountNumber() == accountNumber) {
//                return acc;
//            }
//        }
//        return null;
    public boolean addAccount(int accountNumber, String accountName, int accountBalance) {
        //Account acc = new Account(accountNumber, accountName, accountBalance);
        if (validate(accountNumber) == null) {
            String sql = "INSERT INTO 'bankdb'.'account' ('accountNumber','accountName','accountBalance') VALUES('" + accountNumber + "','" + accountName + "','" + accountBalance + "')";
            return db.iud(sql);
        }
        return false;
    }

    public void checkBalance(int accountNumber) {
        if (validate(accountNumber) != null) {
            Account acc = validate(accountNumber);
            System.out.println("Balance is:" + acc.getAccountBalance());

        } else {
            System.out.println("Account Doesn't Exists");
        }
    }

    public boolean depositBalc(int accountNumber, int depositamt) {
        if (validate(accountNumber) != null) {
            Account acc = validate(accountNumber);
            acc.setAccountBalance(acc.getAccountBalance() + depositamt);
            String sql = "UPDATE 'bankdb'.'account' set 'acountBalance = '" + acc.getAccountBalance() + "' where ('accountNumber' ='" + accountNumber + "')";
            return db.iud(sql);

        } else {
            return false;

        }
    }

    public int widrawtBalc(int accountNumber, int widamt) {
        if (validate(accountNumber) != null) {
            Account acc = validate(accountNumber);
            if (acc.getAccountBalance() >= widamt) {
                acc.setAccountBalance(acc.getAccountBalance() - widamt);
                String sql = "UPDATE 'bankdb'.'account' set 'acountBalance = '" + acc.getAccountBalance() + "' where ('accountNumber' ='" + accountNumber + "');";
                if (db.iud(sql)) {
                    return 1;
                }

            } else {
                return -1;
            }

        }
        return 0;
    }

    public int transferBalc(int accountNumber, int transAcNum, int widamt) {
        if ((validate(accountNumber) != null) && (validate(transAcNum) != null)) {
            Account acc = validate(accountNumber);
            Account tras = validate(transAcNum);
            {
                if (acc.getAccountBalance() >= widamt) {
                    acc.setAccountBalance(acc.getAccountBalance() - widamt);
                    tras.setAccountBalance(acc.getAccountBalance() + widamt);
                    String sql = "UPDATE 'bankdb'.'account' set 'acountBalance = '" + acc.getAccountBalance() + "' where ('accountNumber' ='" + accountNumber + "');";
                    String sql1 = "UPDATE 'bankdb'.'account' set 'acountBalance = '" + acc.getAccountBalance() + "' where ('accountNumber' ='" + transAcNum + "');";
                    System.out.println("Transfered Balance is" + widamt);
                    if (db.iud(sql) && db.iud(sql1)) {
                        return 1;
                    }

                } else {
                    return -1;
                }
            }

        }

        return 0;

    }

    public int DelAcc(int accountNumber) {
        if (validate(accountNumber) != null) {
            Account acc = validate(accountNumber);
            accounts.remove(acc);
            return 1;
        } else {
            return 0;
        }
    }

    public void showAcc(int accountNumber) {
        if (validate(accountNumber) != null) {
            Account acc = validate(accountNumber);
            if (acc.getAccountNumber() == accountNumber) {
                System.out.println("Account Number: " + acc.getAccountNumber());
                System.out.println("Account Name: " + acc.getAccountName());
                System.out.println("Account Balance: " + acc.getAccountBalance());
            } else {
                System.out.println("Account doesn't exists");
            }
        }
    }
}
