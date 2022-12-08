package com.skd.functionalinterface;

@FunctionalInterface
public interface B {
    void show();
    default void m1(){
        System.out.println("An Interface could have any no of default methods from Java 8");
    }
    static void m2(){
        System.out.println("An Interface could have any no of static methods from Java 8");    }
}
