package com.kaikeba.bean;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author gyx
 */
@Component("courier")
public class Courier {
    private Integer id;

    private String couriername;

    private String password;

    private String courierphone;

    private String idnumber;

    private String expressnumber;

    private Date logontime;

    private Date logintime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCouriername() {
        return couriername;
    }

    public void setCouriername(String couriername) {
        this.couriername = couriername == null ? null : couriername.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCourierphone() {
        return courierphone;
    }

    public void setCourierphone(String courierphone) {
        this.courierphone = courierphone == null ? null : courierphone.trim();
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public String getExpressnumber() {
        return expressnumber;
    }

    public void setExpressnumber(String expressnumber) {
        this.expressnumber = expressnumber == null ? null : expressnumber.trim();
    }

    public Date getLogontime() {
        return logontime;
    }

    public void setLogontime(Date logontime) {
        this.logontime = logontime;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }
}