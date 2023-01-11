package com.example.restexample.restexample.dal.bridges;

import java.util.Optional;

import com.example.restexample.restexample.dal.models.Usuarios;

public interface BridgeLogin {
    
    public Optional<Usuarios> getUserByCorreo(String correo);

}
