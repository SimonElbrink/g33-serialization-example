package se.lexicon.model;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Car implements Serializable {

    private final UUID carId;
    private String regNumber;
    private String brand;
    private String model;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate regDate;

    @JsonBackReference
    private Owner owner;

    public Car(String regNumber, String brand, String model, LocalDate regDate) {
        this();
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.regDate = regDate;
    }

    private Car() {
        this.carId = UUID.randomUUID();
    }

    public UUID getCarId() {
        return carId;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getCarId(), car.getCarId()) && Objects.equals(getRegNumber(), car.getRegNumber()) && Objects.equals(getBrand(), car.getBrand()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getRegDate(), car.getRegDate()) && Objects.equals(getOwner(), car.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarId(), getRegNumber(), getBrand(), getModel(), getRegDate(), getOwner());
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", regNumber='" + regNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
