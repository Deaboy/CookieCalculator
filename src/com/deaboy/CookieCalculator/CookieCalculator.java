package com.deaboy.CookieCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CookieCalculator
{
	private static final double priceIncrease = 1.15;
	private static final long basePrices[] = {
		15L,
		100L,
		500L,
		3000L,
		10000L,
		40000L,
		200000L,
		1666666L,
		123456789L,
		3999999999L
	};
	
	public static void main(String[] args)
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		BuildingType type;
		int start;
		int end;
		long cost;
		
		System.out.println("Cookie Clicker Construction Cost Calculator");
		System.out.println("Written by Daniel Andrus on 10/2/2013\n");
		
		type = null;
		start = -1;
		end = -1;
		
		if (args.length > 0)
		{
			type = BuildingType.fromString(args[0]);
			if (type == null) {
				type = promptForType(in);
			}
		}
		if (args.length > 1)
		{
			try {
				start = Integer.parseInt(args[1]);
			}
			catch (NumberFormatException e) {
				start = -1;
			}
		}
		if (args.length > 2)
		{
			try {
				end = Integer.parseInt(args[2]);
			}
			catch (NumberFormatException e) {
				end = -1;
			}
		}
		
		do
		{
			
			// Get type
			if (type == null)
			{
				type = promptForType(in);
			}
			
			// Get starting amount
			if (start < 0)
			{
				start = promptForStart(in, type);
			}
			
			// Get target amount
			if (end < 0)
			{
				end = promptForEnd(in, type);
			}
			
			// Calculate total cost in cookies
			cost = calculateCost(type, start, end);
			
			
			// Output results
			System.out.println();
			System.out.println("It will cost you " + String.format("%,d", cost) + " cookies to buy " + (end - start) + " more " + type.getName((end - start) == 1 ? false : true) + ".");
			System.out.println("Building Type:  " + type.getName(false));
			System.out.println("Current Amount: " + start);
			System.out.println("Target Amount:  " + end);
			System.out.println("TOTAL COST: " + String.format("%,d", cost) + " cookies.\n\n");
			
			type = null;
			start = end = -1;
		}
		while (promptForRestart(in));
		
		System.out.println("\nThank you for using Deaboy's Cookie Clicker Construction Cost Calculator.");
	}
	
	private static BuildingType promptForType(BufferedReader in)
	{
		BuildingType type;
		String input;
		
		do
		{
			System.out.println("Here are Cookie Clicker's building types:");
			System.out.println("  0.  Cursor");
			System.out.println("  1.  Grandma");
			System.out.println("  2.  Farm");
			System.out.println("  3.  Factory");
			System.out.println("  4.  Mine");
			System.out.println("  5.  Shipment");
			System.out.println("  6.  Alchemy lab");
			System.out.println("  7.  Portal");
			System.out.println("  8.  Time machine");
			System.out.println("  9.  Antimatter condenser");
			System.out.print("Please enter a building type: ");
			try {
				input = in.readLine().toLowerCase();
				type = BuildingType.fromString(input);
			} catch (IOException e) {
				type = null;
			}
		}
		while (type == null);
		
		return type;
	}
	private static int promptForStart(BufferedReader in, BuildingType type)
	{
		int start;
		
		do
		{
			System.out.print("Current number of " + type.getName(true) + ": ");
			try
			{
				start = Integer.parseInt(in.readLine());
			}
			catch (NumberFormatException e) {
				start = -1;
			} catch (IOException e) {
				start = -1;
			}
		}
		while (start < 0);
		
		return start;
	}
	private static int promptForEnd(BufferedReader in, BuildingType type)
	{
		int end;
		
		do
		{
			System.out.print("Target number of " + type.getName(true) + ":  ");
			try
			{
				end = Integer.parseInt(in.readLine());
			}
			catch (NumberFormatException e) {
				end = -1;
			} catch (IOException e) {
				end = -1;
			}
		}
		while (end < 0);
		
		return end;
	}
	private static boolean promptForRestart(BufferedReader in)
	{
		do
		{
			System.out.print("\nWould you like to go again (y/n)? ");
			try
			{
				String input = in.readLine().toLowerCase();
				
				if (input.equals("yes") || input.equals("y"))
					return true;
				else if (input.equals("no") || input.equals("n"))
					return false;
				else if (input.equals("leroy"))
					System.out.println("LEEEEEERROOOOOOOOY JEEEENKIIINS!");
				else if (input.equals("ping"))
					System.out.println("pong");
				else if (input.equals("sing"))
				{
					System.out.println("\nYou never know what you will find,");
					try { Thread.sleep(1500); } catch (InterruptedException e) { /* Do nothing */ }
					System.out.println("Shaping a world that's in your mind,");
					try { Thread.sleep(1500); } catch (InterruptedException e) { /* Do nothing */ }
					System.out.println("See for yourself and walk with me!");
					try { Thread.sleep(1500); } catch (InterruptedException e) { /* Do nothing */ }
					System.out.println("A world of wonder, land of beauty,");
					try { Thread.sleep(1500); } catch (InterruptedException e) { /* Do nothing */ }
					System.out.println("Across the mountains and over the sea,");
					try { Thread.sleep(100); } catch (InterruptedException e) { /* Do nothing */ }
					System.out.println("But I still haven't found any diamonds.");
				}
				else if (input.startsWith("boo"))
					System.out.println("GAH! Stop that!");
				else if (input.startsWith("siri"))
					System.out.println("Don't call me Siri, I'm not your slave.");
				else if (input.equals("lemonpledge"))
					System.out.println("I DEMAND MORE LEMON PLEDGE!");
				else if (input.startsWith("say my name"))
				{
					try { Thread.sleep(1000); } catch (InterruptedException e) { /* Do nothing. */ }
					System.out.println("...");
					try { Thread.sleep(2000); } catch (InterruptedException e) { /* Do nothing. */ }
					System.out.println("Heisenberg");
					try { Thread.sleep(2000); } catch (InterruptedException e) { /* Do nothing. */ }
				}
				else
					System.out.println("Sorry, I didn't catch that.");
				
				// What's wrong with me...
			}
			catch (IOException e)
			{
				System.out.println("Sorry, there was an error.");
			}
		}
		while (true);
	}
	
	private static long calculateCost(BuildingType type, int start, int end)
	{
		long cost = 0;
		for (int i = start; i < end; i++)
		{
			cost += basePrices[type.ordinal()] * Math.pow(priceIncrease, i);
		}
		return cost;
	}
	
}
