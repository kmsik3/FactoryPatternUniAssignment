package com.example.pizzashop;
import java.util.*;

abstract public class Customer
{   protected String name;
    private LinkedList<Pizza> order = new LinkedList<Pizza>();
    
    public Customer(String name)
    {   this.name = name;   }
    
    public void greet()
    {   System.out.println("    " + greeting()); }
    
    public String greeting()
    {   return "Hi " + name;    }
    
    public void clear()
    {   order.clear();  }
        
    public void add(Pizza pizza)
    {   order.add(pizza); }
    
    public boolean ordered()
    {   return !order.isEmpty();   }
    
    abstract public void setCredit();
    abstract public double charge();
    
    public double price()
    {   double price = 0;
        for (Pizza pizza: order)
            price += pizza.price();
        return price;   }
        
    public boolean matches(String name)
    {   return this.name.equals(name);  }
    
    public String name()
    {   return name; }
    
    public void show()
    {   System.out.println(toString()); }
    
    public String toString()
    {   String s = "    " + name + ": ";
        for (Pizza pizza: order)
            s += pizza.name() + ", ";
        return s.substring(0, s.length() - 2);   }
}
