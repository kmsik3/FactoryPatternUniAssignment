package com.example.pizzashop;

import java.util.*;

public class Customers
{   private LinkedList<Customer> customers = new LinkedList<Customer>();
    private final double conversionFee = 10.00;
        
    public Customer aCustomer(String name)
    {   Customer found = customer(name);
        if (found != null)
        {   found.clear();
            return found;   }
        else
        {   Normal normal = new Normal(name);
            add(normal);
            return normal;    }}

    public Customer customer(String name)
    {   for (Customer customer: customers)
            if (customer.matches(name))
                return customer;
        return null;    }
    
    public void add(Customer customer)
    {   customers.add(customer);  }
    
    public void convert(Normal normal)
    {   Special special = new Special(normal);
        customers.remove(normal);
        customers.add(special);
        String s = "    Congratulations " + special.name() + ". ";
        s += "\n    For just $10 you are now special.";
        System.out.println(s);  }
        
    public double conversionFee()
    {   return conversionFee;   }
}
