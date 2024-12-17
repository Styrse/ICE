package ice.ice;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserMapper {
    public static User login(String enteredUsername, String enteredPassword){
        ArrayList<String> lines = FileIO.fileReader("src/main/java/data/users.csv");
        for (String s : lines){
            String[] data = s.split(";");
            if (data[0].trim().equalsIgnoreCase(enteredUsername) && data[2].trim().equals(enteredPassword)){
                String[] userInfo = s.split(";");
                String username = userInfo[0].trim();
                String name = userInfo[1].trim();
                String password = userInfo[2].trim();
                String gender = userInfo[3].trim();
                LocalDate birthday = LocalDate.parse(userInfo[4].trim());
                String[] addressArray = userInfo[5].split(":");
                Address address = new Address(addressArray[0].trim(), addressArray[1].trim(), addressArray[2].trim(), addressArray[3].trim(), addressArray[4].trim());

                return new User(username, name, password, gender, birthday, address);
            }
        }
        return null;
    }

    public static boolean checkDuplicateUsername(String username){
        ArrayList<String> lines = FileIO.fileReader("src/main/java/data/users.csv");
        for (String s : lines) {
            String[] data = s.split(";");
            if (data[0].trim().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }
}
