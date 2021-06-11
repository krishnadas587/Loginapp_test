package com.example.login_page.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class bankdb extends SQLiteOpenHelper {
   static String Database_name="Bank_DB";
   static String Table_Name="Bank_branch";
    public bankdb(@Nullable Context context) {
        super(context,Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,branch_name TEXT,financial_amount INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }
    public boolean insertdata(String Branch_name, int Fin_Amount){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("branch_name",Branch_name);
        contentValues.put("financial_amount",Fin_Amount);


        long result=db.insert(Table_Name,null,contentValues);
        db.close();
        return result != -1;

    }
    public Cursor getAlldata(){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.rawQuery("select * from "+Table_Name,null);
    }
    public boolean deletebranch(String name)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        return db.delete(Table_Name, "branch_name" + "=" +"'"+name+"'", null) > 0;
    }
//    public void updatebranch(String name, String amount, int id)
//    {
//        SQLiteDatabase db= this.getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//        contentValues.put("branch_name",name);
//        contentValues.put("financial_amount",amount);
//       db.update(Table_Name, contentValues, "ID=" + id, null);
//    }
    public boolean update(String s, String s1) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE "+Table_Name+" SET branch_name = "+"'"+s+"' "+ "WHERE branch_name = "+"'"+s1+"'");
        return true;
    }
}
