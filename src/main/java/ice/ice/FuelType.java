package ice.ice;

public enum FuelType {
    DIESEL  (2300.0, "Diesel"),
    ELECTRIC(0.0, "Electric"),
    GASOLINE(2600.0, "Gasoline"),
    JETFUEL (10000, "JetFuel");

    final double co2GramsPrKm;
    final String type;

    private FuelType(double co2GramsPrKm, String type){
        this.co2GramsPrKm = co2GramsPrKm;
        this.type = type;
    }

    public double getCo2GramsPrKm() {
        return co2GramsPrKm;
    }
    public String getType() {return this.type;}
}
