package com.test.reflection;

import java.util.Arrays;
import java.lang.reflect.Constructor;

/**
*
*This class makes use of the Reflection API in java to access the public as well as the private properties
*
*@author: Devesh Shetty
*/
public class BookReflectionExplorer{
    
    public static void main(String[] args){
        //get the instance of Class
        Class<Book> clsBook = Book.class;
        
        //gets all the constructors (public as well as private)
        Constructor[] constructors = clsBook.getDeclaredConstructors();
        System.out.println("The class has "+constructors.length+"  constructors(public as well as private)" );
        for(Constructor constructor: constructors){
            System.out.println("Constructor Name: "+constructor.getName());
            System.out.println("Parameter count: "+constructor.getParameterCount());
            System.out.println("Parameters: "+Arrays.toString(constructor.getParameterTypes()));
        }
        
        //get only the public constructors
        constructors = clsBook.getConstructors();
        System.out.println("The class has "+constructors.length+"  public constructors" );
        for(Constructor constructor: constructors){
            System.out.println("Constructor Name: "+constructor.getName());
            System.out.println("Parameter count: "+constructor.getParameterCount());
            System.out.println("Parameters: "+Arrays.toString(constructor.getParameterTypes()));
        }
        
    }
    
}