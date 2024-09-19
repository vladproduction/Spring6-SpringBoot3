package com.vladproduction.assignsendinganemail.javaconfig;

public class MySqlDBDS implements DataSource {

    public MySqlDBDS() {
        System.out.println("MySqlDBDS created by constructor.");
        System.out.println("MySqlDBDS prepared to sending.");
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
