import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.concurrent.TimeUnit;

public class Test{

	//generates a string w/ non-alpha numeric characters and evaluates whether these have been removed(test Fixer)
	@Test
	public void testRemoval(){
	}
	
	//takes a valid string and makes sure it matches elements
	@Test
	public void testMatch(){
		String tester = "";
	}
	//Takes a filename that does not exist and ensures that method recognizes that (test InValid)
	@Test
	public void testInvalidFile(){	
		String filename = "";
		assertEquals(0, testValidFile(filename);//0 means file not found
	}
	//Takes a filename that does exits and ensures method recognizes that method recognizes (test InValid)
	
	@Test
	public void testValidFile(){	
		String filename = "";
		assertEquals(1, testValidFile(filename);//1 means file found
	}
	//Takes a string that has incorrect single first letter solution but correct first two letter solution
	//determines if backtracking algorithm is working correctly
	
	@Test
	public void testBacktrackingAlg1Letter(){
		String tester = "";
	}
	//Tests whether a search for a given abbrev returns correct element 
	@Test
	public void testMatchingHashAbbrev(){
		String tester = "";
		//hash find function
	}
	//Tests whether strings are seperated by colons and commas?
	@Test
	public void testSeperation(){
		String tester = "";
	}
	//Tests if user enters file with emptylines if emptylines will be ignored
	@Test
	public void testEmptyLinesIgnored(){
		String tester = "";
	}
	
	//Tests that the user does not output anything when an emptyFile is Found
	@Test
	public void emptyFileFound(){
		String tester = "";
	}
	//generates a string w/ upperCaseLetters and ensures it still reaches a solution(hash search)
	@Test
	public void testCaseInsensitivity(){
		String tester = "";
	}
	//generates a string with no solution and ensures it returnsNoSolution (hash search)
	@Test
	public void testNoSolution(){
		
	}
	//generates a string w/ correct 2 letter solution but incorrect 1 letter solution(hash search)
	@Test
	public void testBacktrackingAlg2Letter(){
	
	}
	
	
	
	
	

	



}