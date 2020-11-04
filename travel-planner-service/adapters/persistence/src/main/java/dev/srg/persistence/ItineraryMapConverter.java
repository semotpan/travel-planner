package dev.srg.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Slf4j
@Converter
class ItineraryMapConverter implements AttributeConverter<ItineraryTable.ItineraryMap, String> {

    // ObjectMapper is thread safe
    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String convertToDatabaseColumn(ItineraryTable.ItineraryMap itineraryMap) {
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(itineraryMap);

        } catch (JsonProcessingException ex) {
            log.error(ex.getMessage());
        }
        return jsonString;
    }

    @Override
    public ItineraryTable.ItineraryMap convertToEntityAttribute(String source) {
        ItineraryTable.ItineraryMap payload = new ItineraryTable.ItineraryMap();
        try {
            payload = objectMapper.readValue(source, ItineraryTable.ItineraryMap.class);

        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        return payload;
    }
}
