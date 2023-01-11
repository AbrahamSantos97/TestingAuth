package com.example.restexample.restexample.controllers;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restexample.restexample.dal.bridges.BridgeLogin;
import com.example.restexample.restexample.dal.dtos.UsuarioDto;
import com.example.restexample.restexample.dal.models.Usuarios;
import com.example.restexample.restexample.services.auth.JwtUtils;

@RestController
@RequestMapping(value = {"/auth"})
public class LoginController {

    @Autowired
    @Qualifier("serviceLogeo")
    BridgeLogin bridgeLogin;

    @Autowired
    private JwtUtils jwtUtils;
    
    @PostMapping(value = {"/login"})
    @CrossOrigin
    public ResponseEntity<Usuarios> loginUsr(@RequestBody UsuarioDto usuarioDto){
        if(Objects.nonNull(usuarioDto)){
            Optional<Usuarios> s = bridgeLogin.getUserByCorreo(usuarioDto.getCorreo());
            if(s.isPresent()){
                s.get().setToken(jwtUtils.generateToken(s.get()));
                return ResponseEntity.ok(s.get());
            }
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
