package com.test.java8;

import java.util.Random;
import java.util.ArrayList;
import java.util.Map;
import com.test.java8.student.Student;
import com.test.java8.student.StudentGender;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;
import java.util.function.Supplier;
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
        
        studentList.forEach(System.out :: println);
        
     //   A typical way of storing data in a map
    /*    HashMap<String, String> map = new HashMap<String, String>();
        studentList.forEach( student -> {
           String key = student.getGender().value();
            if(!map.containsKey(key)){
            
               map.put(key, student.getName());
           }else{
                //map already has a value with that key
                     so handle the collision by separating the values with "|"
                String name = map.get(key);
                name+= "|"+student.getName();
                map.put(key, name);
            } 
        });
        System.out.println(map);
      */  
        Map<String, String> map = studentList.stream()
                                            .collect(Collectors.toMap( student -> student.getGender().value(),//the key
                                                                      student -> student.getName(),//the value
                                                                      (prevValue, newValue) -> prevValue + "|"+newValue //if collision occurs, specify how to handle collision (basically the else part in the above map functionality)
                                            
                                            ));
        
        map.forEach((key, value) -> System.out.println(key+": "+value));
        
        //Now, instead of creating multiple streams of male and female, why not reuse the old one?
        //once after performing a terminal operation on the stream,
        //If we try to reuse the same stream after performing a terminal operation on it, we get 
        //java.lang.IllegalStateException:"stream has already been operated upon or closed"
        //so instead of reusing the existing stream, we make use of a Stream Supplier
        //that provides a new Stream for all our future purposes
        
        /*Stream<Student> maleStream = studentList.stream()
                                                .filter(Student :: isMale);
        
        Stream<Student> femaleStream = studentList.stream()
                                                    .filter(Student :: isFemale);
        */
        Supplier< Stream<Student> > maleStreamSupplier = new Supplier< Stream<Student> >(){
                                                                    //anonymous inner class syntax
                                                                    public Stream<Student> get(){
                                                                        return studentList.stream().filter(Student :: isMale);
                                                                    }
                                                                };
        //using lambda expressions
        Supplier< Stream<Student> > femaleStreamSupplier = () -> studentList.stream().filter(Student :: isFemale);
        
        
        //Name of all male candidates
        maleStreamSupplier.get().forEach( student -> System.out.print(student.getName()+" "));//terminal operation;
        System.out.println();
        
        //name of all female candidates with age > 20
        List<Student> femalesAgeGreater20 = femaleStreamSupplier.get().filter( Student :: isAgeGreaterThan20 )
                                                    .collect( Collectors.toList() );
        femalesAgeGreater20.forEach(System.out :: println);
        System.out.println();
        
        //Average age of all males in the class
        //OptionalDouble uses the NULL object pattern
        OptionalDouble optionalAverage = maleStreamSupplier.get().mapToInt( Student :: getAge )
                                                    .average();
        
        if(optionalAverage.isPresent()){
            System.out.println("The average age of all males in the class: "+optionalAverage.getAsDouble());
        }else{
            System.out.println("No male in the class");
        }
        
        //get the maximum score secured by a female
        OptionalDouble optionalMax = femaleStreamSupplier.get().mapToDouble( Student :: getMarks)
                                            .max();
        
        if(optionalMax.isPresent()){
            System.out.println("The maximum score secured by a female is "+optionalMax.getAsDouble());
        }else{
            System.out.println("No females exist in the class");
        }
        
    
    }
    
}