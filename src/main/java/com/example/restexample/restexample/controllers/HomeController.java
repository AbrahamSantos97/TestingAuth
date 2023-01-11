package com.example.restexample.restexample.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restexample.restexample.Utils.ParsersFile;
import com.example.restexample.restexample.dal.dtos.SeccionesDto;
import com.example.restexample.restexample.dal.repositories.SeccionesRepository;

@RestController
@RequestMapping(value = {"/home"})
public class HomeController {

    @Autowired
    private SeccionesRepository seccionesRepository;
    
    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<List<SeccionesDto>> home(){
        return ResponseEntity.of(Optional.of(seccionesRepository.getSeccionesById()
        .stream().map(this::builder).collect(Collectors.toList())));
    }

    private SeccionesDto builder(Object...objects){
        return new SeccionesDto(ParsersFile.parseObjectToInteger(objects[0])
        ,ParsersFile.parseObjectToString(objects[1]),ParsersFile.parseObjectToString(objects[2]),
        ParsersFile.parseObjectToInteger(objects[3]));
    }

}
