package com.example.restexample.restexample.dal.dtos;

public class RespuestaBasica {

    private String mensaje;

    public RespuestaBasica(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
}
