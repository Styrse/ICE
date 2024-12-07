package ice.ice;

import java.util.ArrayList;

public class Clothes {
    private String type;
    private int weightGrams;

    public Clothes() {
    }

    public Clothes(String type, int weight) {
        this.type = type;
        this.weightGrams = weight;
    }

    public double calCo2PrItem(Fabric fabricType){
        return fabricType.getCo2Gram() * weightGrams;
    }

    public String saveClothesInfo(){
        return type + "; " +
                weightGrams;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "type='" + type + '\'' +
                ", weightGrams=" + weightGrams +
                '}';
    }
}
