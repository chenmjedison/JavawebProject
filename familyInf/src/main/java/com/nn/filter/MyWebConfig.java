package com.nn.filter;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter{

    /**
     * 注册 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginFilter());
    }
   
    @Bean()
    public Filter AuthFilter() {
      return new AjaxFilter();
    }    
    @Bean
    public MultipartConfigElement multipartConfigElement() {
       MultipartConfigFactory factory = new MultipartConfigFactory();
       //单个文件最大
       factory.setMaxFileSize("5MB");
       /// 设置总上传数据总大小
       factory.setMaxRequestSize("50MB");
       return factory.createMultipartConfig();
    }

}