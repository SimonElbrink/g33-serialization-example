package se.lexicon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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


    public void serializeToJson(List<Car> source, File destination){

        try{
            objectMapper.writeValue(destination, source);

        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            System.out.println("Inside serializeToJson method in class JsonIO");
        }
    }

    public List<Car> deserializeFromJson(File file){

        List<Car> deserializedObjects = new ArrayList<>();

        try {
            deserializedObjects = objectMapper.readValue(file, new TypeReference<List<Car>>() {});

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Inside deserializeFromJson method in class JsonIO");
        }


        return deserializedObjects;
    }













}
