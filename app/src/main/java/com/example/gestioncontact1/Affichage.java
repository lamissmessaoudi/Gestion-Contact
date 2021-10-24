package com.example.gestioncontact1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Affichage extends AppCompatActivity implements TextWatcher {

    //ListView lv ;
    RecyclerView rv ;
    EditText edrech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);

       // lv = findViewById(R.id.lv_aff);
        rv = findViewById(R.id.rv_aff);
        edrech = findViewById(R.id.edrech_aff) ;
        edrech.addTextChangedListener(this);

        //MyAdapter ad =  new MyAdapter(Affichage.this ,Accueil.data );
       // lv.setAdapter(ad);
        MyRecyclerContactAdapter ad = new MyRecyclerContactAdapter(this , Accueil.data);
        //LinearLayoutManager manager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL , true);
        GridLayoutManager manager= new GridLayoutManager(this, 1);
        rv.setLayoutManager(manager);
        rv.setAdapter(ad);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable ch) {
         ArrayList<Contact> filtred = new ArrayList<Contact>();
         for(int i=0 ;  i < Accueil.data.toArray().length ; i++){
            Contact s = Accueil.data.get(i);
            if( (s.nom.contains(ch)) ||(s.prenom.contains(ch))||(s.num.contains(ch))){
                filtred.add(s);
            }
        }

        MyAdapter filter =  new MyAdapter(Affichage.this ,filtred );
        //lv.setAdapter(filter);
    }
}