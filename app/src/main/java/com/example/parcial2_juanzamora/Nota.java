package com.example.parcial2_juanzamora;

import android.content.Intent;
import android.os.Bundle;

public class Nota {

    private int img1, img2;
    private String materia, semestre, nota;

    public Nota(){

    }

    public Nota(int im1, int im2, String mat, String sem, String not){
        this.img1 = im1;
        this.img2 = im2;
        this.materia = mat;
        this.semestre = sem;
        this.nota = not;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
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
        b.putInt("img1", getImg1());
        b.putInt("img2", getImg2());
        b.putString("materia", getMateria());
        b.putString("semestre", getSemestre());
        b.putString("nota", getNota());
        return b;
    }

    public Nota toModel(Bundle b){ //Aqui se supone que se crean las llaves (key)
        return new Nota(
                b.getInt("img1"),
                b.getInt("img2"),
                b.getString("materia"),
                b.getString("semestre"),
                b.getString("nota")
        );
    }
}
