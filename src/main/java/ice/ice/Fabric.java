package ice.ice;

public class Fabric {
    private String type;
    private double co2Gram;

    public Fabric(String type, double co2Gram) {
        this.type = type;
        this.co2Gram = co2Gram;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCo2Gram() {
        return co2Gram;
    }

    public void setCo2Gram(double co2Gram) {
        this.co2Gram = co2Gram;
    }

    public String saveFabricInfo(){
        return type + "; " +
                co2Gram;
    }

    @Override
    public String toString() {
        return "Fabric{" +
                "type='" + type + '\'' +
                ", co2Gram=" + co2Gram +
                '}';
    }
}
