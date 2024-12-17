package ice.ice;

public class carTrips extends Emission {

    private Car car;
    private double distance;

    carTrips(Car car, double distance) {
        super(car.getFuelType().getCo2GramsPrKm()* distance);
        this.car = car;
        this.distance = distance;
    }
    public double getDistance() {
        return distance;
    }

    public Car getCar(){
        return car;
    }
}
