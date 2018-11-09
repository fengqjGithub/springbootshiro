package com.zr.mongodbOper.dao;

import com.zr.mongodbOper.entity.Syslog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Project: gktj
 * @Package: com.zr.mongodbOper.dao
 * @Author: 冯前进
 * @Date: 2018-11-08 15:03
 * @Description: TODO
 **/
@Repository
public interface SysLogDao extends MongoRepository<Syslog,String>{
}
