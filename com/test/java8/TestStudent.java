package com.test.java8;

import java.util.Random;
import java.util.ArrayList;
import java.util.Map;
import com.test.java8.student.Student;
import com.test.java8.student.StudentGender;
import java.util.stream.Collectors;

/**
*@author: Devesh Shetty
*/
public class TestStudent{
    
    public static void main(String[] args){
        ArrayList<Student> studentList = new ArrayList<>();
        Random random = new Random();
        
        for(int i = 0; i < 10; i++){
            int age = random.nextInt(100);
            int marks = random.nextInt(200);
            
            StudentGender gender;
            if( ((age + marks) & 1) == 0 ){
                gender = StudentGender.FEMALE;
            }
            else{
                gender = StudentGender.MALE;
            }
            
            Student student = new Student(age+"_"+gender, age, marks, gender);
            studentList.add(student);
        }
        
        Map<String, String> map = studentList.stream()
                                            .collect(Collectors.toMap( student -> student.getGender().value(),
                                                                      student -> student.getName(),
                                                                      (prevValue, newValue) -> prevValue + "|"+newValue
                                            
                                            ));
        
        map.forEach((key, value) -> System.out.println(key+": "+value));
        
        
    }
    
}