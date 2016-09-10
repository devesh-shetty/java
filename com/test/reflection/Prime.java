package com.test.reflection;

import com.test.reflection.custom.Main;
import com.test.reflection.custom.MainWithPriority;
import com.test.reflection.custom.Inject;
import java.util.Scanner;
import java.util.Arrays;
/**
*This class has a method to print prime numbers upto 'n'
*
*@author Devesh Shetty
*/
public class Prime{
    
    //This field will be injected with the help of a tool
    @Inject
    private QuotesGenerator qg;
    
    @MainWithPriority(priority = 1)
    public void printCustomInfo(){
        System.out.println(qg.getRandomQuote());
        System.out.println("Printing Primes using Sieve of Eratosthenes");
    }
    
    
    /**
    *This method will use Sieve of Eratosthenes technique
    */
    @Main
    @MainWithPriority(priority = 2)
    public void printPrime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();
        sc = null;
        
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        
        for(int i=2; i<=n; i++){
            
            if(primes[i]){
                //if a number is prime
                //then mark all its multiples as not prime (i.e. false)
                for(int j = i*i; j<=n; j+=i){
                    primes[j] = false;
                }
                
            }
        }
        
        for(int i = 2; i<=n; i++){
            if(primes[i]){
                System.out.print(i+" ");
            }
        }
        System.out.println();
        
    }
    
}