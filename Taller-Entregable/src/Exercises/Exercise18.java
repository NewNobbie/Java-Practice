package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise18 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> licenseP = new ArrayList<>();
        ArrayList<String> model = new ArrayList<>();
        ArrayList<String> status = new ArrayList<>();

        boolean next18 = true;

        while (next18) {

            System.out.println("Welcome to the Vehicle management system");
            System.out.println("Choose an option");
            System.out.println("1. Enter a new Vehicle \n" +
                    "2. Update a vehicle \n" +
                    "3. Show all the vehicles \n" +
                    "4. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();


            switch (option) {
                case 1:
                    System.out.println("Enter the license plate of the vehicle: ");
                    String plate = scanner.nextLine();
                    System.out.println("Enter the model: ");
                    String vModel = scanner.nextLine();
                    System.out.println("Enter the status (available/occupied)");
                    String vStatus = scanner.nextLine().toLowerCase();

                    licenseP.add(plate);
                    model.add(vModel);
                    status.add(vStatus);
                    System.out.println("Vehicle registered successfully! ");
                    break;

                case 2:
                    System.out.println("Enter the license plate of the vehicle to update: ");
                    String search = scanner.nextLine();
                    int index = licenseP.indexOf(search);

                    if (index != -1){
                        System.out.println("Enter the new status (available/occupied): ");
                        String newStatus = scanner.nextLine().toLowerCase();
                        System.out.println("Updating status of vehicle at index " + index);
                        System.out.println("Old status: " + status.get(index));

                        status.set(index, newStatus);

                        System.out.println("New status: " + status.get(index));

                        System.out.println("Vehicle status updated successfully! ");


                    } else {
                        System.out.println("Vehicle not found...");
                    }
                    break;

                case 3:
                    // Show vehicles
                    System.out.println("\n Available Vehicles: ");
                    boolean availableVehicles = false;
                    for (int i = 0; i < licenseP.size(); i++) {
                        if (status.get(i).equals("available")){
                            System.out.println("License Plate: " + licenseP.get(i) + " | Model: " + model.get(i) + " | Status: " + status.get(i));
                            availableVehicles = true;
                        }
                    }
                    if (!availableVehicles){
                        System.out.println("No available vehicles at the moment...");
                    }
                    break;

                case 4:
                    next18 = false;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid option... try again");
                    break;

            }
        }
    }
}
