package com.example.pizzashop;

import java.util.*;

public class Factory
{   private Stock stock;
    private LinkedList<Pizza> pizzas = new LinkedList<Pizza>();
    private Pizza made;

    public Factory(Stock stock)
    {   this.stock = stock;
        String[] pepperoniTops = {"pepperoni", "mushroom", "olive"};
        add("pepperoni", pepperoniTops, 4.50);
        String[] marinaraTops = {"prawn", "olive"};
        add("marinara", marinaraTops, 6.70);
        String[] vegetarianTops = {"zucchini", "artichoke"};
        add("vegetarian", vegetarianTops, 8.90);    }
        
    private void add(String name, String[] tops, double price)
    {   pizzas.add(new Pizza(name, tops, price));
        for (String top: tops)
            if (!stock.has(top))
                stock.add(top);    }
        
    public void serve(Customer customer)
    {   String type = readType();
        while (!end(type))
        {   if (makes(type))
            {   make(type);
                customer.add(made());   }
            else
                showTypes();
            type = readType();  }}
            
    private String readType()
    {   System.out.print("    Type of pizza (or end): ");
        return In.nextLine(); }

    private boolean end(String s)
    {   return s.equals("end"); }
        
    public boolean makes(String name)
    {   for (Pizza pizza: pizzas)
            if (pizza.name().equals(name))
                return true;
        return false;   }
        
    public void make(String name)
    {   made = make(pizza(name));  }
                    
    private Pizza pizza(String name)
    {   for (Pizza pizza: pizzas)
            if (pizza.matches(name))
                return pizza;
        return null;    }
        
    private Pizza make(Pizza spec)
    {   Pizza pizza = new Pizza(spec);
        for (String top: spec.tops())
        {   stock.sub(top);
            pizza.add(top); }
        return pizza;   }
        
    public void add()
    {   String name = readName();
        LinkedList<String> tops = new LinkedList<String>();
        String top = readTopping();
        while (!end(top))
        {   tops.add(top);
            if (!stock.has(top))
                stock.add(top);
            top = readTopping();    }
        pizzas.add(new Pizza(name, tops, readPrice()));    }
        
    private String readName()
    {   System.out.println();
        System.out.print("    Pizza name: ");
        return In.nextLine(); }
        
    private String readTopping()
    {   System.out.print("\tTopping (or end): ");
        return In.nextLine(); }
                
    private double readPrice()
    {   System.out.print("\tPrice: ");
        return In.nextDouble(); }
        
    public Pizza made()
    {   return made;   }
    
    public void showTypes()
    {   String s = "    We make " + types();
        System.out.println(s);  }
    
    public String types()
    {   String s = "";
        for (Pizza pizza: pizzas)
            s += pizza.name() + ", ";
        s = s.substring(0, s.length() - 2);
        int loc = s.lastIndexOf(',');
        String before = s.substring(0, loc + 1);
        String after = s.substring(loc + 1, s.length());
        return before + " and" + after + " pizzas"; }
}
