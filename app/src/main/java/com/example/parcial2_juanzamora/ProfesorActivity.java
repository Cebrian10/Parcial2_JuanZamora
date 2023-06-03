package com.example.parcial2_juanzamora;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfesorActivity extends AppCompatActivity {

    TextView txtBienvendo;
    ListView lstNotas;

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
}