package Exercises;

import java.util.Scanner;

public class Exercise2 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        int quota = 100;
        int ticket = 0;

        boolean valid = false;


        System.out.println("Welcome to the entrance management system...");



        while (ticket < quota){

            System.out.println("Select the number of tickets that you want: ");
            int nTicket = scanner.nextInt();
            scanner.nextLine(); // Clean buffer



            if (nTicket + ticket <= quota){
                ticket+= nTicket;
                System.out.println("The missing quota are: " + (quota-ticket));
            }else {
                System.out.println("Not enough quota available.");
            }

            if (nTicket == quota){
                System.out.println("The event is full");
                break;
            }
        }










    }
}
