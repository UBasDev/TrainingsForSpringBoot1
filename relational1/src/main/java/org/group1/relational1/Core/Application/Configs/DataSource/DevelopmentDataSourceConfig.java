package org.group1.relational1.Core.Application.Configs.DataSource;

import org.group1.relational1.Core.Application.Abstractions.Configs.DataSource.IDataSourceConfig;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Primary
@Component
@Profile("development")
public class DevelopmentDataSourceConfig implements IDataSourceConfig {

    @Override
    public void setup() {
        System.out.println("Setting up datasource for DEV environment. ");
    }
}

