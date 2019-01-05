package com.example.yt.libiarymessage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    static Integer version=1;
    static String Tablename="userData";
    static  String DabaBase="ZJXData";
    public static final String CREATE_USERDATA="create table userData(" +
            "id integer primary key autoincrement,"
            +"name text  UNIQUE ,"
            +"password text)";


    public static final String CREATE_Book="create table mybook(" +
            "id integer primary key  ,"
            +"bookname text,"
            +"author text)";
    private Context mcontext;
    public MyDBHelper(Context context,String name,SQLiteDatabase.CursorFactory cursorFactory,int version){
        super(context,DabaBase,cursorFactory,version);
        mcontext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERDATA);
        db.execSQL(CREATE_Book);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
