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
    private IT it;
    private Load load;
    private Save save;
    private static Platform instance;

    public Platform(String platformName) {
        this.platformName = platformName;
        this.users = new ArrayList<>();
        this.clothes = new ArrayList<>();
        this.fabrics = new ArrayList<>();
        this.transports = new ArrayList<>();
        this.renewableEnergies = new ArrayList<>();
        this.foods = new ArrayList<>();
        this.it = new IT();
        this.load = new Load(users, clothes, fabrics, transports, renewableEnergies, foods);
        this.save = new Save();
        instance = this;
    }

    public static Platform getInstance() {
        return instance;
    }

    public void setup(){
        load.loadSetup();
    }

    public String getPlatformName() {
        return platformName;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<User> getUsers() {
        return users;
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

    public void deleteUser() {
        try {
            getInstance().getUsers().remove(currentUser);
        } catch (Exception e) {
            System.out.println("Error user not deleted");
        }
    }

    public void close() {
        save.usersToText();
    }

    public void addUser(User user){
        users.add(user);
    }
}
