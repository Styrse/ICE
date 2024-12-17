package ice.ice;

public enum FuelType {
    DIESEL  (2300.0, "Diesel"),
    ELECTRIC(0.0, "Electric"),
    GASOLINE(2600.0, "Gasoline"),

    JETFUEL (10000, "Jetfuel"),;

    final double co2GramsPrKm;
    final String fuelType;

    private FuelType(double co2GramsPrKm, String fuelType){
        this.co2GramsPrKm = co2GramsPrKm;
        this.fuelType = fuelType;

    public double getCo2GramsPrKm() {
        return co2GramsPrKm;
    }
    public String getType() {return this.type;}
}
