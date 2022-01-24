/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mvc.view;

import com.mycompany.mvc.controller.AccountController;
import com.mycompany.mvc.controller.UserController;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class myMainView {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static AccountController ac = new AccountController();
        static UserController uc = new UserController();

    public static void main(String[] args) {
        // TODO code application logic here
        boolean exit = false;
        while (!exit) {
            if (loginView()) {
                int ch;
                do {
                    System.out.println("Welcome!!!");
                    System.out.println("Enter respective number");
                    System.out.println("1) Add Account");
                    System.out.println("2)Check Balance");
                    System.out.println("3)Deposite Amount");
                    System.out.println("4)Withdraw Amount");
                    System.out.println("5)Transfer Amount");
                    System.out.println("6) Show Account Details");
                    System.out.println("7) Delete Account");
                    System.out.println("8) Add User");
                    System.out.println("9) Delete User");
                    System.out.println("Press 0 to logout");

                    ch = sc.nextInt();
                    switch (ch) {
                        case 0:
                            break;
                        case 1:
                            addAccountView();
                            break;
                        case 2:
                            checkBalance();
                            break;
                        case 3:
                            depositBalc();
                            break;
                        case 4:
                            widrawtBalc();
                            break;
                        case 5:
                            transferBalc();
                            break;
                        case 6:
                            showAcc();
                            break;
                        case 7:
                            DelAcc();
                            break;
                        case 8:
                            addUser();
                            break;
                        case 9:
                            delUser();
                            break;

                        default:
                            System.out.println("Enter appropriate choice");
                    }
                } while (ch != 0);
            }
            System.out.println("Press any key to relogin and n to exit");
            char input = sc.next().charAt(0);
            if (input == 'n') {
                exit = true;
            }
        }
    }

    public static void checkBalance() {
        System.out.println("Enter Account Number");
        int accountNumber = sc.nextInt();
        ac.checkBalance(accountNumber);

    }

    public static void depositBalc() {
        System.out.println("Enter Account Number");
        int accountNumber = sc.nextInt();
        System.out.println("Enter Amount:");
        int depositamt = sc.nextInt();
        boolean x = ac.depositBalc(accountNumber, depositamt);
        if (x == true) {
            System.out.println("Account Balance added successfully");
        } else {
            System.out.println("Account Doesn't exists");
        }

    }

    public static void widrawtBalc() {
        System.out.println("Enter Account Number");
        int accountNumber = sc.nextInt();
        System.out.println("Enter Amount:");
        int widamt = sc.nextInt();
        int y = ac.widrawtBalc(accountNumber, widamt);
        if (y == 1) {
            System.out.println("Account withdraw successfully");
        } else if (y == -1) {
            System.out.println("Insufficent balance");
        } else {
            System.out.println("Account Doesn't exists");
        }

    }

    public static void transferBalc() {
        System.out.println("Enter Sender Account Number");
        int accountNumber = sc.nextInt();
        System.out.println("Enter Receiver Account Number");
        int transAcNum = sc.nextInt();
        System.out.println("Enter Amount:");
        int widamt = sc.nextInt();
        int z = ac.transferBalc(accountNumber, transAcNum, widamt);
        if (z == 1) {
            System.out.println("Account Transfer successfully");
        } else if (z == -1) {
            System.out.println("Insufficent balance");
        } else {
            System.out.println("Account Doesn't exists");
        }

    }

    public static void DelAcc() {
        System.out.println("Enter Account Number to Delete:");
        int accountNumber = sc.nextInt();
        if (ac.DelAcc(accountNumber) == 1) {
            System.out.println("Account Deleted Succefully");
        } else {
            System.out.println("Account Doesn't Exists");
        }

    }

    public static void showAcc() {
        System.out.println("Enter Account Number");
        int accountNumber = sc.nextInt();
        ac.showAcc(accountNumber);

    }

    public static void addAccountView() {
        System.out.println("Enter Account Number");
        int accountNumber = sc.nextInt();
        System.out.println("Enter Account Name");
        String accountName = sc.next();
        System.out.println("Enter Account Opening Balance");
        int accountBalance = sc.nextInt();
        if (ac.addAccount(accountNumber, accountName, accountBalance)) {
            System.out.println("Account Added Successully");
        } else {
            System.out.println("Account already exists");
        }
    }

    public static boolean loginView() {
        System.out.println("Enter Username: ");
        String userName = sc.next();
        System.out.println("Enter Password: ");
        String passWord = sc.next();
        return uc.login(userName, passWord);

    }
     public static void addUser() {
        System.out.println("Login again to add user");
        if (loginView()) {
            System.out.println("Enter new username");
            String userName = sc.next();
            System.out.println("Enter new password");
            String passWord = sc.next();
            System.out.println("Enter new password again");
            String temp = sc.next();
            if (passWord.equals(temp)) {
                if (uc.addUser(userName, passWord)) {
                    System.out.println("User added sucessfully");
                } else {
                    System.out.println("Username already exist");
                }
            } else {
                System.out.println("Password didn't match");
            }

        } else {
            System.out.println("Invalid Login");
        }
    }

    public static void delUser() {
        System.out.println("Login again to delete user");
        if (loginView()) {
            System.out.println("Enter username to delete");
            String userName = sc.next();
            if (uc.delUser(userName)) {
                System.out.println("Username deleted");
            } else {
                System.out.println("Username doesn't exist");
            }
        }
    }


}
