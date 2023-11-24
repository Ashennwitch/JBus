package com.HanifNurIlhamSanjayaJBusBR;


import com.HanifNurIlhamSanjayaJBusBR.dbjson.Serializable;

/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable {
    // instance variables - replace the example below with your own
    public String email;
    public String name;
    public String password;
    //public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$";
    //public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=\\S+$).{8,}$";
    public Renter company;
    public double balance;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z_]+?\\.[a-zA-Z.]+[a-zA-Z]+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    public Account(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.company = null;
        this.balance = 0.0;
    }

    public Object write() {
        return null;
    }

    public String toString() {
        return "Account ID: " + super.id + "\n"
                + "Account name: " + name + "\n"
                + "Email: " + email + "\n"
                + "Password: " + password;
    }

    public boolean validate() {
        return email.matches(REGEX_EMAIL) && password.matches(REGEX_PASSWORD);
    }

    public boolean topUp(double amount) {

        if (amount <= 0) {
            return false;
        }

        // Perform the top-up
        this.balance += amount;
        return true;
    }

}