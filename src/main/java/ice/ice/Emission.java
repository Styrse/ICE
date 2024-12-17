package ice.ice;

import java.util.ArrayList;

public abstract class Emission extends Co2 {
    private double co2Gram = 0;
    private ArrayList<Emission> co2EmissionsAL = new ArrayList<Emission>();

    public Emission(double co2Gram) {
        super();
        this.co2Gram = co2Gram;
    }

    @Override
    public double getCo2Gram() {
        return this.co2Gram;
    }

    private double calcEmissionsFromAL(ArrayList<Emission> emissions) {
        double result = 0;

        for (Emission i : emissions) {
            result += i.getCo2Gram();
        } // Emissions for-each loop

        return result;
    }   // end calcEmissionsFromAL()

    private double calcFoodEmission(Food food){
        double result = 0;
        result = food.getCo2GramsPrMeal();
        return result;
    }

    private double calcFoodEmission(ArrayList<Food> foods){
        double result = 0;

        for (Food i : foods) {
            result += i.getCo2GramsPrMeal();
        }
        return result;
    }

    public boolean calcEmission() {
        double co2Prev = this.co2Gram;

        for (Emission e: co2EmissionsAL) {
            co2Gram += e.getCo2Gram();
        }   // end Emissions for-each loop

        if (co2Prev < co2Gram){
            return true;
        } else {
            return false;
        }   // end if-else statement
    }   // end calcEmission()

    public ArrayList<Emission> getCo2EmissionsAL() {
        return this.co2EmissionsAL;
    }   // end getCo2EmissionsAL()

}   // end Emission
