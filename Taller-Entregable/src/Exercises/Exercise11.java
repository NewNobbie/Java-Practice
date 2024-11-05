package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise11 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> nameProduct = new ArrayList<>();
        ArrayList<Integer> cantProduct = new ArrayList<>();

        System.out.println("Welcome to the inventory");
        int option = 0;
        do {
            System.out.println("1. Add product, 2. update product, 3. show all products, 0. leave ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {

                System.out.println("Create product, enter the name: ");
                String name = scanner.nextLine();
                nameProduct.add(name);

                System.out.println("enter the quantity: ");
                Integer quantity = scanner.nextInt();
                cantProduct.add(quantity);

                System.out.println("product was created sucessful");

            } else if (option == 2){
                show(nameProduct,cantProduct);

                System.out.println("Enter the product number that you want update: ");
                Integer productNumber = scanner.nextInt();

                System.out.println("new quantity: ");
                Integer newQuantity = scanner.nextInt();

                cantProduct.set(productNumber-1, newQuantity);

                System.out.println("product updated succesful");
            }else if (option == 3){
                show(nameProduct,cantProduct);
            }

        } while (option != 0);
        scanner.close();
    }

    public static void show(ArrayList<String> nameProduct,  ArrayList<Integer> cantProduct ){
        System.out.println("------------------------------");
        System.out.println("products: ");
        for (int i = 0; i < nameProduct.size(); i++) {
            System.out.println( i+1 + ". Product name: : "+ nameProduct.get(i)+", quantity: "+ cantProduct.get(i));
        }
        System.out.println("------------------------------");
    }
}
