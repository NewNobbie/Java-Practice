package Exercise.ToUpgrade.PaymentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Payments {

    // Base Payment class
    public static class Payment {
        protected double amount;

        // Constructor
        public Payment(double amount) {
            this.amount = amount;
        }

        // Polymorphic method to process payment
        public void processPayment() {
            System.out.println("Processing a payment of $" + amount);
        }

        @Override
        public String toString() {
            return "Payment of $" + amount;
        }
    }

    // CardPayment subclass
    public static class CardPayment extends Payment {
        private String cardNumber;

        public CardPayment(double amount, String cardNumber) {
            super(amount);
            this.cardNumber = cardNumber;
        }

        @Override
        public void processPayment() {
            System.out.println("Processing card payment of $" + amount + " with card number ending in " + cardNumber.substring(cardNumber.length() - 4));
        }
    }

    // CashPayment subclass
    public static class CashPayment extends Payment {
        public CashPayment(double amount) {
            super(amount);
        }

        @Override
        public void processPayment() {
            System.out.println("Processing cash payment of $" + amount);
        }
    }

    // List to store all payments
    private static List<Payment> payments = new ArrayList<>();

    // Main method to manage payments
    public static void main(Object o) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPayment Processing System\n" +
                    "1. Process Card Payment\n" +
                    "2. Process Cash Payment\n" +
                    "3. Show all payments\n" +
                    "4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    payments.add(createPayment(scanner, "Card"));
                    break;
                case 2:
                    payments.add(createPayment(scanner, "Cash"));
                    break;
                case 3:
                    displayPayments();
                    break;
                case 4:
                    System.out.println("Exiting the payment processing system...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Helper method to create a payment based on type
    private static Payment createPayment(Scanner scanner, String type) {
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        switch (type) {
            case "Card":
                System.out.print("Enter card number: ");
                String cardNumber = scanner.nextLine();
                return new CardPayment(amount, cardNumber);
            case "Cash":
                return new CashPayment(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    // Method to display all payments and process them
    private static void displayPayments() {
        if (payments.isEmpty()) {
            System.out.println("No payments processed.");
        } else {
            System.out.println("Processed Payments:");
            for (Payment payment : payments) {
                System.out.println(payment);
                payment.processPayment(); // Polymorphic call to processPayment()
            }
        }
    }
}
