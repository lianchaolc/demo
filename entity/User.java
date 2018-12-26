package com.pp.learn.demo.entity;


import org.springframework.context.annotation.Bean;

import java.io.Serializable;

/***
 * 实体类
 */

public class User implements Serializable {
    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", userpw='" + userpw + '\'' +
                ", userphone='" + userphone + '\'' +
                ", userstate=" + userstate +
                '}';
    }

    private  int  userid;
    private   String   username;
    private   String  userpassword;
    private   String  userpw;
    private   String userphone;

    public int getUserstate() {
        return userstate;
    }

    private   int  userstate;


    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public void setUserstate(int userstate) {
        this.userstate = userstate;
    }




    public User(int userid) {

    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }






}
