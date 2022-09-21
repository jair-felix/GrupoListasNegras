package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;


@Controller
public class ClienteController {

    private static final String INDEX ="cliente/create"; 
    private static String MODEL_CONTACT="cliente";
    private final ClienteRepository clientsData;


    public ClienteController(ClienteRepository clientsData){
        this.clientsData = clientsData;
    }  


    @GetMapping("/cliente/create")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACT, new Cliente());
        return INDEX;
    }  
    
    @PostMapping("/cliente/create")
    public String createSubmitForm(Model model, 
        @Valid Cliente objCliente, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro un cliente");
        }else{
            this.clientsData.save(objCliente);
            model.addAttribute(MODEL_CONTACT, objCliente);
            model.addAttribute("mensaje", "Se registro un cliente");
        }
        return INDEX;
    }
    
}
