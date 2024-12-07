package ice.ice;

import java.util.ArrayList;

public class Platform {
    private String platformName;
    private User currentUser;
    private User averageUser;
    private ArrayList<User> users;
    private Clothes clothes;
    private Transport transport;
    private RenewableEnergy renewableEnergy;
    private Food food;

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
