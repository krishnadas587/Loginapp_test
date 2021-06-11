package com.example.login_page.Models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.login_page.Branch_settings;
import com.example.login_page.database.bankdb;

public class Database_babk_model {
    String name;
    int amount;
    bankdb db;
    Context ctx;

    public Database_babk_model(Context ctx) {
        db = new bankdb(ctx);
        this.ctx = ctx;
    }


    public String getName() {
        return name;
    }

    public boolean setName(String name,int amount) {
        this.name = name;
       this.amount=amount;
      return insertdata(name,amount);

    }

    public int getAmount() {
        return amount;
    }


    private boolean insertdata(String location,int amt) {

        return db.insertdata(location, amt);


    }

}
