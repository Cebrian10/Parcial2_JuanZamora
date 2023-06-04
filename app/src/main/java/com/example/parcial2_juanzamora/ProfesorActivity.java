package com.example.parcial2_juanzamora;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ProfesorActivity extends AppCompatActivity {

    TextView txtBienvendo;
    ListView lstNotas;
    NotaAdapter adapter;
    List<Nota> notaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);

        this.inicializarControles();


        Bundle b = getIntent().getExtras(); // Aqui es donde se guardan los datos enviados de NuevaNotaActivity en la linea 43
        if(b != null){
            notaList.add(new Nota().toModel(b)); //Aqui mando los datos Nota.java a la linea

            adapter = new NotaAdapter(this, notaList);
        }else{
            adapter = new NotaAdapter(this, LlenarListView());
        }
        lstNotas.setAdapter(adapter);
    }

    private void inicializarControles() {
        this.txtBienvendo = findViewById(R.id.txtBienvendo);
        this.lstNotas = findViewById(R.id.lstNotas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menCrear){
            startActivity(new Intent(ProfesorActivity.this, NuevaNotaActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Nota> LlenarListView(){
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.reprobado, "Inv. de Operaciones", "I Semestre", "F"));
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.aprobado, "Ing. de Software II", "I Semestre", "B"));
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.aprobado, "Des. de Softare V", "I Semestre", "A"));
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.aprobado, "Des. de Softare VI", "I Semestre", "A"));
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.aprobado, "Org. de Comp. I", "I Semestre", "B"));
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.aprobado, "Des. de Softare VII", "II Semestre", "C"));
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.aprobado, "Redes de Comp.", "II Semestre", "A"));
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.aprobado, "Des. de Softare VIII", "II Semestre", "B"));
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.aprobado, "Sist. de Info. General", "II Semestre", "A"));
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.reprobado, "Sist. Operativos I", "II Semestre", "D"));
        return notaList;
    }
}
