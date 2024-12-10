package ice.ice;

import java.util.ArrayList;

public class UserMapper {

    public static User login(String username, String password){
        ArrayList<String> lines = FileIO.fileReader("src/main/java/data/users.csv");
        for (String s : lines){
            String[] data = s.split(";");
            if (data[0].trim().equalsIgnoreCase(username) && data[2].equals(password)){

            }
        }
    }
}
