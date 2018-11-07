package com.zr.dao;

import com.zr.model.SysPermission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "sysPermissionMapper")
public interface SysPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    List<SysPermission> selectByroleid(Integer roleId);

    List<SysPermission> selectByuserid(Integer userId);
}