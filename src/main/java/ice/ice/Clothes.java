package ice.ice;

import java.util.ArrayList;

public class Clothes {
    private String type;
    private int weightGrams;
    private ArrayList<Fabric> fabrics;
    private ArrayList<Clothes> clothes;

    public Clothes(String type, int weight) {
        this.type = type;
        this.weightGrams = weight;
    }

    public void setupClothes(){
        loadFabrics();
        loadClothes();
    }

    public double calCo2PrItem(Fabric fabricType){
        return fabricType.getCo2Gram() * weightGrams;
    }

    public void loadFabrics(){
        ArrayList<String> temp = FileIO.fileReader("data/emission/fabric.csv");
        for (String data : temp){
            String[] tempString = data.split(";");
            fabrics.add(new Fabric(tempString[0], Double.parseDouble(tempString[1])));
        }
    }

    public void loadClothes(){
        ArrayList<String> temp = FileIO.fileReader("data/emission/clothes.csv");
        for (String data : temp){
            String[] tempString = data.split(";");
            clothes.add(new Clothes(tempString[0], Integer.parseInt(tempString[1])));
        }
    }
}
