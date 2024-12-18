package ice.ice;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    public int userInput(String messageToUser) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        int treesPlantedThisTime = 0;
        while (!validInput) {
            try {
                System.out.println(messageToUser);
                treesPlantedThisTime += scanner.nextInt();
                if (treesPlantedThisTime > 0) {
                    totalUserPlantedTrees += treesPlantedThisTime;
                    System.out.println("You have planted: " + treesPlantedThisTime + " 🌳🌳🌳");
                    System.out.println("Total trees you've planted so far: " + totalUserPlantedTrees + " 🌳");
                    validInput = true;
                } else {
                    System.out.println("Please enter a positive number of 🌳🌳🌳");
                }
            } catch (InputMismatchException e) {
                System.out.println("Something went wrong ✋ \n enter a whole number and try again! \uD83E\uDD78");
                scanner.nextLine();         //Wrong user-input is cleared, after this line the loop executes the try-block again
            }
        }
        return treesPlantedThisTime;
    }
}