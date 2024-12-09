package ice.ice;

import java.util.ArrayList;
import java.util.HashMap;

public class Car {
    private String licensePlate;
    private String carBrand;
    private String fuelType;
    private float kmPrLitre;
    private static HashMap<String, Double> fuelCo2PrKm = new HashMap<>();
    private ArrayList<Car> cars;
    private User currentUser;

    public Car(String licensePlate,String carBrand, String fuelType,float kmPrLitre) {
        this.licensePlate = licensePlate;
        this.carBrand = carBrand;
        this.fuelType = fuelType;
        this.kmPrLitre = kmPrLitre;
        this.currentUser = currentUser;
        this.cars = cars;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }


    public float getKmPrLitre() {
        return this.kmPrLitre;
    }

    //TODO need data for co2 emission with different fuel types
    public static void initialiseFuelCo2PrKm()  {
        fuelCo2PrKm.put("gasoline", 0.0);
        fuelCo2PrKm.put("electric", 0.0);
        fuelCo2PrKm.put("diesel", 0.0);
    }

    public Double fuelTypeToCo2PrKm()  {
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

    @Override
    public String toString() {
        return "UserCar{" +
                "User:" + currentUser + + '\'' + //TODO Test if currentUser gives username or whole information in user class.
                ", LicensePlate='" + licensePlate +
                ", Brand=" + carBrand +
                ", FuelType=" + fuelType +
                "kmPrLitre=" + kmPrLitre +
                '}';
    }

}
