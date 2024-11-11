package Exercise.ToUpgrade.EmployeeBonuses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private String name;
    private double baseSalary;
    private int yearsOfExperience;

    // List to store all employees
    private static List<Employee> employees = new ArrayList<>();

    // Constructor
    public Employee(String name, double baseSalary, int yearsOfExperience) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Method to calculate the end-of-year bonus
    public double calculateBonus() {
        double bonusPercentage = 0.05 * yearsOfExperience; // 5% per year of experience
        return baseSalary * bonusPercentage;
    }

    // Method to add an employee to the list
    public static void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee.getName());
    }

    // Method to display all employees and their bonuses
    public static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
        } else {
            System.out.println("Employees in the Company:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    // Method to calculate the total bonuses for all employees
    public static double calculateTotalBonuses() {
        double totalBonuses = 0;
        for (Employee employee : employees) {
            totalBonuses += employee.calculateBonus();
        }
        return totalBonuses;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", baseSalary=" + baseSalary +
                ", yearsOfExperience=" + yearsOfExperience +
                ", end-of-year bonus=" + calculateBonus() +
                '}';
    }

    // Main method with menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System\n" +
                    "1. Add an employee\n" +
                    "2. Display all employees and their bonuses\n" +
                    "3. Show total bonuses for all employees\n" +
                    "4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter base salary: ");
                    double baseSalary = scanner.nextDouble();
                    System.out.print("Enter years of experience: ");
                    int yearsOfExperience = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Employee employee = new Employee(name, baseSalary, yearsOfExperience);
                    addEmployee(employee);
                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    double totalBonuses = calculateTotalBonuses();
                    System.out.println("Total bonuses for all employees: $" + totalBonuses);
                    break;

                case 4:
                    System.out.println("Exiting the employee management system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
