package src;

public class Truck extends Vehicle {

    //constructors - default, custom
    public Truck () {};
    public Truck (String id, String model, int numberOfDays, boolean availability) {
        super(id, model, numberOfDays, availability);
    };
    public Truck (String id, String model, int numberOfDays, boolean availability, double capacity, boolean canDriveOffroad) {
        super(id, model, numberOfDays, availability);
        setCapacity(capacity);
        setCanDriveOffroad(canDriveOffroad);
    };

    //data field
    private double capacity;
    private boolean canDriveOffroad;
    private int days;
    final double truckBaseRent = 169.99;

    //methods
    //getters and setters
    public double getCapacity() {
        return capacity;
    }
    public void setCapacity(double canDriveOffroad) {
        this.capacity = canDriveOffroad;
    }

    public boolean getCanDriveOffroad() {
        return canDriveOffroad;
    }
    public void setCanDriveOffroad(boolean canDriveOffroad) {
        this.canDriveOffroad = canDriveOffroad;
    }

    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }



    @Override
    public double calculateRentalCost(int days) {
        return days * truckBaseRent;
    }

    @Override
    public boolean isAvailableForRental() {
        return super.isAvailable() && canDriveOffroad;
        //will only be available if you want a truck that can't drive off road
    }
}
