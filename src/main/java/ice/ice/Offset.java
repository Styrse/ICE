package ice.ice;

public abstract class Offset extends Co2{
    protected double co2Gram;
    private PlantTree plantTree = new PlantTree(co2Gram);
    private RenewableEnergy renewableEnergy = new RenewableEnergy(co2Gram);

    public Offset(double co2Gram) {
        super();
        this.co2Gram = co2Gram;
    }

    public enum TimePeriod {        //enum method
        DAY,
        WEEK,
        MONTH,
        YEAR
    }
}