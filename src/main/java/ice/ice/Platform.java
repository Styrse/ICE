package ice.ice;

import java.util.ArrayList;

public class Platform {
    private String platformName;
    private User currentUser;
    private User averageUser;
    private ArrayList<User> users;
    private ArrayList<Clothes> clothes;
    private ArrayList<Fabric> fabrics;
    private ArrayList<Transport> transports;
    private ArrayList<RenewableEnergy> renewableEnergies;   //TODO load
    private ArrayList<Food> foods;
    private Load load;
    private static Platform instance;

    public Platform(String platformName) {
        this.platformName = platformName;
        this.users = new ArrayList<>();
        this.clothes = new ArrayList<>();
        this.fabrics = new ArrayList<>();
        this.transports = new ArrayList<>();
        this.renewableEnergies = new ArrayList<>();
        this.foods = new ArrayList<>();
        this.load = new Load(users, clothes, fabrics, transports, renewableEnergies, foods);
        instance = this;
    }

    public static Platform getInstance(){
        return instance;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setup(){
        load.loadSetup();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User getAverageUser() {
        return averageUser;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void addUser(User user){
        users.add(user);
    }
}
