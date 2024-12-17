package ice.ice;

public abstract class Train extends Transport {
    public Train(double averageSpeed, double distance) {
        super("Train", averageSpeed, FuelType.ELECTRIC, distance);
    }
}
