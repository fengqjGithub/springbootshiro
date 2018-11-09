package com.zr.mongodbOper.service;

import com.zr.mongodbOper.entity.Syslog;

import java.util.List;

/**
 * @Project: gktj
 * @Package: com.zr.mongodbOper.service
 * @Author: 冯前进
 * @Date: 2018-11-08 15:10
 * @Description: TODO
 **/
public interface IsysLogservice {
    public Syslog save(Syslog syslog);

    public void delete(Syslog syslog);

    public void deletebyid(String id);

    public List<Syslog> findall();
}
