package com.test.reflection.custom;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
*This is a custom annotation. A field annotated with @Inject will be injected will be injected with the corresponding object
*
*@author Devesh Shetty
*/
@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Inject{
    
}