package com.example.se;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Parents_Information extends BmobObject {
    private String username;
    private String password;
    private String mobile_num;
    private String email;
    private String child_name;
    private String age;
    private String sex;
    private String parents_name;
    private String contact_information;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(String mobile_num) {
        this.mobile_num = mobile_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChild_name() {
        return child_name;
    }

    public void setChild_name(String child_name) {
        this.child_name = child_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getParents_name() {
        return parents_name;
    }

    public void setParents_name(String parents_name) {
        this.parents_name = parents_name;
    }

    public String getContact_information() {
        return contact_information;
    }

    public void setContact_information(String contact_information) {
        this.contact_information = contact_information;
    }



/*
    @Override
    public String toString(){
        return "Parents_Information{" +
                "name = '" + name + '\'' +
                ",address = '" + address + '\''+
                '}';
    }
    */
}
