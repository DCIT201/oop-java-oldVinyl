import java.util.Scanner;
import src.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Create the Rental Agency
        RentalAgency rentalAgency = new RentalAgency("V's Formula[TM] Rentals");

        //Preload sample vehicles
        rentalAgency.addVehicle(new Car("Toyota Corolla", "50.0.12", 5, true, "black", "Diesel"));
        rentalAgency.addVehicle(new Motorcycle("Harley Davidson", "43.6.0", 3, true));
        rentalAgency.addVehicle(new Truck("Ford F-150", "3.21.2", 12, true, 512.72, true));

        //Preload sample customers
        rentalAgency.addCustomer(new Customer("Charles LeClerc", 25, "123456789"));
        rentalAgency.addCustomer(new Customer("Dorianne Pin", 30, "987654321"));

        System.out.println("Welcome to V's Formula[TM] Rentals!");
        int choice;

        do {
            // Main menu
            System.out.println("\nMain Menu:");
            System.out.println("1. Show available vehicles");
            System.out.println("2. Add a new customer");
            System.out.println("3. Rent a vehicle");
            System.out.println("4. Return a vehicle");
            System.out.println("5. Generate rental receipt");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer

            switch (choice) {
                case 1:
                    // Show available vehicles
                    rentalAgency.showAvailableVehicles();
                    break;

                case 2:
                    // Add a new customer
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Clear the input buffer
                    System.out.print("Enter customer license number: ");
                    String license = scanner.nextLine();
                    rentalAgency.addCustomer(new Customer(name, age, license));
                    System.out.println("Customer added successfully!");
                    break;

                case 3:
                    // Rent a vehicle
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter vehicle model: ");
                    String vehicleModel = scanner.nextLine();
                    System.out.print("Enter rental days: ");
                    int rentalDays = scanner.nextInt();
                    rentalAgency.rentVehicle(customerName, vehicleModel, rentalDays);
                    break;

                case 4:
                    // Return a vehicle
                    System.out.print("Enter vehicle model to return: ");
                    String returnModel = scanner.nextLine();
                    rentalAgency.returnVehicle(returnModel);
                    break;

                case 5:
                    // Generate rental receipt
                    System.out.print("Enter customer name: ");
                    String receiptName = scanner.nextLine();
                    rentalAgency.generateRentalReceipt(receiptName);
                    break;

                case 6:
                    // Exit
                    System.out.println("Thank you for using V's Formula[TM] Rentals. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}
