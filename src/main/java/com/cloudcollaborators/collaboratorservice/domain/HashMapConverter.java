package com.cloudcollaborators.collaboratorservice.domain;



import com.cloudcollaborators.collaboratorservice.repository.CollaboratorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;

@Converter(autoApply = true)
public class HashMapConverter implements AttributeConverter<Object, String>{

    private final  ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(Object teamAttribute) {
        ObjectMapper objectMapper = new ObjectMapper();
        String teamAttributesJson = null;
        try{
            teamAttributesJson = objectMapper.writeValueAsString(teamAttribute);
        }catch(final JsonProcessingException e){
            System.out.println("Could not save product teams to DB");
        }
        return teamAttributesJson;
    }

    @Override
    public  Object convertToEntityAttribute(String dbData) {
        try {
          return objectMapper.readValue(dbData, Map.class);
        }
        catch(JsonProcessingException e)
        {
            System.out.println("Could not save product teams to DB");
        }
        return null;
    }
}
