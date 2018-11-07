package com.zr.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @Project: gktj
 * @Package: com.zr.common
 * @Author: 冯前进
 * @Date: 2018-11-06 17:18
 * @Description: TODO
 **/
@Setter
@Getter
public class ResponseBean {
    private boolean flag;
    private String data;
    private String token;
    private Long datetime;
}
