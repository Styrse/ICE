package ice.ice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Load {
    private ArrayList<User> users;
    private ArrayList<Clothes> clothes;
    private ArrayList<Fabric> fabrics;
    private ArrayList<Transport> transports;
    private ArrayList<RenewableEnergy> renewableEnergies;
    private ArrayList<Food> foods;

    public Load(ArrayList<User> users, ArrayList<Clothes> clothes, ArrayList<Fabric> fabrics, ArrayList<Transport> transports, ArrayList<RenewableEnergy> renewableEnergies, ArrayList<Food> foods) {
        this.users = users;
        this.clothes = clothes;
        this.fabrics = fabrics;
        this.transports = transports;
        this.renewableEnergies = renewableEnergies;
        this.foods = foods;
    }

    public void loadSetup(){
        loadUsers();
//        loadClothes();
//        loadPublicTransportData();
        sout();
    }

    public void sout(){
        for (User u : users){
            System.out.println(u);
        }
    }

    public void loadPublicTransportData()  {
        ArrayList<String> data = FileIO.fileReader("data/PublicTransport");
        for (String s : data)   {
            String[] values = s.split(";");
            Transport tmpTransport = new Transport (values[0], (Double.parseDouble(values[1])), (Double.parseDouble(values[2])));
            transports.add(tmpTransport);
        }
    }

    public void loadCarData()   {

    }

    public void loadUsers(){
        ArrayList<String> temp = FileIO.fileReader("src/main/java/data/users.csv");
        for (String data : temp) {
            String[] tempString = data.split(";");
            String username = tempString[0];
            String name = tempString[1];
            String password = tempString[2];
            String gender = tempString[3];
            String birthday = tempString[4];    //TODO parse to Date data type
            String[] addressArray = tempString[5].split(":");
            Address address = new Address(addressArray[0], addressArray[1], addressArray[2], addressArray[3], addressArray[4]);

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
        ArrayList<String> temp = FileIO.fileReader("data/emission/clothes/fabric.csv");
        for (String data : temp){
            String[] tempString = data.split(";");
            fabrics.add(new Fabric(tempString[0], Double.parseDouble(tempString[1])));
        }
    }

    public void loadClothes(){
        ArrayList<String> temp = FileIO.fileReader("data/emission/clothes/clothes.csv");
        for (String data : temp){
            String[] tempString = data.split(";");
            clothes.add(new Clothes(tempString[0], Integer.parseInt(tempString[1])));
        }
    }
}
