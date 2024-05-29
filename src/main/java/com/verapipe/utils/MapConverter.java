package com.verapipe.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Converter
public class MapConverter implements AttributeConverter<Map<String, List<Integer>>, String> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, List<Integer>> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
//          TODO throw new ApplicationException
            return null;
        }
    }

    @Override
    public Map<String, List<Integer>> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<Map<String, List<Integer>>>() {});
        } catch (IOException e) {
//          TODO throw new ApplicationException
            return null;
        }
    }
}
