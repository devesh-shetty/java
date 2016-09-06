package com.test.reflection;

public class QuotesService{
    
    //The object is going to get Injected using the CustomDItool
    private QuotesGenerator quotesGenerator;
    
    /**
    *@return the quote in lower case
    */
    public String getQuoteInLowerCase(){
        return quotesGenerator.getRandomQuote().toLowerCase();
    }
    
    /**
    *@return the quote in upper case
    */
    public String getQuoteInUpperCase(){
        return quotesGenerator.getRandomQuote().toUpperCase();
    }
    
    
}