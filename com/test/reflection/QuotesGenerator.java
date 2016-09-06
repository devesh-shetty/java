package com.test.reflection;

import java.util.Random;
/**
*A class which has a utility method to generate random quotes
*@author: Devesh Shetty
*/
public class QuotesGenerator{
    
    private String quotes[];
    
    public QuotesGenerator(){
        quotes = new String[4];
        
        quotes[0] = "Stay hungry, Stay foolish.";
        quotes[1] = "Sometimes life is going to hit you in the head with a brick. Don't lose faith.";
        quotes[2] = "Innovation distinguishes between a leader and a follower.";
        quotes[3] = "And one more thing.";
        
    }
    
    public String getRandomQuote(){
        Random random = new Random();
        int n = random.nextInt(4);
        return quotes[n];
    }
    
}