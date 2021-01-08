package se.lexicon;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class App_Json {

    public static void main(String[] args) {

        JsonIO jsonIO = new JsonIO();

        File file = new File("src/main/resources/cars.json");

        List<Car> cars = Arrays.asList(
                new Car("ABC123", "Volvo", "XC90", LocalDate.now()),
                new Car("ABC456", "BMW", "E30", LocalDate.now().minusDays(1)),
                new Car("CBA123", "Tesla", "Model 3", LocalDate.now().plusDays(25)),
                new Car("CBA123", "Tesla", "Model 3", LocalDate.of(2019, Month.JANUARY, 25)),
                new Car("GFH658", "Volvo", "XC70", LocalDate.parse("2020-12-24"))
        );


        jsonIO.serializeToJson(cars, file);

        List<Car> foundCarsFromFile = jsonIO.deserializeFromJson(file);

        for (Car c: foundCarsFromFile){
            System.out.println(c.toString());
        }


    }
}
