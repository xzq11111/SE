package com.example.se;

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
import cn.bmob.v3.listener.SaveListener;

public class ParentsRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_register);
        Bmob.initialize(this, "2ccc6140687a4b195b74023bd2a0d248");
        final EditText usernameET = (EditText) findViewById(R.id.username_new);
        final EditText passwordET = (EditText) findViewById(R.id.password_new);
        final EditText emailET = (EditText) findViewById(R.id.email);
        final EditText mobilenumET = (EditText) findViewById(R.id.mobile_phone_num);
        final EditText child_nameET = (EditText) findViewById(R.id.child_name);
        final EditText child_ageET = (EditText) findViewById(R.id.child_age);
        final EditText child_sexET = (EditText) findViewById(R.id.child_sex);
        final EditText parents_nameET = (EditText) findViewById(R.id.parents_name);
        final EditText parents_contact_informationET = (EditText) findViewById(R.id.parents_contact_information);
        Button submit = (Button) findViewById(R.id.register_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = usernameET.getText().toString().trim();
                final String password = passwordET.getText().toString().trim();
                final String email = emailET.getText().toString().trim();
                final String mobile_phone_num = mobilenumET.getText().toString().trim();
                final String child_name = child_nameET.getText().toString().trim();
                final String child_age = child_ageET.getText().toString().trim();
                final String child_sex = child_sexET.getText().toString().trim();
                final String parents_name = parents_nameET.getText().toString().trim();
                final String parents_contact_information = parents_contact_informationET.getText().toString().trim();
                if(username.equals("")||password.equals("")||email.equals("")||mobile_phone_num.equals("")||child_name.equals("")||child_age.equals("")||child_sex.equals("")||parents_name.equals("")||parents_contact_information.equals("")){
                    Toast.makeText(ParentsRegisterActivity.this,"请将信息填写完整",Toast.LENGTH_SHORT).show();
                }else {
                    if (mobile_phone_num.length()!=11){
                        Toast.makeText(ParentsRegisterActivity.this,"请输入11位的手机号",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        //查数据库，看用户名是否重复
                        BmobQuery<Parents_Information> query = new BmobQuery<Parents_Information>();
                        query.addWhereEqualTo("username", username);
                        query.findObjects(new FindListener<Parents_Information>() {
                            @Override
                            public void done(List<Parents_Information> list, BmobException e) {
                                if (e != null) {
                                    Toast.makeText(ParentsRegisterActivity.this, "数据库查找有异常", Toast.LENGTH_LONG).show();
                                } else {
                                    if(!list.isEmpty()){
                                        Toast.makeText(ParentsRegisterActivity.this, username+"兄dei~用户名重复", Toast.LENGTH_LONG).show();
                                    }
                                    else {//用户名没有重复，则把数据上传数据库
                                        Toast.makeText(ParentsRegisterActivity.this, "正在上传"+list.size(), Toast.LENGTH_LONG).show();
                                        Parents_Information parents_information = new Parents_Information();

                                        parents_information.setUsername(username);
                                        parents_information.setPassword(password);
                                        parents_information.setMobile_num(mobile_phone_num);
                                        parents_information.setEmail(email);
                                        parents_information.setChild_name(child_name);
                                        parents_information.setAge(child_age);
                                        parents_information.setSex(child_sex);
                                        parents_information.setParents_name(parents_name);
                                        parents_information.setContact_information(parents_contact_information);
                                        parents_information.save(new SaveListener<String>() {
                                            @Override
                                            public void done(String s, BmobException e) {
                                                if (e!=null){
                                                    Toast.makeText(ParentsRegisterActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                                                }else {
                                                    Toast.makeText(ParentsRegisterActivity.this,"success",Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        });
                        //Intent register_intent = new Intent(RegisterActivity.this,PersonalInformationActivity.class);
                        //startActivity(register_intent);
                        //finish();
                    }
                }
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


