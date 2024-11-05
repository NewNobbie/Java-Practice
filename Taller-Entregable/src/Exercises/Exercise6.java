package Exercises;

import java.util.Scanner;

public class Exercise6 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Seleccione su número de asiento");
        /*System.out.println("    1   2   3   4   5\n" +
                "A   O   O   O   O   O\n" +
                "B   O   O   O   O   O\n" +
                "C   O   O   O   O   O\n" +
                "D   O   O   O   O   O\n" +
                "E   O   O   O   O   O\n");*/

        char[][] quota = new char[5][5];



        for (int i = 0; i < quota.length; i++){
            for (int c = 0; c < quota[i].length; c++){
                quota[i][c] = 'O';
            }
        }

        boolean reservation = true;


        while (reservation) {
            System.out.println("    1   2   3   4   5\n" +
                    "A   " + quota[0][0] + "   " + quota[0][1] + "   " + quota[0][2] + "   " + quota[0][3] + "   " + quota[0][4] + "\n" +
                    "B   " + quota[1][0] + "   " + quota[1][1] + "   " + quota[1][2] + "   " + quota[1][3] + "   " + quota[1][4] + "\n" +
                    "C   " + quota[2][0] + "   " + quota[2][1] + "   " + quota[2][2] + "   " + quota[2][3] + "   " + quota[2][4] + "\n" +
                    "D   " + quota[3][0] + "   " + quota[3][1] + "   " + quota[3][2] + "   " + quota[3][3] + "   " + quota[3][4] + "\n" +
                    "E   " + quota[4][0] + "   " + quota[4][1] + "   " + quota[4][2] + "   " + quota[4][3] + "   " + quota[4][4] + "\n");

            System.out.println("Enter the id of the select seat [A1 to E5]");
            String ticket = scanner.nextLine().toUpperCase();

            // Id converter
            int row = ticket.charAt(0) - 'A';
            int col = Character.getNumericValue(ticket.charAt(1)) -1;

            // Validate if the seats are occupied
            if(row >= 0 && row < 5 && col >= 0 && col < 5){
                if (validateSeat(quota, row, col)){
                    quota[row][col] = 'X'; //Seat reserved
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
                reservation = false;
            }
    }

    }
    public static boolean validateSeat(char[][] seats, int row, int col) {
        return seats[row][col] == 'O';
    }
}
