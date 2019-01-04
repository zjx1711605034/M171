package com.example.yt.libiarymessage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
   public MyDBHelper(Context context){
       super(context,"itcast.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KET AUTOINCREMENT,name VARCHAR(20),phone VARCHAR(20))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }

}
