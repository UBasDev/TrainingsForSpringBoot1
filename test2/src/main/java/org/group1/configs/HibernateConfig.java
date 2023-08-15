package org.group1.configs;

import org.group1.interceptors.CustomInterceptor1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class HibernateConfig implements HibernatePropertiesCustomizer {
    @Autowired
    private CustomInterceptor1 customInterceptor1;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.session_factory.interceptor", customInterceptor1);
    }
}
