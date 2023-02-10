package com.liyan.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @ClassName ServletConfig
 * @Description TODO
 * @Author name
 * @Date 2023/2/8
 * @Version 1.0
 **/

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    //过滤器
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

