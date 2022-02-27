package com.cloudcollaborators.collaboratorservice;

import com.cloudcollaborators.collaboratorservice.domain.ProductTeams;
import com.cloudcollaborators.collaboratorservice.repository.CollaboratorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CollaboratorServiceApplication {

	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CollaboratorServiceApplication.class, args);
	}

//@Bean
//	CommandLineRunner runner(CollaboratorRepository repository) {
//
//		return args -> {
//			ResponseEntity<String> responseEntity = getRestTemplate().getForEntity("https://jiraapicollab.azurewebsites.net/jira/product-teams", String.class);
//			ObjectMapper objectMapper = new ObjectMapper();
//			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//			ProductTeams productTeams = new ProductTeams();
//			try {
//				productTeams = objectMapper.readValue(responseEntity.getBody(), ProductTeams.class);
//				repository.save(productTeams);
//				System.out.println("Saved Product Teams to Database ");
//			}
//			catch(JsonProcessingException e)
//			{
//				System.out.println("Could not save product teams to DB");
//			}
//		};
//}

}
