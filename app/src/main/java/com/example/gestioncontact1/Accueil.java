package com.example.gestioncontact1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Accueil extends AppCompatActivity implements View.OnClickListener {
    TextView tvusername;
    Button btnAjout, btnAffich;

    public static boolean call_permission = false ;

    public static ArrayList<Contact> data = new ArrayList<Contact>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        //check permission
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
            call_permission = true;
        }
        else{
            //demander la permission
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1
                    );
        }

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
    //context: activité qui occupe l'ecran
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1){
            if(grantResults.length>0 && PackageManager.PERMISSION_GRANTED == grantResults[0]){
                call_permission  = true ;
            }
        }
    }
}