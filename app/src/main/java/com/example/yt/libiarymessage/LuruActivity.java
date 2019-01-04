package com.example.yt.libiarymessage;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.ConditionVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LuruActivity extends AppCompatActivity implements View.OnClickListener{
   private Button btnReturn,btnAdd,btnchange,btndelete;
    private EditText edtID,edtname,edtweizhi;
    MyDBHelper myDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luru);
        myDBHelper=new MyDBHelper(this);
        init();
    }
        private void init() {
            btnReturn = findViewById(R.id.btn_luru_return);
            btnAdd = findViewById(R.id.btn_luru_add);
            btnchange = findViewById(R.id.btn_luru_change);
            btndelete = findViewById(R.id.btn_luru_delete);
            edtID = findViewById(R.id.edt_luru_ID);
            edtname = findViewById(R.id.edt_luru_name);
            edtweizhi = findViewById(R.id.edt_luru_weizhi);
            btnReturn.setOnClickListener(this);
            btnAdd.setOnClickListener(this);
            btnchange.setOnClickListener(this);
            btndelete.setOnClickListener(this);
        }

            @Override
            public void onClick(View v){
                String ID;
                String name;
                String weizhi;
                SQLiteDatabase db;
                ContentValues values;
                switch (v.getId()) {
                    case R.id.btn_luru_add:
                        ID = edtID.getText().toString();
                        name = edtname.getText().toString();
                        weizhi = edtweizhi.getText().toString();
                        db = myDBHelper.getWritableDatabase();
                        values = new ContentValues();
                        values.put("ID", ID);
                        values.put("name", name);
                        values.put("weizhi", weizhi);
                        db.insert("information", null, values);
                        Toast.makeText(this, "录入成功", Toast.LENGTH_SHORT).show();
                        db.close();
                        break;

                    case  R.id.btn_luru_change:
                        db=myDBHelper.getWritableDatabase();
                        values=new ContentValues();
                        values.put("ID",ID=edtID.getText().toString());
                        values.put("name",name=edtname.getText().toString());
                        values.put("weizhi",weizhi=edtweizhi.getText().toString());
                        db.update("information",values,"name=?",new String[]{
                                edtname.getText().toString()});
                        Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();
                        db.close();
                        break;

                    case R.id.btn_luru_delete:
                        db =myDBHelper.getWritableDatabase();
                        db.delete("information",null,null);
                        Toast.makeText(this,"信息已删除",Toast.LENGTH_SHORT).show();

                }




            }

}
