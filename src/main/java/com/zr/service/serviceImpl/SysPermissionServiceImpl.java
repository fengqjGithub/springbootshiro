package com.zr.service.serviceImpl;

import com.zr.dao.SysPermissionMapper;
import com.zr.model.SysPermission;
import com.zr.service.SysPermissionService;
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
@Service(value = "sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    SysPermissionMapper sysPermissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(SysPermission record) {
        return 0;
    }

    @Override
    public int insertSelective(SysPermission record) {
        return 0;
    }

    @Override
    public SysPermission selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<SysPermission> selectByroleid(Integer roleId) {
        return sysPermissionMapper.selectByroleid(roleId);
    }

    @Override
    public List<SysPermission> selectByuserid(Integer userId) {
        return sysPermissionMapper.selectByuserid(userId);
    }
}
