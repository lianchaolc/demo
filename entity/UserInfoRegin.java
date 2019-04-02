package com.pp.learn.demo.entity;

import java.io.Serializable;

/**
 * ppshop 用户注册的实体类
 * 20190329
 * lc
 *   返回实体装对象
 *   序列化对象
 */
public class UserInfoRegin  implements Serializable{
    @Override
    public String toString() {
        return "UserInfoRegin{" +
                "UserinfoReginId='" + UserinfoReginId + '\'' +
                ", UserinfoReginIPhone='" + UserinfoReginIPhone + '\'' +
                ", UserInfoReginPassWord='" + UserInfoReginPassWord + '\'' +
                '}';
    }

    private   String   UserinfoReginId;//  用户的id
    private   String   UserinfoReginIPhone;//  用户的账号
    private   String   UserInfoReginPassWord;//  用户的密码
    public UserInfoRegin() {
    }
    public UserInfoRegin(String userinfoReginId, String userinfoReginIPhone, String userInfoReginPassWord) {
        UserinfoReginId = userinfoReginId;
        UserinfoReginIPhone = userinfoReginIPhone;
        UserInfoReginPassWord = userInfoReginPassWord;
    }
    public String getUserinfoReginId() {
        return UserinfoReginId;
    }

    public void setUserinfoReginId(String userinfoReginId) {
        UserinfoReginId = userinfoReginId;
    }

    public String getUserinfoReginIPhone() {
        return UserinfoReginIPhone;
    }

    public void setUserinfoReginIPhone(String userinfoReginIPhone) {
        UserinfoReginIPhone = userinfoReginIPhone;
    }

    public String getUserInfoReginPassWord() {
        return UserInfoReginPassWord;
    }

    public void setUserInfoReginPassWord(String userInfoReginPassWord) {
        UserInfoReginPassWord = userInfoReginPassWord;
    }


}
