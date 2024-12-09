package ice.ice;

public class Transport  {
    private String vehicleType;
    private double averageSpeed;
    private double co2PrKm;


    public Transport(String vehicleType, double averageSpeed, double co2PrKm) {
        this.vehicleType = vehicleType;
        this.averageSpeed = averageSpeed;
        this.co2PrKm = co2PrKm;
    }

    String getVehicleType() {
        return this.vehicleType;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public double getCo2PrKm() {
        return co2PrKm;
    }

    public double emissionPrMin()   {
        double kmPrMin = averageSpeed/60;
        double result = kmPrMin * co2PrKm;
        return result;
    }

    public String saveTransportInfo(){
        return vehicleType + "; " +
                averageSpeed + "; " +
                co2PrKm;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "VehicleType='" + vehicleType + '\'' +
                ", averageSpeed=" + averageSpeed +
                ", co2PrKm=" + co2PrKm +
                '}';
    }

    //TODO data for public transport only tell you about overall co2 emission instead of pr person emission when taking public transport. Find more relevant data.
}
