import java.io.*;
/**
*A simple program in JAVA to convert a given number to its equivalent binary form using only <b>BitWise operations</b>
*
*@author: Devesh Shetty
*/
public class BinaryForm{
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        PrintStream out = System.out;
        
        out.print("Enter a number: ");
        int n = Integer.parseInt(br.readLine());
        
        out.println("Binary form of "+n+": ");
        
        //int is of 4 bytes, hence 32 bits
        for(int i = 31; i>=0; i--){
            //make use of the unsigned right shift operator
            // and & it with 1 to get the bit at the 'i'th position
            out.print( ( n >>> i ) & 1 );
        }
        out.println();
    }
    
}