package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise20 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        char[][] reservation = new char[6][6];

        System.out.println("Welcome to Flight Reservation Management System!");
        System.out.println("\nSelect the number of the airplane");

        for (int i = 0; i < reservation.length; i++){
            for (int c = 0; c < reservation[i].length; c++){
                reservation[i][c] = 'O';
            }
        }

        boolean next20 = true;


        while (next20) {
            System.out.println("    1   2   3   4   5   6\n" +
                    "A   " + reservation[0][0] + "   " + reservation[0][1] + "   " + reservation[0][2] + "   " + reservation[0][3] + "   " + reservation[0][4] + "   " + reservation[0][5] + "\n" +
                    "B   " + reservation[1][0] + "   " + reservation[1][1] + "   " + reservation[1][2] + "   " + reservation[1][3] + "   " + reservation[1][4] + "   " + reservation[1][5] + "\n" +
                    "C   " + reservation[2][0] + "   " + reservation[2][1] + "   " + reservation[2][2] + "   " + reservation[2][3] + "   " + reservation[2][4] + "   " + reservation[2][5] + "\n" +
                    "D   " + reservation[3][0] + "   " + reservation[3][1] + "   " + reservation[3][2] + "   " + reservation[3][3] + "   " + reservation[3][4] + "   " + reservation[3][5] + "\n" +
                    "E   " + reservation[4][0] + "   " + reservation[4][1] + "   " + reservation[4][2] + "   " + reservation[4][3] + "   " + reservation[4][4] + "   " + reservation[4][5] + "\n" +
                    "F   " + reservation[5][0] + "   " + reservation[5][1] + "   " + reservation[5][2] + "   " + reservation[5][3] + "   " + reservation[5][4] + "   " + reservation[5][5] + "\n");

            System.out.println("Enter the id of the select seat [A1 to E6]");
            String ticket = scanner.nextLine().toUpperCase();

            // Id converter
            int row = ticket.charAt(0) - 'A';
            int col = Character.getNumericValue(ticket.charAt(1)) -1;

            // Validate if the seats are occupied
            if(row >= 0 && row < 6 && col >= 0 && col < 6){
                if (validateSeat(reservation, row, col)){
                    reservation[row][col] = 'X'; //Seat reserved
                    System.out.println("Seat reserved successfully");
                }else {
                    System.out.println("Seat already occupied");
                }
            } else {
                System.out.println("Invalid seat id, please try again");
            }

            // Ask if the user wanna do other reservation
            System.out.println("Do you want to reserve another seat? (yes/no)");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")){
                next20 = false;
            }
        }
    }
    public static boolean validateSeat(char[][] seats, int row, int col) {
        return seats[row][col] == 'O';
    }

}
