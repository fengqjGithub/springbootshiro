package com.zr.mongodbOper.service.impl;

import com.zr.mongodbOper.dao.SysLogDao;
import com.zr.mongodbOper.entity.Syslog;
import com.zr.mongodbOper.service.IsysLogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: gktj
 * @Package: com.zr.mongodbOper.service.impl
 * @Author: 冯前进
 * @Date: 2018-11-08 15:11
 * @Description: TODO
 **/
@Service(value = "isysLogservice")
public class SysLogServiceImpl implements IsysLogservice{
    @Autowired
    SysLogDao sysLogDao;

    public Syslog save(Syslog syslog){
        return sysLogDao.save(syslog);
    }

    public void delete(Syslog syslog){
        sysLogDao.delete(syslog);
    }
    public void deletebyid(String id){
        sysLogDao.delete(id);
    }
    public List<Syslog> findall(){
        return sysLogDao.findAll();
    }
}
