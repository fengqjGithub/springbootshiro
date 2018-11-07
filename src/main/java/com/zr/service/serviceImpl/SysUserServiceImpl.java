package com.zr.service.serviceImpl;

import com.zr.constant.UserConstants;
import com.zr.dao.SysUserMapper;
import com.zr.model.SysUser;
import com.zr.service.SysUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Project: gktj
 * @Package: com.zr.service.serviceImpl
 * @Author: 冯前进
 * @Date: 2018-11-07 8:51
 * @Description: TODO
 **/

@Service(value = "sysUserService")
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(SysUser record) {
        return 0;
    }

    @Override
    public int insertSelective(SysUser record) {
        return 0;
    }

    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public SysUser selectByUsername(String username) {
        return sysUserMapper.selectByUsername(username);
    }
    @Override
    public String passwordEncoder(String credentials, String salt) {
        Object object = new SimpleHash("MD5", credentials, salt, UserConstants.HASH_ITERATIONS);
        return object.toString();
    }

}
