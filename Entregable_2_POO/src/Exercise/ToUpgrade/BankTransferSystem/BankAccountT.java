package Exercise.ToUpgrade.BankTransferSystem;

import java.util.ArrayList;
import java.util.List;

public class BankAccountT {

    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public BankAccountT(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: $" + initialBalance);
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("Deposited $" + amount + " into account " + accountNumber);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            System.out.println("Withdrew $" + amount + " from account " + accountNumber);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
            return false;
        }
    }

    // Transfer money to another account
    public boolean transfer(double amount, BankAccountT toAccount) {
        if (withdraw(amount)) {
            toAccount.deposit(amount);
            transactionHistory.add("Transferred: $" + amount + " to account " + toAccount.getAccountNumber());
            return true;
        } else {
            System.out.println("Transfer failed due to insufficient funds.");
            return false;
        }
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Method to display transaction history
    public void showTransactionHistory() {
        System.out.println("Transaction history for account " + accountNumber + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
