package com.isc.itsta.proyecto;

import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import logic.AppControl;

public class Patient extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppControl logic = AppControl.getInstance();

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");

        int idP = getIntent().getIntExtra("_id", 0);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        TextView nombre = (TextView) findViewById(R.id.nombre);
        TextView edad = (TextView) findViewById(R.id.edad);
        TextView inicio = (TextView) findViewById(R.id.inicio);
        TextView fin = (TextView) findViewById(R.id.ultimo);
        edad.setText("Edad: "+logic.getPatient(idP).getAge());
        nombre.setText(logic.getPatient(idP).getName());
        inicio.setText("Inicio de tratamiento: "+sdfDate.format(logic.getPatient(idP).getBegin()));
        fin.setText("Ultima captura: "+((logic.getPatient(idP).getLast()!=null)?sdfDate.format(logic.getPatient(idP).getLast()):"No disponible"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            image.setBackground((logic.getPatient(idP).isMan()?getDrawable(R.mipmap.sin_hombre):getDrawable(R.mipmap.foto_mujer)));
        }
    }

}
