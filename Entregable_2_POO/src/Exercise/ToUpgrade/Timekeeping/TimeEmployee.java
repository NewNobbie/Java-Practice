package Exercise.ToUpgrade.Timekeeping;

public class TimeEmployee {
    private String name;
    private double hourlyWage;
    private double hoursWorked;

    // Constructor
    public TimeEmployee(String name, double hourlyWage) {
        this.name = name;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = 0;
    }

    // Method to register hours worked
    public void registerHours(double hours) {
        if (hours > 0) {
            this.hoursWorked += hours;
            System.out.println(hours + " hours registered for " + name);
        } else {
            System.out.println("Invalid hours. Please enter a positive number.");
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    // Reset hours worked (for a new week)
    public void resetHours() {
        this.hoursWorked = 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", hourlyWage=" + hourlyWage +
                ", hoursWorked=" + hoursWorked +
                '}';
    }
}
