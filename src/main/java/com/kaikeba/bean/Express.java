package com.kaikeba.bean;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author gyx
 */
@Component("express")
public class Express {
    @Override
    public String toString() {
        return "Express{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", username='" + username + '\'' +
                ", userphone='" + userphone + '\'' +
                ", company='" + company + '\'' +
                ", code='" + code + '\'' +
                ", intime=" + intime +
                ", outtime=" + outtime +
                ", status=" + status +
                ", sysphone='" + sysphone + '\'' +
                '}';
    }

    private Integer id;

    private String number;

    private String username;

    private String userphone;

    private String company;

    private String code;

    private Date intime;

    private Date outtime;

    private Integer status;

    private String sysphone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSysphone() {
        return sysphone;
    }

    public void setSysphone(String sysphone) {
        this.sysphone = sysphone == null ? null : sysphone.trim();
    }
}