package com.example.restexample.restexample.dal.dtos;

import java.util.Collection;
import java.util.Collections;

import org.apache.logging.log4j.util.Strings;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.restexample.restexample.dal.models.Usuarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDto implements UserDetails {
    
    private String correo;
    private String password;
    private Integer id;
    private String token;

    public static UserDetails build(Usuarios usuarios){
        return new UsuarioDto(usuarios.getCorreo(), usuarios.getContrasena(), usuarios.getIdUsuario(),Strings.EMPTY);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
    @Override
    public String getUsername() {
       return getCorreo();
    }
    @Override
    public boolean isAccountNonExpired() {
        return Boolean.TRUE;
    }
    @Override
    public boolean isAccountNonLocked() {
        return Boolean.TRUE;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return Boolean.TRUE;
    }
    @Override
    public boolean isEnabled() {
        return Boolean.TRUE;
    }

    

}
