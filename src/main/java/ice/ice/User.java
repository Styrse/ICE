package ice.ice;

import java.time.LocalDate;

public class User {
    private String username;
    private String name;
    private String password;
    private String gender;
    private LocalDate birthday;
    private Address address;
    private Co2 co2Counter;
    private Car myCar;
    private double baseline;
    private int userId;
    private static int idCount = 1;
    private int recurringTrips;
    private float tripDistance;
    private int plantedTrees;
    private double dailyCo2Usage = 0;

    public static double averageCo2EmissionPrYear = 7000000;
    public static double fixedCo2PrYear = 3000000;
    public static double co2Goal2030 = 4900000;

    public User(String username, String name, String password, String gender, LocalDate birthday) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.userId = idCount++;
        Platform.getInstance().addUser(this);
        Platform.getInstance().setCurrentUser(this);
    }

    public User(String username, String name, String password, String gender, LocalDate birthday, Address address, int plantedTrees) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.plantedTrees = plantedTrees;
        this.userId = idCount++;
        Platform.getInstance().addUser(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Co2 getCo2Counter() {
        return co2Counter;
    }

    public void setCo2Counter(Co2 co2Counter) {
        this.co2Counter = co2Counter;
    }

    public double getBaseline() {
        return baseline;
    }

    public void setBaseline(double baseline) {
        this.baseline = baseline;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getUserId() {
        return userId;
    }

    public Car getMyCar() {
        return myCar;
    }

    public void setMyCar(Car myCar) {
        this.myCar = myCar;
        this.myCar.setCurrentUser(this);
    }

    public int getRecurringTrips() {
        return recurringTrips;
    }

    public void setRecurringTrips(int recurringTrips) {
        this.recurringTrips = recurringTrips;
    }

    public float getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(float tripDistance) {
        this.tripDistance = tripDistance;
    }

    public int getPlantedTrees() {
        return plantedTrees;
    }

    public void addPlantedTrees(int amount){
        plantedTrees += amount;
    }

    public double getDailyCo2Usage() {
        return dailyCo2Usage;
    }

    public void adjustCo2(double co2grams){
        dailyCo2Usage += co2grams;
    }

    public String saveUserInfo(){
        return username + "; " +
                name + "; " +
                password + "; " +
                gender + "; " +
                birthday + "; " +
                address.saveAddressInfo() + "; " +
                plantedTrees;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
