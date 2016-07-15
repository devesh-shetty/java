import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
*This program aims to explore the String and its different methods in JAVA
*@author: Devesh Shetty
*/
public class StringExplorer{
    
    private static PrintStream out = System.out;
    
    public static void main(String[] args){
        
        //-----String Pool and Heap-----
        
        //In JAVA, String is an object and it does not end with a null character
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
        
        //-----String methods-----
        
        String str = "world";
        //Since String objects are immutable
        //str.toUpperCase creates a new object and returns it
        //The original string in unaffected
        String strUpper = str.toUpperCase();
        
        out.println("String: "+str+" String Upper: "+strUpper);
        
        //StringBuffer creates a mutable copy of the object
        StringBuffer mutableStr = new StringBuffer(str);
        //Reversing a StringBuffer object with reverse() affects the original string and returns a reference to it
        StringBuffer strRev = mutableStr.reverse();
        out.println("String: "+mutableStr+" String Reverse: "+strRev);

        String strConcat = xPool.concat(str);
        out.println("Concatenation: "+strConcat+" Length of string: "+strConcat.length());
        
        out.println("Index of o in "+strConcat+": "+strConcat.indexOf('o') +" Last Index of o: "+strConcat.lastIndexOf('o'));
        
        out.println(str+" exists in "+strConcat+"? "+strConcat.contains(str));
        
        out.println("SubString from index 2 of "+strConcat+": "+strConcat.substring(2));
        
        char charArr[] = strConcat.toCharArray();
        out.println("Character array of "+strConcat+": "+Arrays.toString(charArr));
        
        charArr[4] = 'Z';
        String strFromChar = String.valueOf(charArr);//Converts character array to String
        out.println("Modified char array in it's string equivalent: "+strFromChar);
        
        byte byteArr[] = strConcat.getBytes();
        out.println("Byte Array: "+Arrays.toString(byteArr));
        
        String demoString = "HelloRRWorldRRTestingRRSplit";
        String splitArr[] = demoString.split("RR");
        
        out.println(demoString+" has been split into using RR: "+Arrays.toString(splitArr));
        
        String demoTrimString = " Hello world, welcome to java ";
        String trimString = demoTrimString.trim();//deletes leading and trailing spaces
        out.println("Before trimming:"+demoTrimString+" Length= "+demoTrimString.length()+", After trimming:"+trimString+", Length: "+trimString.length() );
     
        
        String a = "ABC";
        String b = "BCD";
        String c = "abc";
        String A = "ABC";
        
        String temp = "ZYS";
        
        out.println(a.compareTo(b));//will give -1
        out.println(a.compareTo(A));//will give 0
        out.println(a.compareTo(c));//will give -32
        out.println(b.compareTo(a));//will give 1
        out.println(a.compareTo(temp));
        out.println(c.compareTo(temp));
        
        char ch[] = {'a','b','c'};
        String charString = new String(ch);
        
        for(char x : ch){
            out.print(x+" ");
        }
        
        out.println();
        
        String one = new String("TEST");
        String two = "TEST";
        String three = one.intern();//returns the string from pool
        out.println(one == two);//false
        out.println(one == three);//false
        out.println(two == three);//true
        
        
        StringBuffer buffer = new StringBuffer("I am a ");
        buffer.append("String Buffer");
        out.println(buffer);
        
        buffer.insert(2,"Voila!!!");
        out.println(buffer);
    }
    
}