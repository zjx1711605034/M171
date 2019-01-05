package com.example.yt.libiarymessage.Server;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.yt.libiarymessage.Dao.LibraryDao;
import com.example.yt.libiarymessage.Dao.LibraryDaoImp;
import com.example.yt.libiarymessage.EntryBeans.Book;
import com.example.yt.libiarymessage.EntryBeans.Zhuche;

import java.util.List;

public class FunctionServerImp implements  FunctionServer {
private Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public FunctionServerImp(Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
        libraryDao=new LibraryDaoImp(context);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void Zhuche(Zhuche zhuche,Boolean  isshow) {
    Boolean result=false;
        if(zhuche==null){
                Toast.makeText(context,"请不要留空",Toast.LENGTH_SHORT).show();
            }else {
            int adduser = libraryDao.Adduser(zhuche);
            if(adduser==-1){
                Toast.makeText(context,"用户已存在",Toast.LENGTH_SHORT).show();
            }else {
                if(adduser==1){
                    result=true;
                }

                TitleBack(result,isshow);
            }

            }



    }

    public void TitleBack(Boolean boo,Boolean isback){

        if(boo){
            Toast.makeText(context,"成功",Toast.LENGTH_SHORT).show();
       if(isback){
           activity.onBackPressed();
       }
        }else {
            Toast.makeText(context,"失败",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void StudentLogin() {

    }

    @Override
    public void AdminLogin() {

    }

    @Override
    public void BookLuru(Book book,Boolean isShow) {
        if(book==null){
            Toast.makeText(context,"请不要留空",Toast.LENGTH_SHORT).show();
        }else {
        Boolean aBoolean = libraryDao.AddBook(book);
        TitleBack(aBoolean,isShow);
        }
    }

    @Override
    public   List<Book> BookChaxun(Book book,Boolean isshow) {
        List<Book> books =null;
        if(book.getBookAID()==null&&book.getBookBName()==null){
            books = libraryDao.SelectBook();
        }else if(book.getBookAID()!=null){
            books = libraryDao.BookIDSelectBook(book.getBookAID());
        }else {
            books = libraryDao.BookNameSelectBook(book.getBookBName());
        }
        if(books.size()==0||books==null){
            TitleBack(false,isshow);
        }else {
            TitleBack(true,isshow);
        }
        return  books;
    }

    @Override
    public void BookDelete(Integer id,Boolean isshow) {
        Log.i("Myid", ""+id);
        if(id!=0){
            Boolean delete = libraryDao.delete(id);
            TitleBack(delete,isshow);
        }

    }

    @Override
    public void BookChange(Book book, Boolean isshow) {
                    if(book==null){
                        Toast.makeText(context,"请不要留空",Toast.LENGTH_SHORT).show();
                    }else {
                        Boolean updata = libraryDao.updata(book);
                        TitleBack(updata,isshow);
                    }
    }

    private Context context;



    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public LibraryDao getLibraryDao() {
        return libraryDao;
    }

    public void setLibraryDao(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }
    private   LibraryDao libraryDao;


}
