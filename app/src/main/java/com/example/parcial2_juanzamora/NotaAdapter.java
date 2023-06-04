package com.example.parcial2_juanzamora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NotaAdapter extends ArrayAdapter<Nota> {

    List<Nota> notas;

    public NotaAdapter(Context context, List<Nota> n){
        super(context, R.layout.listview_materia, n);
        notas = n;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext()
        );

        View item = inflater.inflate(R.layout.listview_materia, null);

        ImageView img1 = (ImageView)item.findViewById(R.id.imgMateria);
        img1.setImageResource(notas.get(position).getImg1());

        ImageView img2 = (ImageView)item.findViewById(R.id.imgNota);
        img2.setImageResource(notas.get(position).getImg2());

        TextView materia = (TextView)item.findViewById(R.id.txtMateria);
        materia.setText(notas.get(position).getMateria());

        TextView semeste = (TextView)item.findViewById(R.id.txtSemestre);
        semeste.setText(notas.get(position).getSemestre());

        TextView nota = (TextView)item.findViewById(R.id.txtNota);
        nota.setText(notas.get(position).getNota());

        return item;
    }
}