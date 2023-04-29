package com.fulusi.bridgeme.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.reflect.Type;

public class UtilService {
    public static String toJson(Object pojo) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static <T> T fromJson(String json, Type type) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            return objectMapper.readValue(json, typeFactory.constructType(type));
        } catch (Exception ex) {
            return null;
        }

       // Type userListType = new TypeReference<List<User>>(){}.getType();
       // List<User> users = fromJson(json, userListType);
    }
}
