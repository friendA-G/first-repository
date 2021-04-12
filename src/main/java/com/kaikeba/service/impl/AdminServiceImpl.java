package com.kaikeba.service.impl;

import com.kaikeba.bean.Admin;
import com.kaikeba.dao.AdminMapper;
import com.kaikeba.service.AdminService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Gyx
 * @Date: 2021/3/29 14:59
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper dao;
    @Override
    public Integer findInfo(Admin admin) {
        return dao.findInfo(admin);
    }

    @Override
    public int updateLoginInfo(Admin admin) {
        return dao.updateLoginInfo(admin);
    }
}
