package com.zr.dao;

import com.zr.model.SysRolePermissionKey;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(SysRolePermissionKey key);

    int insert(SysRolePermissionKey record);

    int insertSelective(SysRolePermissionKey record);
}