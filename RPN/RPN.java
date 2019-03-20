import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RPN {
	public static BigInteger[] vars = new BigInteger[26];
	public static int n = 0;
	public static boolean repl_mode;
	public static boolean letting = false;
	
	/**
	 * Initializing the main program.
	 * @param args - files to be read (meant for .rpn format, but can handle .txt as well)
	 */
	public static void main(String[] args) {
		try {
			Scanner scanner = null;
			String line;
			String nl;
			
			for (int i = 0; i < vars.length; i++) {
				vars[i] = null;
			}
			
			if (args.length > 0) {
				repl_mode = false;
				ArrayList<File> files = new ArrayList<File>();
				
				for (int i = 0; i < args.length; i++) {
					nl = null;
					files.add(new File(args[i]));
					scanner = new Scanner(files.get(i));
					while (scanner.hasNextLine()) {
						nl = scanner.nextLine();
						if (!nl.isEmpty()) {
							n++;
							line = nl.toUpperCase();
							if (line.equals("")) {
								break;
							}
							interpret(line);
						}
					}
				}
		        
				scanner.close();
				System.exit(1);
			} else {
				repl_mode = true;
				scanner = new Scanner(System.in);
				
				do {
					n++;
					System.out.print("> ");
					line = scanner.nextLine().toUpperCase();
					if (line.equals("")) {
						break;
					}
					interpret(line);
				}
				while (!line.equals(""));
				scanner.close();
				System.exit(1);
			}
		} catch (Throwable e) {
			System.err.println(e);
			System.exit(5);
		}
	}
	
	/**
	 * Utilized to interpret each line of the user/file
	 * @param line - the line to be interpreted
	 * @return the line to be printed after the line scanned as the answer/response
	 */
	public static String interpret(String line) {
		String answer = "Error";
		
		if (line.startsWith("LET ")) {
			letting = true;
			answer = "" + store(line.substring(4));
			if (repl_mode) {
				if (!answer.equals("null")) {
					System.out.println(answer);
				}
			}
			letting = false;
		} else if (line.startsWith("PRINT ")) {
			answer = "" + solve(line.substring(6));
			if (!answer.equals("null")) {
				System.out.println(answer);
			}
		} else if (line.startsWith("QUIT")) {
			System.exit(1);
		} else {
			answer = "" + solve(line);
			if (repl_mode) {
				if (!answer.equals("null")) {
					System.out.println(answer);
				}
			}
		}
		
		return answer;
	}
	
	/**
	 * Utilized for the "LET" command. Stores variables and initializes arithmetic for what is to be stored.
	 * @param line - the line interpreted w/out the "LET " substring
	 * @return the BigInteger value of what is to be stored
	 */
	public static BigInteger store(String line) {
		BigInteger answer = null;
		if (line.length() != 1) {
			if (line.substring(0, 1).matches("[A-Z]{1}") && line.charAt(1) == ' ') {
				answer = solve(line.substring(2));
				vars[Character.getNumericValue(line.charAt(0)) - 10] = answer;
			} else {
				answer = null;
			}
		} else {
			operatorEmptyStackException("LET");
			if (!repl_mode) {
				System.exit(2);
			} else {
				return null;
			}
		}
		
		return answer;
	}
	
	/**
	 * The arithmetic procedure for storing and operating numbers (handles integer overflow as well)
	 * @param line - the equation that is to be solved
	 * @return the Biginteger value of what is to be solved
	 */
	public static BigInteger solve(String line) {
		Stack<BigInteger> stack = new Stack<BigInteger>();
		String[] tokens = line.split("[\\s,]+");
		BigInteger answer;
		BigInteger pop1;
		BigInteger pop2;
		
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] != null) {
				if (tokens[i].matches("[A-Z]{1}")) {
					if (vars[Character.getNumericValue(tokens[i].charAt(0)) - 10] == null) {
						System.err.println("Line " + n + ": Variable " + tokens[i].charAt(0) 
								+ " is not initialized");
						if (!repl_mode) {
							System.exit(1);
						} else {
							return null;
						}
					}
					stack.push(vars[Character.getNumericValue(tokens[i].charAt(0)) - 10]);
				} else if (tokens[i].matches("[-+]?\\d*\\.?\\d+")) {
					stack.push(new BigInteger(tokens[i]));
				} else {
					if (tokens[i].equals("+")) {
						if (stack.empty()) {
							operatorEmptyStackException("+");
							if (!repl_mode) {
								System.exit(2);
							} else {
								return null;
							}
						}
						pop1 = stack.pop();
						if (stack.empty()) {
							operatorEmptyStackException("+");
							if (!repl_mode) {
								System.exit(2);
							} else {
								return null;
							}
						}
						pop2 = stack.pop();
						stack.push(pop2.add(pop1));
					} else if (tokens[i].equals("-")) {
						if (stack.empty()) {
							operatorEmptyStackException("-");
							if (!repl_mode) {
								System.exit(2);
							} else {
								return null;
							}
						}
						pop1 = stack.pop();
						if (stack.empty()) {
							operatorEmptyStackException("-");
							if (!repl_mode) {
								System.exit(2);
							} else {
								return null;
							}
						}
						pop2 = stack.pop();
						stack.push(pop2.subtract(pop1));
					} else if (tokens[i].equals("*")) {
						if (stack.empty()) {
							operatorEmptyStackException("*");
							if (!repl_mode) {
								System.exit(2);
							} else {
								return null;
							}
						}
						pop1 = stack.pop();
						if (stack.empty()) {
							operatorEmptyStackException("*");
							if (!repl_mode) {
								System.exit(2);
							} else {
								return null;
							}
						}
						pop2 = stack.pop();
						stack.push(pop2.multiply(pop1));
					} else if (tokens[i].equals("/")) {
						if (stack.empty()) {
							operatorEmptyStackException("/");
							if (!repl_mode) {
								System.exit(2);
							} else {
								return null;
							}
						}
						pop1 = stack.pop();
						if (stack.empty()) {
							operatorEmptyStackException("/");
							if (!repl_mode) {
								System.exit(2);
							} else {
								return null;
							}							
						}
						pop2 = stack.pop();
						stack.push(pop2.divide(pop1));
					} else {
						if (tokens[i].equals("LET") || tokens[i].equals("PRINT")) {
							System.err.println("Line " + n 
									+ ": Could not evaluate expression");
							System.exit(5);
						} else {
							System.err.println("Line " + n 
									+ ": Unknown keyword " + tokens[i]);
							if (!repl_mode) {
								System.exit(4);
							} else {
								return null;
							}
						}
					}
				}
			}
		}
		
		answer = stack.pop();
		if (stack.isEmpty()) {
			return answer;
		} else {
			if (letting) {
				return null;
			} else {
				System.err.println("Line " + n + ": " 
						+ (stack.size() + 1) + " elements in stack after evaluation");
				if (!repl_mode) {
					System.exit(3);
				} else {
					return null;
				}
			}
		}
		return null;
	}
	
	/**
	 * Exception shorthand for an Operator being applied to an empty stack
	 * @param op - the Operator being applied
	 */
	public static void operatorEmptyStackException(String op) {
		System.err.println("Line " + n + ": Operator " + op + " applied to empty stack");
	}
}
