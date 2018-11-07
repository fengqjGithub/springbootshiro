package com.zr.common;

import com.zr.model.SysUser;
import lombok.Getter;
import lombok.Setter;

/**
 * @Project: gktj
 * @Package: com.zr.common
 * @Author: 冯前进
 * @Date: 2018-11-06 17:15
 * @Description: TODO
 **/
@Setter
@Getter
public class RequestBean {
    private SysUser sysUser;
    private String token;
    private Long datetime;
}
