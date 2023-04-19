package com.yl.bankacc;

public class FixedDepositAccount extends BankAccount{
    private float interest;
    private Integer duration;

    public FixedDepositAccount(String fullName, String accountNumber) {
        super(fullName, accountNumber);
        //TODO Auto-generated constructor stub
    }


    public FixedDepositAccount(String fullName, String accountNumber, float balance, float interest) {
        super(fullName, accountNumber, balance);//refer to attributes to parent class
        this.interest = interest;
    }


    public FixedDepositAccount(String fullName, String accountNumber, float balance, float interest, Integer duration) {
        super(fullName, accountNumber, balance);
        this.interest = interest;
        this.duration = duration;
    }



    public float getInterest() {
        return interest;
    }
    public void setInterest(float interest) {
        this.interest = interest;
    }
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override 
    public void withdraw(float amount) {
        System.out.println("No withdrawals allowed.");

    }

    @Override
    public void deposit (float amount) {
        System.out.println("No deposits allowed.");
    }
    

    public float getBalance() {
        return super.getBalance() * (100 + interest) / 100; //get balance from parent class
    }


}
