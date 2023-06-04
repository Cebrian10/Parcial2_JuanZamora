package com.example.parcial2_juanzamora;

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
}
