package ice.ice;

import java.util.ArrayList;
import java.util.HashMap;

public class Car {
    private String licensePlate;
    private String carBrand;
    private String fuelType;
    private float kmPrLitre;
    private double co2PrKm;
    private static HashMap<String, Double> fuelCo2PrKm = new HashMap<>();
    private ArrayList<Car> cars;
    private User user;

    public Car(User user, String licensePlate) {
        this.user = user;
        this.licensePlate = licensePlate;
        this.co2PrKm = fuelTypeToCo2PrLiter(fuelType) / kmPrLitre;
    }

    public Car(User user, String fuelType, float kmPrLitre) {
        this.user = user;
        this.fuelType = fuelType;
        this.kmPrLitre = kmPrLitre;
        this.co2PrKm = fuelTypeToCo2PrLiter(fuelType) / kmPrLitre;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }


    public float getKmPrLitre() {
        return this.kmPrLitre;
    }

    //TODO need data for co2 emission with different fuel types
    public static void initialiseFuelCo2PrKm()  {
        fuelCo2PrKm.put("gasoline", 2300.0);
        fuelCo2PrKm.put("electric", 0.0);
        fuelCo2PrKm.put("diesel", 2600.0);
    }

    public double fuelTypeToCo2PrLiter(String fuelType)  {
        //Use this method when calculating total emission with cloth, publicTrans, etc
        return fuelCo2PrKm.get(this.fuelType);
    }

    public void saveCarDataToText()   {
        ArrayList<String> addCarArray = new ArrayList<>();
        for (Car c : cars) {
            addCarArray.add(c.toString());
        }
        FileIO.fileWriter(addCarArray, "data/emission/Cardata.csv");
    }

    public void setCurrentUser(User currentUser) {
        this.user = currentUser;
    }

    @Override
    public String toString() {
        return "UserCar{" +
                "User:" + user.getUsername() + '\'' + //TODO Test if currentUser gives username or whole information in user class.
                ", LicensePlate='" + licensePlate +
                ", Brand=" + carBrand +
                ", FuelType=" + fuelType +
                "kmPrLitre=" + kmPrLitre +
                '}';
    }

}
