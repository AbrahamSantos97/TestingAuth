package com.example.restexample.restexample.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminInformation {
    
    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("hellow");
    }
}
