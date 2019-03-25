package com.example.pizzashop;

import java.text.*;

public class Za
{   public static void main(String[] args)
    {   new Za();   }

    private Stock stock = new Stock();
    private Factory factory = new Factory(stock);
    private Customers customers = new Customers();
    private double money = 1000;

    public Za()
    {   System.out.println("Welcome to Za Pizza");
        char choice = readChoice();
        while (!end(choice))
        {   execute(choice);
            choice = readChoice();  }}
            
    private char readChoice()
    {   System.out.print("\nYour choice (O/C/N/T/Z/?/X): ");
        String s = In.nextLine();
        return s.toUpperCase().charAt(0);   }
            
    private boolean end(char c)
    {   return c == 'X'; }
            
    private void execute(char choice)
    {   switch (choice)
        {   case 'O': order(); break;
            case 'C': convert(readName()); break;
            case 'T': factory.showTypes(); break;
            case 'N': factory.add(); break;
            case 'Z': show(); break;
            case '?': showChoices(); break;
            default: sayError();    }}
        
    private void order()
    {   Customer customer = customers.aCustomer(readName());
        customer.greet();
        factory.serve(customer);
        if (customer.ordered())
        {   charge(customer);
            customer.setCredit();   }}

    private String readName()
    {   System.out.println();
        System.out.print("Your name: ");
        return In.nextLine(); }

    private void charge(Customer customer)
    {   double charge = customer.charge();
        String s = "    The charge is $" + formatted (charge);
        System.out.println(s);
        add(charge);    }
        
    private void add(double amount)
    {   money += amount;    }
    
    private void convert(String name)
    {   Normal normal = (Normal) customers.customer(name);
        if (normal == null)
            System.out.println("\tSorry, you're not a customer");
        else
        {   customers.convert(normal);
            add(customers.conversionFee());   }}
       
    private void show()
    {   System.out.println("\nThe Za has $" + formatted(money));
        stock.show();   }
        
    private String formatted(double amount)
    {   DecimalFormat twoD = new DecimalFormat("###,##0.00");
        return twoD.format(amount); }
        
    private void showChoices()
    {   String s = "The menu choices are";
        s += "\n    O    Order pizzas";
        s += "\n    C    Convert to a special customer";
        s += "\n    N    Define a new pizza";
        s += "\n    T    Show the types";
        s += "\n    Z    Show the Za";
        s += "\n    ?    Show the choices";
        s += "\n    X    Exit";
        System.out.println(s);  }
        
    private void sayError()
    {   System.out.println("Sorry, that is not a menu choice");
        showChoices();  }
}
