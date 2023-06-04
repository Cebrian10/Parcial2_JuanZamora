package com.example.parcial2_juanzamora;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionActivity extends AppCompatActivity {

    TextView txtTitulo;
    RadioGroup rgOpciones;
    RadioButton rbEstudiante, rbEstudianteSIU, rbProfesor;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

        this.inicializarControles();
    }

    private void inicializarControles() {
        this.txtTitulo = findViewById(R.id.txtTitulo);
        this.rgOpciones = findViewById(R.id.rgOpciones);
        this.rbEstudiante = findViewById(R.id.rbEstudiante);
        this.rbEstudianteSIU = findViewById(R.id.rbEstudianteSIU);
        this.rbProfesor = findViewById(R.id.rbProfesor);
        this.btnEntrar = findViewById(R.id.btnEntrar);
    }

    public void Entrar(View view){
        try{
            int rbSeleccionado = rgOpciones.getCheckedRadioButtonId();

            switch(rbSeleccionado){

                case R.id.rbEstudiante:
                    startActivity(new Intent(SeleccionActivity.this, EstudianteActivity.class));
                    break;

                case R.id.rbEstudianteSIU:
                    String url = "http://utp.ac.pa";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    break;

                case R.id.rbProfesor:
                    startActivity(new Intent(SeleccionActivity.this, ProfesorActivity.class));
                    break;
            }

        }catch(Exception ex){

        }
    }
}
