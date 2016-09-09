package com.test.reflection.custom;

import java.util.Scanner;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.TreeMap;
import java.util.Collection;
/**
*This class acts as a custom tool to run any methods annotated with @MainWithPriority within the specified className
*Methods are invoked in the order of their priority
*
*@author Devesh Shetty
*/
public class RunMainToolTwo{
    
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
            System.out.println("There should exist atleast 1 method in the class with @MainWithPriority annotation");
            return;
        }
        boolean mainNotFound = true;//a flag variable to check if any method is annotated with @MainWithPriority or not
        
        //TreeMap keeps the internal data sorted based on their key values
        TreeMap<Integer, Method> treeMap = new TreeMap<Integer, Method>();
        for(Method method: methods){
            //get the annotation associated with the method
            MainWithPriority main = method.getAnnotation(MainWithPriority.class);
            //main will be null if it is not annotated with @Main
            if(main != null){
                //method is annotated with @Main
                mainNotFound = false;
                //get the priority associated with the method
                int priority = main.priority();
                treeMap.put(priority, method);
            }
            
        }
        if(mainNotFound){
            System.out.println("Annotate at least 1 method with @Main annotation");
            return;
        }
        
        //get all the method to be invoked in the order of their priority
        Collection<Method> values = treeMap.values();
        for(Method m : values){
            try{
                    m.invoke(o);
                }
            catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
                System.out.println("Issue with the annotated method");
                e.printStackTrace();
                return;
            }
        }
        
        
    }
    
}