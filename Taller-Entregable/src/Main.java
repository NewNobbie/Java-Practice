import Exercises.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);
        boolean next =true;


        while (next){
            System.out.println("Select an option of exercise to execute: ");
            System.out.println("#1 Validation of simple User \n" +
                    "#2 Entrance control of event \n" +
                    "#3 Management system of pending tasks \n" +
                    "#4 Inventory management of Store \n" +
                    "#5 Register system of users \n" +
                    "#6 Cinema reservation system \n" +
                    "#7 Restaurant reservation system \n" +
                    "#8 Students system management \n" +
                    "#9 Employees evaluation system \n" +
                    "#10 Application of satisfaction surveys \n" +
                    "#11 Inventory of quantity of Products system \n" +
                    "#12 Invoice payment system \n" +
                    "#13 Electronic voting system \n" +
                    "#14 Employee management with search \n" +
                    "#15 Hotel reservation system \n" +
                    "#16 Monthly expense control \n" +
                    "#17 Project evaluation system \n" +
                    "#18 Vehicle management system \n" +
                    "#19 Inventory with prices management system \n" +
                    "#20 Flight Reservation Management System \n" +
                    "#21 Exit");

            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Exercise1.main(null);
                    break;
                case 2:
                    Exercise2.main(null);
                    break;
                case 3:
                    Exercise3.main(null);
                    break;
                case 4:
                    Exercise4.main(null);
                    break;
                case 5:
                    Exercise5.main(null);
                    break;
                case 6:
                    Exercise6.main(null);
                    break;
                case 7:
                    Exercise7.main(null);
                    break;
                case 8:
                    Exercise8.main(null);
                    break;
                case 9:
                    Exercise9.main(null);
                    break;
                case 10:
                    Exercise10.main(null);
                    break;
                case 11:
                    Exercise11.main(null);
                    break;
                case 12:
                    Exercise12.main(null);
                    break;
                case 13:
                    Exercise13.main(null);
                    break;
                case 14:
                    Exercise14.main(null);
                    break;
                case 15:
                    Exercise15.main(null);
                    break;
                case 16:
                    Exercise16.main(null);
                    break;
                case 17:
                    Exercise17.main(null);
                    break;
                case 18:
                    Exercise18.main(null);
                    break;
                case 19:
                    Exercise19.main(null);
                    break;
                case 20:
                    Exercise20.main(null);
                    break;
                case 21:
                    next = false;
                    System.out.println("Exiting the program");
                    break;

                default:
                    System.out.println("Invalid option, try again");
            }

            System.out.println();
        }
        scanner.close();

    }
}