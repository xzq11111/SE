package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //身份选择按钮
        Button identity_determine = (Button) findViewById(R.id.identity_determine);
        //按钮监听
        identity_determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg = (RadioGroup)findViewById(R.id.identity);//单选按钮组
                for(int i=0;i<rg.getChildCount();i++){
                    RadioButton radioButton = (RadioButton) rg.getChildAt(i);
                    if(radioButton.isChecked()){
                        if(radioButton.getText().equals("学生家长")){
                            Intent intent = new Intent(MainActivity.this, ParentsLoginActivity.class);
                            startActivity(intent);
                        }else{
                            if(radioButton.getText().equals("教育机构")){
                                Toast.makeText(MainActivity.this,radioButton.getText().toString(),Toast.LENGTH_SHORT).show();
                            }else{
                                if (radioButton.getText().equals("教师")) {
                                    Toast.makeText(MainActivity.this,"教师",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(MainActivity.this,"管理员",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
            }
        });
    }

        //注释掉的部分都是关于数据库的操作，觉得没用就删了吧
        /*
        //数据库初始化
        Bmob.initialize(this,"2ccc6140687a4b195b74023bd2a0d248");


        Parents_Information person = new Parents_Information();
        person.setName("xzq");
        person.setAddress("address");
        person.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e!=null){
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
                }
            }
        });
        BmobQuery<Parents_Information> query = new BmobQuery<Parents_Information>();
        query.addWhereEqualTo("name", "xzq");
        query.findObjects(new FindListener<Parents_Information>() {
            @Override
            public void done(List<Parents_Information> list, BmobException e) {
                if (e != null){
                    Toast.makeText(MainActivity.this,"chabudaoya",Toast.LENGTH_LONG).show();
                }else {
                    for (Parents_Information person : list) {
                        Toast.makeText(MainActivity.this, person.getObjectId().toString(), Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
        //Parents_Information person = new Parents_Information();
        //person.setName("mzn");
        //person.
    */

    }//这个大括号是oncreate函数的结束

    /*
    private  void show(String msg){
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
    }
    */


