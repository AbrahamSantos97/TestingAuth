package com.example.restexample.restexample.services.auth;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.restexample.restexample.dal.bridges.BridgeLogin;
import com.example.restexample.restexample.dal.models.Usuarios;
import com.example.restexample.restexample.dal.repositories.UsuariosRepository;

@Service("serviceLogeo")
public class LoginService implements BridgeLogin {

    private final UsuariosRepository usuariosRepository;

    public LoginService(UsuariosRepository usuariosRepository){
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public Optional<Usuarios> getUserByCorreo(String correo) {
        return usuariosRepository.getUserByCorreo(correo.trim());
    }
    
    
}
