package Exercise.ToUpgrade.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryStore {
    private List<ProductStore> products;

    // Constructor
    public InventoryStore() {
        this.products = new ArrayList<>();
    }

    // Method to add a product
    public void addProduct(ProductStore product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    // Method to remove a product by name
    public void removeProduct(String name) {
        ProductStore productToRemove = findProductByName(name);
        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println("Product removed: " + name);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to find a product by name
    public ProductStore findProductByName(String name) {
        for (ProductStore product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Method to find products by category
    public List<ProductStore> findProductsByCategory(String category) {
        List<ProductStore> categoryProducts = new ArrayList<>();
        for (ProductStore product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    // Method to update stock after a sale
    public void updateStock(String name, int quantitySold) {
        ProductStore product = findProductByName(name);
        if (product != null) {
            if (product.getStock() >= quantitySold) {
                product.setStock(product.getStock() - quantitySold);
                System.out.println("Sale completed. Updated stock for " + name + ": " + product.getStock());
            } else {
                System.out.println("Insufficient stock for " + name);
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Products in Inventory:");
            for (ProductStore product : products) {
                System.out.println(product);
            }
        }
    }

    // Main method with menu for inventory management
    public static void main(Object o) {
        InventoryStore inventory = new InventoryStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System\n" +
                    "1. Add a product\n" +
                    "2. Remove a product\n" +
                    "3. Search product by name\n" +
                    "4. Search products by category\n" +
                    "5. Sell a product\n" +
                    "6. Display all products\n" +
                    "7. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    ProductStore product = new ProductStore(name, category, price, stock);
                    inventory.addProduct(product);
                    break;

                case 2:
                    System.out.print("Enter the name of the product to remove: ");
                    String nameToRemove = scanner.nextLine();
                    inventory.removeProduct(nameToRemove);
                    break;

                case 3:
                    System.out.print("Enter the product name to search: ");
                    String searchName = scanner.nextLine();
                    ProductStore foundProduct = inventory.findProductByName(searchName);
                    if (foundProduct != null) {
                        System.out.println("Product found: " + foundProduct);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the product category to search: ");
                    String searchCategory = scanner.nextLine();
                    List<ProductStore> categoryProducts = inventory.findProductsByCategory(searchCategory);
                    if (categoryProducts.isEmpty()) {
                        System.out.println("No products found in this category.");
                    } else {
                        System.out.println("Products in category '" + searchCategory + "':");
                        for (ProductStore p : categoryProducts) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter the product name to sell: ");
                    String sellName = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    inventory.updateStock(sellName, quantity);
                    break;

                case 6:
                    inventory.displayProducts();
                    break;

                case 7:
                    System.out.println("Exiting the inventory system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
