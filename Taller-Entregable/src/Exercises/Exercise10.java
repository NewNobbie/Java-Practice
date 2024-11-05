package Exercises;

import java.util.Scanner;

public class Exercise10 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        int[] qualification = new int[10];
        int five = 0;
        float sum = 0;

        System.out.println("Welcome to our survey");

        for (int i = 0; i < qualification.length; i++) {

            try {
                System.out.println("please 1 to 5: ");
                int note = scanner.nextInt();
                qualification[i] = note;


                if(note >= 1 && note <= 5){

                    if(note == 5){
                        five ++;
                    }
                }

            }catch (Exception e){
                System.out.println("Must be a number 1 to 5");
            }

        }

        for (int i = 0; i < qualification.length; i++) {
            sum += qualification[i];
        }

        System.out.println("The average is: "+ (sum/ qualification.length) + five+ " / 10 of clients gave the highest qualification!");
    }
}
