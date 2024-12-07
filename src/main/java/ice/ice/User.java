package ice.ice;

import java.util.Date;
import java.util.HashMap;

public class User {
    private String username;
    private String name;
    private String password;
    private String gender;
    private Date birthday;
    private Address address;
    private Co2 co2Counter;
    private HashMap<Date, Co2> counterCalendar;
//    private Car myCar;
    private double baseline;
    private int userId;
    private static int idCount = 1;

    public User(String username, String name, String password, String gender, Date birthday, Address address) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.userId = idCount++;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getUserId() {
        return userId;
    }
}
