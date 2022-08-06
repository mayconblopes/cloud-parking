package com.mike.parking.controller;

import org.hibernate.event.spi.PostCollectionRecreateEvent;
import org.testcontainers.containers.PostgreSQLContainer;

public abstract class AbstractContainerBase {
    static final PostgreSQLContainer POSTGREE_SQL_CONTAINER;

    static {
        POSTGREE_SQL_CONTAINER = new PostgreSQLContainer("postgres:10-alpine");
        POSTGREE_SQL_CONTAINER.start();

        System.out.println("**************** " + POSTGREE_SQL_CONTAINER.getJdbcUrl());

        System.setProperty("spring.datasource.url", POSTGREE_SQL_CONTAINER.getJdbcUrl());
        System.setProperty("spring.datasource.username", POSTGREE_SQL_CONTAINER.getUsername());
        System.setProperty("spring.datasource.Password", POSTGREE_SQL_CONTAINER.getPassword());
    }
}
