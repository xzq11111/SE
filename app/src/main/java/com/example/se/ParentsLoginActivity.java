package com.example.se;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class ParentsLoginActivity extends AppCompatActivity {
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_login);
        //数据库
        Bmob.initialize(this, "2ccc6140687a4b195b74023bd2a0d248");

        Button new_register = (Button) findViewById(R.id.register);  //新用户注册按钮
        final EditText usernameET = (EditText) findViewById(R.id.username);//用户名
        final EditText passwordET = (EditText) findViewById(R.id.password);//密码
        Button login = (Button) findViewById(R.id.login);           //登录按钮
        //Button forgetpassword = (Button) findViewById(R.id.forgetpassword);  //忘记密码按钮
        //新用户注册按钮监听 跳转到家长注册页面
        new_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentsLoginActivity.this, ParentsRegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //登录按钮监听
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BmobQuery<Parents_Information> query = new BmobQuery<Parents_Information>();
                query.addWhereEqualTo("username", "xzq");
                query.findObjects(new FindListener<Parents_Information>() {
                    @Override
                    public void done(List<Parents_Information> list, BmobException e) {
                        if (e != null) {
                            Toast.makeText(ParentsLoginActivity.this, "chabudaoya", Toast.LENGTH_LONG).show();
                        } else {
                            for (Parents_Information person : list) {
                                Toast.makeText(ParentsLoginActivity.this, person.getObjectId().toString(), Toast.LENGTH_LONG).show();

                            }
                        }
                    }
                });

            }
        });

    }
}




/*
        Parents_Information person = new Parents_Information();
        person.setName("xzq");
        person.setAddress("address");
        person.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e!=null){
                    Toast.makeText(ParentsLoginActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(ParentsLoginActivity.this,"success",Toast.LENGTH_LONG).show();
                }
            }
        });*/
/*
        BmobQuery<Parents_Information> query = new BmobQuery<Parents_Information>();
        query.addWhereEqualTo("name", "xzq");
        query.findObjects(new FindListener<Parents_Information>() {
            @Override
            public void done(List<Parents_Information> list, BmobException e) {
                if (e != null){
                    Toast.makeText(ParentsLoginActivity.this,"chabudaoya",Toast.LENGTH_LONG).show();
                }else {
                    for (Parents_Information person : list) {
                        Toast.makeText(ParentsLoginActivity.this, person.getObjectId().toString(), Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
        //Parents_Information person = new Parents_Information();
        //person.setName("mzn");
        //person.

        */

    /*
    private  void show(String msg){
        Toast.makeText(ParentsLoginActivity.this,msg,Toast.LENGTH_LONG).show();
    }
    */

