package org.group1.relational1.Core.Application.Configs;

import org.group1.relational1.Core.Application.Abstractions.Configs.DataSource.IDataSourceConfig;
import org.group1.relational1.Core.Application.Configs.DataSource.DevelopmentDataSourceConfig;
import org.group1.relational1.Core.Application.Configs.DataSource.ProductionDataSourceConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.security.Provider;

@Component
public class TestConfig {

    //@ConditionalOnProperty(name = "application.environment", havingValue = "development")
    @Profile("development")
    public void serviceDevelopment1() {
        System.out.println("Development settings have been enabled.");
    }


    //@ConditionalOnProperty(name = "application.environment", havingValue = "production")
    @Profile("production")
    public void serviceProduction1() {
        System.out.println("Production settings have been enabled.");
    }
}
