package Exercise.ToUpgrade.VehicleInheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleI {

    private String brand;
    private String model;
    private double price;

    // Constructor
    public VehicleI(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to describe the vehicle
    public String describe() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public static class Car extends VehicleI {
        private int numDoors;

        // Constructor
        public Car(String brand, String model, double price, int numDoors) {
            super(brand, model, price);
            this.numDoors = numDoors;
        }

        // Getter for numDoors
        public int getNumDoors() {
            return numDoors;
        }

        // Override describe method to include car-specific details
        @Override
        public String describe() {
            return super.describe() + ", Car{" +
                    "numDoors=" + numDoors +
                    '}';
        }
    }

    public static class Motorcycle extends VehicleI {
        private String helmetType;

        // Constructor
        public Motorcycle(String brand, String model, double price, String helmetType) {
            super(brand, model, price);
            this.helmetType = helmetType;
        }

        // Getter for helmetType
        public String getHelmetType() {
            return helmetType;
        }

        // Override describe method to include motorcycle-specific details
        @Override
        public String describe() {
            return super.describe() + ", Motorcycle{" +
                    "helmetType='" + helmetType + '\'' +
                    '}';
        }
    }

    private static List<VehicleI> vehicles = new ArrayList<>(); // List to store all vehicles

    public static void main(Object o) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVehicle Management System\n" +
                    "1. Add a car\n" +
                    "2. Add a motorcycle\n" +
                    "3. Show all vehicles\n" +
                    "4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter car brand: ");
                    String carBrand = scanner.nextLine();
                    System.out.print("Enter car model: ");
                    String carModel = scanner.nextLine();
                    System.out.print("Enter car price: ");
                    double carPrice = scanner.nextDouble();
                    System.out.print("Enter number of doors: ");
                    int numDoors = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Car car = new Car(carBrand, carModel, carPrice, numDoors);
                    vehicles.add(car);
                    System.out.println("Car added: " + car.describe());
                    break;

                case 2:
                    System.out.print("Enter motorcycle brand: ");
                    String motoBrand = scanner.nextLine();
                    System.out.print("Enter motorcycle model: ");
                    String motoModel = scanner.nextLine();
                    System.out.print("Enter motorcycle price: ");
                    double motoPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter helmet type: ");
                    String helmetType = scanner.nextLine();

                    Motorcycle motorcycle = new Motorcycle(motoBrand, motoModel, motoPrice, helmetType);
                    vehicles.add(motorcycle);
                    System.out.println("Motorcycle added: " + motorcycle.describe());
                    break;

                case 3:
                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles in the system.");
                    } else {
                        System.out.println("Vehicles in the system:");
                        for (VehicleI vehicle : vehicles) {
                            System.out.println(vehicle.describe());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting the vehicle management system...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
