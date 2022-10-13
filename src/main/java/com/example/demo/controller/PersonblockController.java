package com.example.demo.controller;

import com.example.demo.model.PersonaRec;
import com.example.demo.integration.reniec.api.PersonaAPI;
import com.example.demo.repository.PersonaRepository;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonblockController {
 
    private static final String VIEW_INDEX="reniecPersona/Persona_Crear";
    private static final String VIEW_LISTA="reniecPersona/Persona_Listar";
    private static final String VIEW_VERDETALLE="reniecPersona/Personas_VerDetalle";
    private final PersonaRepository personasData;
    private final PersonaAPI personaapi;
    PersonaRec persona_encontrada;

    public PersonblockController(PersonaRepository personasData, PersonaAPI personaapi){
        this.personasData=personasData;
        this.personaapi=personaapi;
    }


    @GetMapping("/reniecPersona/Persona_Crear")
    public String index(@RequestParam(defaultValue="") String buscarDNI, Model model){
            if(!buscarDNI.isEmpty()){
                PersonaRec persona_ingresada=new PersonaRec();
                persona_ingresada.setDni(buscarDNI);
           
                personaapi.consultarPersona(persona_ingresada);
                
                persona_encontrada=new PersonaRec();
                
                if(persona_ingresada!=null){
                    persona_encontrada=persona_ingresada;
       
                    System.out.println("DNI es => "+persona_encontrada.getDni());
                    System.out.println("Nombre es => "+persona_encontrada.getNombre());
                }
            }

        return createSubmitForm(persona_encontrada);
    }


    @PostMapping("/reniecPersona/Persona_Crear")
    public String createSubmitForm(PersonaRec persona){
        if(persona!=null){
            System.out.println("POST DNI es => "+persona.getDni());
            System.out.println("POST Nombre es => "+persona.getNombre());
            
            
            

            this.personasData.save(persona);
       
        }else{

        }
        
        return VIEW_INDEX;
    }


    @GetMapping("/reniecPersona/Persona_Listar")
    public String Persona_Listar(Model model){
        List<PersonaRec> listPersona=this.personasData.findAll();
        model.addAttribute("personas", listPersona);
        return VIEW_LISTA;
    }



    @GetMapping("/reniecPersona/Personas_VerDetalle/{dni}")
    public String Personas_VerDetalle(@PathVariable("dni") String dni, Model model){
        List<PersonaRec> listaPersona=personasData.buscarPersonasByDni(dni);
        model.addAttribute("personaDetalle", listaPersona);
        return VIEW_VERDETALLE;
    }
    



    @GetMapping("/reniecPersona/Personas_Eliminar/{dni}")
    public String Personas_Eliminar(@PathVariable("dni") String dni){
        personasData.eliminarPersonasByDni(dni);
        // List<Persona> listaPersona=personasData.buscarPersonasByDni(dni);
        // personasData.remove(listaPersona);
        return VIEW_LISTA;
    }



}
