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
    NotaAdapter notaAdapter;
    List<Nota> notaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);

        this.inicializarControles();
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
            NotaAdapter adapter = new NotaAdapter(this, LlenarListView());
            lstNotas.setAdapter(adapter);
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Nota> LlenarListView(){
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, "Quimica", "II Semestre", "A"));
        notaList.add(new Nota(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, "Fisica", "II Semestre", "B"));
        return notaList;
    }
}
