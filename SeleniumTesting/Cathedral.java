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
import java.util.List;

public class Cathedral
{
    static WebDriver driver = new HtmlUnitDriver();

    // Start at the web page we are testing
    @Before
    public void setUp() throws Exception
    {
        driver.get("https://cs1632ex.herokuapp.com");
    }

    // Makes sure that there is an ordered list on the "Cathedral Pics" page.
    @Test
    public void testListExists()
    {
        try
        {
            driver.findElement(By.linkText("Cathedral Pics")).click();
            List<WebElement> l = driver.findElements(By.tagName("ol"));
            assertEquals(1, l.size());
        }
        catch (NoSuchElementException nseex)
        {
            fail();
        }
    }

    // Makes sure that the an ordered list has 3 pictures of the Cathedral of Learning on
    // the "Cathedral Pics" page.
    @Test
    public void testPicturesExist()
    {
        try
        {
            driver.findElement(By.linkText("Cathedral Pics")).click();
            WebElement ordered_list = driver.findElement(By.tagName("ol"));
            List<WebElement> l = ordered_list.findElements(By.tagName("img"));
            assertEquals(3, l.size());
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
    public void testCathedralHasCorrectHeaders()
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