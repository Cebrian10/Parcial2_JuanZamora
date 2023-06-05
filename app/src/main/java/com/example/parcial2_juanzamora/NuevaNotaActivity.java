package com.example.parcial2_juanzamora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class NuevaNotaActivity extends AppCompatActivity {
    //Declaracion de variables
    TextInputEditText materia, semestre, nota;
    private int img1 = R.drawable.ic_launcher_background, img2;

    // Metodo onCreate
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
            String calificacion = nota.getText().toString();

            if(calificacion.equals("A") || calificacion.equals("B") || calificacion.equals("C")){
                img2 = R.drawable.aprobado;
            } else if(calificacion.equals("D") || calificacion.equals("F")){
                img2 = R.drawable.reprobado;
            }
            else
                Toast.makeText(this, "NOTA INCORRECTA", Toast.LENGTH_SHORT).show();

            Nota n = new Nota(
                    img1, img2, materia.getText().toString(), semestre.getText().toString(), nota.getText().toString()
            );
            Intent i = new Intent(NuevaNotaActivity.this, ProfesorActivity.class);
            i.putExtras(n.toBundle());
            startActivity(i);
        }catch(Exception e){

        }
    }
}
