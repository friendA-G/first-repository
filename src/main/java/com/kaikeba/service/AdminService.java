package com.kaikeba.service;

import com.kaikeba.bean.Admin;

/**
 * @Author: Gyx
 * @Date: 2021/3/29 14:55
 */
public interface AdminService {
    Integer findInfo(Admin admin);
    int updateLoginInfo(Admin admin);
}
