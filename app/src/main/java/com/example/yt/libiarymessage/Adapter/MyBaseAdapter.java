package com.example.yt.libiarymessage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yt.libiarymessage.EntryBeans.Book;
import com.example.yt.libiarymessage.R;

import java.util.List;


public class MyBaseAdapter extends BaseAdapter {
    private List<Book> books;
    private Context context;

    public MyBaseAdapter(List<Book> books, Context context) {
        this.books = books;
        this.context = context;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
        convertView = LayoutInflater.from(context).inflate(R.layout.listitem, null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
                viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.Myid.setText(books.get(position).getBookAID()+"");
        viewHolder.MyBook.setText(books.get(position).getBookBName());
        viewHolder.MyAuto.setText(books.get(position).getBookCAuthor());
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView Myid;
        public TextView MyBook;
        public TextView MyAuto;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.Myid = (TextView) rootView.findViewById(R.id.Myid);
            this.MyBook = (TextView) rootView.findViewById(R.id.MyBook);
            this.MyAuto = (TextView) rootView.findViewById(R.id.MyAuto);
        }

    }
}
