package com.example.demo.controller;

import com.example.demo.integration.reniec.api.PersonaAPI;
import com.example.demo.integration.reniec.dto.Persona;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonaController {
    private static final String VIEW_INDEX="reniecPersona/index";
    private final PersonaAPI personaapi;
    
    public PersonaController(PersonaAPI personaapi){
        this.personaapi = personaapi;
    }


    @GetMapping("/reniecPersona/index")
    public String index(@RequestParam(defaultValue="") String searchDNI, Model model){
        if(!searchDNI.isEmpty()){
            Persona persona_ingresado=new Persona();
            persona_ingresado.setDni(searchDNI);
        //    ResponseEntity<?> resReniec=reniecAPI2.send(usuario_ingresado);
            // reniecAPI2.send();
            
            personaapi.send(persona_ingresado);
            
            Persona persona_encontrado=new Persona();
            
            if(persona_ingresado!=null){
                persona_encontrado=persona_ingresado;
                model.addAttribute("persona_encontrado", persona_encontrado);
                System.out.println("usuario_ingresado: DNI=> "+persona_ingresado.getDni());
                System.out.println("usuario_ingresado: NOMBRES=> "+persona_ingresado.getNombres());
                System.out.println("usuario_ingresado: APELLIDOPAT=> "+persona_ingresado.getApePat());
                System.out.println("usuario_ingresado: FECHA=> "+persona_ingresado.getBirthdate());
            }
        }
        return VIEW_INDEX;
    }

}
