package se.lexicon;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import se.lexicon.model.Car;
import se.lexicon.model.Owner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonIO {

    private ObjectMapper objectMapper;

    public JsonIO() {

        this.objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }


    public <T> void serializeToJson(T source, File destination) {

        try {
            objectMapper.writeValue(destination, source);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Inside serializeToJson method in class JsonIO");
        }
    }


/*    public <T> List<T> deserializeListFromJson(File file) {

        List<T> deserializedObjects = new ArrayList<>();

        try {
            deserializedObjects = objectMapper.readValue(file, new TypeReference<List<T>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Inside deserializeCarListFromJson method in class JsonIO");
        }

        return deserializedObjects;
    }*/


    public List<Car> deserializeCarListFromJson(File file) {

        List<Car> deserializedObjects = new ArrayList<>();

        try {
            deserializedObjects = objectMapper.readValue(file, new TypeReference<List<Car>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Inside deserializeCarListFromJson method in class JsonIO");
        }

        return deserializedObjects;
    }

    public List<Owner> deserializeOwnerListFromJson(File file) {

        List<Owner> deserializedObjects = new ArrayList<>();

        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Owner.class);
        try {
            deserializedObjects = objectMapper.readValue(file, type);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Inside deserializeCarListFromJson method in class JsonIO");
        }

        return deserializedObjects;
    }

}
