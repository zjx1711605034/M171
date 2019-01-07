package com.example.yt.libiarymessage;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yt.libiarymessage.EntryBeans.Zhuche;
import com.example.yt.libiarymessage.Server.FunctionServer;
import com.example.yt.libiarymessage.Server.FunctionServerImp;
import com.example.yt.libiarymessage.Until.MyUntil;

import java.util.List;
import java.util.Map;

public class ZhuceActivity extends AppCompatActivity implements View.OnClickListener {


    private MyDBHelper myDBHelper;
    private TextView tv_zhuce_title;
    private TextView tv_zhuce_zhanghao;
    private EditText edt_zhuce_zhanghao;
    private TextView tv_zhuce_mima;
    private EditText edt_zhuce_mima;
    private Button btn_zhuce_zhuce;
    private Context context;
    private Toolbar MyToobar;
    private FunctionServer functionServer;
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        initView();
        context=this;

    }

    private void initView() {

        tv_zhuce_title = (TextView) findViewById(R.id.tv_zhuce_title);
        tv_zhuce_zhanghao = (TextView) findViewById(R.id.tv_zhuce_zhanghao);
        edt_zhuce_zhanghao = (EditText) findViewById(R.id.edt_zhuce_zhanghao);
        tv_zhuce_mima = (TextView) findViewById(R.id.tv_zhuce_mima);
        edt_zhuce_mima = (EditText) findViewById(R.id.edt_zhuce_mima);
        btn_zhuce_zhuce = (Button) findViewById(R.id.btn_zhuce_zhuce);
        btn_zhuce_zhuce.setOnClickListener(this);
        activity=this;
        functionServer=new FunctionServerImp(activity,this);
        MyToobar = (Toolbar) findViewById(R.id.MyToobar);
        setSupportActionBar(MyToobar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MyToobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_zhuce_zhuce:
                Zhuche zhuche=null;
                try {
                    zhuche = MyUntil.isEntry(Zhuche.class, edt_zhuce_zhanghao, edt_zhuce_mima);
                    Log.i("Myzhuche", zhuche.toString());
                } catch (Exception e) {
                    Log.i("Myerrow", e+"");
                    e.printStackTrace();
                }
                if (zhuche==null) {
                    Toast.makeText(this, "请输入账号密码", Toast.LENGTH_SHORT).show();
                } else {
                    functionServer.Zhuche(zhuche,true);
                }
                break;
        }
    }
}

