package com.test.java8.student;

/**
*A Student class with some properties
*@author: Devesh Shetty
*/
public class Student{
        
    private String name;
    private int age;
    private double marks;
    private StudentGender gender;
    
    public Student(String name, int age, double marks, StudentGender gender){
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.gender = gender;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public double getMarks(){
        return marks;
    }
    
    public StudentGender getGender(){
        return gender;
    }
    
    public String toString(){
        return "Student[name = "+name+", age= "+age+", marks= "+marks+", gender= "+gender+"]";
    }
    
}