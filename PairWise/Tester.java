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

public class Tester{
	//tests if input is returned if <= 10 charc
	@Test
	public void testTruncateLessThan10(){
		Pairwise p = new Pairwise();
		String test = "longString";
		String result = "longString";
		assertEquals(p.truncate(test),result);
	}
	//tests if trunc input is returned if > 10 charcs
	@Test
	public void testTruncateGreaterThan10(){
		Pairwise p = new Pairwise();
		String test = "longStringThatneedsToBeTruncated";
		String result = "longString";
		assertEquals(p.truncate(test),result);
	}
	//Tests whether validNumofInputs were inputted
	@Test
	public void testInvalidNumInput(){
	Pairwise p = new Pairwise();
		assertTrue(p.isInValidNumInput(1));
	}
	//Tests whether validNumofInputs were inputted
	@Test
	public void testValidNumInput(){
	Pairwise p = new Pairwise();
		assertFalse(p.isInValidNumInput(3));
	}
	//Tests whether validNumofInputs were inputted
	public void testHugeInValidNumInput(){
	Pairwise p = new Pairwise();
		assertFalse(p.isInValidNumInput(33));
	}
	//tests if number of lines of cover < full truth table #
	//lines of TT that are redundant are reflected with '0' value in boolean [] cov
	//These lines are not outputted
	@Test
	public void testNonExaustive6Param(){
		PrintStream originalStream = System.out;
		PrintStream dummyStream = new PrintStream(new OutputStream(){//SUPRESS OUTPUT
			public void write(int b) {
				// NO-OP
			}
		});		
		int numberOfZeros = 0;
		Pairwise p = new Pairwise();
		ArrayList<int[]> inter = p.createInteractions(6);
		int[][] table = p.createTruthTable(7,(int) Math.pow(2,6));
		System.setOut(dummyStream);//SUPPRESS OUTPUT
		boolean[] cov = p.cover(table, inter, (int) Math.pow(2, 6), 6);
		System.setOut(originalStream);//RESET OUTPUT
		for(int i = 0; i < cov.length; i++){
			if(!cov[i]) 
				numberOfZeros ++;
		}
		assertTrue(numberOfZeros > 0);
		
	}
	//tests if number of lines of cover = full truth table #
	//lines of TT that are redundant are reflected with '0' value in boolean [] cov
	//All lines of TT should be kept in 2 arguement case
	@Test
	public void testExaustive2Param(){
		PrintStream originalStream = System.out;
		PrintStream dummyStream = new PrintStream(new OutputStream(){//SUPRESS OUTPUT
			public void write(int b) {
				// NO-OP
			}
		});		
		int numberOfZeros = 0;
		Pairwise p = new Pairwise();
		ArrayList<int[]> inter = p.createInteractions(2);
		int[][] table = p.createTruthTable(2,(int) Math.pow(2,2));
		System.setOut(dummyStream);//SUPPRESS OUTPUT
		boolean[] cov = p.cover(table, inter, (int) Math.pow(2, 2), 2);
		System.setOut(originalStream);//RESET OUTPUT
		for(int i = 0; i < cov.length; i++){
			if(!cov[i]) 
				numberOfZeros ++;
		}
		assertTrue(numberOfZeros == 0);
		
	}	
	//tests if number of lines of cover < full truth table #
	//lines of TT that are redundant are reflected with '0' value in boolean [] cov
	//These lines are not outputted
	@Test
	public void testNonExaustive4Param(){
		PrintStream originalStream = System.out;
		PrintStream dummyStream = new PrintStream(new OutputStream(){//SUPRESS OUTPUT
			public void write(int b) {
				// NO-OP
			}
		});		
		int numberOfZeros = 0;
		Pairwise p = new Pairwise();
		ArrayList<int[]> inter = p.createInteractions(4);
		int[][] table = p.createTruthTable(7,(int) Math.pow(2,7));
		System.setOut(dummyStream);//SUPPRESS OUTPUT
		boolean[] cov = p.cover(table, inter, (int) Math.pow(2, 7), 4);
		System.setOut(originalStream);//RESET OUTPUT
		for(int i = 0; i < cov.length; i++){
			if(!cov[i]) 
				numberOfZeros ++;
		}
		assertTrue(numberOfZeros > 0);
		
	}
	//tests if number of lines of cover < full truth table #
	//lines of TT that are redundant are reflected with '0' value in boolean [] cov
	//These lines are not outputted
	@Test
	public void testNonExaustive7Param(){
		PrintStream originalStream = System.out;
		PrintStream dummyStream = new PrintStream(new OutputStream(){//SUPRESS OUTPUT
			public void write(int b) {
				// NO-OP
			}
		});		
		int numberOfZeros = 0;
		Pairwise p = new Pairwise();
		ArrayList<int[]> inter = p.createInteractions(7);
		int[][] table = p.createTruthTable(7,(int) Math.pow(2,7));
		System.setOut(dummyStream);//SUPPRESS OUTPUT
		boolean[] cov = p.cover(table, inter, (int) Math.pow(2, 7), 7);
		System.setOut(originalStream);//RESET OUTPUT
		for(int i = 0; i < cov.length; i++){
			if(!cov[i]) 
				numberOfZeros ++;
		}
		assertTrue(numberOfZeros > 0);
	}
	//tests whether the correct interactions are generated for 3 variables
	@Test
	public void testGenerateInteractions3(){
	PrintStream originalStream = System.out;
		PrintStream dummyStream = new PrintStream(new OutputStream(){//SUPRESS OUTPUT
			public void write(int b) {
				// NO-OP
			}
		});		
		Pairwise p = new Pairwise();
		ArrayList<int[]> inters = p.createInteractions(3);
		int iterate = 0;
		for(int i = 0; i < 2; i++)
		{
			for(int j = i + 1; j < 3; j++)
			{
				assertEquals(inters.get(iterate)[0],i);
				assertEquals(inters.get(iterate)[1],j);
				iterate++;
			}
		}
	}
	//tests the values created within 3 variable TT
	@Test
	public void testCreateTruthTable3(){
		Pairwise p = new Pairwise();
		int[][] table = p.createTruthTable(3,(int) Math.pow(2,3));
		for(int i = 0; i < Math.pow(2,3); i++)
		{
			for(int j = 0; j < 3; j++)
			{
				assertEquals(table[i][j],(i/(int) Math.pow(2,j)%2));
			}
		}
	}	
	//tests whether makeTester generates correct 2 variable TT 
	@Test
	public void testMakeTester(){
		Pairwise p = new Pairwise();
		ArrayList<int[]> tester = p.makeTester();
		int iterate = 0;
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				assertEquals(tester.get(iterate)[0],i);
				assertEquals(tester.get(iterate)[1],j);
				iterate++;
			}
		}
	}
}	
	