package Exercise;

import java.util.Scanner;

public class Vehicle {

    private String branch;
    private String model;
    private int maxVelocity;

    public Vehicle(String branch, String model, int maxVelocity) {
        this.branch = branch;
        this.model = model;
        this.maxVelocity = maxVelocity;
    }

    public int speed;

    public void speedUp(){
        if (speed < maxVelocity){
            speed+=10;
        }else {
            System.out.println("MaxSpeed reached...");
        }
    }

    public void slowDown(){
        if (speed >= 10){
            speed-=10;
        }else {
            speed=0;
        }
    }

    public static void main(Object o){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Model speed simulator\n" +
                "Enter the vehicle branch: ");
        String branch = scanner.nextLine();

        System.out.println("Enter the vehicle model: ");
        String model = scanner.nextLine();

        System.out.println("Enter the max-speed of vehicle: ");
        int maxSpeed = scanner.nextInt();

        Vehicle vehicle = new Vehicle(branch,model,maxSpeed);

        while (true){

            System.out.println(" (W) - To SpeedUp\n" +
                    " (S) - To SlowDown\n" +
                    " (Q) - To exit");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("W")){
                vehicle.speedUp();
                System.out.println("SpeedUp... "+ vehicle.speed + "KMs/H");
            } else if (input.equals("S")) {
                vehicle.slowDown();
                System.out.println("SlowDown... "+ vehicle.speed + "KMs/H");
            } else if (input.equals("Q")){
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid input, try again!");
            }
        }
    }
}
