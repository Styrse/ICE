package ice.ice;

import java.util.HashMap;

public class Car {
    private String licensePlate;
    private String carBrand;
    private String fuelType;
    private float kmPrLitre;
    static HashMap<String, Double> fuelCo2PrKm = new HashMap<>();
    private User currentUser;

    public Car(String licensePlate,String carBrand, String fuelType,float kmPrLitre) {
        this.licensePlate = licensePlate;
        this.carBrand = carBrand;
        this.fuelType = fuelType;
        this.kmPrLitre = kmPrLitre;
        this.currentUser = currentUser;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public float getKmPrLitre() {
        return this.kmPrLitre;
    }

    //need data for co2 emission with different fuel types
    public static void initialiseFuelCo2PrKm()  {
        fuelCo2PrKm.put("gasoline", 0.0);
        fuelCo2PrKm.put("electric", 0.0);
        fuelCo2PrKm.put("diesel", 0.0);
    }

    public Double getFuelCo2PrKmCar()  {
        return fuelCo2PrKm.get(this.fuelType); //Use this method when calculating total emission with cloth, publicTrans, etc
    }

    @Override
    public String toString() {
        return "UserCar{" +
                "User:" + currentUser + + '\'' + //TODO Test if currentUser gives username or whole information in user class.
                "LicensePlate='" + licensePlate +
                ", Brand=" + carBrand +
                ", FuelType=" + fuelType +
                "kmPrLitre=" + kmPrLitre +
                '}';
    }

}
