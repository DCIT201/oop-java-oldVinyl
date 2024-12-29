package src;

public class Motorcycle extends Vehicle {

    //constructors - default, custom
    public Motorcycle () {};
    public Motorcycle (String id, String model, int numberOfDays, boolean availability) {
        super(id, model, numberOfDays, availability);
    };
    public Motorcycle (String id, String model, int numberOfDays, boolean availability, double topSpeed, boolean hasSidecar) {
        super(id, model, numberOfDays, availability);
        setTopSpeed(topSpeed);
        setHasSidecar(hasSidecar);
    };

    //data field
    private double topSpeed;
    private boolean hasSidecar;
    private int days;
    final double motorBaseRent = 59.99;

    //methods
    //getters and setters
    public double getTopSpeed() {
        return topSpeed;
    }
    public void setTopSpeed(double speed) {
        this.topSpeed = speed;
    }

    public boolean getHasSideCar() {
        return hasSidecar;
    }
    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }



    @Override
    public double calculateRentalCost(int days) {
        return days * motorBaseRent;
    }

    @Override
    public boolean isAvailableForRental() {
        return super.isAvailable() && days > 1;
        //will only be available if you want to rent for more than a day
    }
}
