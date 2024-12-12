package ice.ice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserMapper {
    public static User login(String enteredUsername, String enteredPassword){
        ArrayList<String> lines = FileIO.fileReader("src/main/java/data/users.csv");
        User user = null;
        for (String s : lines){
            String[] data = s.split(";");
            if (data[0].trim().equalsIgnoreCase(enteredUsername) && data[2].trim().equals(enteredPassword)){
                String[] userInfo = s.split(";");
                String username = userInfo[0].trim();
                String name = userInfo[1].trim();
                String password = userInfo[2].trim();
                String gender = userInfo[3].trim();
                String birthday = userInfo[4].trim();
                String[] addressArray = userInfo[5].split(":");
                Address address = new Address(addressArray[0].trim(), addressArray[1].trim(), addressArray[2].trim(), addressArray[3].trim(), addressArray[4].trim());

                SimpleDateFormat formatter = new SimpleDateFormat(("yyyy-MM-dd"));
                Date birthdayFormatted;
                try {
                    birthdayFormatted = formatter.parse(birthday);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                    //TODO Golf look at Load class
                }
                return new User(username, name, password, gender, birthdayFormatted, address);
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
