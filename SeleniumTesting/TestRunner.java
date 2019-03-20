/*
 *  Josh Koshy
 *  CS 1632 Fall 2017
 *  Professor Laboon
 *  30 October 2017
 */

import java.util.ArrayList;
import java.util.logging.*;

import org.junit.runner.*;
import org.junit.runner.notification.*;

public class TestRunner {
    public static void main(String[] args) {

		ArrayList<Class> classesToTest = new ArrayList<Class>();
		boolean anyFailures = false;
	
		// ADD ANY MORE CLASSES YOU WISH TO TEST HERE
		
		classesToTest.add(Homepage.class);
		classesToTest.add(Hello.class);
		classesToTest.add(Factorial.class);
		classesToTest.add(Fibonacci.class);
		classesToTest.add(Cathedral.class);
		
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
	    java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

		
		// For all test classes added, loop through and use JUnit
		// to run them.
		
		for (Class c: classesToTest) {
		    Result r = JUnitCore.runClasses(c);
	
		    // Print out any failures for this class.
	      
		    for (Failure f : r.getFailures()) {
			System.out.println(f.toString());
		    }
	
		    // If r is not successful, there was at least one
		    // failure.  Thus, set anyFailures to true - this
		    // can never be set back to false (no amount of
		    // successes will ever eclipse the fact that there
		    // was at least one failure.
		    
		    if (!r.wasSuccessful()) {
			anyFailures = true;
		    }
		    
		}
		
		// After completion, notify user if all tests passed or any failed.
		
		if (anyFailures) {
		    System.out.println("\n!!! - At least one failure, see above.");
		} else {
		    System.out.println("\nALL TESTS PASSED");
		} 
    }
} 
