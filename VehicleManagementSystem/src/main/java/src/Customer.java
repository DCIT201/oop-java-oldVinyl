package src;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private int age;
    private String licenseNumber;
    private List<RentalRecord> rentalRecords;
    private boolean isEligible = true;

    //Constructors
    public Customer(String name, int age, String licenseNumber) {
        this.name = name;
        this.age = age;
        this.licenseNumber = licenseNumber;
        this.rentalRecords = new ArrayList<>();
    }
    public Customer() {
    }

    //Getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public List<RentalRecord> getRentalRecords() {
        return rentalRecords;
    }
    public void setRentalRecords(List<RentalRecord> rentalRecords) {
        this.rentalRecords = rentalRecords;
    }

    public boolean getIsEligible() {
        return isEligible;
    }
    public void setIsEligible(boolean isEligible) {
        //sets the eligibility
        this.isEligible = isEligible;
    }

    //to add a rental record
    public void addRentalRecord(Vehicle vehicle, int days) {
        RentalRecord record = new RentalRecord(vehicle, days);
        rentalRecords.add(record);
    }

    //Check if the customer is eligible to rent a specific vehicle
    public boolean isEligibleToRent(Vehicle vehicle) {
        return getIsEligible();
    }
}