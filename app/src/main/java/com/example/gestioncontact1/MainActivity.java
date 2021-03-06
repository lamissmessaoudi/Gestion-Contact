package com.example.gestioncontact1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ednom , edmp;
    Button btnval , btnQuit;


    @Override //appel implicite par system
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Réccuperation des composants
        edmp = findViewById(R.id.edmp_auth) ;
        ednom = findViewById(R.id.ednom_auth) ;
        btnval = findViewById(R.id.btnval_ajt) ;
        btnQuit = findViewById(R.id.btnquit_ajt) ;

        //Ecouteur d'actions
        //this => classe courante MainActivity that needs to implement View.OnClickListener inteface
        btnQuit.setOnClickListener(this);
        btnval.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String nom= ednom.getText().toString();
        String mdp= edmp.getText().toString();
        if(v==btnQuit){
            this.finish();
        }
        if(v==btnval) {
            if (nom.equalsIgnoreCase("test") && mdp.equals("000")) {
                Intent i = new Intent(this, Accueil.class);
                //sending properties to another page
                i.putExtra("user", nom);
                startActivity(i);
            } else {
                Toast.makeText(this, "login non valide ", Toast.LENGTH_SHORT).show();
                //this.finish();
            }
        }
    }
}