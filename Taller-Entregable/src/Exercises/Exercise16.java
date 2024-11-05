package Exercises;

import java.util.Scanner;

public class Exercise16 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        float[] monthly = new float[12];

        // Entrance of the data for 12 months
        for (int i = 0; i < 12; i++){
            boolean next16 = false;
            while (!next16){
                try{
                    System.out.println("Enter the expense for month " + (i + 1) + ": ");
                    float expense = scanner.nextFloat();

                    // Valid if the expense is positive
                    if (expense >= 0){
                        monthly[i] = expense;
                        next16 = true;
                    } else {
                        System.out.println("Please enter a positive value...");
                    }
                }catch (Exception e){
                    System.out.println("Invalid input. Please enter a numerical value");
                    scanner.nextLine();
                }
            }
        }


        // Calculate the total expense and the average
        float total = 0;
        for (float expense : monthly){
            total+= expense;
        }
        float average = total / 12;

        // Show the result
        System.out.println("The total expense is: " + total );
        System.out.println("The year per month average: " + average);







    }
}
