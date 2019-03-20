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

public class Hello
{
    static WebDriver driver = new HtmlUnitDriver();

    // Starts the web page for each test
    @Before
    public void setUp() throws Exception
    {
        driver.get("https://cs1632ex.herokuapp.com");
    }

    // Makes sure that the "Hello" link works properly when clicked if there is nothing trailing
    // on the URL (the string "Hello CS1632, from Prof. Laboon!" should show)
    @Test
    public void testDefaultTrailingUrl()
    {
        try
        {
            driver.findElement(By.linkText("Hello")).click();
            driver.findElement(By.xpath("//*[text()[contains(.,'Hello CS1632, from Prof. Laboon!')]]"));
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that the "Hello" link works properly when clicked if there is something trailing
    // on the URL (the string that is trailing should be shown)
    @Test
    public void testCustomTrailingUrl()
    {
        try
        {
            driver.findElement(By.linkText("Hello")).click();

            String url = driver.getCurrentUrl();
            String temp_url = url + "/Cookie_Monster";
            driver.get(temp_url);

            driver.findElement(By.xpath("//*[text()[contains(.,'Hello CS1632, from Cookie_Monster!')]]"));
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
    public void testHelloHasCorrectHeaders()
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