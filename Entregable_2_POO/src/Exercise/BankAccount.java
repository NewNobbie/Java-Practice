package Exercise;

import java.util.*;

public class BankAccount {


    private static int accountCounter = 100000; //Static counter for unique numbers
    private int numberAccount;
    private String holder;
    private float balance;
    private List<String> transactionHistory;

    private TransactionType transactionType;



    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL,
        TRANSFER;

    }

    public BankAccount(String holder, float initialBalance) {
        this.numberAccount = accountCounter++;
        this.holder = holder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        deposit(initialBalance);
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +", numberAccount='" + numberAccount + '\''+
                ", balance=" + balance + '\'' +
                ", holder='" + holder + '\'' +
                 +
                '}';
    }


    public void deposit(float amount){
        if (amount > 0){
            balance += amount;
            transactionHistory.add("Deposit: $" +amount);
        } else {
            System.out.println("Deposit amount must be positive...");
        }
    }

    public void withDraw(float amount){
        if(amount > 0 && amount <= balance){
            balance-=amount;
            transactionHistory.add("Withdrawal: $"+amount);
        }else {
            System.out.println("Insufficient balance or invalid amount...");
        }
    }

    public void showHistory(){
        System.out.println("Transaction History for account "+ numberAccount+ ":");
        for (String i : transactionHistory){
            System.out.println(i);
        }
    }



    public static void main(Object o) {
        Scanner scanner = new Scanner(System.in);

        List<BankAccount> accounts = new ArrayList<>();


        while (true){
            System.out.println("Welcome to Transaction History\n" +
                    "- - - - - - - - - -\n" +
                    "1. Create a new account\n" +
                    "2. Show the accounts\n" +
                    "3. Make a movement\n" +
                    "4. Show the movement history\n" +
                    "5. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    System.out.println("Enter the name of the account holder: ");
                    String nameAccount = scanner.nextLine();

                    System.out.println("Enter the initial deposit amount: ");
                    float balance = scanner.nextFloat();
                    scanner.nextLine();

                    BankAccount newAccount = new BankAccount(nameAccount,balance);
                    accounts.add(newAccount);
                    System.out.println("Account created successfully with account Number:  "+ newAccount.getNumberAccount());


                    break;
                case 2:
                    for (BankAccount i : accounts){
                        System.out.println(i);
                    }

                    break;
                case 3:
                    System.out.println("Enter the account number: ");
                    int accountSearch = scanner.nextInt();
                    scanner.nextLine();

                    BankAccount foundAccount = findAccount(accounts, accountSearch);
                    if (foundAccount != null){
                        System.out.println("Enter the transaction type (1 for DEPOSIT, 2 for WITHDRAWAL): ");
                        int transactionType = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter the amount: ");
                        float amount = scanner.nextFloat();
                        scanner.nextLine();

                        if (transactionType == 1){
                            foundAccount.deposit(amount);
                        } else if (transactionType == 2) {
                            foundAccount.withDraw(amount);
                        } else {
                            System.out.println("Invalid transaction type...");
                        }
                    }else {
                        System.out.println("Account not found! ");
                    }
                    break;
                case 4:
                    System.out.println("Enter the account number to show all the history movements: ");
                    int accountSearchShow = scanner.nextInt();
                    scanner.nextLine();

                    BankAccount accountToShow = findAccount(accounts, accountSearchShow);
                    if (accountToShow != null){
                        accountToShow.showHistory();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, Please try again");
            }
        }
    }

    private static BankAccount findAccount(List<BankAccount> accounts, int accountNumber){
        for (BankAccount account : accounts){
            if (account.getNumberAccount() == accountNumber){
                return account;
            }
        }
        return null;
    }


}
