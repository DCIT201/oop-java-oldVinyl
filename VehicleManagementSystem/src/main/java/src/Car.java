package src;

public class Car extends Vehicle {

    //constructors - default, custom
    Car () {};
    public Car(String id, String model, int numberOfDays, boolean availability) {
        super(id, model, numberOfDays, availability);
    };
    public Car (String id, String model, int numberOfDays, boolean availability, String colour, String fuelType) {
        super(id, model, numberOfDays, availability);
        setColour(colour);
        setFuelType(fuelType);
    };

    //data field
    private String colour;
    private String fuelType;
    private int days;
    final double carBaseRent = 99.99;

    //methods
    //getters and setters
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }



    @Override
    public double calculateRentalCost(int days) {
        return days * carBaseRent;
    }

    @Override
    public boolean isAvailableForRental() {
        return super.isAvailable() && colour.equals("black");
        //no black cars are available
    }
}
