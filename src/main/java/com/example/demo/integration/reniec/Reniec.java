package com.example.demo.integration.reniec;

import com.example.demo.integration.reniec.dto.Persona;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


public class Reniec {

    private static final String URL_API_RENIEC="https://app-reniec.herokuapp.com/api/persona/";

    private RestTemplate restTemplate;

    public Reniec(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    
    public Persona me(){


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> entity = 
                new HttpEntity<String>(headers);
        ResponseEntity<Persona> response = restTemplate.
                                    exchange(URL_API_RENIEC,
                                    HttpMethod.GET,
                                    entity,
                                    new ParameterizedTypeReference<Persona>(){});
        return response.getBody();

    }

}
