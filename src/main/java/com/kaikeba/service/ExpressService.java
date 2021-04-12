package com.kaikeba.service;

import com.kaikeba.bean.Express;
import com.kaikeba.exception.RepeatCodeException;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: Gyx
 * @Date: 2021/3/29 14:56
 */
public interface ExpressService {
    Map findConsole();

    int insert(Express record) throws RepeatIdNumberException, RepeatPhoneException;

    List<Express> findAll();

    Express findByNumber(String number);

    int delete(Integer id);

    int updateByPrimaryKey(Express record);

    Express findByCode(String code);

    List<Express> findAllByPhoneAndCode(String userPhone);

    List<Express> findAllByPhoneNotCode(String userPhone);

    int updateExpressByCode(String code);
}
