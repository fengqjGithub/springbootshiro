package com.zr.dao;

import com.zr.model.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "sysRoleMapper")
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    List<SysRole> selectByuserid(Integer userId);
}