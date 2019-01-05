package com.example.yt.libiarymessage.Dao;

import android.content.Context;

import com.example.yt.libiarymessage.EntryBeans.Book;
import com.example.yt.libiarymessage.EntryBeans.Zhuche;

import java.util.List;

public interface LibraryDao {
    public int Adduser(Zhuche zhuche);
    public List<Book> BookNameSelectBook(String ZIduan);
    public List<Book> BookIDSelectBook(Integer ZIduan);
    public List<Book> SelectBook();
    public Boolean updata(Book book);
    public Boolean AddBook(Book mybook);
    public Boolean delete(Integer bookid);

}
