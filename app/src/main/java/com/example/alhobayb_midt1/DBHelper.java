package com.example.alhobayb_midt1;

import android.app.Person;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="Humans.database";
    public static  final String TABLE_NAME="Person";
    public static final String COLUMN_ID="ID";
    public static final String COLUMN_NAME="Name";
    public static final String COLUMN_EMAIL="Email";
    public static final String COLUMN_PHONE="Phone";
    public static final String COLUMN_PERSONAL_ID="Personal_id";

    SQLiteDatabase db;
    public DBHelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, 2);
        db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                        + "("+ COLUMN_ID + " INTEGER PRIMARY KEY ,"
                        + COLUMN_NAME + " TEXT NOT NULL,"
                        + COLUMN_EMAIL +" TEXT NOT NULL,"
                        + COLUMN_PHONE + " TEXT NOT NULL, "
                        + COLUMN_PHONE + " TEXT NOT NULL)");
    }

    public void insert(String id, String fname,String email, String phone, String pid){
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID,id);
        values.put(COLUMN_NAME, fname);
        values.put(COLUMN_EMAIL,email);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_PERSONAL_ID, pid);

        db.insert(TABLE_NAME, null, values);

    }

    public void delete(String personal_id){
        String [] args={personal_id};
        db.delete(TABLE_NAME, COLUMN_PERSONAL_ID+"= ?", args);
    }



    public Cursor getResult(String name){
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME+" Where Name="+name,null);
        if (data.moveToNext()){
            return data;
        }else{
            return null;
        }
    }


    /* Every time the dB is updated (or upgraded) */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void deleteFirstRow(){
        db.execSQL("Delete from "+TABLE_NAME+" where ID IN (Select ID from "+TABLE_NAME+" limit 1)");

    }

    public Cursor getFirstRow(){
        Cursor c=db.rawQuery("SELECT * FROM "+TABLE_NAME+" LIMIT 1",null);
        if (c.moveToNext()){
            return c;
        }else{
            return null;
        }
    }

    public Cursor getSpecificResult(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME+ " WHERE ID = ?", new String[]{id});
        while (data.moveToNext()){
            // some examples, you can continue from here
            String temp = data.getString(0);  //0 is the index of the column ID
            String temp2 = data.getString(1); //1 is the index of the column CUSTOMER_NAME
        }
        return data;
    }

    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

}
