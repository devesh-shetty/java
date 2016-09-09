package com.test.reflection.custom;

import java.util.Scanner;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
*This class acts as a custom tool to run any method annotated with @Main within the specified className
*
*@author Devesh Shetty
*/
public class RunMainTool{
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the class name: ");
        String className = sc.nextLine();
        sc = null;//for garbage collection
        
        Class<?> cls;
        try{
            cls = Class.forName(className);
        }
        catch(ClassNotFoundException e){
            System.out.println("Class cannot be found!");
            e.printStackTrace();
            return;
        }
        
        Object o;
        
        try{
            //create an instance of the specified class
            o = cls.newInstance();
        }
        catch(InstantiationException | IllegalAccessException e){
            System.out.println("Error in creating the object. Please ensure an empty constructor exists within the class");
            e.printStackTrace();
            return;
        }
        
        Method[] methods = cls.getMethods();
        if(methods.length == 0){
            System.out.println("There should exist atleast 1 method in the class with @Main annotation");
            return;
        }
        boolean mainNotFound = true;//a flag variable to check if any method is annotated with @Main or not
        for(Method method: methods){
            Main main = method.getAnnotation(Main.class);
            //main will be null if it is not annotated with @Main
            if(main != null){
                //method is annotated with @Main
                mainNotFound = false;
                try{
                    method.invoke(o);
                    break;
                }
                catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
                    System.out.println("Issue with the annotated method");
                    e.printStackTrace();
                    return;
                }
            }
            
        }
        if(mainNotFound){
            System.out.println("Annotate at least 1 method with @Main annotation");
            return;
        }
        
    }
    
}