/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mvc.controller;

import com.mycompany.mvc.model.Users;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class UserController {

    ArrayList<Users> users = new ArrayList<>();

    public boolean login(String userName, String passWord) {
        for (Users us : users) {
            if ((us.getUserName().equals(userName)) && (us.getPassWord().equals(passWord))) {
                return true;
            }
        }
        if ((userName.equals("admin")) && (passWord.equals("admin"))) {
            return true;
        }
        return false;
    }

    public boolean addUser(String userName, String passWord) {
        if (findUser(userName) == null) {
            Users us = new Users(userName, passWord);
            users.add(us);
            return true;
        }
        return false;
    }

    public Users findUser(String userName) {
        for (Users us : users) {
            if (us.getUserName().equalsIgnoreCase(userName)) {
                return us;
            }
        }
        return null;
    }

    public boolean delUser(String userName) {
        if (findUser(userName) != null) {
            Users us = findUser(userName);
            users.remove(us);
            return true;
        }
        return false;
    }

}
