package com.vladproduction.assignsendinganemail.javaconfig;

public class PostgresDBDS implements DataSource {

    public PostgresDBDS() {
        System.out.println("PostgresDBDS created by constructor.");
        System.out.println("PostgresDBDS prepared to sending.");
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
