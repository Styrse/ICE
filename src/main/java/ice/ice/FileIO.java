package ice.ice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    public static ArrayList<String> fileReader(String path) {
        ArrayList<String> data = new ArrayList<>();
        if (!path.isEmpty()) {
            try {
                Scanner scanner = new Scanner(new File(path));
                scanner.nextLine();
                while (scanner.hasNextLine()) {
                    data.add(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                //TODO When error gets catched notify IT department by mail, if there is a method for that
                throw new RuntimeException(e);
            }
        } else {
            //TODO Notify IT
        }
        return data;
    }

    public static void fileWriter(ArrayList<String> data, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            for (String str : data) {
                writer.write(str + "\n");
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Something went wrong writing to file");
        }

    }
}
