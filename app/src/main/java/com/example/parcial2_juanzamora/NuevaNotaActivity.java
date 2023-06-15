package com.example.parcial2_juanzamora;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONObject;

public class  NuevaNotaActivity extends AppCompatActivity {

    Spinner spMateria, spSemestre, spNota;
    EditText edtCedulaEs;

    // Metodo onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevanota);
        this.IniciarlizarControles();
        this.InicializarSpinners();
    }
    private void IniciarlizarControles(){
        spMateria = (Spinner) findViewById(R.id.spMateria);
        spSemestre = (Spinner) findViewById(R.id.spSemestre);
        spNota = (Spinner) findViewById(R.id.spNota);
        edtCedulaEs = (EditText) findViewById(R.id.edtCedulEs);
    }

    private void InicializarSpinners(){
        ArrayAdapter<CharSequence> adapterMateria = ArrayAdapter
                .createFromResource(getApplicationContext(),R.array.materiasOpciones, android.R.layout.simple_spinner_dropdown_item);
        spMateria.setAdapter(adapterMateria);

        ArrayAdapter<CharSequence> adapterSemestre = ArrayAdapter
                .createFromResource(getApplicationContext(),R.array.semestreOpciones, android.R.layout.simple_spinner_dropdown_item);
        spSemestre.setAdapter(adapterSemestre);

        ArrayAdapter<CharSequence> adapterNota = ArrayAdapter
                .createFromResource(getApplicationContext(),R.array.notasOpciones, android.R.layout.simple_spinner_dropdown_item);
        spNota.setAdapter(adapterNota);
    }

    private void obtenerDatos(String cedula, String materia, String semestre, String nota) {
        try {
            SharedPreferences preferencias = getSharedPreferences("NotasEstudiantes", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("Materia", materia);
                editor.putString("Semestre", semestre);
                editor.putString("Nota", nota);
                editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void GuardarNota(View view){
        try{
            String cedula = edtCedulaEs.getText().toString();
            String materia = ObtenerMateria();
            String semestre = ObtenerSemestre();
            String nota = ObtenerNota();

            obtenerDatos(cedula, materia, semestre, nota);

            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            int band = 1;
            e.printStackTrace();
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
        }
    }
    private String ObtenerMateria(){
        try {
            return (String)spMateria.getSelectedItem();
        }catch (Exception e){

        }
        return " ";
    }
    private String ObtenerSemestre(){
        try {
            return (String)spSemestre.getSelectedItem();
        }catch (Exception e){

        }
        return " ";
    }
    private String ObtenerNota(){
        try {
            return (String)spNota.getSelectedItem();
        }catch (Exception e){

        }
        return " ";
    }
}
