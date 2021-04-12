package com.kaikeba.dao;

import com.kaikeba.bean.Express;
import com.kaikeba.exception.RepeatCodeException;
import com.kaikeba.exception.RepeatIdNumberException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ExpressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Express record)throws SQLException;

    int insertSelective(Express record);

    Express selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Express record);

    int updateByPrimaryKey(Express record);

    Map findConsole();

    List<Express> findAll();

    Express findByNumber(String number);

    Express findByCode(String code);

    List<Express> findAllByPhoneAndCode(String userPhone);

    List<Express> findAllByPhoneNotCode(String userPhone);

    int updateExpressByCode(String code);

}