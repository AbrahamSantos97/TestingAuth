package com.example.restexample.restexample.dal.dtos;

public class SeccionesDto {
    
    private Integer idSeccion;
    private String texto;
    private String nivelSuperior;
    private Integer idSeccionBase;

    public SeccionesDto(Integer idSeccion, String texto, String nivelSuperior, Integer idSeccionBase){
        this.idSeccion = idSeccion;
        this.texto = texto;
        this.nivelSuperior = nivelSuperior;
        this.idSeccionBase = idSeccionBase;
    }

    public Integer getIdSeccion() {
        return idSeccion;
    }
    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getNivelSuperior() {
        return nivelSuperior;
    }
    public void setNivelSuperior(String nivelSuperior) {
        this.nivelSuperior = nivelSuperior;
    }
    public Integer getIdSeccionBase() {
        return idSeccionBase;
    }
    public void setIdSeccionBase(Integer idSeccionBase) {
        this.idSeccionBase = idSeccionBase;
    }

    
}
