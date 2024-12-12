package ice.ice;


public abstract class Offset extends Co2{
    //Below this line are class attributes
    protected double co2Gram;
    private PlantTree plantTree = new PlantTree(co2Gram);
    private RenewableEnergy renewableEnergy = new RenewableEnergy(co2Gram);

    //Below this line are class constants
    final static double ONE_THOUSAND = 1000.00;


    public Offset(double co2Gram) {
        super();
        this.co2Gram = co2Gram;
    }

    //Below this line are class methods

    public double calculateTotalTreeCarbonOffset(TimePeriod timePeriod) {
        switch (timePeriod) {
            case DAY:
                return plantTree.treesCarbonOffset(plantTree.selfPlant("today"), plantTree.pay2Plant("today"));
            case WEEK:
                return plantTree.treesCarbonOffset(plantTree.selfPlant("this week"), plantTree.pay2Plant("this week"));
            case MONTH:
                return plantTree.treesCarbonOffset(plantTree.selfPlant("this month"), plantTree.pay2Plant("this month"));
            case YEAR:
                return plantTree.treesCarbonOffset(plantTree.selfPlant("this year"), plantTree.pay2Plant("this year"));
            default:
                return 0.0;
        }
    }

    public enum TimePeriod {        //enum method
        DAY,
        WEEK,
        MONTH,
        YEAR
    }


    public double calculateTotalCarbonOffset(TimePeriod timePeriod) {
        /*
        timePeriod int values
        1 = day
        2 = week
        3 = month
        4 = year
         */
        double resultInKg = (renewableEnergy.solarSavingsDefinedDate(timePeriod) + plantTree.calculateTotalTreeCarbonOffset(TimePeriod.YEAR));
        co2Gram = resultInKg * ONE_THOUSAND;
        return co2Gram;
    }

    @Override
    public double getCo2Gram() {
        this.co2Gram += calculateTotalCarbonOffset(TimePeriod.YEAR);
        return this.co2Gram;
    }

    public Offset getInstance() {
        return this;
    }



}