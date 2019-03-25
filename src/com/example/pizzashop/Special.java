package com.example.pizzashop;

import java.text.*;

public class Special extends Customer
{   private final double creditRate = 10;
    private double credit = 0;
    
    public Special(String name)
    {   super(name);    }
    
    public Special(Normal normal)
    {   super(normal.name());   }
    
    public String greeting()
    {   String s = super.greeting();
        s += ", you have $" + formatted(credit) + " credit";
        return s; }
        
    private String formatted(double amount)
    {   DecimalFormat twoD = new DecimalFormat("###,##0.00");
        return twoD.format(amount); }

    public void setCredit()
    {   credit = refund();  }
        
    private double refund()
    {   double basic = charge() * (creditRate / 100.0);
        int truncated = (int) (basic * 100);
        return truncated / 100.0;   }
        
    public double charge()
    {   double charge = price() - credit;
        if (charge < 0)
            return 0;
        else
            return charge;  }
}
