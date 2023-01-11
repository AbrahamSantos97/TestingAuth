package com.example.restexample.restexample.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.restexample.restexample.dal.dtos.UsuarioDto;
import com.example.restexample.restexample.dal.models.Usuarios;
import com.example.restexample.restexample.dal.repositories.UsuariosRepository;

@Service("securityService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios user = usuariosRepository.getUserByCorreo(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return UsuarioDto.build(user);
    }
    
    

}
