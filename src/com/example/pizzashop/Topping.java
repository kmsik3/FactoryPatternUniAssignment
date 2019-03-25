package com.example.pizzashop;

public class Topping
{   private String name;
    private int stock;

    public Topping(String name)
    {   this.name = name;
        stock = 20; }
        
    public boolean matches(String name)
    {   return this.name.equals(name);  }
        
    public void sub()
    {   stock--; }
        
    public String toString()
    {   return name + ": " + stock; }
}
