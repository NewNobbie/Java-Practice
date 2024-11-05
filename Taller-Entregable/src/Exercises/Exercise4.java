package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise4 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> products = new ArrayList<>();
        ArrayList<Integer> stock = new ArrayList<>();
        boolean next4 = true;

        while (next4) {
            System.out.println("\n Inventory Management System\n" +
                    "1. Add product\n" +
                    "2. Remove product\n"+
                    "3. Show inventory\n" +
                    "4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); //Clean buffer

            switch (option){
                // Add product
                case 1:
                    System.out.print("Enter the product name: ");
                    String productName = scanner.nextLine();

                    System.out.print("Enter the stock quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();  // Clean buffer

                    products.add(productName);
                    stock.add(quantity);
                    System.out.println("Product added successfully.");
                break;

                case 2:
                    // Remove product or update stock
                    System.out.println("Current inventory:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(i + 1 + ". " + products.get(i) + " - Stock: " + stock.get(i));
                    }
                    System.out.print("Enter the product number to update or remove: ");
                    int productIndex = scanner.nextInt() - 1;  // Convert to 0-based index

                    if (productIndex >= 0 && productIndex < products.size()) {
                        System.out.print("Enter new stock quantity (0 to remove): ");
                        int newQuantity = scanner.nextInt();
                        scanner.nextLine();  // Clean buffer

                        if (newQuantity == 0) {
                            products.remove(productIndex);
                            stock.remove(productIndex);
                            System.out.println("Product removed from inventory.");
                        } else {
                            stock.set(productIndex, newQuantity);
                            System.out.println("Product stock updated.");
                        }
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;
                case 3:
                    // Show inventory
                    System.out.println("\nInventory:");
                    for (int i = 0; i < products.size(); i++) {
                        String status = stock.get(i) == 0 ? "Out of Stock" : "In Stock";
                        System.out.println("- " + products.get(i) + " | Stock: " + stock.get(i) + " (" + status + ")");
                    }
                    break;
                case 4:
                    // Exit
                    next4 = false;
                    System.out.println("Exiting Inventory Management System.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }


    }
}
