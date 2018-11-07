package com.zr.config.shiroConfig;

import com.zr.config.filter.RestfulFilter;
import com.zr.constant.UserConstants;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.*;

@Configuration
public class ShiroConfig {
    /**
     * 设置缓存管理器
     * 读取ehcache文件
     *
     * @return em
     */
    @Bean("ehCacheManager")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache.xml");
        return em;
    }

    /**
     * 用户自定义realm
     * 设置缓存管理器
     *
     * @param cacheManager
     * @return userRealm
     */
    @Bean
    UserRealm userRealm(EhCacheManager cacheManager) {
        UserRealm userRealm = new UserRealm();
        userRealm.setCacheManager(cacheManager);
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    @Bean
    SessionDAO sessionDAO() {
        MemorySessionDAO sessionDAO = new MemorySessionDAO();
        return sessionDAO;
    }

    /**
     * 设置session管理器
     * 设置session监听
     *
     * @return sessionManager
     */
    @Bean
    public SessionManager sessionManager() {
        //session.timeout，过期时间默认30分钟
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
        listeners.add(new BDSessionListener());
        sessionManager.setSessionListeners(listeners);
        sessionManager.setSessionDAO(sessionDAO());
        return sessionManager;
    }

    /**
     * 定义自定义过滤器（用来处理ajax 请求session过期问题）
     *
     * @return
     */
    @Bean
    public UserAuthenticationFilter getFormAuthenticationFilter() {
        UserAuthenticationFilter filter = new UserAuthenticationFilter();
        return filter;
    }

    @Bean
    SecurityManager securityManager(UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        manager.setCacheManager(getEhCacheManager());
        manager.setSessionManager(sessionManager());
        return manager;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(UserConstants.HASH_ITERATIONS);

        return hashedCredentialsMatcher;
    }
    @Bean(name = "shiroFilter")
    ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/t", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/sys/login/**", "anon");
        filterChainDefinitionMap.put("/files/*", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setSuccessUrl("/index.html");

        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl("/login.html");

        RestfulFilter restfulFilter = new RestfulFilter();

        shiroFilterFactoryBean.getFilters().put("authc", restfulFilter);
        shiroFilterFactoryBean.getFilters().put("logout", logoutFilter);

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public FilterRegistrationBean delegatingFilterProxy() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),
     * 需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

//	@Bean
//	public ShiroDialect shiroDialect() {
//		return new ShiroDialect();
//	}

    /**
     * 增加shiro拦截器注解方式的功能
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            @Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
