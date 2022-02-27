package com.cloudcollaborators.collaboratorservice.controller;


import com.cloudcollaborators.collaboratorservice.ProductTeam;
import com.cloudcollaborators.collaboratorservice.service.CollaboratorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudcollaborator")
public class CollaboratorController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public ResponseEntity<String> getAllTheTeamsInTheOrganization(@PathVariable("userId") String userId) {

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://jiraapicollab.azurewebsites.net/jira/product-teams", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ProductTeam team = new ProductTeam();
        try {
           team = objectMapper.readValue(responseEntity.getBody(), ProductTeam.class);
//
//           System.out.println("Total teams: " + team.getTotalCount());
//           System.out.println("Team names :" + Arrays.toString(team.getname().toArray()));
       }
       catch(JsonProcessingException e)
       {
           e.printStackTrace();
       }
        return responseEntity;
    }

    private CollaboratorService collaboratorService;

    public CollaboratorController(CollaboratorService collaboratorService)
    {
        this.collaboratorService = collaboratorService;
    }

//    @GetMapping("/teamlist")
//    public Iterable<ProductTeam> list(){
//        return collaboratorService.list();
//    }
}
