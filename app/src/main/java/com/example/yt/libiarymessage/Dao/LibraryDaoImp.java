package com.example.yt.libiarymessage.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.yt.libiarymessage.EntryBeans.Book;
import com.example.yt.libiarymessage.EntryBeans.Zhuche;
import com.example.yt.libiarymessage.Mysql;

import java.util.ArrayList;
import java.util.List;

public class LibraryDaoImp implements  LibraryDao {
    SQLiteDatabase sqLiteDatabase =null;
    Context context;

    public LibraryDaoImp(Context context) {
        this.context = context;
    }

    @Override
    public int Adduser(Zhuche zhuche) {
       try{
           ContentValues contentValues=new ContentValues();
           contentValues.put("name",zhuche.getUsername());
           contentValues.put("password",zhuche.getUserpasw());
            sqLiteDatabase = Mysql.WrieData(context);
           long userData = sqLiteDatabase.insert("userData", "name,password", contentValues);
           if(userData!=-1){
               return  1;
           }else{
               return  -1;
           }

       }catch (Exception e){
           Log.e("Adduser", e+"");
           return  0;
       }finally {
           Mysql.CloseData(sqLiteDatabase);
       }
    }

    @Override
    public List<Book> BookNameSelectBook(String book) {
     try {
         String sql="select * from mybook where bookname=?";
         sqLiteDatabase = Mysql.ReadDate(context);
         String [] pares={book};
         Cursor cursor = sqLiteDatabase.rawQuery(sql, pares);
         List<Book> mybook=new ArrayList<>();
         while (cursor.moveToNext()){
             int anInt = cursor.getInt(0);
             String string = cursor.getString(0);
             String string1 = cursor.getString(1);
             mybook.add(new Book(anInt,string,string1));
             if(cursor.moveToLast()==true){
                 break;
             }
         }
         return mybook;
     }catch (Exception e){
         return  null;
     }
    }

    @Override
    public List<Book> BookIDSelectBook(Integer ID) {
        try {
            String sql="select * from mybook where id=?";
            sqLiteDatabase = Mysql.ReadDate(context);
            String [] pares={ID+""   };
            Cursor cursor = sqLiteDatabase.rawQuery(sql, pares);
            List<Book> mybook=new ArrayList<>();
            while (cursor.moveToNext()){
                int anInt = cursor.getInt(0);
                String string = cursor.getString(0);
                String string1 = cursor.getString(1);
                mybook.add(new Book(anInt,string,string1));
                if(cursor.moveToLast()==true){
                    break;
                }
            }
            return mybook;
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public List<Book> SelectBook() {
        try {
            String sql="select * from mybook";
            sqLiteDatabase = Mysql.ReadDate(context);
            Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
            List<Book> mybook=new ArrayList<>();
            while (cursor.moveToNext()){
                int anInt = cursor.getInt(0);
                String string = cursor.getString(0);
                String string1 = cursor.getString(1);
                mybook.add(new Book(anInt,string,string1));


            }
            return mybook;
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public Boolean updata(Book book) {
        Log.i("Muyus", book.getBookAID()+"");
       try {

  String where="id ="+book.getBookAID();
               sqLiteDatabase = Mysql.WrieData(context);
           ContentValues contentValues=new ContentValues();
           contentValues.put("bookname",book.getBookBName());
           contentValues.put("author",book.getBookCAuthor());

           int mybook = sqLiteDatabase.update("mybook", contentValues, where,null);
            if(mybook==1){
                return  true;
            }else{
                return  false;
            }



       }catch (Exception e){
           return false;
       }finally {
           Mysql.CloseData(sqLiteDatabase);
       }
    }

    @Override
    public Boolean AddBook(Book mybook) {
        try{
            ContentValues contentValues=new ContentValues();
            contentValues.put("id",mybook.getBookAID());
            contentValues.put("bookname",mybook.getBookBName());
            contentValues.put("author",mybook.getBookCAuthor());
            sqLiteDatabase = Mysql.WrieData(context);
            long mybook1 = sqLiteDatabase.insert("mybook", "id,bookname,author", contentValues);
            Log.i("Mlong", mybook1+"");
            if(mybook1!=-1){
                return  true;
            }
            return  false;

        }catch (Exception e){
            Log.i("Myerrwo", e+"");
            return  false;
        }finally {
          Mysql.CloseData(sqLiteDatabase);
        }

    }

    @Override
    public Boolean delete(Integer bookid) {
        try{
            String Where="id = "+bookid;
            sqLiteDatabase = Mysql.WrieData(context);
            int mybook = sqLiteDatabase.delete("mybook", Where, null);
            if(mybook==1){
                return  true;
            }else {
                return  false;
            }
        }catch (Exception e){
            Log.i("Errows", e+"");
            return  false;
        }finally {
            Mysql.CloseData(sqLiteDatabase);
        }

    }

}
