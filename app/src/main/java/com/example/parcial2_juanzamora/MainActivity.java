package com.example.parcial2_juanzamora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextView txtTitulo;
    TextInputEditText edtCedula, edtContra;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inicializarControles();
    }

    private void inicializarControles() {
        this.txtTitulo = findViewById(R.id.txtTitulo);
        this.edtCedula = findViewById(R.id.edtCedula);
        this.edtContra = findViewById(R.id.edtContra);
        this.btnIngresar = findViewById(R.id.btnIngresar);
    }

    public void Ingresar(View view){
        startActivity(new Intent(MainActivity.this, SeleccionPerfilActivity.class));
    }
}