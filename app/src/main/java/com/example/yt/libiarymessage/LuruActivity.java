package com.example.yt.libiarymessage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yt.libiarymessage.EntryBeans.Book;
import com.example.yt.libiarymessage.Server.FunctionServer;
import com.example.yt.libiarymessage.Server.FunctionServerImp;
import com.example.yt.libiarymessage.Until.MyUntil;

import java.util.List;

public class LuruActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar MyToobar;
    private TextView tv_luru_title;
    private TextView tv_luru_ID;
    private TextView tv_luru_name;
    private TextView tv_luru_weizhi;
    private EditText edt_luru_ID;
    private EditText edt_luru_name;
    private EditText edt_luru_weizhi;
    private Button btn_luru_add;
    private Button btn_luru_change;
    private Button btn_luru_delete;
    private Button btn_luru_return;
    private FunctionServer functionServer;
    private Activity activity;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luru);
        initView();


    }

    private void initView() {
        activity=this;
        context=this;
        MyToobar = (Toolbar) findViewById(R.id.MyToobar);
        tv_luru_title = (TextView) findViewById(R.id.tv_luru_title);
        tv_luru_ID = (TextView) findViewById(R.id.tv_luru_ID);
        tv_luru_name = (TextView) findViewById(R.id.tv_luru_name);
        tv_luru_weizhi = (TextView) findViewById(R.id.tv_luru_weizhi);
        edt_luru_ID = (EditText) findViewById(R.id.edt_luru_ID);
        edt_luru_name = (EditText) findViewById(R.id.edt_luru_name);
        edt_luru_weizhi = (EditText) findViewById(R.id.edt_luru_weizhi);
        btn_luru_add = (Button) findViewById(R.id.btn_luru_add);
        btn_luru_change = (Button) findViewById(R.id.btn_luru_change);
        btn_luru_delete = (Button) findViewById(R.id.btn_luru_delete);
        btn_luru_return = (Button) findViewById(R.id.btn_luru_return);
        functionServer=new FunctionServerImp(activity,context);
        btn_luru_add.setOnClickListener(this);
        btn_luru_change.setOnClickListener(this);
        btn_luru_delete.setOnClickListener(this);
        btn_luru_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_luru_add:
                Addbt();
                break;
            case R.id.btn_luru_change:
                changbt();
                break;
            case R.id.btn_luru_delete:
                deletebt();

                break;
            case R.id.btn_luru_return:
                onBackPressed();
                returnbt();

                break;
        }
    }

    //返回按钮
    private void returnbt() {

    }

    //删除按钮
    private void deletebt() {
        try {
            functionServer.BookDelete(Integer.valueOf(edt_luru_ID.getText()+""),false);
        }catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
    }

    //修改按钮
    private void changbt() {
        Book entry=null;
        try {
             entry = MyUntil.isEntry(Book.class, edt_luru_ID, edt_luru_name, edt_luru_weizhi);
            functionServer.BookChange(entry,false);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }

    }

    //添加按钮
    private void Addbt() {

        Book entry =null;
        try {
             entry = MyUntil.isEntry(Book.class, edt_luru_ID, edt_luru_name, edt_luru_weizhi);
                functionServer.BookLuru(entry,false);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }

        // Book book=new Book(Integer.valueOf(entry.get(0)),entry.get(1),entry.get(2));
       // functionServer.BookLuru();
    }


}
