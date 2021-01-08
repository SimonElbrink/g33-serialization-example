package se.lexicon.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import java.util.ArrayList;
import java.util.List;

public class Owner extends AppUser{

    @JsonManagedReference
    List<Car> ownedCars;


    public Owner(String firstName, String lastName, int age, String password) {
        super(firstName, lastName, age, password);
        this.ownedCars = new ArrayList<>();
    }

    public Owner() {
        this.ownedCars = new ArrayList<>();
    }

    public List<Car> getOwnedCars() {
        return ownedCars;
    }

    public void registerCar(Car car) {

        if (ownedCars == null) {
            this.ownedCars = new ArrayList<>();
        }

        if (!ownedCars.contains(car)) {
            ownedCars.add(car);
            car.setOwner(this);
        }
    }

    public void UnregisterCar(Car car) {
        if (ownedCars == null) {
            this.ownedCars = new ArrayList<>();
        }

        ownedCars.remove(car);
        car.setOwner(null);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", age=" + getAge() +
                ", password='" + getPassword() + '\'' +
                ", ownedCars=" + ownedCars +
                '}';
    }
}
