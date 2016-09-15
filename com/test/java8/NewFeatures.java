package com.test.java8;
/**
*Exploring new JAVA8 features
*
*@author: Devesh Shetty
*/
public class NewFeatures{
    
    public static void main(String[] args){
        
        //Lambda expression
        //We can use Lambda expression to replace anonymous inner classes
        //Constraint: The interface must have only 1 abstract method
        // -> marks the body of the lambda expression
        //Thread constructor takes a Runnable
        //which has a single abstract method public void run()
        //Our lambda expression will be based on this single abstract method
        //run() takes no arguments so our lambda will take no argument
        Thread one = new Thread(() -> {
            System.out.println("Thread One");
        });
        
        //When we have a single statement in the body of the lambda expression, 
        //we can skip the '{}' braces and directly write that 1 statement
        Thread two = new Thread( () -> System.out.println("Thread Two"));
        
        one.start();
        two.start();
        
    }
}