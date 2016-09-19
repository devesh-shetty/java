package com.test.java8;

import java.util.List;
import java.util.Arrays;

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
        
        List<Integer> list = Arrays.asList(5, 67, 21, 54, 32, 90, 98, 34, 1);
        //--------------------Functional Programming --------------------
        //we try to avoid using loops!
        //since, we have a single statement; we can skip the braces
        //the functional method accept takes a single argument
        //so our lambda expression also takes a single argument
        //the data-type of the argument 'item' will be infered
        ListUtil.forEach(list, (item) -> System.out.print(item + " "));
        System.out.println();
        
        //data-type of the argument can also be specified
        ListUtil.forEach(list, (Integer item) -> {
            //print only even numbers
            if( (item & 1) == 0){
                System.out.print(item + " ");
            }
        });
        System.out.println();
        
        //functional method test takes one argument and also returns a value
        //when we have a single statement in the lambda expression
        //the value generated by the expression gets returned automatically
        //no 'return' keyword needed
        List<Integer> evenList = ListUtil.filter(list, (item) -> (item & 1) == 0);
        ListUtil.forEach(evenList, (item) -> System.out.print(item+" "));
        System.out.println();
        
        List<Integer> squares = ListUtil.map(list, (item) -> item*item);
        ListUtil.forEach(squares, (item) -> System.out.print(item+" "));
        System.out.println();
        
    }
}