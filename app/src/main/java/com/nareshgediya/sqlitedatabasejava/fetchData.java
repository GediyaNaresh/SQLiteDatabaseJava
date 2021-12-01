package com.nareshgediya.sqlitedatabasejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class fetchData extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model> dataHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);

        recyclerView = (RecyclerView) findViewById(R.id.rv1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        Cursor cursor = new dbManager(this).readAllData();

        while (cursor.moveToNext()){
            model obj = new model(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            dataHolder.add(obj);
        }


        recyclerView.setAdapter(new myAdapter(dataHolder));

//
//        myAdapter adapter = new myAdapter(dataHolder);
//        recyclerView.setAdapter(adapter);
    }
}