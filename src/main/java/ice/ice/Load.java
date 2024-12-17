package ice.ice;

import java.time.LocalDate;
import java.util.ArrayList;

public class Load {
    private ArrayList<User> users;
    private ArrayList<Clothes> clothes;
    private ArrayList<Fabric> fabrics;
    private ArrayList<Transport> transports;
    //private ArrayList<Car> cars;
    private ArrayList<RenewableEnergy> renewableEnergies;
    private ArrayList<Food> foods;


    public Load() {
        this.fabrics = loadFabricsAL();
    }

    public Load(ArrayList<User> users, ArrayList<Clothes> clothes, ArrayList<Fabric> fabrics, ArrayList<Transport> transports/*, ArrayList<Car> cars*/,ArrayList<RenewableEnergy> renewableEnergies, ArrayList<Food> foods) {
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
            Transport tmpTransport = new Transport (values[0], (Double.parseDouble(values[1])), (FuelType.ELECTRIC), Double.parseDouble(values[3]));
            transports.add(tmpTransport);
        }
    }

    //TODO loadcardata value 0 should be user.
    /*public void loadCarData()   {
        ArrayList<String> data = FileIO.fileReader("src/main/java/data/emission/Cardata");
                for (String s : data)   {
                    String[] values = s.split(";");
                    Car tmpCar = new Car (values[0], values[1].trim(), values[2].trim(), values[3].trim(),Float.parseFloat(values[4].trim()));
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
            LocalDate birthday = LocalDate.parse(tempString[4].trim());    //TODO parse to Date data type
            String[] addressArray = tempString[5].split(":");
            Address address = new Address(addressArray[0].trim(), addressArray[1].trim(), addressArray[2].trim(), addressArray[3].trim(), addressArray[4].trim());

            users.add(new User(username, name, password, gender, birthday, address));
        }
    }

    public void loadFabrics(){
        ArrayList<String> temp = FileIO.fileReader("src/main/java/data/emission/clothes/fabric.csv");
        for (String data : temp){
            String[] tempString = data.split(";");
            fabrics.add(new Fabric(tempString[0].trim(), Double.parseDouble(tempString[1].trim())));
        }
    }

    public ArrayList<Fabric> loadFabricsAL() {
        ArrayList<String> temp = FileIO.fileReader("src/main/java/data/emission/clothes/fabric.csv");
        for (String data : temp){
            String[] tempString = data.split(";");
            fabrics.add(new Fabric(tempString[0].trim(), Double.parseDouble(tempString[1].trim())));
        }
        return fabrics;
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
        int i = 0;
        for (String data : temp){
            String[] tempString = data.split(";");
            clothes.add(new Clothes(
                        new Fabric(tempString[0].trim(), getFabricCo2PrGram(fabrics, i)),
                        Integer.parseInt(tempString[1].trim())));
            i++;                                                                            // counts up index of fabric ArrayList
        }
    }
}
