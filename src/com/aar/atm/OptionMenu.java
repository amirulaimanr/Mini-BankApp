package com.aar.atm;

import java.util.HashMap;

public class OptionMenu extends Account{

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();


    public void login() {

        int x = 1;
        do {
            try {
                data.put(123456, 00000);
                data.put(112233, 99999);

                System.out.println("ATM BANK APPLICATION");
                System.out.println("Please insert information below to login");

                System.out.print("Account Number : ");
                setAccNo(menuInput.nextInt());

                System.out.print("PIN Number: ");
                setPinNo(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("\n" + "Incorrect input details, please input only numbers");
                x = 2;
            }

            int acc = getAccNo();
            int pin = getPinNo();

            if(data.containsKey(acc) && data.get(acc) == pin) {
                getAccountOption();
            }
            x++;
        } while (x==1);
    }

    public void getAccountOption() {
        System.out.println("\nSelect account you want to access\n");
        System.out.println("1. Savings account");
        System.out.println("2. Current account");
        System.out.println("3. Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 :
                getSavings();
                break;
            case 2 :
                getCurrent();
                break;
            case 3 :
                System.out.println("Thank you for using this atm machine. Goodbye");
                break;
            default :
                System.out.println("Invalid request");

        }

    }

    public void getCurrent() {
        System.out.println("\nCurrent Account :\n");
        System.out.println("1. View balance");
        System.out.println("2. Withdraw funds");
        System.out.println("3. Deposit funds");
        System.out.println("4. Back");

        int currentIn = menuInput.nextInt();

        switch (currentIn) {
            case 1:
                System.out.println("Current account balance : " + moneyFormat.format(getCurrentBalance()));
                getCurrent();
                break;
            case 2:
                withdrawCurrentMoney();
                getCurrent();
                break;
            case 3:
                depositCurrentMoney();
                getCurrent();
                break;
            case 4:
                getAccountOption();
                break;
        }
    }

    public void getSavings() {
        System.out.println("\nSavings Account :\n");
        System.out.println("1. View balance");
        System.out.println("2. Withdraw funds");
        System.out.println("3. Deposit funds");
        System.out.println("4. Back");

        int savingsIn = menuInput.nextInt();

        switch (savingsIn) {
            case 1:
                System.out.println("Savings account balance : " + moneyFormat.format(getSavingsBalance()));
                getSavings();
                break;
            case 2:
                withdrawSavingsMoney();
                getSavings();
                break;
            case 3:
                depositSavingsMoney();
                getSavings();
                break;
            case 4:
                getAccountOption();
                break;
        }
    }

}
