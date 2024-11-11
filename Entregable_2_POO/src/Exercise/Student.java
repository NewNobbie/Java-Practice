package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

    private String name;
    private List<Integer> notesList;

    public String getName() {
        return name;
    }

    public Student(String name) {
        this.name = name;
        this.notesList = new ArrayList<>();
    }

    public void addQualification(int note){
        if (note >= 0 && note <= 100){
            notesList.add(note);
            System.out.println("Qualification added: "+ note);
        }else {
            System.out.println("Qualification must be between 0 and 100");
        }
    }

    public double calculateAverage(){
        if (notesList.isEmpty()){
            return 0.0;
        }

        int sum = 0;
        for (int note : notesList){
            sum += note;
        }
        return (double) sum / notesList.size();
    }

    public int maxQualification(){
        if (notesList.isEmpty()){
            return 0;
        }
        int max = notesList.get(0);
        for (int i : notesList){
            if (i > max){
                max = i;
            }
        }
        return max;
    }

    public int minQualification() {
        if (notesList.isEmpty()) {
            return 0;
        }
        int min = notesList.get(0);
        for (int nota : notesList) {
            if (nota < min) {
                min = nota;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Average: " + calculateAverage() +
                ", Max Qualification: " + maxQualification() +
                ", Min Qualification: " + minQualification();
    }

    public static void main(Object o) {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Qualification Management System\n" +
                    "1. Add a student\n" +
                    "2. Add a qualification to a student\n" +
                    "3. Show information of all students\n" +
                    "4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine();
                    Student newStudent = new Student(name);
                    students.add(newStudent);
                    System.out.println("Student added: " + name);
                    break;

                case 2:
                    System.out.print("Enter the student's name: ");
                    String studentName = scanner.nextLine();
                    Student foundStudent = null;
                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(studentName)) {
                            foundStudent = student;
                            break;
                        }
                    }
                    if (foundStudent != null) {
                        System.out.print("Enter the qualification: ");
                        int note = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        foundStudent.addQualification(note);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students in the system.");
                    } else {
                        System.out.println("Students in the system:");
                        for (Student student : students) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

}
