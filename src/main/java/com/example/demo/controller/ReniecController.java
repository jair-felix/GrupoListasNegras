package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

@Controller
public class ReniecController {

    private static final String HOME_INDEX ="reniec/visualizar"; 

    @GetMapping("/reniec/visualizar")
    public String index() {
        
        return HOME_INDEX;
    }
    
}
