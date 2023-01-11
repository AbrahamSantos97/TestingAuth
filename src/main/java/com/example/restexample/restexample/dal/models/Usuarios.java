package com.example.restexample.restexample.dal.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "usuarios")
@NoArgsConstructor
@Data
public class Usuarios implements Serializable {
    
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellido")
    private String apellidoPaterno;

    @Column(name = "apellidos")
    private String apellidoMaterno;

    @Column(name = "correo")
    private String correo;

    @Column(name = "password")
    private String contrasena;

    @Column(name="perfil_cliente")
    private String perfil;

    @Transient
    private String token;

}
