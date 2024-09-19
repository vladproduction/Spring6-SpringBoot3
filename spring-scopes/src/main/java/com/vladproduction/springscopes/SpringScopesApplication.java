package com.vladproduction.springscopes;

import com.vladproduction.springscopes.lazy.LazyLoader;
import com.vladproduction.springscopes.scope.PrototypeBean;
import com.vladproduction.springscopes.scope.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringScopesApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(SpringScopesApplication.class, args);

        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        System.out.println("singletonBean1.hashCode() = " + singletonBean1.hashCode());
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
        System.out.println("singletonBean2.hashCode() = " + singletonBean2.hashCode());
        SingletonBean singletonBean3 = context.getBean(SingletonBean.class);
        System.out.println("singletonBean3.hashCode() = " + singletonBean3.hashCode());

        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1.hashCode() = " + prototypeBean1.hashCode());
        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
        System.out.println("prototypeBean2.hashCode() = " + prototypeBean2.hashCode());
        PrototypeBean prototypeBean3 = context.getBean(PrototypeBean.class);
        System.out.println("prototypeBean3.hashCode() = " + prototypeBean3.hashCode());

        //spring container create LazyLoader only after request (in demand):
        LazyLoader lazyLoader = context.getBean(LazyLoader.class);




    }

}
