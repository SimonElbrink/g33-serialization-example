package se.lexicon;

import java.io.Serializable;

public class AppUser implements Serializable {

    private static int counter = 0;

    private final int id;
    private String firstName;
    private String lastName;
    private int age;
    private transient String password;

    public AppUser(String firstName, String lastName, int age, String password) {
        this.id = ++counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
    }



    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
