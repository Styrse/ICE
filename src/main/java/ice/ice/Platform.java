package ice.ice;

import java.util.ArrayList;

public class Platform {
    private String platformName;
    User currentUser;
    User averageUser;
    ArrayList<User> users;



    public Platform(String platformName) {
        this.platformName = platformName;
        this.users = new ArrayList<>();
    }

    public String getPlatformName() {
        return platformName;
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
