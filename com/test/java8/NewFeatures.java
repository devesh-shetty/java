/**
*Exploring new JAVA8 features
*
*@author: Devesh Shetty
*/
public class NewFeatures{
    
    public static void main(String[] args){
        
        //Lambda expression
        Thread one = new Thread(() -> {
            System.out.println("Thread One");
        });
        
        one.start();
        
    }
}