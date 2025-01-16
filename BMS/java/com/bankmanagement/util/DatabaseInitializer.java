package com.bankmanagement.util;

import jakarta.servlet.ServletContextEvent;

import jakarta.servlet.ServletContextListener;

public class DatabaseInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DatabaseUtil.createDatabase();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
