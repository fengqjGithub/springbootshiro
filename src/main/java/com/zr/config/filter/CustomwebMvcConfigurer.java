package com.zr.config.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Project: gktj
 * @Package: com.zr.config.filter
 * @Author: 冯前进
 * @Date: 2018-11-09 8:52
 * @Description: TODO
 **/
@Configuration
public abstract class CustomwebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }
}