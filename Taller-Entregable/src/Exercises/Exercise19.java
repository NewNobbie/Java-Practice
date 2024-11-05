package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise19 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> products = new ArrayList<>();
        ArrayList<String> prices = new ArrayList<>();

        boolean next19 = true;


        while (next19){

            System.out.println("\nWelcome to { Inventory with prices management system }");

            System.out.println("\nSelect an option");
            System.out.println("1. Add a new product");
            System.out.println("2. View a list of products");
            System.out.println("3. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){

                case 1:
                    System.out.println("Enter a new Product: ");
                    String product = scanner.nextLine();
                    System.out.println("Enter a price of the product: ");
                    String price = scanner.nextLine();

                    products.add(product);
                    prices.add(price);
                    break;
                case 2:
                    for (int i = 0; i < products.size(); i++){
                        System.out.println("Name of the product: " + products.get(i) + " | Price: " + prices.get(i));
                    }
                    break;
                case 3:
                    next19 = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option... try again");
                    break;
            }

        }



    }
}
