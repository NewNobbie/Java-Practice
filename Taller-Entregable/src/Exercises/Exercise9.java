package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise9 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);
        String[] employees = new String[5];
        Double[] notesEmployees = new Double[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the " + (i + 1) + " employee's name: ");
            employees[i] = scanner.nextLine();
        }

        for (int i = 0; i < employees.length; i++) {
            System.out.println("Please enter the note for the: " + (i + 1) + " employee");
            notesEmployees[i] = scanner.nextDouble();
        }

        double aux = 0;
        double auxMin = 10000;
        int maxNote = 0;
        int minNote = 0;
        for (int i = 0; i < notesEmployees.length; i++) {
            if (notesEmployees[i] > aux) {
                aux = notesEmployees[i];
                maxNote = i;
            }
        }
        for (int i = 0; i < notesEmployees.length; i++) {
            if (notesEmployees[i] < auxMin) {
                auxMin = notesEmployees[i];
                minNote = i;
            }
        }

        System.out.println("the employee with more note are: " + employees[maxNote] + " with: " + notesEmployees[maxNote] + " minus note are: " + employees[minNote] + " with: " + notesEmployees[minNote]);
    }
}
