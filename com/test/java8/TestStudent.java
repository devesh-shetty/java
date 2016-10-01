package com.test.java8;

import java.util.Random;
import java.util.ArrayList;
import java.util.Map;
import com.test.java8.student.Student;
import com.test.java8.student.StudentGender;
import java.util.stream.Collectors;
import java.util.HashMap;

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
        
        //A typical way of storing data in a map
//        HashMap<String, String> map = new HashMap<String, String>();
//        studentList.forEach( student -> {
//           String key = student.getGender().value();
//            if(!map.containsKey(key)){
//            
//               map.put(key, student.getName());
//           }else{
//                //map already has a value with that key
                    // so handle the collision by separating the values with "|"
//                String name = map.get(key);
//                name+= "|"+student.getName();
//                map.put(key, name);
//            } 
//        });
//        System.out.println(map);
        
        Map<String, String> map = studentList.stream()
                                            .collect(Collectors.toMap( student -> student.getGender().value(),//the key
                                                                      student -> student.getName(),//the value
                                                                      (prevValue, newValue) -> prevValue + "|"+newValue //if collision occurs, specify how to handle collision (basically the else part in the above map functionality)
                                            
                                            ));
        
        map.forEach((key, value) -> System.out.println(key+": "+value));
        
        
    }
    
}