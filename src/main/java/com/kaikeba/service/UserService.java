package com.kaikeba.service;

import com.kaikeba.bean.User;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;

import java.util.List;
import java.util.Map;

/**
 * @Author: Gyx
 * @Date: 2021/3/29 14:56
 */
public interface UserService {

    Map findConsole();

    List<User> findAll();

    int insert(User record) throws RepeatIdNumberException, RepeatPhoneException;

    User findByPhone(String userPhone);

    int delete(Integer id);

    int updateByPrimaryKey(User record) throws RepeatPhoneException, RepeatIdNumberException;
}
