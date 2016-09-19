package com.test.java8;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
*A utility class to help us with operations on list using functional interfaces
*
*@author: Devesh Shetty
*/
public class ListUtil{
    
    /**
    *Perform the operation specified by the user on every item of the list 
    *
    *@param list: the list on which operation is to be performed
    *@param consumer: the functional interface to perform some operation on the item
    */
    public static void forEach(List<Integer> list, Consumer<Integer> consumer){
        for(Integer item: list){
            consumer.accept(item);
        }
    }
    
    /**
    *Returns a new list with all the items in the list which pass the given test
    *
    *@param list
    *@param predicate
    *@return List<Integer>: A new list with the operation performed
    */
    public static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate){
        List<Integer> newList = new ArrayList<>();
        
        for(Integer item: list){
            if(predicate.test(item)){
                newList.add(item);
            }
        }
        return newList;
    } 
    
    /**
    *Returns a new list with the results of applying the given function on every item of the list
    *
    *@param list
    *@param function
    */
    public static List<Integer> map(List<Integer> list, Function<Integer, Integer> function){
        List<Integer> newList = new ArrayList<>();
        
        for(Integer item: list){
            newList.add(function.apply(item));
        }
        
        return newList;
    }
    
    
}