package src;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {

    private String agencyName;
    private List<Vehicle> vehicles;
    private List<Customer> customers;

    public String getAgencyName() {
        return agencyName;
    }
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    //Constructor
    public RentalAgency(String agencyName) {
        this.agencyName = agencyName;
        this.vehicles = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Add a vehicle to the agency
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Add a customer to the agency
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Rent a vehicle
    public void rentVehicle(String customerName, String vehicleModel, int rentalDays) {
        Customer customer = findCustomerByName(customerName);
        Vehicle vehicle = findVehicleByModel(vehicleModel);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle is not available for rent.");
            return;
        }

        if (!customer.isEligibleToRent(vehicle)) {
            System.out.println("Customer is not eligible to rent this vehicle.");
            return;
        }

        // Process the rental
        vehicle.setIsAvailable(false);
        customer.addRentalRecord(vehicle, rentalDays);
        System.out.println("Rental successful: " + vehicleModel + " rented to " + customerName + " for " + rentalDays + " days.");
    }

    // Return a vehicle
    public void returnVehicle(String vehicleModel) {
        Vehicle vehicle = findVehicleByModel(vehicleModel);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        if (vehicle.isAvailable()) {
            System.out.println("This vehicle was not rented.");
            return;
        }

        // Process the return
        vehicle.setIsAvailable(true);
        System.out.println("Vehicle returned successfully: " + vehicleModel);
    }

    // Generate rental receipts for a customer
    public void generateRentalReceipt(String customerName) {
        Customer customer = findCustomerByName(customerName);

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Rental Receipt for " + customer.getName() + ":");
        for (RentalRecord record : customer.getRentalRecords()) {
            System.out.println(" - Vehicle: " + record.getVehicle().getModel() +
                    ", Days Rented: " + record.getRentalDays() +
                    ", Total Cost: $" + record.getRentalDays() * record.getVehicle().getBaseRentalRate());
        }
    }

    // List available vehicles
    public void showAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                System.out.println(" - " + vehicle.getVehicleId() + " - " + vehicle.getModel() + " ($" + vehicle.getBaseRentalRate() + "/day)");
            }
        }
    }

    // Helper method: Find a customer by name
    private Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    // Helper method: Find a vehicle by model
    private Vehicle findVehicleByModel(String model) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getModel().equalsIgnoreCase(model)) {
                return vehicle;
            }
        }
        return null;
    }
}

