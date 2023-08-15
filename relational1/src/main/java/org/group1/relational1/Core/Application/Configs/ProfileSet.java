package org.group1.relational1.Core.Application.Configs;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Properties;

@Configuration
public class ProfileSet {
    @Bean
    CommandLineRunner commandLineRunner(ConfigurableEnvironment env) {
        return args -> {
            env.setActiveProfiles(env.getProperty("application.environment"));
        };
    }
}
