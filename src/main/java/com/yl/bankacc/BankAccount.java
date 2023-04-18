package com.yl.bankacc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class BankAccount {
    private final String fullName;
    private String accountNumber;
    private float balance;
    private boolean isClosed;
    private Date accountStartDate;
    private Date accountEndDate;
    private List<String> transactions;

    public BankAccount(String fullName, String accountNumber) {
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.balance = 0.0f;
        this.accountStartDate = new Date();
        transactions = new ArrayList<>();
    }

    public BankAccount(String fullName, String accountNumber, float balance) {
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountStartDate = new Date();
        transactions = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    

    public Date getAccountEndDate() {
        return accountEndDate;
    }

    public void setAccountEndDate(Date accountEndDate) {
        this.accountEndDate = accountEndDate;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
        this.accountEndDate = new Date();
    }

    public Date getAccountStartDate() {
        return accountStartDate;
    }

    public void setAccountStartDate(Date accountStartDate) {
        this.accountStartDate = accountStartDate;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }


    
    @Override
    public String toString() {
        // return "BankAccount [fullName= " + fullName + ", accountNumber= " + accountNumber + ", balance= " + balance
        //         + ", isClosed= " + isClosed + ", accountStartDate= " + accountStartDate + ", transactions= " + transactions
        //         + "]\n";

        return "BankAccount [fullName= " + fullName + ", accountNumber= " + accountNumber + ", balance= " + balance
        + ", isClosed= " + isClosed + ", accountStartDate= " + accountStartDate + ", accountEndDate= " + accountEndDate
        + "]\n";
    }

    public void showAccount(){
        System.out.println("Account fullname: " + fullName);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: " + balance+"\n");

    }

    public void deposit(float amount) {

        if (isClosed) {
            throw new IllegalArgumentException(
                    "Account closed/inactive. You cannot make a deposit to a closed/inactive account.");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("You cannot make a negative amount deposit.");
        } else {
            balance += amount;
            Date dt = new Date();
            transactions.add("Deposit " + amount + " to account " + accountNumber + " on " + dt.toString());
        }

    }



    public void withdraw(float amount) {

        if (isClosed) {
            throw new IllegalArgumentException(
                    "Account closed/inactive. You cannot make a withdrawal to a closed/inactive account.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("You cannot withdraw a negative amount.");
        } else {
            balance -= amount;
            Date dt = new Date();
            transactions.add("Withdraw " + amount + " to account " + accountNumber + " on " + dt.toString());
        }

    }

public static void main (String[] args){
    BankAccount myBank = new BankAccount("Yenleng", "001-001-001", 100000);
    System.out.println(myBank.toString());

    myBank.deposit(9999);
    System.out.println(myBank.toString());

    myBank.setClosed(true);
    System.out.println(myBank.toString());



    for(String transDetails : myBank.getTransactions()){
        System.out.println("Transaction Details:\n" + transDetails);
    }


    //Fixed Arrays

    int n = 5; //to have 5 bank accounts
    BankAccount[] bankAcct = new BankAccount[n];

    for(int i = 0; i < bankAcct.length; i++){
        String uuid = UUID.randomUUID().toString();
        
        float min = 1000.00f;
        float max = 100000.00f;

        Random randomNum = new Random();
        float initialBalance = min + randomNum.nextFloat();
        bankAcct[i] = new BankAccount("Employee " + String.valueOf(i), uuid, initialBalance); //valueof = change string back to int

    }

    bankAcct[0].showAccount();
    bankAcct[0].withdraw(100.00f);
    bankAcct[0].showAccount();

}


}
