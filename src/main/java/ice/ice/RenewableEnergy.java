package ice.ice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RenewableEnergy extends Offset{

    //Below this line are class attributes
    protected double co2Kilo;
    private int totalRenewableEnergySources;
    // String energyType; might be useful for later iterations

    //Below this line are constants for calculations
    private static final double PANEL_WATTAGE = 300.0; // Typical residential solar panel rating ~300W (Source: NREL PV system benchmarks: https://www.nrel.gov/pv/)
    private static final double PEAK_SUN_HOURS_PER_DAY = 4.0; // Approximate average peak sun hours for parts of the Western Hemisphere (Source: NREL Resource Data: https://www.nrel.gov/gis/solar.html)
    private static int DAYS_PER_YEAR = 365; // Number of days in a year (General knowledge)
    private static final double GRID_EMISSION_FACTOR = 0.4; // Approximate CO2 kg/kWh for U.S. average grid (Source: U.S. EPA eGRID Data: https://www.epa.gov/egrid)


    //Below this line is the constructor
    public RenewableEnergy() {

    }



//RenewableEnergy methods are below this line

    public double solarSavingsDefinedDate(int date) {                   //Call this method
        System.out.println("Pick one of the options to see your CO₂ offset in different time intervals  \uD83E\uDD78");
        switch (date) {
            case 1:
                System.out.println("Displaying your CO₂ offset per day!");
                return co2SolarSaving("day", 365);

            case 2:
                System.out.println("Displaying your CO₂ offset per week!");
                return co2SolarSaving("week", 52);

            case 3:
                System.out.println("Displaying your CO₂ offset per month!");
                return co2SolarSaving("month", 12);

            case 4:
                System.out.println("Displaying your CO₂ offset per year!");
                return co2SolarSaving("year", 1);

            default:
                System.out.println("Displaying your CO₂ offset per year!");
                return co2SolarSaving("year", 1);

        }

    }

    public double co2SolarSaving(String perDate, int one52Or12Or365 ) {  //insert 365 for per day, 52 for per week, 12 per month, 1 per year.
        int numberOfPanels = solarPanels();  //number of solar panels stored here

        // Annual energy production per panel:
        // (Panel Wattage / 1000 to convert W to kW) * Peak sun hours/day * Days/year
        // = (300 W / 1000) * 4 h/day * 365 days ≈ 438 kWh/year
        double annualKWhPerPanel = (PANEL_WATTAGE / 1000.0) * PEAK_SUN_HOURS_PER_DAY * DAYS_PER_YEAR; // Source: Calculation based on NREL PVWatts methodology

        // CO2 offset per panel = annual kWh * emission factor
        // = 438 kWh/year * 0.4 kg CO2/kWh ≈ 175.2 kg CO2/year
        double co2OffsetPerPanel = annualKWhPerPanel * GRID_EMISSION_FACTOR; // Source: Based on EPA average emission factor

        // Total CO2 offset for the given number of panels
         co2Kilo = co2OffsetPerPanel * numberOfPanels;

        System.out.println("Your solar panels offset approximately " + (co2Kilo / (double) one52Or12Or365) + " kg of CO₂ per " + perDate + "!");
        return co2Kilo;

    }


    public int solarPanels() {
        return userInput("Please type in the number of solar panels you want to add your profile: ", "Solar cells");
    }

    public int userInput(String messageToUser, String energySources) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int renewableEnergySources = 0;
        while (!validInput) {
            try {
                System.out.println(messageToUser);
                renewableEnergySources = 0; // Reset before adding
                renewableEnergySources += scanner.nextInt();
                if (renewableEnergySources > 0) {
                    totalRenewableEnergySources += renewableEnergySources;
                    System.out.println("You have registered that you own: " + renewableEnergySources + " " + energySources + " \uD83D\uDD0B \uD83D\uDD0B \uD83D\uDD0B");
                    System.out.println("You have a total of " + energySources + " and other renewable energy sources in your household!");
                    validInput = true;
                } else {
                    System.out.println("Please enter a positive number!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Something went wrong ✋ \n enter a whole number and try again! \uD83E\uDD78");
                scanner.nextLine();         //Wrong user-input is cleared,  after this line the loop executes the try-block again
            }
        }
        return renewableEnergySources;

    }


} //End of RenewableEnergy class