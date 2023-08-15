package org.group1.relational1.Core.Application.Configs;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

//@Configuration
public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContextContainer) throws ServletException {
        System.out.println("===========================================================================================================");
        System.out.println("CURRENT ENVIRONMENT: " + "development");
        System.out.println("===========================================================================================================");
        //servletContext.setInitParameter("spring.profiles.active", "development");
        ServletRegistration.Dynamic registration = servletContextContainer.addServlet("dispatcher", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/example/*");
    }
}
