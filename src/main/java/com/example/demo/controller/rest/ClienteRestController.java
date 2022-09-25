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

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Cliente e){
        clientsData.save(e);
        clientsData.flush();
        return new ResponseEntity<Integer>(e.getId(),HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> Clientes(@PathVariable int id){
        Optional<Cliente> optinalEntity = clientsData.findById(id);
        if(optinalEntity.isPresent())
            return new ResponseEntity<Cliente>(
                optinalEntity.get(), HttpStatus.OK);
        else
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable int id){
        clientsData.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> update(@RequestBody Cliente update){
        Optional<Cliente> optinalEntity = clientsData.findById(update.getId());
        if(optinalEntity.isPresent()){
            Cliente current = optinalEntity.get();
            current.setCalifSBS(update.getCalifSBS());
            create(current);
        }
        return new ResponseEntity<Cliente>(HttpStatus.OK);
    }

    

}
