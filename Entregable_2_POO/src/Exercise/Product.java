package Exercise;

import java.util.Scanner;

public class Product {

    private String name;
    private int price;
    private int stockQuantity;

    public Product(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    int amount = 0;

    public void increaseQ(int amount){
        if (amount > 0) {
            stockQuantity += amount;
        }
    }

    public void decreaseQ(int amount){
        if(stockQuantity - amount >= 0){
            stockQuantity -=amount;
        }else {
            System.out.println("Cannot decrease, insufficient stock...");
        }
    }

    public int stockV(){
        return price* stockQuantity;
    }


    public static void main(Object o) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter product price: ");
        int price = scanner.nextInt();

        System.out.println("Enter initial stock quantity; ");
        int stock_quantity = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(name, price, stock_quantity);

        boolean next = false;

        do {
            System.out.println("Do you want to increase or decrease the stock? : ");
            String option = scanner.nextLine().toLowerCase();

            if (option.equals("increase")){

                System.out.println("This is the actual stock "+ stock_quantity);
                System.out.println("Enter the amount to increase stock: ");
                int increase = scanner.nextInt();
                scanner.nextLine();
                product.increaseQ(increase);
                System.out.println("Stock after increase: "+product.stockQuantity);
                next = true;

            } else if (option.equals("decrease")) {
                System.out.println("This is the actual stock "+ stock_quantity);
                System.out.println("Enter the amount to decrease stock: ");
                int decrease = scanner.nextInt();
                scanner.nextLine();
                product.decreaseQ(decrease);
                System.out.println("Stock after decrease: "+product.stockQuantity);
                next = true;

            }else {
                System.out.println("The option is invalid, try again");
            }
        }while (!next);

        System.out.println("Total stock value: " + product.stockV());

    }





}
