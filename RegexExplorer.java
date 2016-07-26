import java.util.regex.*;
import java.io.PrintStream;

/**
*Program to explore various Regex functionalities
*
*@author: Devesh Shetty
*/
class RegexExplorer{
    
    public static void main(String[] args){
        
        PrintStream out = System.out;
        //check for a single character before 'g'
        out.println(Pattern.matches(".g", "rg"));
    }
    
}