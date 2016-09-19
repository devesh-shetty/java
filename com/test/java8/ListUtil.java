package com.test.java8;

import java.util.List;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
*A utility class to help us with operations on list using functional interfaces
*
*@author: Devesh Shetty
*/
public class ListUtil{
    
    public static void forEach(List<Integer> list, Consumer<Integer> consumer){
        for(Integer item: list){
            consumer.accept(item);
        }
    }
    
    public static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate){
        List<Integer> newList = new ArrayList<>();
        
        for(Integer item: list){
            if(predicate.test(item)){
                newList.add(item);
            }
        }
        return newList;
    } 
    
    public static List<Integer> map(List<Integer> list, Function<Integer> function){
        List<Integer> newList = new ArrayList<>();
        
        for(Integer item: list){
            newList.add(function.apply(item));
        }
        
        return newList;
    }
    
    
}