package ice.ice;

public class Transport extends Emission {
    private final String vehicleType;
    private final double averageSpeed;
    private double co2PrKm;
    private final double distance;
    private double co2Gram;

    public Transport(String vehicleType, double averageSpeed, FuelType fuelType, double travelDistance){
        super((fuelType.getCo2GramsPrKm()) * travelDistance);       //Calculates total co2Gram for every total distance
        this.distance = travelDistance;
        this.vehicleType = vehicleType;
        this.averageSpeed = averageSpeed;
        //this.co2PrKm = co2PrKm;
    }

    public double calcTotalCarbonEmission(){
        double result = 0;
        result += co2Gram;
        return result;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public double getAverageSpeed() {
        return this.averageSpeed;
    }

    public double getCo2PrKm() {
        return this.co2PrKm;
    }

    public double getDistance() {
        return this.distance;
    }

    public double emissionPrMin()   {
        double kmPrMin = averageSpeed/60;
        double result = kmPrMin * co2PrKm;
        return result;
    }

    public double calcCo2(){
        return getCo2PrKm() * getDistance();
    }

    public String saveTransportInfo(){
        return  vehicleType + "; " +
                averageSpeed + "; " +
                co2PrKm + ";" +
                distance;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "VehicleType='" + vehicleType + "\'" +
                ", averageSpeed=" + averageSpeed +
                ", co2PrKm=" + co2PrKm +
                ", distanceKm=" + distance +
                "}";
    }
}
