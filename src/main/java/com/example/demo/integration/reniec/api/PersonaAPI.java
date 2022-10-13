package com.example.demo.integration.reniec.api;

import com.example.demo.integration.reniec.dto.*;
import com.example.demo.integration.reniec.dto.Persona;
import com.example.demo.integration.reniec.dto.ReniecUsuario;
import com.example.demo.model.PersonaRec;



import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;


@Service
public class PersonaAPI {
    private static final String URL_API_RENIEC="https://app-reniec.herokuapp.com/api/persona/";
    private RestTemplate restTemplate;

    public PersonaAPI(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public ResponseEntity<?> send(Persona persona){
        Map<String, String> params=new HashMap<String, String>();
        Map<String, Object> response=new HashMap<>();

        try{
        ResponseEntity<ReniecUsuario> responseEntityReniec=restTemplate.getForEntity(URL_API_RENIEC+'/'+persona.getDni(), ReniecUsuario.class, params);
        
        persona.setNombres(responseEntityReniec.getBody().getNombres());
        persona.setApePat(responseEntityReniec.getBody().getApePat());
        persona.setApeMat(responseEntityReniec.getBody().getApeMat());
        persona.setDirec(responseEntityReniec.getBody().getDirec());
        persona.setGenero(responseEntityReniec.getBody().getGenero());
        persona.setBirthdate(responseEntityReniec.getBody().getBirthdate());
        persona.setEstado(responseEntityReniec.getBody().getEstado());
        
        }catch(HttpStatusCodeException e){
            response.put("mensaje", "Error: Se ha producido un error al intentar consumir el servicio de la reniec");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }


    public ResponseEntity<?> consultarPersona(PersonaRec persona){
        Map<String, String> params=new HashMap<String, String>();
        Map<String, Object> response=new HashMap<>();

        try{
        ResponseEntity<ReniecUsuario> responseEntityReniec=restTemplate.getForEntity(URL_API_RENIEC+'/'+persona.getDni(), ReniecUsuario.class, params);
        
        persona.setNombre(responseEntityReniec.getBody().getNombres());
        persona.setApellidopat(responseEntityReniec.getBody().getApePat());
        persona.setApellidomat(responseEntityReniec.getBody().getApeMat());
        persona.setDireccion(responseEntityReniec.getBody().getDirec());
        persona.setGenero(responseEntityReniec.getBody().getGenero());
        persona.setFechacumpleanos(responseEntityReniec.getBody().getBirthdate());
        persona.setEstadocivil(responseEntityReniec.getBody().getEstado());
        
        }catch(HttpStatusCodeException e){
            response.put("mensaje", "Error: Se ha producido un error al intentar consumir el servicio de la reniec");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }


}
