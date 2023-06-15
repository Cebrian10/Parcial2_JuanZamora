package com.example.parcial2_juanzamora;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EstudianteActivity extends AppCompatActivity {

    TextView txtBienvendo, txtNombre, txtCedula;
    ListView lstNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);

        this.inicializarControles();


        Bundle b = getIntent().getExtras(); // Aqui es donde se guardan los datos enviados de NuevaNotaActivity en la linea 43
        NotaAdapter adapter;
        if(b != null){
            Nota nota = new Nota().toModel(b);
            List <Nota> notas = LlenarListView();
            notas.add(nota);
            adapter = new NotaAdapter(getApplicationContext(), notas);
        }else{
            adapter = new NotaAdapter(this, LlenarListView());
        }
        lstNotas.setAdapter(adapter);


        datosEstudiante();
    }

    private void inicializarControles() {
        this.txtBienvendo = findViewById(R.id.txtBienvendo);
        this.txtNombre = findViewById(R.id.txtNombre);
        this.txtCedula = findViewById(R.id.txtCedula);
        this.lstNotas = findViewById(R.id.lstNotas);
    }


    @NonNull
    private List<Nota> LlenarListView(){
        List<Nota> notaList = new ArrayList<>();
        SharedPreferences preferencias = getSharedPreferences("NotasEstudiantes", Context.MODE_PRIVATE);
        String materia = preferencias.getString("Materia", " ");
        String semestre = preferencias.getString("Semestre", " ");
        String nota = preferencias.getString("Nota", " ");
        String icono = preferencias.getString("Materia", " ");


        notaList.add(new Nota(R.drawable.inv_op, R.drawable.reprobado, "Inv. de Operaciones", "I Semestre", "F"));
        notaList.add(new Nota(R.drawable.ing_soft, R.drawable.aprobado, "Ing. de Software II", "I Semestre", "B"));
        notaList.add(new Nota(R.drawable.ds_v, R.drawable.aprobado, "Des. de Softare V", "I Semestre", "A"));
        notaList.add(new Nota(R.drawable.ds_vi, R.drawable.aprobado, "Des. de Softare VI", "I Semestre", "A"));
        notaList.add(new Nota(R.drawable.arq_org, R.drawable.aprobado, "Org. de Comp. I", "I Semestre", "B"));
        notaList.add(new Nota(R.drawable.ds_vii, R.drawable.aprobado, "Des. de Softare VII", "II Semestre", "C"));
        notaList.add(new Nota(R.drawable.redes_comp, R.drawable.aprobado, "Redes de Comp.", "II Semestre", "A"));
        notaList.add(new Nota(R.drawable.ds_viii, R.drawable.aprobado, "Des. de Softare VIII", "II Semestre", "B"));
        notaList.add(new Nota(R.drawable.sist_info, R.drawable.aprobado, "Sist. de Info. General", "II Semestre", "A"));
        notaList.add(new Nota(R.drawable.sist_op, R.drawable.reprobado, "Sist. Operativos I", "II Semestre", "D"));



        if (icono.equals("Inv. Operaciones")){
            int imagen = R.drawable.inv_op;
            int imgnota = 0;
            if (nota.equals("A") ||nota.equals("B") ||nota.equals("C")){
                imgnota = R.drawable.aprobado;
            } else if (nota.equals("D") || nota.equals("F")) {
                imgnota = R.drawable.reprobado;
            }
            notaList.add(new Nota(imagen, imgnota, materia, semestre, nota));
        } else if (icono.equals("Org. Computacional")) {
            int imagen = R.drawable.arq_org;
            notaList.add(new Nota(imagen, R.drawable.reprobado, materia, semestre, nota));

        } else if (icono.equals("Ing. Software 2")) {
            int imagen = R.drawable.ing_soft;
            int imgnota = 0;
            if (nota.equals("A") ||nota.equals("B") ||nota.equals("C")){
                imgnota = R.drawable.aprobado;
            } else if (nota.equals("D") || nota.equals("F")) {
                imgnota = R.drawable.reprobado;
            }
            notaList.add(new Nota(imagen, imgnota, materia, semestre, nota));
        } else if (icono.equals("Desarrollo 6")) {
            int imagen = R.drawable.ds_vi;
            int imgnota = 0;
            if (nota.equals("A") ||nota.equals("B") ||nota.equals("C")){
                imgnota = R.drawable.aprobado;
            } else if (nota.equals("D") || nota.equals("F")) {
                imgnota = R.drawable.reprobado;
            }
            notaList.add(new Nota(imagen, imgnota, materia, semestre, nota));
        } else if (icono.equals("Desarrollo 5")) {
            int imagen = R.drawable.ds_v;
            int imgnota = 0;
            if (nota.equals("A") ||nota.equals("B") ||nota.equals("C")){
                imgnota = R.drawable.aprobado;
            } else if (nota.equals("D") || nota.equals("F")) {
                imgnota = R.drawable.reprobado;
            }
            notaList.add(new Nota(imagen, imgnota, materia, semestre, nota));
        } else if (icono.equals("Sist. Operativos")) {
            int imagen = R.drawable.sist_op;
            int imgnota = 0;
            if (nota.equals("A") ||nota.equals("B") ||nota.equals("C")){
                imgnota = R.drawable.aprobado;
            } else if (nota.equals("D") || nota.equals("F")) {
                imgnota = R.drawable.reprobado;
            }
            notaList.add(new Nota(imagen, imgnota, materia, semestre, nota));
        } else if (icono.equals("Sist. Info. General")) {
            int imagen = R.drawable.sist_info;
            int imgnota = 0;
            if (nota.equals("A") ||nota.equals("B") ||nota.equals("C")){
                imgnota = R.drawable.aprobado;
            } else if (nota.equals("D") || nota.equals("F")) {
                imgnota = R.drawable.reprobado;
            }
            notaList.add(new Nota(imagen, imgnota, materia, semestre, nota));
        } else if (icono.equals("Desarrollo 7")) {
            int imagen = R.drawable.ds_vii;
            int imgnota = 0;
            if (nota.equals("A") ||nota.equals("B") ||nota.equals("C")){
                imgnota = R.drawable.aprobado;
            } else if (nota.equals("D") || nota.equals("F")) {
                imgnota = R.drawable.reprobado;
            }
            notaList.add(new Nota(imagen, imgnota, materia, semestre, nota));
        } else if (icono.equals("Desarrollo 8")) {
            int imagen = R.drawable.ds_viii;
            int imgnota = 0;
            if (nota.equals("A") ||nota.equals("B") ||nota.equals("C")){
                imgnota = R.drawable.aprobado;
            } else if (nota.equals("D") || nota.equals("F")) {
                imgnota = R.drawable.reprobado;
            }
            notaList.add(new Nota(imagen, imgnota, materia, semestre, nota));
        } else if (icono.equals("Redes de Computadoras")) {
            int imagen = R.drawable.redes_comp;
            int imgnota = 0;
            if (nota.equals("A") ||nota.equals("B") ||nota.equals("C")){
                imgnota = R.drawable.aprobado;
            } else if (nota.equals("D") || nota.equals("F")) {
                imgnota = R.drawable.reprobado;
            }
            notaList.add(new Nota(imagen, imgnota, materia, semestre, nota));
        }

        return notaList;
    }




    private void datosEstudiante(){
        String nom_estudiante = " ";
        String cedula = " ";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("estudiantes.txt")));
            List<Usuarios> usuariosList = new ArrayList<>();
            String texto;

            while((texto = br.readLine()) != null){

                String[] datos = texto.split(",");

                if(datos.length == 3){
                    Usuarios usuario = new Usuarios(datos[0], datos[1], datos[2]);
                    usuariosList.add(usuario);

                    nom_estudiante = usuario.getNombre();
                    cedula = usuario.getCedula();
                }
            }

        }catch(Exception e){

        }

        txtBienvendo.setText("Bienvenido :)");
        txtNombre.setText(nom_estudiante);
        txtCedula.setText(cedula);
    }

}
