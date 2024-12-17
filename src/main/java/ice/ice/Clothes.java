package ice.ice;

public class Clothes extends Emission {

    private String type;
    private int weightGrams;
    private Fabric fabricType;
    private Load load = new Load();

    public Clothes(Fabric fabricType, int weight) {
        super(weight * fabricType.getCo2PrGram());
        this.type = fabricType.toString();
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
