package com.vladproduction.assignsendinganemail.javaconfig;

public class EmailService implements SenderService {

    private final DataSource dataSource;

    public EmailService(DataSource dataSource) {
        System.out.println("EmailService created by constructor.");
        System.out.println("DataSource: " + dataSource.getClass().getSimpleName() + " defined as source.");
        this.dataSource = dataSource;
    }

    @Override
    public void sendEmail() {
        System.out.println("DataSource: " + dataSource.getClass().getSimpleName() + " sending email starting...");
        String[] emails = this.dataSource.getEmails();
        for (String email : emails) {
            System.out.println("email = " + email);
        }
        System.out.println("DataSource: " + dataSource.getClass().getSimpleName() + " sending email finish!!!");

    }
}
