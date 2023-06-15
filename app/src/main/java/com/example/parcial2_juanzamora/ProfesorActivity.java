package com.example.parcial2_juanzamora;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProfesorActivity extends AppCompatActivity {

    TextView txtBienvendo;
    ListView lstNotas;
    NotaAdapter adapter;
    //List<Nota> notaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);

        this.inicializarControles();

/*
        Bundle b = getIntent().getExtras(); // Aqui es donde se guardan los datos enviados de NuevaNotaActivity en la linea 43
        if(b != null){
            Nota nota = new Nota().toModel(b);
            List <Nota> notas = LlenarListView();
            notas.add(nota);
            adapter = new NotaAdapter(getApplicationContext(), notas);
        }else{
            adapter = new NotaAdapter(this, LlenarListView());
        }
        lstNotas.setAdapter(adapter);

 */
        datosProfesor();
    }

    private void inicializarControles() {
        this.txtBienvendo = findViewById(R.id.txtBienvendo);
        this.lstNotas = findViewById(R.id.lstNotas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menCrear) {
            startActivity(new Intent(ProfesorActivity.this, NuevaNotaActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    private List<Nota> LlenarListView(){
        List<Nota> notaList = new ArrayList<>();
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
        return notaList;
    }

     */
    private void datosProfesor(){
        String nom_profesor = " ";

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("profesores.txt")));
            List<Usuarios> usuariosList = new ArrayList<>();
            String texto;

            while((texto = br.readLine()) != null){

                String[] datos = texto.split(",");

                if(datos.length == 3){
                    Usuarios usuario = new Usuarios(datos[0], datos[1], datos[2]);
                    usuariosList.add(usuario);

                    nom_profesor = usuario.getNombre();
                }
            }

        }catch(Exception e){

        }


        txtBienvendo.setText("Bienvenido Profesor " + nom_profesor);
    }
}