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

public class Factorial
{
    static WebDriver driver = new HtmlUnitDriver();

    // Starts the web page for each test
    @Before
    public void setUp() throws Exception
    {
        driver.get("https://cs1632ex.herokuapp.com");
    }

    // Makes sure the user is allowed to enter a positive integer (within given range) and after, shows the user the
    // Factorial of the value (5! = 120)
    @Test
    public void testPositiveIntegerInput()
    {
        try
        {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("5");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 5 is 120!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure after the user enters a negative integer, it shows the user the
    // Factorial value of the integer is 1
    @Test
    public void testNegativeInput()
    {
        try
        {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("-1");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of -1 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that the lower boundary inputs are shown their proper Fibonnaci values according
    // to the requirements. Input of 0 should be invalid and therefore, show a Factorial value of 1. 
    // Input of 1 should be valid and show a Factorial value of 1.
    @Test
    public void testLowerBoundaryInput()
    {
        try
        {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("0");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 0 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }

        try
        {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("1");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 1 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that the upper boundary inputs are shown their proper Fibonnaci values according
    // to the requirements. Input of 101 should be invalid and therefore, show a Fibonnaci value of 1. 
    // Input of 100 should be valid and show a the factorial value of 100.
    @Test
    public void testUpperBoundaryInput()
    {
        // Test entering 100
        try
        {        	
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("100");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 100 is 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
        
        try
        {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("101");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 101 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that an input of an integer above 100 is handled properly
    @Test
    public void testOutOfRange()
    {
        try
        {
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("110");
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 110 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }
    
    // Makes sure that when a string is used as input, the program considers it invalid input
    @Test
    public void testTextInput()
    {
        try
        {
            // Test entering a String
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("asdf");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of asdf is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that when a decimal is used as input, the program considers it invalid input
    @Test
    public void testDecimalInput()
    {
        try
        {
            // Test entering a decimal
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("0.111");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of 0.111 is 1!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that when no input is used, the program considers it invalid input
    @Test
    public void testNoInput()
    {
        try
        {
            // Test entering nothing
            driver.findElement(By.linkText("Factorial")).click();
            driver.findElement(By.name("value")).sendKeys("");
            driver.findElement(By.cssSelector("input[type='submit']")).click();

            driver.findElement(By.xpath("//*[text()[contains(.,'Factorial of is 1!')]]"));
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
    public void testFactorialHasCorrectHeaders()
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