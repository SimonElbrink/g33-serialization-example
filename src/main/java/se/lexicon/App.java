package se.lexicon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        AppUser appUser = new AppUser("Simon", "Elbrink", 23, "123456789");
        AppUser appUser1 = new AppUser("Erik", "Svensson", 0, "987654321");

        List<AppUser> appUserList = Arrays.asList(appUser, appUser1);

        File file = new File("src/main/resources/user.ser");


        // WRITE
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {

            out.writeObject(appUser);

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        //READ
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {

            Object deserialized = in.readObject();

            System.out.println(deserialized.toString());

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        serialize(appUserList, file.getPath());

        System.out.println(deserialize(file.getPath()).toString());


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
