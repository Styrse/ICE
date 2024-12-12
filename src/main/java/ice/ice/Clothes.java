package ice.ice;

public class Clothes extends Emission {
    private String type;
    private int weightGrams;
    private Fabric fabricType;


    public Clothes(String type, int weight) {
        super(weight);
        this.type = type;
        this.weightGrams = weight;
        this.fabricType = fabricType;
    }

    public double calCo2PrItem(){
        return fabricType.getCo2PrGram() * weightGrams;
    }

    public String saveClothesInfo(){
        return type + "; " +
                weightGrams;
    }

    public Fabric getFabricType() {
        return fabricType;
    }


    @Override
    public String toString() {
        return "Clothes{" +
                "type='" + type + '\'' +
                ", weightGrams=" + weightGrams +
                '}';
    }
}
