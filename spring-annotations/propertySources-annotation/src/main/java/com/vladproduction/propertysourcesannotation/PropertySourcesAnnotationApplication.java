package com.vladproduction.propertysourcesannotation;

import com.vladproduction.propertysourcesannotation.propertysource.PropertySourceDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertySourcesAnnotationApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(PropertySourcesAnnotationApplication.class, args);
        PropertySourceDemo propertySourceDemo = context.getBean(PropertySourceDemo.class);
        System.out.println(propertySourceDemo.getHost());
        System.out.println(propertySourceDemo.getEmail());
        System.out.println(propertySourceDemo.getPassword());
        System.out.println(propertySourceDemo.getAppName());
        System.out.println(propertySourceDemo.getAppDescription());
    }

}
