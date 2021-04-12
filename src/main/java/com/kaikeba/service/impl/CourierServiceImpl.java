package com.kaikeba.service.impl;

import com.kaikeba.bean.Courier;
import com.kaikeba.bean.Express;
import com.kaikeba.dao.CourierMapper;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;
import com.kaikeba.service.CourierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: Gyx
 * @Date: 2021/3/29 14:59
 */
@Service("courierService")
public class CourierServiceImpl implements CourierService {
    @Resource
    private CourierMapper dao;

    @Override
    public Map findConsole() {
        return dao.findConsole();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateExpressNumber(Map map) {
        return dao.updateExpressNumber(map);
    }

    @Override
    public Courier findByCourierPhone(String courierPhone) {
        return dao.findByCourierPhone(courierPhone);
    }

    @Override
    public List<Courier> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Courier record) throws RepeatPhoneException, RepeatIdNumberException {
        int i = 0;
        try {
            i = dao.insertSelective(record);
        } catch (Exception e) {
            if(e.getMessage().endsWith("for key 'courierPhone'")){
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
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(Courier record) throws RepeatPhoneException, RepeatIdNumberException {
        int i = 0;
        try {
            i = dao.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            if(e.getMessage().endsWith("for key 'courierPhone'")){
                throw new RepeatPhoneException("该电话号码已被占用，请更换号码");
            }else if(e.getMessage().endsWith("for key 'idNumber'")){
                throw new RepeatIdNumberException("该身份证号已被占用，请跟换身份证号");
            }else {
                e.printStackTrace();
            }
        }
        return i;
    }
}
