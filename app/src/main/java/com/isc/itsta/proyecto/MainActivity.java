package com.isc.itsta.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import logic.AppControl;


public class MainActivity extends AppCompatActivity {

    private AppControl logic;
            AutoCompleteTextView user;
            AutoCompleteTextView password;
            Button login;


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                logic = AppControl.getInstance();

                user = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
                password = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
                login = (Button) findViewById(R.id.button);
            }



        public void attemptLogin(View view){
            if(user.getText().toString().isEmpty()){
                user.setError(getString(R.string.requerido));
            }else{
                if(password.getText().toString().isEmpty()){
                    password.setError(getString(R.string.requerido));
                }else{
                    Boolean attempt = logic.login(user.getText().toString(), password.getText().toString());
                    System.out.println(attempt);
                    if(attempt){
                        Intent intent = new Intent(this, PatientList.class);
                        startActivity(intent);
                    }else{
                        String[] us = logic.getUser(user.getText().toString()).split(":");
                        if(!user.getText().toString().equals(us[0])){
                            user.setError(getString(R.string.usuario_invalido));
                        }
                        if(!password.getText().toString().equals(us[1])){
                            password.setError(getString(R.string.contrasena_invalida));
                        }
                    }
                }
            }


        }





}
