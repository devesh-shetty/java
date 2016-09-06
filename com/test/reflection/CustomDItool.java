package com.test.reflection;

import java.util.Scanner;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
*A custom DI tool injector class to handle dependencies.
*This makes use of the Reflection API to resolve/handle dependencies(Dependency Injection)
*
*@author: Devesh Shetty
*/
public class CustomDItool{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //fully-qualified name is basically with the package name
        //e.g java.util.Scanner
        System.out.print("Enter the class name (fully qualified class name): ");
        String className = sc.nextLine();
        
        System.out.print("Enter the no-arguments method name: ");
        String methodName = sc.nextLine();
        
        sc= null; //for garbage collection
        
        Class<?> cls;
        try{
            cls = Class.forName(className);
        }
        catch(LinkageError | ClassNotFoundException e){
            System.out.println("Please enter a valid className");
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
        
        Field[] fields = cls.getDeclaredFields();
        for(Field field : fields){
            //get the type of the field
            Class<?> clsField = field.getType();
            //create an object of that field type
            Object objField;
            try{
                objField = clsField.newInstance();
                //make the field accesible directly
                field.setAccessible(true);
                //set the field on the enclosing class object with the value of the field type
                //i.e; inject the field with its required value
                field.set(obj, objField);
            }
            catch(IllegalAccessException | InstantiationException 
                    | ExceptionInInitializerError e){
                System.out.println("Object instantiation failed");
                e.printStackTrace();
                return;
            }
        }
        
        Method method;
        try{
            method = cls.getMethod(methodName);
        }
        catch(NoSuchMethodException e){
            System.out.println("Please enter a valid accessible method name");
            e.printStackTrace();
            return;
        }
        
        try{
            Class<?> resCls = method.getReturnType();
            if(resCls == void.class){
                //if the return type is void then just invoke the method
                method.invoke(obj);
            }else{
                //return type is not void
                //then print the result
                Object res = method.invoke(obj);
                System.out.println(res);
            }
        }
        catch(IllegalAccessException | InvocationTargetException 
              | ExceptionInInitializerError e){
            System.out.println("Method invocation failed");
            e.printStackTrace();
        }
        
    }
    
}