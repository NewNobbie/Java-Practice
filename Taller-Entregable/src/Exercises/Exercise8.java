package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise8 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> nameStudent = new ArrayList<>();
        ArrayList<String> studendAverage = new ArrayList<>();

        System.out.println("Welcome to the average program");
        int option = 0;
        do {
            System.out.println("1. Add student, 2. Show list, 3. seach by name, 0. leave ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {

                System.out.println("Enter the student name:");
                String name = scanner.nextLine();
                nameStudent.add(name);

                System.out.println("Enter the "+ name + "'s average: ");
                String ave = scanner.nextLine();
                studendAverage.add(ave);

                System.out.println("Studend added successfuly");

            } else if (option == 2){
                show(nameStudent,studendAverage);
            }else if (option == 3){

                System.out.println("Enter student's name: ");
                String name = scanner.nextLine();
                int index = nameStudent.indexOf(name);
                if( index != -1 ){
                    System.out.println("Student: "+ nameStudent.get(index)+ " ,average: "+ studendAverage.get(index));
                }
            }

        } while (option != 0);
    }
    public static void show(ArrayList<String> nameStudent,  ArrayList<String> studendAverage){
        System.out.println("------------------------------");
        System.out.println("Students: ");
        for (int i = 0; i < nameStudent.size(); i++) {
            System.out.println( i+1 + ". Student name: : "+ nameStudent.get(i)+", average: "+ studendAverage.get(i));
        }
        System.out.println("------------------------------");

    }

}
