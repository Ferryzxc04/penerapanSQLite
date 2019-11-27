package com.example.penerapansqlite;

import android.content.Context;
import android.widget.Toast;

public class Info {
    public static void show(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
