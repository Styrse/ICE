package ice.ice;

public class PlantTree extends Offset{
    protected double co2Kilo;
    private int selfPlantedTrees;
    private int totalUserPlantedTrees;
    private int paidPlantedTrees;

    private static final double AVERAGE_TREE_OFFSET = 24.62;

    public PlantTree(double co2gram) {
        super(co2gram);
    }

    public double treesCarbonOffset(boolean iHavePlantedMyOwnTrees, boolean iHavePaidForTrees) {
        if (iHavePaidForTrees && iHavePlantedMyOwnTrees && selfPlantedTrees > 0 && paidPlantedTrees > 0) {
            co2Kilo = (AVERAGE_TREE_OFFSET * selfPlantedTrees);
            co2Kilo += (AVERAGE_TREE_OFFSET * paidPlantedTrees);
        } else if (iHavePlantedMyOwnTrees && !iHavePaidForTrees && selfPlantedTrees > 0) {
            co2Kilo = (AVERAGE_TREE_OFFSET * selfPlantedTrees);
        } else if(!iHavePlantedMyOwnTrees && iHavePaidForTrees && paidPlantedTrees > 0) {
            co2Kilo = (AVERAGE_TREE_OFFSET * paidPlantedTrees);
        } else {
            System.out.println("You have neither planted or paid for the planting of any trees");
            co2Kilo = 0;
        }
        return co2Kilo;
    }
}