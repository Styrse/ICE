package ice.ice;

import java.util.ArrayList;

public class Car {

    private String licensePlate;
    private String carBrand;
    private double fuelType;
    private double kmPrLitre;
    private double co2PrKm;
    private ArrayList<Car> cars;
    private User user;
    private double distance;
    private double co2PrLitre;
    private FuelType fuelTypeEnum ;


    public Car(User user, String licensePlate, String carBrand, FuelType fuelTypeEnum, double kmPrLitre, double distance) {
        this.user = user;
        this.licensePlate = licensePlate;
        this.carBrand = carBrand;

        this.co2PrLitre = fuelTypeEnum.getCo2GramsPrKm() * kmPrLitre; //                                         = Kg/L
        this.kmPrLitre = kmPrLitre;//                                                                           = Km/L
        this.co2PrKm = fuelTypeEnum.getCo2GramsPrKm();//                                                        = Kg/Km

        this.distance = distance;
        this.cars = cars;
        this.fuelTypeEnum = fuelTypeEnum;
    }

    public Car(User user, String licensePlate) {
        this.user = user;
        this.licensePlate = licensePlate;
        this.co2PrKm = fuelTypeToCo2PrLiter(fuelTypeEnum)/ kmPrLitre;
    }


    public Car(User user, double fuelType, float kmPrLiter) {
        this.user = user;
        this.kmPrLitre = kmPrLiter;
        this.co2PrKm = fuelType/kmPrLiter;
    }

    public double getDistance() {
        return this.distance;
    }

    public long  calcFuelUsed(double distance){
        long result = 0;
        result = (1 / (long) kmPrLitre)*(long)distance;
        return result;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public double getKmPrLitre() {
        return this.kmPrLitre;
    }

    public Double fuelTypeToCo2PrLiter(FuelType fuelType)  {
        //Use this method when calculating total emission with cloth, publicTrans, etc
        return fuelTypeEnum.getCo2GramsPrKm();
    }

    FuelType getFuelType() {
        return this.fuelTypeEnum;
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
                "User:" + user.getUsername() + '\'' +
                ", LicensePlate='" + licensePlate +
                ", Brand=" + carBrand +
                ", FuelType=" + fuelType +
                "kmPrLitre=" + kmPrLitre +
                '}';
    }
}
