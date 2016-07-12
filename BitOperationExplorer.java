import java.io.PrintStream;
/**
*Aim to explore and implement efficient operations that can be performed with bit manipulation
*
*@author: Devesh Shetty
*/
class Main{
    
    public static void main(String[] args){
        
        PrintStream out = System.out;
        //shifting 1 bit to left multiplies the number by 2
        out.println("1 << 1 is basically shifting 1 bit to left(multiplying by 2), to get: " + ( 1 << 1));
        
        int n = 10;
        out.println(n+" << 1 = "+ (n << 1));
        out.println(n+" >> 1 = "+ (n >> 1));
        out.println(n+" << 2 = "+ (n << 2));
        out.println(n+" >>> 1 = "+ (n >>> 1));
        
        //To check if a number has exactly one 1 
        int bitNo = 64;
        int res = bitNo - 1;
        if( (bitNo & res) == 0){
            out.println("Yes");
        }
        
    }
    
}