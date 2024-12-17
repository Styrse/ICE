package ice.ice;

import java.awt.Desktop;
import java.net.URI;
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

    public boolean selfPlant(String timeFrame) {
        int trees = userInput("How many  🌳🌳🌳 have you planted " + timeFrame + "?");

        if (trees > selfPlantedTrees) {
            selfPlantedTrees += totalUserPlantedTrees;
            return true;
        } else {
            System.out.println("No trees were added to your count" + " " + timeFrame + ".");
            return false;
        }
    }

    public void openLinkForTreeDonation(String url) {
        if (url == null || url.isBlank()) {
            url = "https://teamtrees.org/"; //Default to TeamTrees official donation page
        }        System.out.println("Redirecting to " + url + " \n \uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73");

        try {
            if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {   //Checks if the current desktop environment supports browsing URLs

                Desktop.getDesktop().browse(new URI(url));    // Opens the provided URL in the default web browser
            } else {
                System.out.println("Couldn't open the link, please visit " + url + " to make your donation!");     //Prints message if browsing is not supported
            }
        } catch (Exception e) {
            System.out.println("Couldn't open the link, please visit " + url);
            e.printStackTrace();
        }
    }

    public boolean pay2Plant(String timeFrame) {
        int trees = userInput("How many  🌳🌳🌳 do you want to sponsor " + timeFrame + "?");
        if (trees > paidPlantedTrees) {
            paidPlantedTrees += trees;
            openLinkForTreeDonation("");
            return true;
        } else {
            System.out.println("No trees were added to your count" + " " + timeFrame + ".");
            return false;
        }
    }
}