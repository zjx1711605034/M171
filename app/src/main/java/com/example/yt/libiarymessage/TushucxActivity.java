package com.example.yt.libiarymessage;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.ConditionVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.SQLData;

public class TushucxActivity extends AppCompatActivity {
    Button btnReturn,btncheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tushucx);
        btnReturn=findViewById(R.id.btn_tushu_return);
        btncheck=findViewById(R.id.btn_tushu_check);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String ID;
                    String name;
                SQLiteDatabase db;
                ConditionVariable variable;
                switch (v.getId()){
                    case R.id.btn_tushu_check:

                }
                Intent intent=new Intent(TushucxActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
