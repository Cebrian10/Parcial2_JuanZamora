package com.example.parcial2_juanzamora;

public class Usuarios {
    private String cedula, contra, nombre;

    public Usuarios(String ced, String con, String nom){
        this.cedula = ced;
        this.contra = con;
        this.nombre = nom;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
