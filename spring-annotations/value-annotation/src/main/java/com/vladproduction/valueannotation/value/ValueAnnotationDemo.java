package com.vladproduction.valueannotation.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotationDemo {

    @Value("Default Name")
    private String defaultName;

    @Value("${mail.host}")
    private String host;

    @Value("${mail.email}")
    private String email;

    @Value("${mail.password}")
    private String password;

    @Value("${java.home}")
    private String javaHome;

    @Value("${JAVA_HOME}")
    private String homeDir;

    @Value("${SERVER_PORT}")
    private String serverPort;

    public String getDefaultName() {
        return defaultName;
    }

    public String getHost() {
        return host;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public String getHomeDir() {
        return homeDir;
    }

    public String getServerPort() {
        return serverPort;
    }
}
