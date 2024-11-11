package Exercise.ToUpgrade.OnlineResgister;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private Client client;
    private List<OnlineProduct> purchasedProducts;
    private double totalAmount;

    // Constructor
    public Order(Client client) {
        this.client = client;
        this.purchasedProducts = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    // Method to add a product to the order
    public void addProductToOrder(OnlineProduct product, int quantity) {
        if (product.reduceStock(quantity)) {
            for (int i = 0; i < quantity; i++) {
                purchasedProducts.add(product);
            }
            totalAmount += product.getPrice() * quantity;
            System.out.println(quantity + " units of " + product.getName() + " added to the order.");
        }
    }

    // Method to calculate the total amount of the order
    public double calculateTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", totalAmount=" + totalAmount +
                ", purchasedProducts=" + purchasedProducts +
                '}';
    }

    // Main method for order management
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample products for the inventory
        List<OnlineProduct> inventory = new ArrayList<>();
        inventory.add(new OnlineProduct("Laptop", 1000.0, 5));
        inventory.add(new OnlineProduct("Smartphone", 500.0, 10));
        inventory.add(new OnlineProduct("Headphones", 50.0, 20));

        // List of orders
        List<Order> orders = new ArrayList<>();

        while (true) {
            System.out.println("\nOnline Store Order System\n" +
                    "1. Create a new order\n" +
                    "2. Show inventory\n" +
                    "3. Show all orders\n" +
                    "4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter client name: ");
                    String clientName = scanner.nextLine();
                    System.out.print("Enter client email: ");
                    String clientEmail = scanner.nextLine();
                    Client client = new Client(clientName, clientEmail);

                    Order order = new Order(client);
                    System.out.println("Adding products to the order...");

                    while (true) {
                        System.out.println("Available products:");
                        for (int i = 0; i < inventory.size(); i++) {
                            System.out.println((i + 1) + ". " + inventory.get(i));
                        }
                        System.out.print("Enter the product number to add to the order (or 0 to finish): ");
                        int productOption = scanner.nextInt();
                        if (productOption == 0) break;

                        if (productOption < 1 || productOption > inventory.size()) {
                            System.out.println("Invalid product number.");
                            continue;
                        }

                        OnlineProduct selectedProduct = inventory.get(productOption - 1);
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        order.addProductToOrder(selectedProduct, quantity);
                    }

                    System.out.println("Order created for " + client.getName() + ". Total: $" + order.calculateTotalAmount());
                    orders.add(order);
                    break;

                case 2:
                    System.out.println("Current Inventory:");
                    for (OnlineProduct product : inventory) {
                        System.out.println(product);
                    }
                    break;

                case 3:
                    if (orders.isEmpty()) {
                        System.out.println("No orders have been placed.");
                    } else {
                        System.out.println("All Orders:");
                        for (Order o : orders) {
                            System.out.println(o);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting the order system...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
