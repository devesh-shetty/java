import java.io.*;
/**
*A simple program in JAVA to convert a given number to its equivalent binary form using <b>BitWise operatiions</b>
*
*@author: Devesh Shetty
*/
public class BinaryForm{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
        PrintWriter out = new PrintWriter(System.out);
        out.print("Enter a number: ");
        int n = Integer.parseInt(br.readLine());
        
        out.println("Binary form of "+n+": ");
        
    }
    
}