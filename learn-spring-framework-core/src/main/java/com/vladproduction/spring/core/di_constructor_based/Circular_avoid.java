package com.vladproduction.spring.core.di_constructor_based;

public class Circular_avoid {
}
class DependencyA{

    private DependencyB dependencyB;

//    public DependencyA(DependencyB dependencyB) {
//        this.dependencyB = dependencyB;
//    }

    //instead of constructor were using setter approach to create bean:
    public void setDependencyB(DependencyB dependencyB) {
        this.dependencyB = dependencyB;
    }
}
class DependencyB{

    private DependencyA dependencyA;

//    public DependencyB(DependencyA dependencyA) {
//        this.dependencyA = dependencyA;
//    }

    //also injected field created by setter method;
    public void setDependencyA(DependencyA dependencyA) {
        this.dependencyA = dependencyA;
    }
}
