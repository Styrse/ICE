package ice.ice;

import java.util.ArrayList;

public abstract class Co2 {
    protected double co2Gram;
    private ArrayList<Emission> emissionAL = new ArrayList<>();
    private ArrayList<Offset> OffsetAL = new ArrayList<>();


    public double getCo2Gram() {
        return this.co2Gram;
    }

    private double calcCo2 (Co2 co2_1, Co2 co2_2) {
        double res = 0;

        if (co2_1 instanceof Emission && co2_2 instanceof Offset) {
            res =   ((Emission) co2_1).getCo2Gram() -
                    ((Offset) co2_2).getCo2Gram();
        }   // end Emission-Offset case

        else if (co2_1 instanceof Offset && co2_2 instanceof Emission) {
            res = - ((Offset) co2_1).getCo2Gram() +
                    ((Emission) co2_2).getCo2Gram();
        }   // end Offset-Emission case

        else if (co2_1 instanceof Emission && co2_2 instanceof Emission) {
            res =   ((Emission) co2_1).getCo2Gram() +
                    ((Emission) co2_2).getCo2Gram();
        }   // end Emission-Emission case

        else if (co2_1 instanceof Offset && co2_2 instanceof Offset) {
            res = -   ((Offset) co2_1).getCo2Gram()
                    - ((Offset) co2_2).getCo2Gram();
        }   // end Offset-Offset case & if-else block
        return res;
    }   // end calcCo2()

    private double calcCo2 (ArrayList<Emission> emissionAL, ArrayList<Offset> OffsetAL) {
        double emission = 0;
        double offset = 0;

        for (Emission i : emissionAL) {
            emission += i.getCo2Gram();
        }   // end emission for-each loop

        for (Offset i : OffsetAL) {
            offset += i.getCo2Gram();
        }   // end offset for-each loop

        return emission-offset;
    }   // end calcCo2()

    private void userEducation(){

    }

}
