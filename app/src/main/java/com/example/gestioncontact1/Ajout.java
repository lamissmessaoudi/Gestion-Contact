package com.example.gestioncontact1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ajout extends AppCompatActivity implements View.OnClickListener {

    EditText ednom , ednum , edpnom;
    Button btnval , btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        Intent x =  this.getIntent();

        //Réccuperation des composants
        ednum = findViewById(R.id.ednum_ajt) ;
        edpnom = findViewById(R.id.edpnom_ajt) ;
        ednom = findViewById(R.id.ednom_ajt) ;
        btnval = findViewById(R.id.btnval_ajt) ;
        btnQuit = findViewById(R.id.btnquit_ajt) ;

        //Ecouteur d'actions
        //this => classe courante MainActivity that needs to implement View.OnClickListener inteface
        btnQuit.setOnClickListener(this);
        btnval.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==btnval){
            String nom= ednom.getText().toString();
            String pnom= edpnom.getText().toString();
            String num= ednum.getText().toString();
            Contact c= new Contact(nom, pnom , num) ;
            Accueil.data.add(c);
            Toast.makeText(this, "Contact Ajouté avec succes ", Toast.LENGTH_SHORT).show();

        }
        if(v==btnQuit){
            this.finish();
        }
    }
}