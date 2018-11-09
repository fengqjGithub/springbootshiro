package com.zr.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Project: gktj
 * @Package: com.zr.common
 * @Author: 冯前进
 * @Date: 2018-11-06 17:18
 * @Description: TODO
 **/
@Setter
@Getter
public class ResponseBean implements Serializable {
    private String code;//code 200 取data数据，否则弹出错误提示message
    private String message;
    private Object data;
    private Long datetime=new Date().getTime();

    public ResponseBean() {
    }

    public ResponseBean(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseBean(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
