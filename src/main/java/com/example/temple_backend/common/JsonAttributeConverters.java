package com.example.temple_backend.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.List;
import java.util.Map;

public class JsonAttributeConverters {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Converter
    public static class MapToJsonConverter
      implements AttributeConverter<Map<String, Integer>, String> {

        @Override
        public String convertToDatabaseColumn(Map<String, Integer> attribute) {
            if (attribute == null) return null;
            try {
                return objectMapper.writeValueAsString(attribute);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("JSON 직렬화 오류", e);
            }
        }

        @Override
        public Map<String, Integer> convertToEntityAttribute(String dbData) {
            if (dbData == null) return null;
            try {
                return objectMapper.readValue(
                  dbData,
                  objectMapper.getTypeFactory()
                    .constructMapType(Map.class, String.class, Integer.class)
                );
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("JSON 역직렬화 오류", e);
            }
        }
    }

    @Converter
    public static class ListToJsonConverter
      implements AttributeConverter<List<Integer>, String> {

        @Override
        public String convertToDatabaseColumn(List<Integer> attribute) {
            if (attribute == null) return null;
            try {
                return objectMapper.writeValueAsString(attribute);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("JSON 직렬화 오류", e);
            }
        }

        @Override
        public List<Integer> convertToEntityAttribute(String dbData) {
            if (dbData == null) return null;
            try {
                return objectMapper.readValue(
                  dbData,
                  objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Integer.class)
                );
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("JSON 역직렬화 오류", e);
            }
        }
    }
}

