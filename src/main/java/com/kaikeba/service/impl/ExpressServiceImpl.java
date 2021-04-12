package com.kaikeba.service.impl;

import com.kaikeba.bean.Courier;
import com.kaikeba.bean.Express;
import com.kaikeba.dao.ExpressMapper;
import com.kaikeba.exception.RepeatCodeException;
import com.kaikeba.exception.RepeatIdNumberException;
import com.kaikeba.exception.RepeatPhoneException;
import com.kaikeba.service.CourierService;
import com.kaikeba.service.ExpressService;
import com.kaikeba.util.RandomUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Gyx
 * @Date: 2021/3/29 15:00
 */
@Service("expressService")
public class ExpressServiceImpl implements ExpressService {
    @Resource
    private ExpressMapper dao;
    @Override
    public Map findConsole() {
        return dao.findConsole();
    }

    @Resource
    private CourierService courierService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Express record)throws RepeatIdNumberException,RepeatPhoneException{
        record.setCode(RandomUtil.getCode()+"");
        int insert = 0;
        try {
            insert = dao.insert(record);
        } catch (Exception e) {
            if(e.getMessage().endsWith("for key 'code'")){
                return insert(record);
            }else if(e.getMessage().endsWith("for key 'number'")){
                throw new RepeatIdNumberException("单号重复,添加失败");
            }else {
                e.printStackTrace();
            }
        }
        if(record.getSysphone()==null){
            Courier courier = courierService.findByCourierPhone("14715046330");
            Map map = new HashMap();
            map.put("sysPhone","14715046330");
            map.put("expressNumber",Integer.parseInt(courier.getExpressnumber()) + 1);
            int i = courierService.updateExpressNumber(map);
            if(i!=0&&insert!=0){
                return 1;
            }else if(i==0) {
                throw new RepeatPhoneException("快递员派件数量更改有误，添加失败");
            }else {
                return 0;
            }
        }else {
            Courier courier  = courierService.findByCourierPhone(record.getSysphone());
            Map map = new HashMap();
            map.put("sysPhone",record.getSysphone());
            map.put("expressNumber",Integer.parseInt(courier.getExpressnumber()) + 1);
            int i = courierService.updateExpressNumber(map);
            if(i!=0&&insert!=0){
                return 1;
            }else if(i==0) {
                throw new RepeatPhoneException("快递员派件数量更改有误，添加失败");
            }else {
                return 0;
            }
        }
    }

    @Override
    public List<Express> findAll() {
        return dao.findAll();
    }

    @Override
    public Express findByNumber(String number) {
        return dao.findByNumber(number);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKey(Express record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public Express findByCode(String code) {
        return dao.findByCode(code);
    }

    @Override
    public List<Express> findAllByPhoneAndCode(String userPhone) {
        return dao.findAllByPhoneAndCode(userPhone);
    }

    @Override
    public List<Express> findAllByPhoneNotCode(String userPhone) {
        return dao.findAllByPhoneNotCode(userPhone);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateExpressByCode(String code) {
        return dao.updateExpressByCode(code);
    }


}
