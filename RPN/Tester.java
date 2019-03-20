import java.util.HashMap;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;

public class Tester{
    
	@Test
	public void testOutput1(){ //happy trail
		RPN r = new RPN();
		r.repl_mode = true;
		String test = "4 3 +";
		String result = "7";
		assertEquals(result, r.interpret(test));
	}
	public void testOutput2(){ //negative numbers
		RPN r = new RPN();
		String test = "-1 -2 *";
		String result = "2";
		assertEquals(result, r.solve(test).toString());
	}
	@Test
	public void testOutput3(){ //lots of operators
		RPN r = new RPN();
		String test = "10 10 * 5 5 * 0 0 * + +";
		String result = "125";
		assertEquals(result, r.interpret(test));
	}
	@Test
	public void testOutput4(){ //happy trail
		RPN r = new RPN();
		String test = "90 9 *";
		String result = "810";
		assertEquals(result, r.interpret(test));
	}
	@Test
	public void testOutput5(){ //big numbers
		RPN r = new RPN();
		String test = "999999999999999999 999999999999999999 *";
		String result = "999999999999999998000000000000000001";
		assertEquals(result, r.interpret(test));
	}
	@Test
	public void testOutput6(){ //done
		RPN r = new RPN();
		r.interpret("LET a 10");
		String test = ("a 7 *");
		String result = "70";
		assertEquals(result, r.solve(test));
	}
	public void testOutput7(){ //done
		RPN r = new RPN();
		String test = ("67 7 -");
		String result = "60";
		assertEquals(result, r.solve(test));
	}
		public void testOutput8(){ //happy trail
		RPN r = new RPN();
		String test = "90 9 +";
		String result = "99";
		assertEquals(result, r.interpret(test));
	}
	@Test
	public void testOutput9(){ //big numbers
		RPN r = new RPN();
		r.interpret("Let b 1");
		String test = "b 109 +";
		String result = "110";
		assertEquals(result, r.interpret(test));
	}
	public void testOutput10(){ //done
		RPN r = new RPN();
		String test = ("5 1 /");
		String result = "5";
		assertEquals(result, r.interpret(test));
		
	}	public void testOutput11(){ //done
		RPN r = new RPN();
		String test = ("LET a 1");
		String result = "1";
		assertEquals(result, r.interpret(test));
	}
		public void testOutput12(){ //done
		RPN r = new RPN();
		String test = ("LET b 3");
		String result = "3";
		assertEquals(result, r.interpret(test));
	}
		public void testOutput13(){ //done
		RPN r = new RPN();
		
		String test = ("100 1 *");
		String result = "100";
		assertEquals(result, r.interpret(test));
	}
		public void testOutput14(){ //done
		RPN r = new RPN();

		String test = ("2 0 +");
		String result = "2";
		assertEquals(result, r.interpret(test));
	}
	public void testOutput15(){ //done
		RPN r = new RPN();
		String test = ("780 1 *");
		String result = "780";
		assertEquals(result, r.interpret(test));
	}
	public void testOutput16(){ //done
		RPN r = new RPN();
		String test = ("55 4 +");
		String result = "220";
		assertEquals(result, r.interpret(test));
	}
	public void testOutput17(){ //done
		RPN r = new RPN();
		r.interpret("LET a 1");
		String test = ("a 1 +");
		String result = "2";
		assertEquals(result, r.interpret(test));
	}
	public void testOutput18(){ //done
		RPN r = new RPN();
		r.interpret("LET a 1");
		String test = ("PRINT a 8 *");
		String result = "8";
		assertEquals(result, r.interpret(test));
	}
		public void testOutput19(){ //done
		RPN r = new RPN();
		String test = ("90 2 +");
		String result = "92";
		assertEquals(result, r.interpret(test));
	}
		public void testOutput20(){ //done
		RPN r = new RPN();
		String test = ("QUIT");
		String result = "";
		assertEquals(result, r.interpret(test));
	}
	//REQUIREMENT: 4. Variable names can be a single letter (A-Z) and are case-insensitive (e.g., a and A refer to the same variable.
	//REQUIREMENT: 7. Keywords shall be case-insensitive (e.g. print, PRINT, or pRiNt are interchangeable)
	//generates a string w/ lowercase letters and ensures it is properly changed to uppercase letters
	//REQUIREMENT: 19. If an expression used for initializing a LET variable is invalid, the variable is considered to have not been initialized. 
	//tests that an invalid initialization will not initialize a variable
}