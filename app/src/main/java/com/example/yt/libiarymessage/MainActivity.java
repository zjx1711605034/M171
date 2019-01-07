package com.example.yt.libiarymessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private TextView tv_main_title;
    private TextView tv_main_zhanghao;
    private EditText edt_main_zhanghao;
    private TextView tv_main_mima;
    private EditText edt_main_mima;
    private Button btn_main_guanli;
    private Button btn_main_fangke;
    private Button btn_main_zhuce;

    private Toolbar MyToobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        tv_main_zhanghao = (TextView) findViewById(R.id.tv_main_zhanghao);
        edt_main_zhanghao = (EditText) findViewById(R.id.edt_main_zhanghao);
        tv_main_mima = (TextView) findViewById(R.id.tv_main_mima);
        edt_main_mima = (EditText) findViewById(R.id.edt_main_mima);
        btn_main_guanli = (Button) findViewById(R.id.btn_main_guanli);
        btn_main_fangke = (Button) findViewById(R.id.btn_main_fangke);
        btn_main_zhuce = (Button) findViewById(R.id.btn_main_zhuce);
        // toolbar=findViewById(R.id.MyToobar);
        btn_main_guanli.setOnClickListener(this);
        btn_main_fangke.setOnClickListener(this);
        btn_main_zhuce.setOnClickListener(this);
        MyToobar = (Toolbar) findViewById(R.id.MyToobar);
        MyToobar.setOnClickListener(this);
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
            case R.id.btn_main_guanli:
                JoinStep(LuruActivity.class);
                break;
            case R.id.btn_main_fangke:
                JoinStep(TushucxActivity.class);
                break;
            case R.id.btn_main_zhuce:
                JoinStep(ZhuceActivity.class);
                break;
        }
    }

    public void JoinStep(Class myclass) {
        Intent intent = new Intent();
        intent.setClass(this, myclass);
        startActivity(intent);
    }

}
