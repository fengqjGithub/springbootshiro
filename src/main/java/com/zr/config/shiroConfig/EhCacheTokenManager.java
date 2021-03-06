package com.zr.config.shiroConfig;

import com.zr.common.dto.Token;
import com.zr.utils.constract.SpringUtil;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * EhCache实现的Token<br>
 * 默认采用此实现
 *
 */
@Service(value = "tokenManager")
public class EhCacheTokenManager implements TokenManager {

   private EhCacheManager cacheManager;
    /**
     * token过期秒数
     */
    @Value("${token.expire.seconds}")
    private Integer expireSeconds;

    @Override
    public Token saveToken(UsernamePasswordToken usernamePasswordToken) {

        if(cacheManager==null){
            cacheManager = SpringUtil.getBean(EhCacheManager.class);
        }
        Cache cache = cacheManager.getCacheManager().getCache("login_user_tokens");

        String key = UUID.randomUUID().toString();
        Element element = new Element(key, usernamePasswordToken);
        element.setTimeToLive(expireSeconds);
        cache.put(element);
        return new Token(key, DateUtils.addSeconds(new Date(), expireSeconds));
    }

    @Override
    public UsernamePasswordToken getToken(String key) {
        if(cacheManager==null){
            cacheManager = SpringUtil.getBean(EhCacheManager.class);
        }
        Cache cache = cacheManager.getCacheManager().getCache("login_user_tokens");
        Element element = cache.get(key);
        if (element != null) {
            UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) element.getValue();
            return usernamePasswordToken;
        }

        return null;
    }

    @Override
    public boolean deleteToken(String key) {
        if(cacheManager==null){
            cacheManager = SpringUtil.getBean(EhCacheManager.class);
        }
        Cache cache = cacheManager.getCacheManager().getCache("login_user_tokens");
        return cache.remove(key);
    }
}
