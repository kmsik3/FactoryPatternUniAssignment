package com.example.pizzashop;

import java.util.*;

public class Pizza
{   private String name;
    private LinkedList<String> tops = new LinkedList<String>();
    private int index = 0;
    private double price;

    public Pizza(String name, String[] tops, double price)
    {   this.name = name;
        for (String top: tops)
            this.tops.add(top);
        this.price = price; }
        
    public Pizza(String name, LinkedList<String> tops, double price)
    {   this.name = name;
        this.tops = tops;
        this.price = price; }
    
    public Pizza(Pizza spec)
    {   name = spec.name;
        price = spec.price; }
    
    public boolean matches(String name)
    {   return this.name.equals(name);  }
    
    public void add(String name)
    {   tops.add(name);   }
    
    public String name()
    {   return name;    }
    
    public LinkedList<String> tops()
    {   return tops;    }
    
    public double price()
    {   return price;   }
    
    public void show()
    {   System.out.println(toString()); }
    
    public String toString()
    {   String s = name + " pizza";
        s += "\n    ";
        for (String top: tops)
            s += top + ", ";
        return s.substring(0, s.length() - 2);  }
}

