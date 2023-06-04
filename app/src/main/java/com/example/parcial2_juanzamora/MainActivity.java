package com.example.parcial2_juanzamora;

import androidx.appcompat.app.AppCompatActivity;

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

    public void Ingresar(View view){
        if(VerificarExistenciaArchivo()){
            String cedulaIngresada = edtCedula.getText().toString();
            String contraIngresada = edtCedula.getText().toString();
            if(verificarUsuario(cedulaIngresada, contraIngresada))
                startActivity(new Intent(MainActivity.this, SeleccionActivity.class));
            else
                Toast.makeText(this, "NO SON IGUALES", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "NO HAY NADA AUN", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean verificarUsuario(String cedulaIngresada, String contraIngresada) {
        try {
            List<Usuarios> usuarios = convertirArchivoList();
            for (Usuarios usuario : usuarios){
                if(cedulaIngresada.equals(usuario.getCedula()) && contraIngresada.equals(usuario.getContra()))
                    return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    private void inicializarDatos(){
        String cedula = "8-987-2235", contra = "1234";
        try {
            BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(openFileOutput("usuarios.txt", MODE_PRIVATE))));
            bw.write(cedula + "," + contra);
            bw.newLine();
            bw.close();

        }catch(Exception ex){
            Toast.makeText(this, "ALGO PASO", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean VerificarExistenciaArchivo(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("usuarios.txt")));
            String texto = br.readLine();

            if(!texto.isEmpty())
                return true;

        }catch(Exception ex){
            return false;
        }
        return false;
    }

    private List<Usuarios> convertirArchivoList(){
        try{
            List<Usuarios> usuarios = new ArrayList<>();
            String texto = new BufferedReader(new InputStreamReader(openFileInput("usuarios.txt"))).readLine();

            String[] arrUsuarios = texto.split(",");

            for(String usuario : arrUsuarios){
                String[] arrUsuario = usuario.split(",");
                Usuarios newUsuario = new Usuarios(
                        arrUsuario[0],
                        arrUsuario[1]
                );
                usuarios.add(newUsuario);
            }
            return usuarios;

        }catch(Exception e){

        }
        return new ArrayList<Usuarios>();
    }
}