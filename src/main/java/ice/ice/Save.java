package ice.ice;

import java.io.FileWriter;
import java.util.ArrayList;

public class Save {

    public void usersToText()  {
        ArrayList<String> textOverwrite = new ArrayList<>();
        textOverwrite.add("username; name; password; gender; birthday; address; userID");
        for (User s : Platform.getInstance().getUsers()) {
            textOverwrite.add(s.saveUserInfo());
        }
        FileIO.fileWriter(textOverwrite, "src/main/java/data/users.csv");
    }
}
