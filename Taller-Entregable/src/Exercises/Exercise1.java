package Exercises;

import java.util.Scanner;

public class Exercise1 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);
        int edad = 0;
        boolean validInput = false;



        while (!validInput){
            try {
                System.out.print("Enter your age: ");
                edad = scanner.nextInt();

                if (edad >= 0){
                    validInput = true;
                }else {
                    System.out.println("Please enter a positive number");
                }

            }catch (Exception e){
                System.out.println("The age must be a number...");
                scanner.next(); // Clean buffer
            }
        }

        if (edad >= 18){
            System.out.println("User is of legal age");
        }else {
            System.out.println("User is not of legal age");
        }






    }
}
