package com.nareshgediya.sqlitedatabasejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout name, email, contact;
    FloatingActionButton fab;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextInputLayout) findViewById(R.id.name1);
        contact = (TextInputLayout)findViewById(R.id.contact1);
        email=(TextInputLayout) findViewById(R.id.email1);

        fab = (FloatingActionButton)findViewById(R.id.fab1);
        addButton = (Button) findViewById(R.id.addbtn);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processInsert(name.getEditText().getText().toString(),contact.getEditText().getText().toString(),email.getEditText().getText().toString());
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),fetchData.class));
            }
        });


    }
    

    private void processInsert(String n, String c, String e){
        String res = new dbManager(this).addRecord(n,c,e);
        name.getEditText().setText("");
        contact.getEditText().setText("");
        email.getEditText().setText("");

        boolean insertData = DB.addData(newEntry, newEntry2);

        if (insertData){
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();

        }

        Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();

    }
}