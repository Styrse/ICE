package ice.ice;

public enum FuelType {
    DIESEL  (2300.0),
    ELECTRIC(0.0),
    GASOLINE(2600.0),
    JETFUEL (10000);

    final double co2GramsPrKm;

    private FuelType(double co2GramsPrKm){
        this.co2GramsPrKm = co2GramsPrKm;
    }

    public double getCo2GramsPrKm() {
        return co2GramsPrKm;
    }
}
