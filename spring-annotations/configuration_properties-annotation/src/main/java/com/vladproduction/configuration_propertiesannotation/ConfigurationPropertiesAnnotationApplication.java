package com.vladproduction.configuration_propertiesannotation;

import com.vladproduction.configuration_propertiesannotation.configurationproperties.AppPropertiesDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigurationPropertiesAnnotationApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(ConfigurationPropertiesAnnotationApplication.class, args);

        AppPropertiesDemo appPropertiesDemo = context.getBean(AppPropertiesDemo.class);
        appPropertiesDemo.display();
    }

}
