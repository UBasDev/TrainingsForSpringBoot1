package org.group1.relational1.Core.Application.Configs;

import org.group1.relational1.Core.Application.Interceptors.CustomLoggerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private final CustomLoggerInterceptor customLoggerInterceptor;

    public InterceptorConfig(CustomLoggerInterceptor customLoggerInterceptor) {
        this.customLoggerInterceptor = customLoggerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.customLoggerInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
