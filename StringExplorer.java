import java.io.*;

/**
*This program aims to explore the String and its different methods in JAVA
*@author: Devesh Shetty
*/
public class StringExplorer{
    
    private static PrintStream out = System.out;
    
    public static void main(String[] args){
        //In JAVA, String is an object
        //By default, a String object is immutable
        //String object can be stored in the heap or in the string pool
        
        //String object made without using the new operator is stored in String pool
        //In String pool, duplicate content can not exist
        String xPool = "Hello";
        
        //String object made using the new operator are stored in the Heap
        //In the heap, duplicate content can exist
        String xHeap = new String("Hello");
        //xPool and xHeap point to different String objects even thought they have the same content
        
        //yPool points to the same object as xPool in the String pool
        String yPool = "Hello";
        
        // == compares strings for reference equality,i.e., whether they refer to the same object or not
        out.println("xPool == yPool: "+( xPool == yPool ));//will print true
        out.println("xPool == xHeap: "+ (xPool == xHeap));//will print false
    }
    
}