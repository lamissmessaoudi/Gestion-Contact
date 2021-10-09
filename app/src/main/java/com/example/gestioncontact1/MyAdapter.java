package com.example.gestioncontact1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context ;
    ArrayList<Contact> data ;

    public MyAdapter (Context c ,ArrayList<Contact> d ){
        this.context=c ;
        this.data=d;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //creation d'un view
        LayoutInflater inf = LayoutInflater.from(context);
        View v = inf.inflate(R.layout.view_contact, null );

        //Recuperation des holders
        TextView tvnom = v.findViewById((R.id.tvnom_vl));
        TextView tvpnom = v.findViewById((R.id.tvpnm_vl));
        TextView tvnum = v.findViewById((R.id.tvnum_vl));

        //Modification des holders
        tvnom.setText(data.get(i).getNom());
        tvpnom.setText(data.get(i).getPrenom());
        tvnum.setText(data.get(i).getNum());

        return v;

    }
}
