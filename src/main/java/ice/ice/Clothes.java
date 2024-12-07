package ice.ice;

import java.util.ArrayList;

public class Clothes {
    private String type;
    private int weightGrams;
    private ArrayList<Fabric> fabrics;
    private ArrayList<Clothes> clothes;

    public Clothes() {
    }

    public Clothes(String type, int weight) {
        this.type = type;
        this.weightGrams = weight;
    }

    public double calCo2PrItem(Fabric fabricType){
        return fabricType.getCo2Gram() * weightGrams;
    }

}
