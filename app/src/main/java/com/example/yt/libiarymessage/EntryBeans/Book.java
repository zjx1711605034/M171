package com.example.yt.libiarymessage.EntryBeans;

public class Book {
    private  Integer BookAID;
    private  String BookBName;
    private  String BookCAuthor;

    public Book() {
    }

    public Integer getBookAID() {
        return BookAID;
    }

    public void setBookAID(Integer bookAID) {
        BookAID = bookAID;
    }

    public String getBookBName() {
        return BookBName;
    }

    public void setBookBName(String bookBName) {
        BookBName = bookBName;
    }

    public String getBookCAuthor() {
        return BookCAuthor;
    }

    public void setBookCAuthor(String bookCAuthor) {
        BookCAuthor = bookCAuthor;
    }

    public Book(Integer bookAID, String bookBName, String bookCAuthor) {
        BookAID = bookAID;
        BookBName = bookBName;
        BookCAuthor = bookCAuthor;
    }
}
