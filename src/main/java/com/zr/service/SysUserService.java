package com.zr.service;

import com.zr.model.SysUser;

/**
 * @Project: gktj
 * @Package: com.zr.service
 * @Author: 冯前进
 * @Date: 2018-11-07 8:47
 * @Description: TODO
 **/
public interface SysUserService {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    SysUser selectByUsername(String username);

    String passwordEncoder(String credentials, String salt);

}
