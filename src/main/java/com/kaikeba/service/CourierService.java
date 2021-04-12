package com.kaikeba.service;

import com.kaikeba.bean.Courier;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;

import java.util.List;
import java.util.Map;

/**
 * @Author: Gyx
 * @Date: 2021/3/29 14:55
 */
public interface CourierService {
    Map findConsole();

    int updateExpressNumber(Map map);

    Courier findByCourierPhone(String courierPhone);

    List<Courier> findAll();

    int insert(Courier record) throws RepeatPhoneException, RepeatIdNumberException;

    int deleteByPrimaryKey(Integer id);

    int update(Courier record) throws RepeatPhoneException, RepeatIdNumberException;
}
