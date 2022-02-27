package com.cloudcollaborators.collaboratorservice.controller;



import com.cloudcollaborators.collaboratorservice.ProductTeam;
import com.cloudcollaborators.collaboratorservice.domain.ProductTeams;
import com.cloudcollaborators.collaboratorservice.repository.CollaboratorRepository;
import com.cloudcollaborators.collaboratorservice.service.CollaboratorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudcollaborator")
public class CollaboratorController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CollaboratorRepository collaboratorRepository;


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


//  public List<ProductTeams> getAllProductTeams() {
//        List<ProductTeams> myItems = new ArrayList<>();
//        collaboratorRepository.findAll().forEach(myItems::add);
//        return myItems;
//  }

//    public ProductTeams saveTeams(){
//    ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://jiraapicollab.azurewebsites.net/jira/product-teams", String.class);
//    ObjectMapper objectMapper = new ObjectMapper();
//    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//    ProductTeams productTeams = new ProductTeams();
//    try {
//        productTeams = objectMapper.readValue(responseEntity.getBody(), ProductTeams.class);
//
////           System.out.println("Total teams: " + team.getTotalCount());
////           System.out.println("Team names :" + Arrays.toString(team.getname().toArray()));
//    }
//    catch(JsonProcessingException e)
//    {
//        e.printStackTrace();
//    }
//    return collaboratorRepository.save(productTeams);
//
//}

}
