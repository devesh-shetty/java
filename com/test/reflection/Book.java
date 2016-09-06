package com.test.reflection;

/**
*A simple class 
*
*@author: Devesh Shetty
*/
public class Book{
    
    private String title;
    private double price;
    private int pages;
    
    //Constructors
    public Book(){
        
    }
    
    public Book(String title, double price, int pages){
        this.title = title;
        this.price = price;
        this.pages = pages;
    }
    
    //This constructor is just to check whether it shall be accessible via Reflection
    private Book(String title){
        this.title = title;
    }
    
    //GETTERS & SETTERS
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setPages(int pages){
        this.pages = pages;
    }
    
    public String getTitle(){
        return title;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getPages(){
        return pages;
    }
    
    
    /**
    *A utility method to print the details of the object
    */
    public void printDetails(){
        System.out.println("Title: "+title+", Price: "+price+", Pages: "+pages);
    }
    
    @Override
    public String toString(){
        return title;
    }
    
}
