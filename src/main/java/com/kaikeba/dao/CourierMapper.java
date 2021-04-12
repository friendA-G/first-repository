package com.kaikeba.dao;

import com.kaikeba.bean.Courier;

import java.util.List;
import java.util.Map;

public interface CourierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Courier record);

    int insertSelective(Courier record)throws Exception;

    Courier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Courier record) throws Exception;

    int updateByPrimaryKey(Courier record);

    Map findConsole();

    int updateExpressNumber(Map map);

    Courier findByCourierPhone(String courierPhone);

    List<Courier> findAll();
}