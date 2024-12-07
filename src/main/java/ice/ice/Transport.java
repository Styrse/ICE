package ice.ice;

import java.util.ArrayList;
import java.util.HashMap;

public class Transport  {
    private String VehicleType;
    private double averageSpeed;
    private double co2PrKm;


    public Transport(String vehicleType, double averageSpeed, double co2PrKm) {
        this.VehicleType = vehicleType;
        this.averageSpeed = averageSpeed;
        this.co2PrKm = co2PrKm;
    }


    public double emissionPrMin()   {
        double kmPrMin = averageSpeed/60;
        double result = kmPrMin * co2PrKm;
        return result;
    }
    //TODO data for public transport only tell you about overall co2 emission instead of pr person emission when taking public transport. Find more relevant data.
}
