package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise12 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<ArrayList<Double>> facturas = new ArrayList<>();

        System.out.println("Welcome to the payment");
        int option = 0;
        do {
            System.out.println("1. add payment, 2. show total of the payments, 3. pay payment");
            option = scanner.nextInt();
            if(option == 1){
                for (int i = 0; i < 3; i++) {
                    System.out.println("Enter the amount for the "+ (i+1)+ ": ");
                    double amount = scanner.nextDouble();

                    ArrayList<Double> factura = new ArrayList<>();
                    factura.add(amount);

                    facturas.add(factura);
                }
            } else if(option == 2){
                double aux = 0;
                for (ArrayList<Double> factura : facturas) {
                    aux += factura.get(0);
                }
                System.out.println("El valor a pagar es:"+ aux);
            } else if(option == 3){
                System.out.println("Which payment do you want pay?: 1,2,3?");
                int numPayment= scanner.nextInt();
                if( numPayment == 1 ){
                    facturas.get(0).set(0, 0.0);
                    System.out.println("amount update.");
                }else if( numPayment == 2 ){
                    facturas.get(0).set(0, 0.0);
                    System.out.println("amount update.");
                } else if( numPayment == 3 ){
                    facturas.get(0).set(0, 0.0);
                    System.out.println("amount update.");
                }else System.out.println("invalid");
            }

        } while (option != 0);

    }
}
