package se.lexicon;

import se.lexicon.model.Car;
import se.lexicon.model.Owner;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class App_Json {

    private static List<Car> cars;

    public static void main(String[] args) {

        JsonIO jsonIO = new JsonIO();

        File file = new File("src/main/resources/cars.json");

        cars = Arrays.asList(
                new Car("ABC123", "Volvo", "XC90", LocalDate.now()),
                new Car("ABC456", "BMW", "E30", LocalDate.now().minusDays(1)),
                new Car("CBA123", "Tesla", "Model 3", LocalDate.now().plusDays(25)),
                new Car("CBA123", "Tesla", "Model 3", LocalDate.of(2019, Month.JANUARY, 25)),
                new Car("GFH658", "Volvo", "XC70", LocalDate.parse("2020-12-24"))
        );


        jsonIO.serializeToJson(cars, file);

        List<Car> foundCarsFromFile = jsonIO.deserializeCarListFromJson(file);

        foundCarsFromFile.forEach(System.out::println);


        extra(jsonIO);
    }

    public static void extra(JsonIO jsonIO) {

        File file = new File("src/main/resources/Owners.json");

        Owner owner = new Owner("Simon", "Elbrink", 23, "123456789");
        owner.registerCar(cars.get(0));

        Owner owner1 = new Owner("Erik", "Svensson", 0, "987654321");
        owner1.registerCar(cars.get(2));
        owner1.registerCar(cars.get(3));

        jsonIO.serializeToJson(Arrays.asList(owner, owner1), file);

        List<Owner> foundOwnersFromFile = jsonIO.deserializeOwnerListFromJson(file);

        System.out.println(foundOwnersFromFile.get(0));

       foundOwnersFromFile.forEach(System.out::println);

    }
}
