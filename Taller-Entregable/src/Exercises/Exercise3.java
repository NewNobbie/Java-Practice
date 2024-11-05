package Exercises;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise3 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);


        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<Boolean> status = new ArrayList<>();

        int nTask = 10;
        int c = 0;

        System.out.println("Welcome to your mini Notion, write the number of task that u wanna add {the maximum is 10}");
        nTask = scanner.nextInt();
        scanner.nextLine();




        while (nTask != c){
            for (int i = 0; i < nTask; i++){
                System.out.println("Enter the description of the task #" +(i+1)+ ": ");
                String task = scanner.nextLine();
                tasks.add(task);

                try{
                    System.out.println("Enter the status of the task #"+(i+1)+ ": 1 = Completed / 2 = Uncompleted");
                    int statusInput = scanner.nextInt();
                    scanner.nextLine(); // Clean Buffer

                    if (statusInput == 1){
                        status.add(true); //Completed...
                    }else {
                        status.add(false);
                    }
                    c+=1;
                }catch (InputMismatchException e){
                    System.out.println("Must be a number [1 = Completed / 2 = Uncompleted]");
                }
            }
        }


        System.out.println("All tasks have been added. ");
        /*tasks.forEach((task)-> System.out.println(task));*/
        for (int i = 0; i < tasks.size(); i++){
            String taskPrint = tasks.get(i);
            String taskStatus = status.get(i) ? "Completed" : "Pending";
            System.out.println("- " + taskPrint + "   |  [" + taskStatus + "]");
        }

    }
}
