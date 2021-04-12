package com.kaikeba.dao;

import com.kaikeba.bean.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Integer findInfo(Admin admin);

    int updateLoginInfo(Admin admin);
}