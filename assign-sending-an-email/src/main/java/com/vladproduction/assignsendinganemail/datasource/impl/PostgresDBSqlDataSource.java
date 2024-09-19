package com.vladproduction.assignsendinganemail.datasource.impl;

import com.vladproduction.assignsendinganemail.datasource.DataSource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgresDBSqlDataSource implements DataSource {

    public PostgresDBSqlDataSource() {
        System.out.println("PostgresDBSqlDataSource created by constructor.");
        System.out.println("PostgresDBSqlDataSource getEmails prepared to sending.");
    }

    @Override
    public String[] getEmails() {
        String[] arr = {
                "postgres-1",
                "postgres-2",
                "postgres-3"
        };
        return arr;
    }
}
