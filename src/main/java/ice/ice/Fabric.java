package ice.ice;

public class Fabric {
    private String type;
    private double co2PrGram;

    public Fabric(String type, double co2PrGram) {
        this.type = type;
        this.co2PrGram = co2PrGram;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCo2PrGram() {
        return co2PrGram;
    }

    public void setCo2PrGram(double co2PrGram) {
        this.co2PrGram = co2PrGram;
    }

    public String saveFabricInfo(){
        return type + "; " +
                co2PrGram;
    }

    public Fabric getFabric(){
        return new Fabric(this.type, this.co2PrGram);
    }

    @Override
    public String toString() {
        return "Fabric{" +
                "type='" + type + '\'' +
                ", co2Gram=" + co2PrGram +
                '}';
    }
}
