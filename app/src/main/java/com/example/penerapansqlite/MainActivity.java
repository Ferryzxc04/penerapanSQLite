package com.example.penerapansqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

EditText Name, Pass, updateold, updatenew, delete;
Button btnView;
MyDbAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.editName);
        Pass = findViewById(R.id.editPass);
        updateold = findViewById(R.id.editText3);
        updatenew = findViewById(R.id.editText5);
        delete = findViewById(R.id.editText6);
        btnView = findViewById(R.id.button2);
        adapter = new MyDbAdapter(this);
    }
    public void addUser(View view)
    {
        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();
        if(t1.isEmpty() || t2.isEmpty()){
            Info.show(getApplicationContext(),"Masukan User Nama dan Password !");
        }else {
            long id = adapter.insertData(t1,t2);
            if(id <= 0){
                Info.show(getApplicationContext(),"Gagal Tambah Data");
                Name.setText("");
                Pass.setText("");
            }else {
                Info.show(getApplicationContext(),"Sukses Tambah Data");
                Name.setText("");
                Pass.setText("");
            }
        }
        Name.requestFocus();
    }

    public void delete (View view){
        String uname = delete.getText().toString();
        if(uname.isEmpty()){
            Info.show(getApplicationContext(),"Masukan User Yang Akan Dihapus");
        }else {
            int a = adapter.delete(uname);
            if (a <= 0){
                Info.show(getApplicationContext(),"Gagal Melakukan Hapus Data");
                delete.setText("");
                delete.requestFocus();
            }else {
                Info.show(this,"Sukses Hapus Data");
                delete.setText("");
            }
        }

    }
    public void update (View view){
        String t1 = updateold.getText().toString();
        String t2 = updatenew.getText().toString();
        if(t1.isEmpty() || t2.isEmpty()){
            Info.show(getApplicationContext(),"Masukan Data User dan Password !");
        }else {
            long id = adapter.insertData(t1,t2);
            if(id <= 0){
                Info.show(getApplicationContext(),"Gagal Update");
                updateold.setText("");
                updatenew.setText("");
                updateold.requestFocus();
            }else {
                Info.show(getApplicationContext(),"Sukses Update Data");
                updateold.setText("");
                updatenew.setText("");
            }
        }

    }
    public void viewData(View view){
        String data = adapter.getData();
        Info.show(this,data);
        btnView.requestFocus();
    }
}
