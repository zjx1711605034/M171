package com.example.yt.libiarymessage;

import android.content.Intent;
import android.os.ConditionVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LuruActivity extends AppCompatActivity {
    Button btnReturn,btnAdd,btnchange,btndelete;
    EditText edtID,edtname,edtweizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luru);
        btnReturn=findViewById(R.id.btn_luru_return);
        btnAdd=findViewById(R.id.btn_luru_add);
        btnchange=findViewById(R.id.btn_luru_change);
        btndelete=findViewById(R.id.btn_luru_delete);
        edtID=findViewById(R.id.edt_luru_ID);
        edtname=findViewById(R.id.edt_luru_name);
        edtweizhi=findViewById(R.id.edt_luru_weizhi);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID;
                String name;
                String weizhi;
                ConditionVariable variable;

                Intent intent=new Intent(LuruActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
