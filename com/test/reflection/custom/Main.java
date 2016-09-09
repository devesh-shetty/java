package com.test.reflection.custom;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
*A custom annotation to run any method of a class as a main method
*
*@author Devesh Shetty
*/
@Target(value = {ElementType.METHOD})//our annotation only target methods
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Main{
    
}