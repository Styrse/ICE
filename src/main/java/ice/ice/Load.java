package ice.ice;

import java.time.LocalDate;
import java.util.ArrayList;

public class Load {
    private ArrayList<User> users;
    private ArrayList<Clothes> clothes;
    private ArrayList<Fabric> fabrics;
    private ArrayList<Transport> transports;
    private ArrayList<RenewableEnergy> renewableEnergies;
    private ArrayList<Food> foods;

    public Load(ArrayList<User> users, ArrayList<Clothes> clothes, ArrayList<Fabric> fabrics, ArrayList<Transport> transports,ArrayList<RenewableEnergy> renewableEnergies, ArrayList<Food> foods) {
        this.users = users;
        this.clothes = clothes;
        this.fabrics = fabrics;
        this.transports = transports;
        this.renewableEnergies = renewableEnergies;
        this.foods = foods;
    }

    public void loadSetup(){
        loadUsers();
        loadClothes();
        loadFabrics();
        loadPublicTransportData();
    }

    public void loadPublicTransportData()  {
        ArrayList<String> data = FileIO.fileReader("src/main/java/data/emission/PublicTransport");
        for (String s : data)   {
            String[] values = s.split(";");
            Transport tmpTransport = new Transport (values[0], (Double.parseDouble(values[1])), (FuelType.ELECTRIC), Double.parseDouble(values[3]));
            transports.add(tmpTransport);
        }
    }

    public void loadUsers(){
        ArrayList<String> temp = FileIO.fileReader("src/main/java/data/users.csv");
        for (String data : temp) {
            String[] tempString = data.split(";");
            String username = tempString[0].trim();
            String name = tempString[1].trim();
            String password = tempString[2].trim();
            String gender = tempString[3].trim();
            LocalDate birthday = LocalDate.parse(tempString[4].trim());
            String[] addressArray = tempString[5].split(":");
            Address address = new Address(addressArray[0].trim(), addressArray[1].trim(), addressArray[2].trim(), addressArray[3].trim(), addressArray[4].trim());

            users.add(new User(username, name, password, gender, birthday, address));
        }
    }

    public void loadFabrics(){
        ArrayList<String> temp = FileIO.fileReader("src/main/java/data/emission/clothes/fabric.csv");
        for (String data : temp){
            String[] tempString = data.split(";");
            fabrics.add(new Fabric(tempString[0].trim()));
        }
    }

    public double getFabricCo2PrGram(ArrayList<Fabric> fabrics, int index){
             Fabric currentFabric =   this.fabrics.get(index);
             return currentFabric.getCo2PrGram();
    }

    public double getFabricCo2PrGram(String fabricName) {
        double result = 0;

        for (Fabric f : fabrics) {
            if (f.getType().equals(fabricName)) {
                result = f.getCo2PrGram();
            }
        }
        return result;
    }

    public void loadClothes(){
        ArrayList<String> temp = FileIO.fileReader("src/main/java/data/emission/clothes/clothes.csv");
        for (int i = 0; i < temp.size(); i++){
            String[] tempString = temp.get(i).split(";");
            clothes.add(new Clothes(new Fabric(tempString[0].trim()), Integer.parseInt(tempString[1].trim())));
        }
    }
}
