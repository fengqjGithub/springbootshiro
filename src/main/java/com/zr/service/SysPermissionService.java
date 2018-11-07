package com.zr.service;

import com.zr.model.SysPermission;

import java.util.List;

/**
 * @Project: gktj
 * @Package: com.zr.service
 * @Author: 冯前进
 * @Date: 2018-11-07 9:26
 * @Description: TODO
 **/
public interface SysPermissionService {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    List<SysPermission> selectByroleid(Integer roleId);

    List<SysPermission> selectByuserid(Integer userId);
}
