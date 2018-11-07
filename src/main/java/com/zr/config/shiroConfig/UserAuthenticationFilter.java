package com.zr.config.shiroConfig;

import com.zr.utils.http.HttpCommonUtil;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UserAuthenticationFilter extends FormAuthenticationFilter {
    private static final Logger log = LoggerFactory.getLogger(UserAuthenticationFilter.class);

    /**
     * @Description: 此方法过滤器只验证ajax调用验证session是否过期
     * @Param: param
     * @ReturnType:
     * @Exception   
     **/
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                //登录已经在UserReam自定义中过滤
//              return executeLogin(request, response);
                return true;
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                //allow them to see the login page ;)
                HttpServletRequest req=(HttpServletRequest) request;
                if (req.getRequestURI().indexOf("login")!=-1){
                    if(isAjax(request)){
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("httpStatCode", "300");
                        HttpCommonUtil.out(response, map);
                        return false;
                    }
                }
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
                        "Authentication url [" + getLoginUrl() + "]");
            }
            if(isAjax(request)){
                Map<String, String> map = new HashMap<String, String>();
                map.put("httpStatCode", "300");
                HttpCommonUtil.out(response, map);
            }else{
                this.saveRequestAndRedirectToLogin(request, response);
            }
            return false;
        }
    }

    private static boolean isAjax(ServletRequest request){
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if("XMLHttpRequest".equalsIgnoreCase(header)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
