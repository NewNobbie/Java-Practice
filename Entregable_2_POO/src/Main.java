import Exercise.*;
import Exercise.ContactList.Agenda;
import Exercise.ToUpgrade.BankTransferSystem.BankT;
import Exercise.ToUpgrade.EmployeeBonuses.Employee;
import Exercise.ToUpgrade.FlightReservationSystem.Reservation;
import Exercise.ToUpgrade.LoanBooks.Library;
import Exercise.ToUpgrade.MaintenanceVehicles.Fleet;
import Exercise.ToUpgrade.OnlineResgister.Order;
import Exercise.ToUpgrade.PaymentSystem.Payments;
import Exercise.ToUpgrade.ProductCategory.Inventory;
import Exercise.ToUpgrade.StoreInventory.SInventory;
import Exercise.ToUpgrade.Timekeeping.TimeControl;
import Exercise.ToUpgrade.VehicleInheritance.VehicleI;
import Exercise.ToUpgrade.VideoGame.Character;
import Exercise.ToUpgrade.Zoo.Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello to deliverable #2!");

        Scanner scanner = new Scanner(System.in);

        boolean next = true;

        while (next){
            System.out.println("Main / Menu\n" +
                    "- - - - - -\n" +
                    "1. Class Product\n" +
                    "2. Class Book and Printer method\n" +
                    "3. Basic Vehicle system\n" +
                    "4. Class person\n" +
                    "5. Class Bank Account\n" +
                    "6. Contact List\n" +
                    "7. Qualifications system for students\n" +
                    "8. Product inventory with categories\n" +
                    "9. Library system\n" +
                    "10. Employee system with bonus management\n" +
                    "11. System of vehicles with inheritance\n" +
                    "12. System video game characters\n" +
                    "13. Zoo System\n" +
                    "14. Payments System\n" +
                    "15. Fleet maintenance vehicles\n" +
                    "16. Inventory management store system\n" +
                    "17. Sales registers Online store\n" +
                    "18. Hours control App for employee\n" +
                    "19. Flight reservation system\n" +
                    "20. Bank transfer system\n");
            int option = scanner.nextInt();
            scanner.nextLine();


            switch (option){
                case 1:
                    Product.main(null);
                    break;
                case 2:
                    Book.main(null);
                    break;
                case 3:
                    Vehicle.main(null);
                    break;
                case 4:
                    Person.main(null);
                    break;
                case 5:
                    BankAccount.main(null);
                    break;
                case 6:
                    Agenda.main(null);
                    break;
                case 7:
                    Student.main(null);
                    break;
                case 8:
                    Inventory.main(null);
                    break;
                case 9:
                    Library.main(null);
                    break;
                case 10:
                    Employee.main(null);
                    break;
                case 11:
                    VehicleI.main(null);
                    break;
                case 12:
                    Character.main(null);
                    break;
                case 13:
                    Animals.main(null);
                    break;
                case 14:
                    Payments.main(null);
                    break;
                case 15:
                    Fleet.main(null);
                    break;
                case 16:
                    SInventory.main(null);
                    break;
                case 17:
                    Order.main(null);
                    break;
                case 18:
                    TimeControl.main(null);
                    break;
                case 19:
                    Reservation.main(null);
                    break;
                case 20:
                    BankT.main(null);
                    break;
                default:
                    System.out.println("Invalid option try again...");
            }







        }

    }
}