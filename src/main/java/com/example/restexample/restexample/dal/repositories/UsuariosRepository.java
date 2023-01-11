package com.example.restexample.restexample.dal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.restexample.restexample.dal.models.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Integer>{

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM usuarios WHERE usuarios.correo = ?1 ",nativeQuery = true)
    Optional<Usuarios> getUserByCorreo(String correo);
    
}
