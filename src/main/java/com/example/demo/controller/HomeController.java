package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

import com.example.demo.integration.sendgrid.*;
import com.example.demo.integration.spotify.*;

@Controller
public class HomeController {

    private static final String HOME_INDEX ="welcome"; 

    private final SpotifyAPI spotifyAPI;
    private final SendGridAPI sendGridAPI;

    public HomeController(SpotifyAPI spotifyAPI,SendGridAPI sendGridAPI ){
        this.spotifyAPI = spotifyAPI;
        this.sendGridAPI = sendGridAPI;
    }

    @GetMapping("/")
    public String index(Model model) {
        sendGridAPI.send("jair_alarcon@usmp.pe","jair_alarcon@gmail.com","test","test");
        return HOME_INDEX;
    }
    
}
