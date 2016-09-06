package com.test.reflection;

import java.util.Scanner;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
/**
*This class will act as a tool to run any class and call any of its public no-arguments method
*It makes use of the Reflection API
*@author: Devesh Shetty
*/
public class ClassRunnerTool{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //fully-qualified name is basically with the package name
        //e.g java.util.Scanner
        System.out.print("Enter the class name (fully qualified class name): ");
        String className = sc.nextLine();
        
        System.out.print("Enter the no-arguments method name: ");
        String methodName = sc.nextLine();
        
        Class<?> cls;
        
        try{
            //get the reference of the class object associated with the given className
            cls = Class.forName(className);
        }
        //use a multi-catch block (available since jdk 1.7)
        catch(LinkageError | ClassNotFoundException e){
            System.out.println("Please enter a valid class name");
            e.printStackTrace();
            return;
        }
        
        Method method;
        try{
            //get the method object from class
            method = cls.getMethod(methodName);
        }
        catch(NoSuchMethodException e){
            System.out.println("Please enter a valid accessible method name");
            e.printStackTrace();
            return;
        }
        
        Object obj;
        try{
            //create a new instance of the class object
            obj = cls.newInstance();
        }
        catch(IllegalAccessException | InstantiationException 
                | ExceptionInInitializerError e){
            System.out.println("Object instantiation failed");
            e.printStackTrace();
            return;
        }
        
        try{
            //invoke the method on the supplied object
            method.invoke(obj);
        }
        catch(IllegalAccessException | InvocationTargetException 
              | ExceptionInInitializerError e){
            System.out.println("Method invocation failed");
            e.printStackTrace();
        }
        
        
        
    }
    
}