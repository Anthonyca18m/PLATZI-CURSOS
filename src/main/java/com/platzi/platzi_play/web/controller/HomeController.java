package com.platzi.platzi_play.web.controller;

import com.platzi.platzi_play.domain.service.PlatziPlayAiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final PlatziPlayAiService aiService = new PlatziPlayAiService();

    @GetMapping(name = "Home", path = "/")
    public String home() {
        //return "Welcome to Platzi Play!";
        return aiService.generateGreeting("""
                Generate a greeting message for the user visiting Platzi Play.
                The message should be friendly and welcoming, inviting the user to explore the platform.
                Use 120 characters or less.
                """);
    }
}
