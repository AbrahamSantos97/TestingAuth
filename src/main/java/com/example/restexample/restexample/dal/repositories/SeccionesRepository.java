package com.example.restexample.restexample.dal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.restexample.restexample.dal.models.Secciones;

public interface SeccionesRepository extends JpaRepository<Secciones,Integer> {
    
    @Transactional(readOnly = true)
    @Query(value = "SELECT secciones.id_seccion, secciones.texto, secciones.nivel_superior, secciones.id_seccion_base FROM secciones where secciones.id_documento = 521",nativeQuery = true)
    List<Object[]> getSeccionesById();
}
