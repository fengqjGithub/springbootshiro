package com.zr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@MapperScan("com.zr.dao")
@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println(" =========|_|=======启动成功=======|___/=/_/_/_/");
    }
        /**
         * 设置匹配*.action后缀请求
         * @param dispatcherServlet
         * @return
         */
        @Bean
        public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
            System.out.println("-----------加载后缀过滤------------");
            ServletRegistrationBean servletServletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
            servletServletRegistrationBean.addUrlMappings("*.html");
            servletServletRegistrationBean.addUrlMappings("*.do");
            servletServletRegistrationBean.addUrlMappings("/*");
            return servletServletRegistrationBean;
        }

}