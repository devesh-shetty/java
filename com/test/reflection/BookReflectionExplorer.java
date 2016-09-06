package com.test.reflection;

import java.util.Arrays;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
        
        //get all the fields (public as well as private)
        Field[] fields = clsBook.getDeclaredFields();
        System.out.println("The class has "+fields.length+"  fields(public as well as private)" );
        for(Field field: fields){
            System.out.println("Field Name: "+field.getName());
            System.out.println("Type: "+field.getType());
        }
        
        //get all the public fields 
        fields = clsBook.getFields();
        System.out.println("The class has "+fields.length+"  public fields" );
        for(Field field: fields){
            System.out.println("Field Name: "+field.getName());
            System.out.println("Type: "+field.getType());
        }
        
        //gets all the methods (public as well as private) excludes inherited methods
        Method[] methods = clsBook.getDeclaredMethods();
        System.out.println("The class has "+methods.length+"  methods(public as well as private)" );
        for(Method method: methods){
            System.out.println();
            System.out.println("Method Name: "+method.getName());
            System.out.println("Parameter count: "+method.getParameterCount());
            System.out.println("Parameters: "+Arrays.toString(method.getParameterTypes()));
            System.out.println("Return Type: "+method.getReturnType());
        }
        
        //gets all the public methods as well as those inherited
        methods = clsBook.getMethods();
        System.out.println("\nThe class has "+methods.length+"  public methods" );
        for(Method method: methods){
            System.out.println();
            System.out.println("Method Name: "+method.getName());
            System.out.println("Parameter count: "+method.getParameterCount());
            System.out.println("Parameters: "+Arrays.toString(method.getParameterTypes()));
            System.out.println("Return Type: "+method.getReturnType());
        }
        
        
    }
    
}