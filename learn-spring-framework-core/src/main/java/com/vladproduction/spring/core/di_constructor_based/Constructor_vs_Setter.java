package com.vladproduction.spring.core.di_constructor_based;

/**
 * advantages of using constructor based-dependency:
 *      -all required dependencies are available at initialization time;
 *      in this example - while car bean creating all dependencies available by constructor;
 *      -immutability and avoid NullPointerException (we can make injection final);
 *      -prevents errors in testing;
 * */
public class Constructor_vs_Setter {
}
class Car{

    private Engin engin;
    private Music music;

    /**
     * we have a full control; and it`s reject null catch for injected instances;
     * in case of constructor approach:
     *  -spring create bean for object using constructor method first;
     *  -only after that will be creating beans by using setter method;
     *  -if we make field/s final we can not use setters (compilation error case);
     * */
    public Car(Engin engin, Music music) {
        this.engin = engin;
//        this.music = music;
    }

    /**
     * by setter approach we can create beans optionally,
     * just to invoke setter method;
     * */
    public void setMusic(Music music) {
        this.music = music;
    }
}

class Engin{

}

class Music{

}