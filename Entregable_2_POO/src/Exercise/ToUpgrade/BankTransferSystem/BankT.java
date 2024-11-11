package Exercise.ToUpgrade.BankTransferSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankT {

    private List<BankAccountT> accounts;

    // Constructor
    public BankT() {
        this.accounts = new ArrayList<>();
    }

    // Method to add a new bank account
    public void addAccount(BankAccountT account) {
        accounts.add(account);
        System.out.println("Account added: " + account.getAccountNumber());
    }

    // Find account by account number
    public BankAccountT findAccount(String accountNumber) {
        for (BankAccountT account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    // Main method with menu for bank operations
    public static void main(String[] args) {
        BankT bank = new BankT();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBank Account Management System\n" +
                    "1. Create a new account\n" +
                    "2. Deposit into an account\n" +
                    "3. Withdraw from an account\n" +
                    "4. Transfer between accounts\n" +
                    "5. Show account balance\n" +
                    "6. Show transaction history\n" +
                    "7. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    BankAccountT account = new BankAccountT(accountNumber, initialBalance);
                    bank.addAccount(account);
                    break;

                case 2:
                    System.out.print("Enter account number for deposit: ");
                    String depositAccountNumber = scanner.nextLine();
                    BankAccountT depositAccount = bank.findAccount(depositAccountNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        depositAccount.deposit(depositAmount);
                    }
                    break;

                case 3:
                    System.out.print("Enter account number for withdrawal: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    BankAccountT withdrawAccount = bank.findAccount(withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    }
                    break;

                case 4:
                    System.out.print("Enter your account number: ");
                    String fromAccountNumber = scanner.nextLine();
                    BankAccountT fromAccount = bank.findAccount(fromAccountNumber);
                    if (fromAccount != null) {
                        System.out.print("Enter destination account number: ");
                        String toAccountNumber = scanner.nextLine();
                        BankAccountT toAccount = bank.findAccount(toAccountNumber);
                        if (toAccount != null) {
                            System.out.print("Enter amount to transfer: ");
                            double transferAmount = scanner.nextDouble();
                            fromAccount.transfer(transferAmount, toAccount);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter account number to check balance: ");
                    String balanceAccountNumber = scanner.nextLine();
                    BankAccountT balanceAccount = bank.findAccount(balanceAccountNumber);
                    if (balanceAccount != null) {
                        System.out.println("Current balance: $" + balanceAccount.getBalance());
                    }
                    break;

                case 6:
                    System.out.print("Enter account number to view transaction history: ");
                    String historyAccountNumber = scanner.nextLine();
                    BankAccountT historyAccount = bank.findAccount(historyAccountNumber);
                    if (historyAccount != null) {
                        historyAccount.showTransactionHistory();
                    }
                    break;

                case 7:
                    System.out.println("Exiting the bank system...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
