import java.util.HashMap;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Tester{
	//generates a string w/ non-alpha numeric characters and evaluates whether these have been removed(test Fixer)
	@Test
	public void testAlphaRemoval(){
		ElementUtils f = new ElementUtils();
		String test = "11cor87823r432ect2";
		String result = "correct";
		assertEquals(f.remNonAlpha(test),result);
	}
	@Test
	public void testSeperateColon(){
		ElementUtils f = new ElementUtils();
		String array[] = new String[2];
		String test = "this:is";
		array = f.seperateColon(test);
		assertEquals(array[0],"this");
		assertEquals(array[1],"is");
	}
	//generates a string w/ commas and evaluates whether these have been removed(test Fixer)
	@Test
	public void testCommaRemoval(){
		ElementUtils f = new ElementUtils();
		String test = "cor,,,,r,ect";
		String result = "correct";
		assertEquals(f.remComma(test),result);
	}
	
	//takes a valid string and makes sure it matches elements
	@Test
	public void testMatch(){
		Elements el = new Elements();
		ElementUtils f = new ElementUtils();
		el.loadElements();
		el.fix("flick alba",el.table);
		assertEquals("F - Li - C - K - Al - Ba",el.answer1);
		//should print Fl I C K Al Ba
	}
	//Takes a string that has incorrect double letter solution but correct first one letter solution
	//determines if backtracking algorithm is working correctly
	
	@Test
	public void testBacktrackingAlg1Letter(){
		Elements el = new Elements();
		el.loadElements();
		el.fix("kin",el.table);
		assertEquals("K - I - N",el.answer1);
		//K I N 
		
	}
	//Tests whether a search for a given abbrev returns correct element 
	@Test
	public void testMatchingHashAbbrev(){
		Elements el = new Elements();
		ElementUtils f = new ElementUtils();
		el.loadElements();
		el.fix("Cm", el.table);
		assertEquals(el.answer1,"Cm");
		//hash should return Curium
	}
	//Tests whether quotations are removed from a given string
	@Test
	public void testRemQuotations(){
		ElementUtils f = new ElementUtils();
		String test = "tester\"something\"";
		String result = "testersomething";
		assertEquals(f.remQuotations(test),result);
		
	}
	//generates a string w/ lowercase letters and ensures it is properly changed to uppercase letters
	@Test
	public void testCaseInsensitivity(){
		ElementUtils f = new ElementUtils();
		String test = "tester";
		String result = "TESTER";
		assertEquals(f.toUpperCase(test),result);
	}
	//generates a string with no solution and ensures it returnsNoSolution (hash search)
	@Test
	public void testRemEmpty(){
		ElementUtils f = new ElementUtils();
		String test = "t es te       r";
		String result = "tester";
		assertEquals(f.remEmpty(test),result);
		
	}
	//generates a string w/ correct 2 letter solution but incorrect 1 letter solution(hash search)
	@Test
	public void testBacktrackingAlg2Letter(){
		Elements el = new Elements();
		ElementUtils f = new ElementUtils();
		el.loadElements();
		el.fix("fever",el.table);
		assertEquals("Fe - V - Er",el.answer1);
		//Using F will not work, but using Fe will result in solution
		//Fe V Er
	}
	//tests results (output) when a valid string is passed in
	
	@Test
	public void testProcessStringsValid(){
		PrintStream originalStream = System.out;
		PrintStream dummyStream = new PrintStream(new OutputStream(){//SUPRESS OUTPUT
			public void write(int b) {
				// NO-OP
			}
		});		
		String original = "fe";
		try(PrintWriter out = new PrintWriter("foo.txt")){
    		out.println(original);
		}
		catch(FileNotFoundException f){
			assertEquals(1,0);//fail
		}
		Elements el = new Elements();
		ElementUtils f = new ElementUtils();
		el.loadElements();
		System.setOut(dummyStream);//SUPPRESS OUTPUT
		el.processStrings("foo.txt");
		//RESET OUTPUT
		System.setOut(originalStream);
		assertEquals("Fe" + "\n" + "Iron" + "\n",el.results);
	//tests results (output) when a invalid string is passed in
	}
	@Test
	public void testProcessStringsInvalid(){
		PrintStream originalStream = System.out;
		PrintStream dummyStream = new PrintStream(new OutputStream(){//SUPRESS OUTPUT
			public void write(int b) {
				// NO-OP
			}
		});
		String original = "supercalifragilous";
		try(PrintWriter out = new PrintWriter("foo.txt")){
    		out.println(original);
		}
		catch(FileNotFoundException f){
			assertEquals(1,0);//fail
		}
		//write string to a file
		Elements el = new Elements();
		ElementUtils f = new ElementUtils();
		el.loadElements();
		System.setOut(dummyStream);//SUPPRESS OUTPUT
		el.processStrings("foo.txt");
		//RESET OUTPUT
		System.setOut(originalStream);
		assertEquals("Could not create name \"" + original + "\" out of elements.\n",el.results);
	} 

	

}