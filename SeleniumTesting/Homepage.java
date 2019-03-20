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

public class Homepage
{
    static WebDriver driver = new HtmlUnitDriver();

    // Starts the web page for each test
    @Before
    public void setUp() throws Exception
    {
        driver.get("https://cs1632ex.herokuapp.com/");
    }

	// Makes sure that the homepage displays the string: "Welcome, friend, to a land of pure calculation"
    @Test
    public void testDisplayText1()
    {
        try
        {
            driver.findElement(By.xpath("//*[text()[contains(.,'Welcome, friend, to a land of pure calculation')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that the homepage displays the string: "Used for CS1632 Software Quality Assurance, taught by Bill Laboon"
    @Test
    public void testDisplayText2()
    {
        try
        {
            driver.findElement(By.xpath("//*[text()[contains(.,'Used for CS1632 Software Quality Assurance, taught by Bill Laboon')]]"));
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
    public void testHomepageHasCorrectHeaders()
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