package Exercises;

import java.util.Scanner;

public class Exercise17 {
    public static void main(Object o) {

        Scanner scanner = new Scanner(System.in);

        String[] projects = new String[5];
        int[] notes = new int[5];


        for (int i = 0; i < 5; i++){
            System.out.println("Enter the name of the project: ");
            projects[i] = scanner.nextLine();

            System.out.println("Enter the qualification of the project: ");
            notes[i] = scanner.nextInt();
            scanner.nextLine();
        }

        // Bubble method for order
        for (int i = 0; i < notes.length -1; i++){
            for (int j = 0; j < notes.length -1; j++){
                if (notes[j] < notes[j +1]) {

                    //Notes changer
                    int tempNote = notes[j];
                    notes[j] = notes[j + 1];
                    notes[j + 1] = tempNote;

                    // Names changer
                    String tempProject = projects[j];
                    projects[j] = projects[j + 1];
                    projects[j + 1] = tempProject;
                }
            }
        }

        // Print Project + Qualifications ordered
        System.out.println("\nProjects ordered by grade:");
        for (int i = 0; i < 5; i++){
            System.out.println("Project: " + projects[i] + " | Grades: " + notes[i]);
        }

    }
}
