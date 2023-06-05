package com.aar.atm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'RM '###,##0.00");

    private int accNo;
    private int pinNo;
    private double currentBalance = 0;
    private double savingsBalance = 0;

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public int getPinNo() {
        return pinNo;
    }

    public void setPinNo(int pinNo) {
        this.pinNo = pinNo;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double withdrawSavingsOperation(double amount) {
        savingsBalance = savingsBalance - amount;
        return savingsBalance;
    }

    public double withdrawCurrentOperation(double amount) {
        currentBalance = currentBalance - amount;
        return currentBalance;
    }

    public double depositSavingsOperation(double amount){
        savingsBalance = savingsBalance + amount;
        return savingsBalance;
    }

    public double depositCurrentOperation(double amount){
        currentBalance = currentBalance + amount;
        return currentBalance;
    }

    public void withdrawCurrentMoney() {
        System.out.println("Account balance : " + moneyFormat.format(getCurrentBalance()));
        System.out.println("Please enter amount to withdraw : ");
        double withdrawAmount = menuInput.nextDouble();

        if((currentBalance-withdrawAmount) > 0) {
            withdrawCurrentOperation(withdrawAmount);
            System.out.println("Balance after withdraw : " + moneyFormat.format(getCurrentBalance()));
        } else {
            System.out.println("Sorry, balance cannot be negative");
        }
    }

    public void withdrawSavingsMoney() {
        System.out.println("Account balance : " + moneyFormat.format(getSavingsBalance()));
        System.out.println("Please enter amount to withdraw : ");
        double withdrawAmount = menuInput.nextDouble();

        if((savingsBalance-withdrawAmount) > 0) {
            withdrawSavingsOperation(withdrawAmount);
            System.out.println("Balance after withdraw : " + moneyFormat.format(getSavingsBalance()));
        } else {
            System.out.println("Sorry, balance cannot be negative");
        }
    }

    public void depositCurrentMoney() {
        System.out.println("Account balance : " + moneyFormat.format(getCurrentBalance()));
        System.out.println("Please enter amount to deposit : ");
        double depositAmount = menuInput.nextDouble();

        if ((currentBalance + depositAmount) >= 0) {
            depositCurrentOperation(depositAmount);
            System.out.println("Balance after deposit : " + moneyFormat.format(getCurrentBalance()));
        } else {
            System.out.println("Sorry, balance cannot be negative");
        }
    }

    public void depositSavingsMoney() {
        System.out.println("Account balance : " + moneyFormat.format(getSavingsBalance()));
        System.out.println("Please enter amount to deposit : ");
        double depositAmount = menuInput.nextDouble();

        if ((savingsBalance + depositAmount) >= 0) {
            depositSavingsOperation(depositAmount);
            System.out.println("Balance after deposit : " + moneyFormat.format(getSavingsBalance()));
        } else {
            System.out.println("Sorry, balance cannot be negative");
        }
    }


}
