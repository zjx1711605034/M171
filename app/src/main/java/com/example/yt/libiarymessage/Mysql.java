package com.example.yt.libiarymessage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Mysql {

   static MyDBHelper myDBHelper=null;

    public static SQLiteDatabase WrieData(Context context){
         myDBHelper=new MyDBHelper(context,MyDBHelper.DabaBase,null,MyDBHelper.version);
        SQLiteDatabase writableDatabase = myDBHelper.getWritableDatabase();
        return  writableDatabase;
    }
    public static  void CloseData(SQLiteDatabase sqLiteDatabase){
        if(sqLiteDatabase!=null){
            sqLiteDatabase.close();
            if(myDBHelper!=null){
                myDBHelper.close();
            }
        }


    }




    public static SQLiteDatabase ReadDate(Context context){
        myDBHelper=new MyDBHelper(context,MyDBHelper.DabaBase,null,MyDBHelper.version);
        SQLiteDatabase writableDatabase = myDBHelper.getReadableDatabase();
        return  writableDatabase;
    }
  /*  public  static void DelAndInserAndAlter(String sqlyuju, Object[] chanshu, Context context){
        MyDBHelper myDBHelper1=null;
        SQLiteDatabase sqLiteDatabase=null;
        try{
            myDBHelper1=new MyDBHelper(context, MyDBHelper.DabaBase, null, MyDBHelper.version);
            sqLiteDatabase= ReadeData(myDBHelper1);
            sqLiteDatabase.execSQL(sqlyuju,chanshu);
           Toast.makeText(context, "注册成功", Toast.LENGTH_SHORT).show();
       }catch (Exception e){
           Toast.makeText(context, "注册失败", Toast.LENGTH_SHORT).show();
       }finally {
        if(sqLiteDatabase!=null){
            sqLiteDatabase.close();
            if(myDBHelper1!=null){
                myDBHelper1.close();
            }
        }
        }
    }
    public  static  Map<Integer,String[]> Select(String sqlyuju, Object[] chanshu, Context context){
        MyDBHelper myDBHelper1=null;
        String[] columnNames=null;
        Map<Integer,String[]> map=new HashMap<>();
        try {
            myDBHelper1=new MyDBHelper(context, MyDBHelper.DabaBase, null, MyDBHelper.version);
            SQLiteDatabase sqLiteDatabase = ReadeData(myDBHelper1);
            Cursor cursor = sqLiteDatabase.rawQuery(sqlyuju, (String[]) chanshu);
            int count=0;
            while (cursor.moveToFirst()){
                map.put(count, cursor.getColumnNames());
            }
            return  map;
        }catch (Exception e){
            Log.i("sadadsada",e+"");

        }
        return  map;
    }
    public  static  Map<Integer,String> Select(String sqlyuju,  Context context){
        MyDBHelper myDBHelper1=null;
        String[] columnNames=null;
        SQLiteDatabase sqLiteDatabase=null;
        Map<Integer,String> map=new HashMap<>();
        try {
            myDBHelper1=new MyDBHelper(context, MyDBHelper.DabaBase, null, MyDBHelper.version);
             sqLiteDatabase = ReadeData(myDBHelper1);
            Cursor cursor = sqLiteDatabase.rawQuery(sqlyuju,null);
            int count=0;
            while (cursor.moveToFirst()){
                map.put(count, cursor.getString(0));

            }
            return  map;
        }catch (Exception e){
            Log.i("sadadsada",e+"");
        }finally {
            if(sqLiteDatabase!=null){
                sqLiteDatabase.close();
                if(myDBHelper1!=null){
                    myDBHelper1.close();
                }
            }
        }

        return  map;
    }*/

}
