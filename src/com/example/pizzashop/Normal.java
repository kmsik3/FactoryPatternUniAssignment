package com.example.pizzashop;

public class Normal extends Customer
{   public Normal(String name)
    {   super(name);    }
    
    public void setCredit()
    {}
    
    public double charge()
    {   return price(); }
}
