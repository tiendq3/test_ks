package com.example.test_ks.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonConverter {

    //jackson
    public static <T> String convertListToJson(List<T> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
//            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            return objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error converting List to JSON";
        }
    }

    //gson
    public static <T> List<T> convertJsonToList(String jsonList, Class<T> classOfT) {
        Gson gson = new Gson();
        Type type = TypeToken.getParameterized(List.class, classOfT).getType();
        return gson.fromJson(jsonList, type);
    }
}
