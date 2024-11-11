package Exercise.ToUpgrade.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private List<Product> products;

    // Constructor
    public Inventory() {
        this.products = new ArrayList<>();
    }

    // Method to add a product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    // Method to search for products by category
    public List<Product> searchByCategory(String category) {
        List<Product> categoryProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    // Method to calculate the total value of the inventory
    public double calculateTotalValue() {
        double totalValue = 0;
        for (Product product : products) {
            totalValue += product.getPrice();
        }
        return totalValue;
    }

    // Method to display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Products in Inventory:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public static void main(Object o) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nProduct Inventory System\n" +
                    "1. Add a product\n" +
                    "2. Search products by category\n" +
                    "3. Display total inventory value\n" +
                    "4. Show all products\n" +
                    "5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();

                    Product product = new Product(name, price, category);
                    inventory.addProduct(product);
                    break;

                case 2:
                    System.out.print("Enter category to search: ");
                    String searchCategory = scanner.nextLine();
                    List<Product> foundProducts = inventory.searchByCategory(searchCategory);
                    if (foundProducts.isEmpty()) {
                        System.out.println("No products found in this category.");
                    } else {
                        System.out.println("Products in category '" + searchCategory + "':");
                        for (Product p : foundProducts) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 3:
                    double totalValue = inventory.calculateTotalValue();
                    System.out.println("Total inventory value: $" + totalValue);
                    break;

                case 4:
                    inventory.displayProducts();
                    break;

                case 5:
                    System.out.println("Exiting the inventory system...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
