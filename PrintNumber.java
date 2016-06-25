import java.io.*;

/**
*A program to print a given number in words
*
*@author: Devesh Shetty
*/
public class PrintNumber{

    private static PrintStream out = System.out;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        String choice;
        
        do{
            out.print("Enter a number: ");
            int n = Integer.parseInt(br.readLine());
            printNumberInWordFormat(n);
            out.println("Do you wish to continue? (y/n)");
            choice = br.readLine();
        }while( choice.equals("y") );
        
    }
    
    /**
    *This method takes a number and prints it's word equivalent
    *@param n the number
    */
    private static void printNumberInWordFormat(int n){
        int m = n;
        int d = 1;
        
        //This loop helps to determine the number of digits in the factor of 10
        while( n!= 0 ){
            d*= 10;
            n/=10;
        }
        
        d/= 10;
        
        do{
            switch( m/d ){
                
                case 0: out.print("Zero ");
                    break;
                    
                case 1: out.print("One ");
                    break;
                
                case 2: out.print("Two ");
                    break;
                    
                case 3: out.print("Three ");
                    break;
                
                case 4: out.print("Four ");
                    break;
                    
                case 5: out.print("Five ");
                    break;
                
                case 6: out.print("Six ");
                    break;
                    
                case 7: out.print("Seven ");
                    break;
                    
                case 8: out.print("Eight ");
                    break;
                    
                case 9: out.print("Nine ");
                    break;
                
            }
            
            m = m%d;
            d = d/10;
            
        }while(d!=0);
        
        out.println();
    }
    
}