package com.example.yt.libiarymessage.Server;

import com.example.yt.libiarymessage.EntryBeans.Book;
import com.example.yt.libiarymessage.EntryBeans.Zhuche;

import java.util.List;

public interface FunctionServer {
    public void Zhuche(Zhuche zhuche,Boolean isshow);
    public void StudentLogin();
    public void AdminLogin();
    public void  BookLuru(Book book,Boolean isshow);
    public List<Book> BookChaxun(Book book,Boolean isshow);
    public void   BookDelete(Integer id,Boolean isshow);
    public void   BookChange(Book book,Boolean isshow);

}
