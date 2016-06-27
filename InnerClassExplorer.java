/**
*
*@author: Devesh Shetty
*/
public class InnerClassExplorer{
    
    private String data = "DATA";
    
    
    class Inner{
        void printData(){
            //inner class can access outer class variables
            System.out.println("The data is "+data );
        }
    }
    
    public static void main(String[] args){
        
        InnerClassExplorer outer = new InnerClassExplorer();
        InnerClassExplorer.Inner in = outer.new Inner();
        in.printData();
        
    }
    
    
}