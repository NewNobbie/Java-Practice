package Exercise.ToUpgrade.MaintenanceVehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fleet {

    // Inner Vehicle class
    public static class Vehicle {
        private String brand;
        private String model;
        private int mileage;
        private List<String> maintenanceRecords;

        // Constructor
        public Vehicle(String brand, String model, int mileage) {
            this.brand = brand;
            this.model = model;
            this.mileage = mileage;
            this.maintenanceRecords = new ArrayList<>();
        }

        // Method to record maintenance
        public void recordMaintenance(String maintenance) {
            maintenanceRecords.add("Mileage " + mileage + ": " + maintenance);
            System.out.println("Maintenance recorded for " + brand + " " + model + ": " + maintenance);
        }

        // Update mileage and check if maintenance is due
        public void updateMileage(int newMileage) {
            if (newMileage > mileage) {
                mileage = newMileage;
                System.out.println("Mileage updated to " + mileage + " for " + brand + " " + model);
            } else {
                System.out.println("New mileage must be greater than current mileage.");
            }
        }

        public int getMileage() {
            return mileage;
        }

        @Override
        public String toString() {
            return "Vehicle{" +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", mileage=" + mileage +
                    ", maintenanceRecords=" + maintenanceRecords +
                    '}';
        }
    }

    // List to store all vehicles in the fleet
    private static List<Vehicle> fleetVehicles = new ArrayList<>();

    // Main method to manage fleet and maintenance
    public static void main(Object o) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nFleet Maintenance System\n" +
                    "1. Add a new vehicle\n" +
                    "2. Update vehicle mileage\n" +
                    "3. Record vehicle maintenance\n" +
                    "4. Show all vehicles and maintenance records\n" +
                    "5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    fleetVehicles.add(createVehicle(scanner));
                    break;
                case 2:
                    updateVehicleMileage(scanner);
                    break;
                case 3:
                    recordVehicleMaintenance(scanner);
                    break;
                case 4:
                    displayFleet();
                    break;
                case 5:
                    System.out.println("Exiting the fleet maintenance system...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Helper method to create a vehicle
    private static Vehicle createVehicle(Scanner scanner) {
        System.out.print("Enter vehicle brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();
        System.out.print("Enter vehicle mileage: ");
        int mileage = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Vehicle vehicle = new Vehicle(brand, model, mileage);
        System.out.println("Vehicle added: " + brand + " " + model + " with mileage " + mileage);
        return vehicle;
    }

    // Helper method to update vehicle mileage
    private static void updateVehicleMileage(Scanner scanner) {
        Vehicle vehicle = selectVehicle(scanner);
        if (vehicle != null) {
            System.out.print("Enter new mileage: ");
            int newMileage = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            vehicle.updateMileage(newMileage);
        }
    }

    // Helper method to record maintenance
    private static void recordVehicleMaintenance(Scanner scanner) {
        Vehicle vehicle = selectVehicle(scanner);
        if (vehicle != null) {
            System.out.print("Enter maintenance description: ");
            String maintenance = scanner.nextLine();
            vehicle.recordMaintenance(maintenance);
        }
    }

    // Method to select a vehicle from the fleet
    private static Vehicle selectVehicle(Scanner scanner) {
        if (fleetVehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
            return null;
        }

        System.out.println("Select a vehicle:");
        for (int i = 0; i < fleetVehicles.size(); i++) {
            System.out.println((i + 1) + ". " + fleetVehicles.get(i).toString());
        }
        System.out.print("Enter vehicle number: ");
        int vehicleNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (vehicleNumber < 1 || vehicleNumber > fleetVehicles.size()) {
            System.out.println("Invalid vehicle number.");
            return null;
        }

        return fleetVehicles.get(vehicleNumber - 1);
    }

    // Method to display all vehicles in the fleet
    private static void displayFleet() {
        if (fleetVehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
        } else {
            System.out.println("Vehicles in the Fleet:");
            for (Vehicle vehicle : fleetVehicles) {
                System.out.println(vehicle);
            }
        }
    }
}
