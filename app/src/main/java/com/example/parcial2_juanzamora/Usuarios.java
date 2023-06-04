package com.example.parcial2_juanzamora;

public class Usuarios {
    private String cedula, contra;

    public Usuarios(String ced, String con){
        this.cedula = ced;
        this.contra = con;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}
