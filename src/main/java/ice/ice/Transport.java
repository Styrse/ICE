package ice.ice;

public abstract class Transport extends Emission  {
    private String VehicleType;
    private double co2PrKm;

    public Transport(String vehicleType, double co2PrKm, double co2Gram) {
        super(co2Gram);
        this.VehicleType = vehicleType;
        this.co2PrKm = co2PrKm;
    }
    public void convertTimeToKm()   {
        // (hastighed:86,6/tid:3060)*(køretid*60)
    }
}
