package com.example.demo.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.*;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;


@RestController
@RequestMapping(value = "api/clientes", produces = "application/json")
public class ClienteRestController {

    private final ClienteRepository clientsData;

    public ClienteRestController(ClienteRepository clientsData){
        this.clientsData = clientsData;
    }  

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> clientes(){
        return  new ResponseEntity<List<Cliente>>(
            clientsData.findAll(), HttpStatus.OK);
    }

}
