package se.lexicon;

import se.lexicon.model.AppUser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Quick and dirty examples.
 */
public class App {
    public static void main(String[] args) {

        AppUser appUser = new AppUser("Simon", "Elbrink", 23, "123456789");
        AppUser appUser1 = new AppUser("Erik", "Svensson", 0, "987654321");

        List<AppUser> appUserList = Arrays.asList(appUser, appUser1);

        File file = new File("src/main/resources/user.ser");


        // WRITE
        serialize(appUser, file);

        //READ
        System.out.println(deserialize(file).toString());

        // USING MORE THEN ONE.

        // WRITE
        serialize(appUserList, file.getPath());

        //READ
        System.out.println(deserialize(file.getPath()).toString());


    }

    private static AppUser deserialize(File file) {
        AppUser deserialized = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {

            deserialized = (AppUser) in.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return deserialized;
    }

    private static void serialize(AppUser appUser, File file) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {

            out.writeObject(appUser);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<AppUser> serialize(List<AppUser> source, String filePath) {

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)
        ) {
            out.writeObject(source);

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return source;
    }

    public static List<AppUser> deserialize(String filePath) {

        List<AppUser> appUsers = new ArrayList<>();

        try (
                FileInputStream fileInputStream = new FileInputStream(filePath);
                ObjectInputStream in = new ObjectInputStream(fileInputStream)
        ) {
            appUsers = (List<AppUser>) in.readObject();


        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }

        return appUsers;
    }
}
