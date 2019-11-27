package com.example.penerapansqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MyDbAdapter {

    private MyDbHelper myDbHelper;

    public MyDbAdapter (Context context){
        myDbHelper = new MyDbHelper (context);
    }

    public long insertData (String name, String pass){

        SQLiteDatabase dbb = myDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.NAME,name);
        contentValues.put(MyDbHelper.MyPASSWORD,pass);
        long id = dbb.insert(MyDbHelper.TABLE_NAME,null,contentValues);
        return id;
    }
}
