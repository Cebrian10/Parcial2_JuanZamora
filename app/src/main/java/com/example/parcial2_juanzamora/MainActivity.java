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
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
            OutputStreamWriter writer = new OutputStreamWriter(openFileOutput("usuarios.txt", Context.MODE_PRIVATE));
            writer.write("8-987-2235" + "," + "1234\n");
            writer.write("8-745-461" + "," + "4321");
            writer.close();
            Toast.makeText(this, "DATOS CARGARON", Toast.LENGTH_SHORT).show();
        }catch(Exception ex){
            Toast.makeText(this, "NO SE CARGARON", Toast.LENGTH_SHORT).show();
        }
    }

    public void Ingresar(View view){
        try {
            if(VerificarExistencia())
                startActivity(new Intent(MainActivity.this, SeleccionActivity.class));
            else
                Toast.makeText(this, "NO SON IGUALES", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "NO HAY NADA AUN", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean VerificarExistencia() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("usuarios.txt")));
            List<Usuarios> usuariosList = new ArrayList<>();

            String texto;

            while((texto = br.readLine()) != null){
                String[] datos = texto.split(",");
                if(datos.length == 2){
                    Usuarios usuario = new Usuarios(datos[0], datos[1]);
                    usuariosList.add(usuario);
                }
            }

            for(Usuarios usuarios : usuariosList){
                if (edtCedula.getText().toString().equals(usuarios.getCedula()) &&
                        (edtContra.getText().toString().equals(usuarios.getContra()))){
                    return true;
                }
            }
        }catch(Exception e){

        }
        return false;
    }
}