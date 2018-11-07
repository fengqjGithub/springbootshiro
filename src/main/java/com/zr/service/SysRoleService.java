package com.zr.service;

import com.zr.model.SysRole;

import java.util.List;

/**
 * @Project: gktj
 * @Package: com.zr.service
 * @Author: 冯前进
 * @Date: 2018-11-07 9:25
 * @Description: TODO
 **/
public interface SysRoleService {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    List<SysRole> selectByuserid(Integer userId);
}
