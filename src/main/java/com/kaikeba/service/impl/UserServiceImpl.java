package com.kaikeba.service.impl;

import com.kaikeba.bean.User;
import com.kaikeba.dao.UserMapper;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;
import com.kaikeba.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: Gyx
 * @Date: 2021/3/29 15:00
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper dao;

    @Override
    public Map findConsole() {
        return dao.findConsole();
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(User record) throws RepeatPhoneException, RepeatIdNumberException {
        int i = 0;
        try {
            i = dao.insertSelective(record);
        } catch (Exception e) {
            if(e.getMessage().endsWith("for key 'userPhone'")){
                throw new RepeatPhoneException("该电话号码已被占用，请更换号码");
            }else if(e.getMessage().endsWith("for key 'idNumber'")){
                throw new RepeatIdNumberException("该身份证号已被占用，请跟换身份证号");
            }else {
                e.printStackTrace();
            }
        }
        return i;
    }

    @Override
    public User findByPhone(String userPhone) {
        return dao.findByPhone(userPhone);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKey(User record) throws RepeatPhoneException, RepeatIdNumberException {
        int update = 0;
        try {
             update = dao.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            if(e.getMessage().endsWith("for key 'userPhone'")){
                throw new RepeatPhoneException("该电话号码已被占用，请更换号码");
            }else if(e.getMessage().endsWith("for key 'idNumber'")){
                throw new RepeatIdNumberException("该身份证号已被占用，请跟换身份证号");
            }else {
                e.printStackTrace();
            }
        }
        return update;
    }
}
