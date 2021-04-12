package com.kaikeba.bean;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @Author: Gyx
 * @Date: 2021/2/27 21:33
 */
@Component("bootStrapCourier")
public class BootStrapCourier {
    private int id;
    private String courierName;
    private String courierPhone;
    private String passWord;
    private String idNumber;
    private String expressNumber;
    private String loginTime;
    private String logonTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public String getCourierPhone() {
        return courierPhone;
    }

    public void setCourierPhone(String courierPhone) {
        this.courierPhone = courierPhone;
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

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
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

    public BootStrapCourier() {
    }

    public BootStrapCourier(int id, String courierName, String courierPhone, String passWord, String idNumber, String expressNumber, String loginTime, String logonTime) {
        this.id = id;
        this.courierName = courierName;
        this.courierPhone = courierPhone;
        this.passWord = passWord;
        this.idNumber = idNumber;
        this.expressNumber = expressNumber;
        this.loginTime = loginTime;
        this.logonTime = logonTime;
    }
}
