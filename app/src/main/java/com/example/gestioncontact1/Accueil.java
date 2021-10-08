package com.example.gestioncontact1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Accueil extends AppCompatActivity {
    TextView tvusername;
    Button btnAjout;
    Button btnAffich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        //Réccuperation des composants
        tvusername = findViewById(R.id.tvuser_acc) ;
        btnAjout= findViewById(R.id.btnaj_acc) ;
        btnAffich = findViewById(R.id.btnaff_acc) ;
    }
}