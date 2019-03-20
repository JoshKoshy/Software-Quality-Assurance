/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author nigelbernard & joshkoshy
 */
public class Elements
{
	public String answer1 = "", answer2 = "";
	ElementUtils u = new ElementUtils();
    String element[];
    String results = "";
    HashMap<String,String> table = new HashMap<String, String>();
    static Elements el = new Elements();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        if(args.length != 1)
        {
            System.out.println("Please enter only one single argument. Program is now closing...");
            System.exit(0);
        }
        el.loadElements();
        el.processStrings(args[0]);       
    }

    public boolean solve(String test, HashMap<String,String> table)
    {
    	//base case - empty string
    	if(test.length() == 0)
    		return true;
    	//test one letter
    	String key = "" + Character.toUpperCase(test.charAt(0));
    	if(table.containsKey(key))
    	{
    		if(solve(test.substring(1), table))
    		{
    			answer1 = " - " + key + answer1;
    			answer2 = " - " + table.get(key) + answer2;
    			return true;
    		}
    	}
    	
    	if(test.length() == 1)
    		return false;
    	
    	key += test.charAt(1);
    	//tests two letters
		if (table.containsKey(key))
		{
			if(solve(test.substring(2), table))
			{
				answer1 = " - " + key + answer1;
				answer2 = " - " + table.get(key) + answer2;
				return true;
			}
		}
    	return false;
    }
    
    public void loadElements()
    {
    	try 
        {
	        File file = new File("elements.txt");	//elements.txt
	        Scanner scanner = new Scanner(file);
	        
	        //splits elements from List, maps name of element to it's abbreviation in HashTable
	        while (scanner.hasNext())
	        {
	        	
	        	element = u.seperateColon(scanner.nextLine());
	        	element[0] = u.remQuotations(element[0]);
	        	element[1] = u.remQuotations(element[1]);
	        	element[1] = u.remComma(element[1]);
	        	element[1] = element[1].substring(1);
				
	        	/*
	        	 * Old string filtering used in first iteration of Elements.java
	        	 * 
	        	element = scanner.nextLine().split(":");
	        	element[0] = element[0].replaceAll("\"", "");
	        	element[1] = element[1].replaceAll("\"", "");
	        	element[1] = element[1].substring(1, element[1].length() - 1);
	            table.put(element[0], element[1]);
				*/
	        	
	        	table.put(element[0], element[1]);
	        }
	        scanner.close();
        } 
        catch (FileNotFoundException e)
        {
        	System.out.println("We could not find the 'elements.txt' file. Program is now closing...");
        	System.exit(0);
        }
    }
    
    public boolean fix(String test, HashMap<String,String> table)
    {
    	test = filter(test);
    	if(solve(test, table))
    	{
    		answer1 = answer1.substring(3);
    		answer2 = answer2.substring(3);
    		return true;
    	}
    	return false;
    }
    
    public void processStrings(String f)
    {
    	try
        {
        	File file2 = new File(f);
        	Scanner scanner2 = new Scanner(file2);
        	
        	String test;
        	
        	while (scanner2.hasNext())
        	{
        		test = scanner2.nextLine();
        		answer1 = "";
        		answer2 = "";
        		if(!test.trim().isEmpty())
        		{
            		if(fix(test, table))
            			results += answer1 + "\n" + answer2 + "\n";
            		else
            			results += "Could not create name \"" + test + "\" out of elements.\n";
        		}
        	}
        	System.out.print(results);
        	scanner2.close();
        }
    	catch(FileNotFoundException e)
        {
        	System.out.println("Either we cannot read your file or your file was not found. Please check that you have entered the correct file name. Program is now closing...");
        	System.exit(0);
        }
    }
    
    public String filter(String s)
    {
    	String t = s.toLowerCase();
		t = t.replaceAll("\\s", "");
		t = u.remNonAlpha(t);
		return t;
    }
}
   
