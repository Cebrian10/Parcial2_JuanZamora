package com.example.parcial2_juanzamora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txtTitulo;
    TextInputEditText edtCedula, edtContra;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inicializarControles();
        this.inicializarDatos();
    }

    private void inicializarControles() {
        this.txtTitulo = findViewById(R.id.txtTitulo);
        this.edtCedula = findViewById(R.id.edtCedula);
        this.edtContra = findViewById(R.id.edtContra);
        this.btnIngresar = findViewById(R.id.btnIngresar);
    }

    private void inicializarDatos(){
        try {
            OutputStreamWriter writerEs = new OutputStreamWriter(openFileOutput("estudiantes.txt", Context.MODE_PRIVATE));
            writerEs.write("8-975-537" + "," + "1234" + "," + "Pablo Palacios\n");
            writerEs.close();

            OutputStreamWriter writerProf = new OutputStreamWriter(openFileOutput("profesores.txt", Context.MODE_PRIVATE));
            writerProf.write("8-987-2235" + "," + "456" + "," + "Ameth Cebrian\n");
            writerProf.close();

            Toast.makeText(this, "DATOS CARGARON", Toast.LENGTH_SHORT).show();
        }catch(Exception ex){
            Toast.makeText(this, "NO SE CARGARON", Toast.LENGTH_SHORT).show();
        }
    }

    public void Ingresar(View view){
        try {
            if(VerificarExistenciaEstudiante()) {

                Intent intent = new Intent(MainActivity.this, SeleccionActivity.class);
                intent.putExtra("rbProfesor", !VerificarExistenciaEstudiante());
                intent.putExtra("rbEstudiante", !VerificarExistenciaProfesor());
                startActivity(intent);

            }else if(VerificarExistenciaProfesor()){

                Intent intent = new Intent(MainActivity.this, SeleccionActivity.class);
                intent.putExtra("rbProfesor", !VerificarExistenciaEstudiante());
                intent.putExtra("rbEstudiante", !VerificarExistenciaProfesor());
                startActivity(intent);

            }
            else {
                Toast.makeText(this, "CREDENCIALES INVALIDAS", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "ALGO FALLO, CONTACTA A SOPORTE", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean VerificarExistenciaEstudiante() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("estudiantes.txt")));
            List<Usuarios> usuariosList = new ArrayList<>();

            String texto;

            while((texto = br.readLine()) != null){

                String[] datos = texto.split(",");

                if(datos.length == 3){
                    Usuarios usuario = new Usuarios(datos[0], datos[1], datos[2]);
                    usuariosList.add(usuario);
                }
            }

            for(Usuarios usuarios : usuariosList){

                if (edtCedula.getText().toString().equals(usuarios.getCedula()) && (edtContra.getText().toString().equals(usuarios.getContra()))){
                    return true;
                }
            }

        }catch(Exception e){
        }
        return false;
    }

    public boolean VerificarExistenciaProfesor() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("profesores.txt")));
            List<Usuarios> usuariosList = new ArrayList<>();

            String texto;

            while((texto = br.readLine()) != null){

                String[] datos = texto.split(",");

                if(datos.length == 3){
                    Usuarios usuario = new Usuarios(datos[0], datos[1], datos[2]);
                    usuariosList.add(usuario);
                }
            }

            for(Usuarios usuarios : usuariosList){

                if (edtCedula.getText().toString().equals(usuarios.getCedula()) && (edtContra.getText().toString().equals(usuarios.getContra()))){
                    return true;
                }
            }

        }catch(Exception e){
        }
        return false;
    }
}