package com.example.login_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.login_page.Adapters.Recycle_adapter;
import com.example.login_page.Models.Database_babk_model;
import com.example.login_page.database.bankdb;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Branch_settings extends AppCompatActivity {
    Database_babk_model dbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if( insertdata()){
            System.out.println("Inserted");
            Load_data();
        }else {
            System.out.println("not Inserted");
        }


    }

    private void Load_data() {
        RecyclerView recyclerView=findViewById(R.id.full_data_recycle);
        StaggeredGridLayoutManager grid = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(grid);
        bankdb hhf=new bankdb(getApplicationContext());
        Cursor cursor=hhf.getAlldata();
        List<String> dbm_name=new ArrayList<>();
        List<Integer> dbm_amount=new ArrayList<>();
        while (cursor.moveToNext()){
            dbm_name.add(cursor.getString(1));
            dbm_amount.add(cursor.getInt(2));
        }



        Recycle_adapter ad=new Recycle_adapter(Branch_settings.this,dbm_name,dbm_amount);
        recyclerView.setAdapter(ad);
    }

    private boolean insertdata() {
        dbm=new Database_babk_model(getApplicationContext());
        return dbm.setName("palakkad",2000)&&dbm.setName("Thrissur",3000)&& dbm.setName("alapuzha",2500)&&dbm.setName("kollam",2021);
    }


}