/*
 *  Josh Koshy
 *  CS 1632 Fall 2017
 *  Professor Laboon
 *  30 October 2017
 */

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import static org.junit.Assert.*;
import java.util.logging.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Fibonacci
{
    static WebDriver driver = new HtmlUnitDriver();

    // Starts the web page for each test
    @Before
    public void setUp() throws Exception
    {
        driver.get("https://cs1632ex.herokuapp.com");
    }

    // Makes sure the user is allowed to enter a positive integer (within given range) and after, shows the user the
    // Fibonacci of the value (Input of 5 should show a Fibonnaci value of 8)
    @Test
    public void testPositiveIntegerInput2()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("5");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 5 is 8!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure after the user enters a negative integer, it shows the user the
    // Fibonnaci value of the integer is 1
    @Test
    public void testNegativeIntegerInput2()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("-1");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of -1 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that the lower boundary inputs are shown their proper Fibonnaci values according
    // to the requirements. Input of 0 should be invalid and therefore, show a Fibonnaci value of 1. 
    // Input of 1 should be valid and show a Fibonnaci value of 1.
    @Test
    public void testLowerEdgeCases2()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("0");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 0 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
        
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("1");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 1 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that the upper boundary inputs are shown their proper Fibonnaci values according
    // to the requirements. Input of 101 should be invalid and therefore, show a Fibonnaci value of 1. 
    // Input of 100 should be valid and show a Fibonnaci value of 354224848179261915075.
    @Test
    public void testUpperEdgeCases2()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("100");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 100 is 354224848179261915075!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }

        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("101");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 101 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that an input of an integer above 100 is handled properly
    @Test
    public void testOutOfRange2()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("110");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 110 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    
    
    // Makes sure that when a string is used as input, the program considers it invalid input
    @Test
    public void testTextInput2()
    {
        try
        {
            // Testing entering a String
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("asdf");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of asdf is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that when a decimal is used as input, the program considers it invalid input
    @Test
    public void testDecimalInput2()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("0.123");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of 0.123 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that when no input is used, the program considers it invalid input
    @Test
    public void testNoInput2()
    {
        try
        {
            driver.findElement(By.linkText("Fibonacci")).click();
            driver.findElement(By.name("value")).sendKeys("");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Fibonacci of is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }
    
    // Makes sure that there are 5 headers listed with
    // the specified names: "CS1632 D3 Home", "Factorial",
    // "Fibonacci", "Hello", and "Cathedral Pics"
    @Test
    public void testFibonacciHasCorrectHeaders()
    {
        try
        {
            driver.findElement(By.linkText("CS1632 D3 Home"));
            driver.findElement(By.linkText("Factorial"));
            driver.findElement(By.linkText("Fibonacci"));
            driver.findElement(By.linkText("Hello"));
            driver.findElement(By.linkText("Cathedral Pics"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }
}