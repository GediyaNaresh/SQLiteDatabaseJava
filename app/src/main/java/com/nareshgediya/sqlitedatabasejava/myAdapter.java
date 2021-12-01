package com.nareshgediya.sqlitedatabasejava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder>{

    ArrayList<model> dataHolder;

    public myAdapter(ArrayList<model> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

//        holder.nameT.setText(dataHolder.get(position).getName());
//        holder.contactT.setText(dataHolder.get(position).getContact());
//        holder.emailT.setText(dataHolder.get(position).getEmail());
        holder.contactT.setText(dataHolder.get(position).getContact());
         holder.nameT.setText(dataHolder.get(position).getName());
        holder.emailT.setText(dataHolder.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

   public static class myViewHolder extends RecyclerView.ViewHolder{

    TextView nameT, contactT,emailT;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);

        nameT = itemView.findViewById(R.id.textname1);
        contactT = itemView.findViewById(R.id.textcontact);
        emailT = itemView.findViewById(R.id.textemail);
    }
}
}
