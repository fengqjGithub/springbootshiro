package com.zr.dao;

import com.zr.model.SysUser;
import org.springframework.stereotype.Repository;

@Repository(value = "sysUserMapper")
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    SysUser selectByUsername(String username);
}