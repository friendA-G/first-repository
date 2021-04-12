package com.kaikeba.dao;

import com.kaikeba.bean.User;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record) throws Exception;

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record)throws Exception;

    Map findConsole();

    List<User> findAll();

    User findByPhone(String userPhone);
}