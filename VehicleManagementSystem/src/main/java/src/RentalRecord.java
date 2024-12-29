package src;

public class RentalRecord {

    private Vehicle vehicle;
    private int rentalDays;

    // Constructor
    public RentalRecord(Vehicle vehicle, int rentalDays) {
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
    }

    // Getters
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getRentalDays() {
        return rentalDays;
    }
    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

}