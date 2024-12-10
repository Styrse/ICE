package ice.ice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Load {
    private ArrayList<User> users;
    private ArrayList<Clothes> clothes;
    private ArrayList<Fabric> fabrics;
    private ArrayList<Transport> transports;
    //private ArrayList<Car> cars;
    private ArrayList<RenewableEnergy> renewableEnergies;
    private ArrayList<Food> foods;

    public Load(ArrayList<User> users, ArrayList<Clothes> clothes, ArrayList<Fabric> fabrics, ArrayList<Transport> transports, ArrayList<RenewableEnergy> renewableEnergies, ArrayList<Food> foods) {
        this.users = users;
        this.clothes = clothes;
        this.fabrics = fabrics;
        this.transports = transports;
        //this.cars = cars;
        this.renewableEnergies = renewableEnergies;
        this.foods = foods;
    }

    public void loadSetup(){
        loadUsers();
        loadClothes();
        loadFabrics();
        loadPublicTransportData();
        //loadCarData();
    }

    public void loadPublicTransportData()  {
        ArrayList<String> data = FileIO.fileReader("src/main/java/data/emission/PublicTransport");
        for (String s : data)   {
            String[] values = s.split(";");
            Transport tmpTransport = new Transport (values[0], (Double.parseDouble(values[1])), (Double.parseDouble(values[2])));
            transports.add(tmpTransport);
        }
    }

    //TODO loadcardata value 0 should be username. it starts with licenseplate, talk with other group members to find  a solution.
    /*public void loadCarData()   {
        ArrayList<String> data = FileIO.fileReader("src/main/java/data/emission/Cardata");
                for (String s : data)   {
                    String[] values = s.split(";");
                    Car tmpCar = new Car (values[0].trim(), values[1].trim(), values[2].trim(), values[3].trim(), (Float.parseFloat(values[4].trim())));
                    cars.add(tmpCar);
                }
    }*/

    public void loadUsers(){
        ArrayList<String> temp = FileIO.fileReader("src/main/java/data/users.csv");
        for (String data : temp) {
            String[] tempString = data.split(";");
            String username = tempString[0].trim();
            String name = tempString[1].trim();
            String password = tempString[2].trim();
            String gender = tempString[3].trim();
            String birthday = tempString[4].trim();    //TODO parse to Date data type
            String[] addressArray = tempString[5].split(":");
            Address address = new Address(addressArray[0].trim(), addressArray[1].trim(), addressArray[2].trim(), addressArray[3].trim(), addressArray[4].trim());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date birthdayFormatted;
            try {
                birthdayFormatted = formatter.parse(birthday);
            } catch (ParseException e) {
                throw new RuntimeException(e);
                //TODO IT
            }

            users.add(new User(username, name, password, gender, birthdayFormatted, address));
        }
    }

    public void loadFabrics(){
        ArrayList<String> temp = FileIO.fileReader("src/main/java/data/emission/clothes/fabric.csv");
        for (String data : temp){
            String[] tempString = data.split(";");
            fabrics.add(new Fabric(tempString[0].trim(), Double.parseDouble(tempString[1].trim())));
        }
    }

    public void loadClothes(){
        ArrayList<String> temp = FileIO.fileReader("src/main/java/data/emission/clothes/clothes.csv");
        for (String data : temp){
            String[] tempString = data.split(";");
            clothes.add(new Clothes(tempString[0].trim(), Integer.parseInt(tempString[1].trim())));
        }
    }
}
