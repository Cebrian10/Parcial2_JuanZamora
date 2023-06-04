package com.example.parcial2_juanzamora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class NuevaNotaActivity extends AppCompatActivity {
    TextInputEditText materia, semestre, nota;
    private int img1 = R.drawable.ic_launcher_background, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevanota);

        this.inicializarControles();

    }

    private void inicializarControles() {
        materia = findViewById(R.id.edtMateria);
        semestre = findViewById(R.id.edtSemestre);
        nota = findViewById(R.id.edtNota);
    }

    public void agregarNota(View v) {
        try {
            if(nota.getText().toString() == "D" || nota.getText().toString() ==  "F")
                img2 = R.drawable.reprobado;
            else
                img2 = R.drawable.aprobado;
            Nota n = new Nota(
                    img1,
                    img2,
                    materia.getText().toString(),
                    semestre.getText().toString(),
                    nota.getText().toString()
            );
            Intent i = new Intent(NuevaNotaActivity.this, ProfesorActivity.class); //Envio los datos
            i.putExtras(n.toBundle());
            startActivity(i);
        }catch(Exception e){

        }
    }
}
