package com.example.penerapansqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDbAdapter {
    private MyDbHelper myDbHelper;

    public MyDbAdapter (Context context){
        myDbHelper = new MyDbHelper(context);
    }

    public long insertData (String name, String pass){

        SQLiteDatabase dbb = myDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.NAME,name);
        contentValues.put(MyDbHelper.MyPASSWORD,pass);
        long id = dbb.insert(MyDbHelper.TABLE_NAME,null,contentValues);
        return id;
    }
    public String getData()
    {
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        String[] columns = {MyDbHelper.UID,MyDbHelper.NAME,MyDbHelper.MyPASSWORD};
        Cursor cursor = db.query(myDbHelper.TABLE_NAME,columns,
                null,null,null,null,null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid = cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name = cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String password = cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            buffer.append(cid + " " + name + " " + password + "\n");
        }
        return buffer.toString();
    }
    public int delete(String uname)
    {
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        String[] whereArgs = {uname};

        int count = db.delete(MyDbHelper.TABLE_NAME , MyDbHelper.NAME + "= ?",whereArgs);
        return count;
    }
    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.NAME,newName);
        String[] whereArgs = {oldName};
        int count = db.update(MyDbHelper.TABLE_NAME,contentValues,myDbHelper.NAME+" = ?",whereArgs);
        return count;
    }
}
