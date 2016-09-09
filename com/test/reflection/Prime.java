package com.test.reflection;

import com.test.reflection.custom.Main;
import java.util.Scanner;
import java.util.Arrays;
/**
*This class has a method to print prime numbers upto 'n'
*
*@author Devesh Shetty
*/
public class Prime{
    
    /**
    *This method will use Sieve of Eratosthenes technique
    */
    @Main
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