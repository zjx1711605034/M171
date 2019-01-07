package com.example.yt.libiarymessage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yt.libiarymessage.Adapter.MyBaseAdapter;
import com.example.yt.libiarymessage.EntryBeans.Book;
import com.example.yt.libiarymessage.Server.FunctionServer;
import com.example.yt.libiarymessage.Server.FunctionServerImp;

import java.util.ArrayList;
import java.util.List;


public class TushucxActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar MyToobar;
    private TextView tv_tushucx;
    private TextView tv_mian_ID;
    private TextView tv_main_name;
    private EditText edt_main_ID;
    private EditText edt_main_name;
    private TextView tv_main_show;
    private Button btn_tushu_check;
    private Button btn_tushu_return;
    private FunctionServer functionServer;
    private Activity activity;
    private Context context;
    private ListView Mylist;
    private MyBaseAdapter myBaseAdapter ;
    private  List<Book> mybook=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tushucx);
        initView();

    }

    private void initView() {
        myBaseAdapter=new MyBaseAdapter(mybook,this);
        activity = this;
        context = this;
        functionServer = new FunctionServerImp(activity, context);
        MyToobar = (Toolbar) findViewById(R.id.MyToobar);
        tv_tushucx = (TextView) findViewById(R.id.tv_tushucx);
        tv_mian_ID = (TextView) findViewById(R.id.tv_mian_ID);
        tv_main_name = (TextView) findViewById(R.id.tv_main_name);
        edt_main_ID = (EditText) findViewById(R.id.edt_main_ID);
        edt_main_name = (EditText) findViewById(R.id.edt_main_name);
        btn_tushu_check = (Button) findViewById(R.id.btn_tushu_check);
        btn_tushu_return = (Button) findViewById(R.id.btn_tushu_return);
        setSupportActionBar(MyToobar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MyToobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn_tushu_check.setOnClickListener(this);
        btn_tushu_return.setOnClickListener(this);
        Mylist = (ListView) findViewById(R.id.Mylist);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tushu_check:
                try {
                    String ID = edt_main_ID.getText() + "";
                    String Name = edt_main_name.getText() + "";
                    Integer IDS = null;
                    if (ID.equals("")) {
                        IDS = null;
                    } else {
                        IDS = Integer.valueOf(ID);
                    }
                    if (Name.equals("")) {
                        Name = null;
                    }
                    Book entry = new Book(IDS, Name, null);
                    List<Book> books = functionServer.BookChaxun(entry, false);
                    myBaseAdapter=new MyBaseAdapter(books,this);
                    myBaseAdapter.notifyDataSetChanged();
                    Mylist.setAdapter(myBaseAdapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_tushu_return:
            onBackPressed();
                break;
        }
    }

}
