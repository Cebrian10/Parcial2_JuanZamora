package com.example.parcial2_juanzamora;

import android.os.Bundle;

public class Nota {

    private int imgMateria, imgNota;
    private String materia, semestre, nota;

    public Nota(){

    }

    public Nota(int imgMateria, int imgNota, String mat, String sem, String not){
        this.imgMateria = imgMateria;
        this.imgNota = imgNota;
        this.materia = mat;
        this.semestre = sem;
        this.nota = not;
    }

    public int getImgMateria() {
        return imgMateria;
    }

    public void setImgMateria(int imgMateria) {
        this.imgMateria = imgMateria;
    }

    public int getImgNota() {
        return imgNota;
    }

    public void setImgNota(int imgNota) {
        this.imgNota = imgNota;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putInt("imgMateria", getImgMateria());
        b.putInt("imgNota", getImgNota());
        b.putString("materia", getMateria());
        b.putString("semestre", getSemestre());
        b.putString("nota", getNota());
        return b;
    }

    public Nota toModel(Bundle b){ //Aqui se supone que se crean las llaves (key)
        return new Nota(
                b.getInt("imgMateria"),
                b.getInt("imgNota"),
                b.getString("materia"),
                b.getString("semestre"),
                b.getString("nota")
        );
    }
}
