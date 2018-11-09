package com.zr.constant;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: gktj
 * @Package: com.zr.constant
 * @Author: 冯前进
 * @Date: 2018-11-08 18:24
 * @Description: TODO
 **/
@Configuration
public class SysConstant {
    public static List<String> urlExcloud = new ArrayList<>();
    @PostConstruct
    public void init(){
        urlExcloud.add("/sys/login/restful.do");
        urlExcloud.add("/sys/login.do");
    }
}
