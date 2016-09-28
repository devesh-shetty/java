package com.test.java8.student;

/**
*@author: Devesh Shetty
*/
public enum StudentGender{
    MALE("MALE"), FEMALE("FEMALE");

    private String gender;

    private StudentGender(String gender){
        this.gender = gender;
    }

    public String value(){
        return this.gender;
    }
        
}