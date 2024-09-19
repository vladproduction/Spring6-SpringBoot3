package com.vladproduction.spring.core.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Student{
    private Address address;

    public Student(Address address) {
        this.address = address;
    }

    public void print(){
        System.out.println("Student class method called...");
        address.print();
    }

}

class Address{

    public void print(){
        System.out.println("Address class method called...");
    }

}

@Configuration
class AppConfigure{

    @Bean(name = "addressBean")
    public Address address(){
        return new Address();
    }

    @Bean(name = {"studentBean", "studentDemo"})
    public Student student(){
        return new Student(address());
    }

}

public class BeanAnnotationDemo {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigure.class);
        Student student = applicationContext.getBean(Student.class);
        Student student1 = (Student) applicationContext.getBean("studentBean");
        Student student2 = (Student) applicationContext.getBean("studentDemo");
        student.print();
        System.out.println("--------");

        student1.print();
        System.out.println("--------");

        String[] beanNames = applicationContext.getBeanDefinitionNames();
//        System.out.println("beanNames = " + Arrays.toString(beanNames));
        //forEach loop to print:
        int i = 1;
        for (String beanName : beanNames) {
            System.out.println("bean " + i + " : " + beanName);
            i++;
        }

        System.out.println("--------");
        student2.print();

    }
}
