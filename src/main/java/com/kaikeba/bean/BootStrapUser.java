package com.kaikeba.bean;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @Author: Gyx
 * @Date: 2021/2/27 20:03
 */
@Component("bootStrapUser")
public class BootStrapUser {

    private int id;
    private String userName;
    private String userPhone;
    private String passWord;
    private String idNumber;
    private String loginTime;
    private String logonTime;

    public BootStrapUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogonTime() {
        return logonTime;
    }

    public void setLogonTime(String logonTime) {
        this.logonTime = logonTime;
    }

    public BootStrapUser(int id, String userName, String userPhone, String passWord, String idNumber, String loginTime, String logonTime) {
        this.id = id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.passWord = passWord;
        this.idNumber = idNumber;
        this.loginTime = loginTime;
        this.logonTime = logonTime;
    }
}
