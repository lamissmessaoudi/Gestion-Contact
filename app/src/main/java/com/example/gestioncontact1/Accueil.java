package com.example.gestioncontact1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Accueil extends AppCompatActivity implements View.OnClickListener {
    TextView tvusername;
    Button btnAjout, btnAffich;
    public static ArrayList<Contact> data = new ArrayList<Contact>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        //Réccuperation des composants
        tvusername = findViewById(R.id.tvuser_acc) ;
        btnAjout= findViewById(R.id.btnaj_acc) ;
        btnAffich = findViewById(R.id.btnaff_acc) ;

        //Réccuperation des props
        Intent x =  this.getIntent();
        Bundle b = x.getExtras(); //bundle stock de donnees.
        String u = b.getString("user");

        tvusername.setText("Accueil de M. "+ u );

        //Ecouteur d'actions
        btnAjout.setOnClickListener(this);
        btnAffich.setOnClickListener(this);
    }
//context activité qui occpe l'ecran
    @Override
    public void onClick(View v) {
        if(v==btnAjout){
                Intent i = new Intent(this, Ajout.class );
                startActivity(i);
        }
        if(v==btnAffich){
            Intent a = new Intent(this, Affichage.class );
            startActivity(a);
        }

    }
}