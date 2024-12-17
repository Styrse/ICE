package ice.ice;

import java.util.ArrayList;
import java.util.HashMap;

public class Car extends Emission {
    //Class attributes/fields
    private String licensePlate;
    private String carBrand;
    private double fuelType;
    private double kmPrLitre;
    private double co2PrKm;
    private static HashMap<String, Double> fuelCo2PrKm = new HashMap<>();
    private ArrayList<Car> cars;
    private User user;
    private double distance;
    private double co2PrLitre;

    //Main constructor
    public Car(User user,
               String licensePlate,
               String carBrand,
               FuelType fuelType,
               double kmPrLitre,
               double distance) {

        super(fuelType.getCo2GramsPrKm() * distance);
        // KmPrLitre / distance                                                                             = L
        // Co2GramsPrKm * distance                                                                          = Kg
        // Distance                                                                                         = Km

        this.user = user;
        this.licensePlate = licensePlate;
        this.carBrand = carBrand;
        this.co2PrLitre = fuelType.getCo2GramsPrKm() * kmPrLitre; //                                         = Kg/L
        this.kmPrLitre = kmPrLitre;//                                                                       = Km/L
        this.co2PrKm = fuelType.getCo2GramsPrKm();//                                                        = Kg/Km
        this.distance = distance;
        this.cars = cars;
    }

/*
    public Car(User user, String licensePlate) {
        super();
        this.user = user;
        this.licensePlate = licensePlate;
        this.co2PrKm = fuelTypeToCo2PrLiter(fuelType)/ kmPrLitre;
    }



    public Car(User user, FuelType fuelType, float kmPrLitre) {
        super();
        this.user = user;
        this.kmPrLitre = kmPrLitre;
        this.co2PrKm = fuelType.co2GramsPrKm ;
    }
 */


    public double getDistance() {
        return this.distance;
    }

    public double calcFuelUsed(double distance){
        double result = 0;
        result = kmPrLitre / distance;
        return result;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }


    public double getKmPrLitre() {
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
