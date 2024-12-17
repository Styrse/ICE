package ice.ice;

public class Plane extends Transport {
    public Plane(double averageSpeed, double distance) {
        super("Plane", averageSpeed, FuelType.JETFUEL, distance);
    }
}
