package com.example.penerapansqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "data.db";    //    nama basis database
    public static final String TABLE_NAME    = "table_user"; //    nama table
    public static final int DATABASE_Version = 2;            //    version
    public static final String UID           = "_id";        //    column I (Primery Key)
    public static final String NAME          = "Name";       //    column II
    public static final String MyPASSWORD    = "Password";   //    column II
    public static final String CREATE_TABLE  = "CREATE TABLE" + TABLE_NAME + "("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+MyPASSWORD+" VARCHAR(5)"; //    CRETAE TABLE
    public static final String DROP_TABLE    = "DROP TABLE IF EXISTS "+ TABLE_NAME; //    DROP TABLE
    private Context context;


    public MyDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MyDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public MyDbHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, DATABASE_NAME, null,DATABASE_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Info.show(context,""+e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Info.show(context,"OnUpgrede");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e){
            Info.show(context,""+e);
        }

    }
}
