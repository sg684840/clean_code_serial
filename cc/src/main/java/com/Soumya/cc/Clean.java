package com.Soumya.cc;

import java.util.*;
import java.io.*;

class SI
{
	double principal=0.0,rate=0.0,time=0.0;
	SI(double principal,double rate,double time)
	{
		this.principal=principal;
		this.rate=rate;
		this.time=time;
	}
	double getSI()
	{
		return ((principal*rate*time)/100);
	}
}

class CI
{
	double principal=0.0,rate=0.0,time=0.0,number=0.0;
	CI(double principal,double rate,double time,double number)
	{
		this.principal=principal;
		this.rate=rate;
		this.time=time;
		this.number=number;
	}
	double getCI()
	{
		return (principal*Math.pow(1+(rate/(number*100)), time*number) -principal);
		
	}
}
public class Clean 
{
    @SuppressWarnings("resource")
	public static void main( String[] args ) throws IOException
    {
    	double interest=0.0;
		Scanner sc = new Scanner(System.in);
        System.out.format("%s", "Enter Principle Amount: \n");
        double principal = sc.nextDouble();
        System.out.format("%s", "Enter Rate: \n");
       double rate = sc.nextDouble();
        System.out.format("%s", "Enter the time in years: \n");
        double time = sc.nextDouble();
        System.out.format("%s", "Would you want to have the Simple Interest? [Y/N] \n");
        char choice = sc.next().toLowerCase().charAt(0);
        if (choice=='y')
        {
        	SI simpleInterest = new SI(principal,rate,time);
        	interest = simpleInterest.getSI();
        }
        else
        {
        	System.out.format("%s", "How many times interest is compounded per year: \n");
        	double number=sc.nextDouble();
        	CI compoundInterest = new CI(principal,rate,time,number);
        	interest = compoundInterest.getCI();
        }
        PrintStream myout =  new PrintStream(new FileOutputStream(FileDescriptor.out));
        myout.print("The interest is : Rs ");
        myout.printf("%3.2f",interest);
        sc.close();
    }
}
