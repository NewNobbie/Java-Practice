package Exercise.ToUpgrade.Timekeeping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeControl {

    private List<TimeEmployee> employees;

    // Constants
    private static final int REGULAR_HOURS = 40;
    private static final double OVERTIME_MULTIPLIER = 1.5;

    // Constructor
    public TimeControl() {
        this.employees = new ArrayList<>();
    }

    // Method to add an employee
    public void addEmployee(TimeEmployee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee.getName());
    }

    // Method to calculate weekly salary
    public double calculateWeeklySalary(TimeEmployee employee) {
        double hoursWorked = employee.getHoursWorked();
        double hourlyWage = employee.getHourlyWage();
        double regularPay, overtimePay = 0;

        if (hoursWorked > REGULAR_HOURS) {
            regularPay = REGULAR_HOURS * hourlyWage;
            overtimePay = (hoursWorked - REGULAR_HOURS) * hourlyWage * OVERTIME_MULTIPLIER;
        } else {
            regularPay = hoursWorked * hourlyWage;
        }

        return regularPay + overtimePay;
    }

    // Method to display all employees and their weekly salaries
    public void displayEmployeeSalaries() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
        } else {
            System.out.println("Weekly Salaries:");
            for (TimeEmployee employee : employees) {
                double salary = calculateWeeklySalary(employee);
                System.out.println(employee.getName() + ": $" + salary);
            }
        }
    }

    // Method to register hours for an employee
    public void registerHoursForEmployee(String employeeName, double hours) {
        TimeEmployee employee = findEmployeeByName(employeeName);
        if (employee != null) {
            employee.registerHours(hours);
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Method to find an employee by name
    private TimeEmployee findEmployeeByName(String name) {
        for (TimeEmployee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }

    // Method to reset hours for all employees (for a new week)
    public void resetAllHours() {
        for (TimeEmployee employee : employees) {
            employee.resetHours();
        }
        System.out.println("Hours reset for all employees.");
    }

    // Main method with menu
    public static void main(String[] args) {
        TimeControl timeControl = new TimeControl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Time Control System\n" +
                    "1. Add an employee\n" +
                    "2. Register hours worked\n" +
                    "3. Display weekly salaries\n" +
                    "4. Reset hours for a new week\n" +
                    "5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter hourly wage: ");
                    double wage = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    TimeEmployee employee = new TimeEmployee(name, wage);
                    timeControl.addEmployee(employee);
                    break;

                case 2:
                    System.out.print("Enter employee name: ");
                    String employeeName = scanner.nextLine();
                    System.out.print("Enter hours worked: ");
                    double hours = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    timeControl.registerHoursForEmployee(employeeName, hours);
                    break;

                case 3:
                    timeControl.displayEmployeeSalaries();
                    break;

                case 4:
                    timeControl.resetAllHours();
                    break;

                case 5:
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
