package com.kaikeba.bean;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author gyx
 */
@Component("user")
public class User {
    private Integer id;

    private String username;

    private String userphone;

    private String password;

    private String idnumber;

    private Date logintime;

    private Date logontime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getLogontime() {
        return logontime;
    }

    public void setLogontime(Date logontime) {
        this.logontime = logontime;
    }
}