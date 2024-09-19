package com.vladproduction.assignsendinganemail.datasource.impl;

import com.vladproduction.assignsendinganemail.datasource.DataSource;
import org.springframework.stereotype.Component;

@Component
public class MySqlDBDataSource implements DataSource {

    public MySqlDBDataSource() {
        System.out.println("MySqlDBDataSource created by constructor.");
        System.out.println("MySqlDBDataSource getEmails prepared to sending.");
    }

    @Override
    public String[] getEmails() {

        String[] arr = {
                "mysql-1",
                "mysql-2",
                "mysql-3"
        };
        return arr;
    }
}
