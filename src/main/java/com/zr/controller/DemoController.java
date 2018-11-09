package com.zr.controller;

import com.zr.common.ResponseBean;
import com.zr.common.annotation.Log;
import com.zr.config.shiroConfig.UserUtil;
import com.zr.model.SysUser;
import com.zr.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Autowired
    SysUserService sysUserService;

    @ApiOperation(value = "测试1")
    @RequiresPermissions("test:test1")
    @GetMapping(value = "/test1.do")
    @Log(modelName = "测试模块",action = "这是测试操作",description = "测试是否能获取当前用户")
    public ResponseBean test1(String id){
        SysUser user =UserUtil.getCurrentUser();
        System.out.println("-----------------1111111111------------------"+id);
        String uu = null;
       SysUser sysUser= sysUserService.selectByUsername("user");
//        uu.getBytes();
        return new ResponseBean("200","",sysUser);
    }
    @ApiOperation(value = "测试2")
    @RequiresPermissions("test:test2")
    @GetMapping(value = "/test2.do")
    public String test2(){
        System.out.println("------------222222222-----------------------");
        return "hello2";
    }
}
