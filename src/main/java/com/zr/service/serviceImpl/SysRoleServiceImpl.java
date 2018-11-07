package com.zr.service.serviceImpl;

import com.zr.dao.SysRoleMapper;
import com.zr.model.SysRole;
import com.zr.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: gktj
 * @Package: com.zr.service.serviceImpl
 * @Author: 冯前进
 * @Date: 2018-11-07 9:26
 * @Description: TODO
 **/
@Service(value = "sysRoleService")
public class SysRoleServiceImpl implements SysRoleService{

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(SysRole record) {
        return 0;
    }

    @Override
    public int insertSelective(SysRole record) {
        return 0;
    }

    @Override
    public SysRole selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<SysRole> selectByuserid(Integer userId) {
        return sysRoleMapper.selectByuserid(userId);
    }
}
