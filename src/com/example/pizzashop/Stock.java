package com.example.pizzashop;

import java.util.*;

public class Stock
{   private LinkedList<Topping> toppings = new LinkedList<Topping>();
            
    public void add(String topping)
    {   toppings.add(new Topping(topping));    }
        
    public void sub(String name)
    {   topping(name).sub();    }
    
    public boolean has(String name)
    {   return topping(name) != null;   }
        
    public Topping topping(String name)
    {   for (Topping top: toppings)
            if (top.matches(name))
                return top;
        return null;    }
        
    public void show()
    {   System.out.println(toString()); }
            
    public String toString()
    {   String s = "The stock on hand is";
        for (Topping top: toppings)
            s += "\n    " + top.toString();
        return s;   }
}
