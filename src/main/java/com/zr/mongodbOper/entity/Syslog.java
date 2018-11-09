package com.zr.mongodbOper.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Project: gktj
 * @Package: com.zr.mongodbOper
 * @Author: 冯前进
 * @Date: 2018-11-08 15:01
 * @Description: TODO
 **/
@Setter
@Getter
public class Syslog implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @Id
    private Integer operationLogId;
    /**
     * 日志描述
     */
    private String logDescription;
    /**
     * 方法参数
     */
    private String actionArgs;
    /**
     * 用户主键
     */
    private String userName;
    /**
     * 类名称
     */
    private String className;
    /**
     * 方法名称
     */
    private String methodName;
    private String ip;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 是否成功 1:成功 2异常
     */
    private Integer succeed;
    /**
     * 异常堆栈信息
     */
    private String message;

    /**
     * 模块名称
     */
    private String modelName;

    /**
     * 操作
     */
    private String action;

    /**
     * 返回值
     */
    private String returnRes;

}
