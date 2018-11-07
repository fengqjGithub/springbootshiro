package com.zr.controller;

import com.zr.config.shiroConfig.UserUtil;
import com.zr.model.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: gktj
 * @Package: com.zr.controller
 * @Author: 冯前进
 * @Date: 2018-11-07 10:36
 * @Description: TODO
 **/
@Api(tags = "测试")
@RestController
@RequestMapping
public class DemoController {

    @ApiOperation(value = "测试1")
    @RequiresPermissions("test:test1")
    @GetMapping(value = "/test1")
    public String test1(){
        SysUser user =UserUtil.getCurrentUser();
        System.out.println("-----------------1111111111------------------");
        return "hello1";
    }
    @ApiOperation(value = "测试2")
    @RequiresPermissions("test:test2")
    @GetMapping(value = "/test2")
    public String test2(){
        System.out.println("------------222222222-----------------------");
        return "hello2";
    }
}
