package com.example.yt.libiarymessage;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnZhuce,btnGuanli,btnFangke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnZhuce=findViewById(R.id.btn_main_zhuce);
        btnGuanli=findViewById(R.id.btn_main_guanli);
        btnFangke=findViewById(R.id.btn_main_fangke);

        //注册界面跳转
        btnZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent=new Intent(MainActivity.this,ZhuceActivity.class);
              startActivity(intent);
            }
        });

        //图书管理员界面跳转
        btnGuanli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LuruActivity.class);
                startActivity(intent);
            }
        });
        //访客界面跳转
        btnFangke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TushucxActivity.class);
                startActivity(intent);
            }
        });
    }
}
