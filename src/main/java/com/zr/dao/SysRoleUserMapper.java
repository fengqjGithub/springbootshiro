package com.zr.dao;

import com.zr.model.SysRoleUserKey;

public interface SysRoleUserMapper {
    int deleteByPrimaryKey(SysRoleUserKey key);

    int insert(SysRoleUserKey record);

    int insertSelective(SysRoleUserKey record);
}