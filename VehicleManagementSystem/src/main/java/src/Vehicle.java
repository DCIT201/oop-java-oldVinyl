package src;

public abstract class Vehicle {

    //CONSTRUCTORS - default, custom
    public Vehicle () {
        isAvailable = true;
    };
    public Vehicle (String id, String model, int numOfDays, boolean availability) {
        setVehicleId(id);
        setModel(model);
        setBaseRentalRate(calculateRentalCost(numOfDays));
        setIsAvailable(availability);
        isAvailable = true;
    };

    //DATA FIELD
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;

    //METHODS
    //setters
    public void setVehicleId(String id) {
        this.vehicleId = id;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setBaseRentalRate(double baseRentRate) {
        this.baseRentalRate = baseRentRate;
    }
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    //getters
    public String getVehicleId() {
        return vehicleId;
    }
    public String getModel() {
        return model;
    }
    public double getBaseRentalRate() {
        return baseRentalRate;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    //abstract methods
    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();

}
