package com.example.gestioncontact1;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerContactAdapter extends RecyclerView.Adapter<MyRecyclerContactAdapter.MyViewHolder> {
    Context context;
    ArrayList<Contact> data ;

    public MyRecyclerContactAdapter(Context con, ArrayList<Contact> data) {
        this.context = con;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creation d'un view
        LayoutInflater inf = LayoutInflater.from(context);
        View v = inf.inflate(R.layout.view_contact, null );
        return new MyViewHolder((v));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact c =  data.get(position);
        //Modification des holders
        holder.tvnom.setText(c.getNom());
        holder.tvpnom.setText(c.getPrenom());
        holder.tvnum.setText(c.getNum());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvnom , tvpnom , tvnum ;
        ImageButton call , delete , edit;
        public MyViewHolder(@NonNull View v) {
            super(v);
            //Recuperation des holders
             tvnom = v.findViewById((R.id.tvnom_vl));
             tvpnom = v.findViewById((R.id.tvpnm_vl));
             tvnum = v.findViewById((R.id.tvnum_vl));

             call= v.findViewById((R.id.ib_call));
             delete = v.findViewById((R.id.ib_delete));
             edit = v.findViewById((R.id.ib_edit));

             delete.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     int indice = getAdapterPosition();  // retoune pos de elemnet selectionné
                     data.remove(indice);
                     notifyDataSetChanged();
                 }
             });

            edit.setOnClickListener(
                    new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context)   ;
                    builder.setTitle("Edition") ;
                    builder.setMessage("choisir une action") ;
                    LayoutInflater inf = LayoutInflater.from((context));
                    View dialog_view = inf.inflate(R.layout.dialog_layout, null);

                    builder.setView(dialog_view);
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }
    }
}
