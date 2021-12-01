package com.nareshgediya.sqlitedatabasejava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbManager extends SQLiteOpenHelper {

    public static final String dbName = "dbContact";

    public dbManager(@Nullable Context context) {
        super(context,dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qury = "Create table table_contact(id integer primary key autoincrement,name text, contact text, email text)";
        db.execSQL(qury);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String qry = "DROP TABLE IF EXISTS tabl_contact";
        db.execSQL(qry);
        onCreate(db);
    }
    public  String addRecord(String name, String contact ,String email){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv =new ContentValues();
        cv.put("name",name);
        cv.put("contact",contact);
        cv.put("email",email);

        float res = db.insert("table_contact",null,cv);

        if (res == -1) {
            Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        }else {

        }
    }

    public Cursor readAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String qyry = "Select * from table_contact order by id desc";
        Cursor cursor = db.rawQuery(qyry,null);
        return cursor;
    }
}
