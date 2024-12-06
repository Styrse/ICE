package ice.ice;

import java.util.ArrayList;

public class Platform {
    private String platformName;
    private GUI gui;
    User currentUser;
    User averageUser;
    ArrayList<User> users;
    Clothes clothes;
    //Transport transport;
    //RenewableEnergy renewableEnergy;
    Food food;



    public Platform(String platformName) {
        this.platformName = platformName;
        this.users = new ArrayList<>();
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setup(){
        clothes.setupClothes();
        //transport.setupTransport();
        //renewableEnergy.setupRenewableEnergy();
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
}
