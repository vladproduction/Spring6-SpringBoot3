package com.vladproduction.spring.core.bean_init_destroy;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Student{
    private Address address;

    public Student(Address address) {
        this.address = address;
    }

    public void print(){
        System.out.println("Student class print...");
    }

    public void initMethod() {
        System.out.println("initialization logic by -  initMethod()");

    }

    public void destroyMethod() {
        System.out.println("destroying logic by -  destroyMethod()");
    }
}

class Address{
    public void print(){
        System.out.println("Address class print...");
    }
}

@Configuration
class AppConfiguration{

    @Bean(name = "studentBean", initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Student student(){
        return new Student(address());
    }

    @Bean(name = "addressBean")
    public Address address(){
        return new Address();
    }


}

public class BeanInitDestroyDemo {
    public static void main(String[] args) {
        //try-with-resources autocloseable so no need to close resources manually ;
        // and destroy will act after closing
        try(var applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class)){

            String[] beanNames = applicationContext.getBeanDefinitionNames();
            int i = 1;
            for (String beanName : beanNames) {
                System.out.println("beanName " + i + " : " + beanName);
                i++;
            }
            Student student = (Student) applicationContext.getBean("studentBean");
            student.print();
        }
        //destroy action now... Spring container invoke destroyMethod() for Student bean;

    }
}
