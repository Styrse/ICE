package ice.ice;

public class Transport extends Emission {
    private final String vehicleType;
    private final double averageSpeed;
    private double co2PrKm;
    private final double distance;
    private double co2Gram;

    // The intention is to make
    public Transport(String vehicleType, double averageSpeed,  FuelType fuelType, double travelDistance){
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


    public double calc(){
        return 0;
    }

    String getVehicleType() {
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
    }   // end getDistance()

    public double emissionPrMin()   {
        double kmPrMin = averageSpeed/60;
        double result = kmPrMin * co2PrKm;
        return result;
    }

    public double calcCo2(){
        return getCo2PrKm() * getDistance();
    } // end calcCo2()

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

    //TODO data for public transport only tell you about overall co2 emission instead of pr person emission when taking public transport. Find more relevant data.
    // This is done in Emissions calcEmissionsFromAL & calcOffsetsFromAL
}
