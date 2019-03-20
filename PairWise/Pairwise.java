import java.util.ArrayList;

public class Pairwise {
	 /**
	 * Makes list of interactions, designated by width/column number
	 */
	public static ArrayList<int[]> createInteractions(int num) {
		ArrayList<int[]> inters = new ArrayList<int[]>();
		for (int i = 0; i < num - 1; i++) {
			for (int j = i + 1; j < num; j++) {
				int[] row = {i, j};
				inters.add(row);
			}
		}
		return inters;
	}
	
	/**
	 * Makes exhaustible truth table
	 * @ param Integer width  number of columns
	 * @ param Integer rows  number of rows
	 * @return Integer[][] table  Exhaustible truth table array
	 */
	public static int[][] createTruthTable(int width, int rows) {
		int bool_vals;
		
		int[][] table = new int[rows][width];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < width; j++) {
				bool_vals = i / (int) Math.pow(2,j) % 2;
				table[i][j] = bool_vals;
			}
		}
		return table;
	}
	
	/**
	 * Display final string version of entire fixed truth-table after using a cover array
	 */
	public static boolean[] cover(int[][] table, ArrayList<int[]> inter, int rows, int width) {
	
		ArrayList<int[]> tt_tester = makeTester();
		boolean[] check = new boolean[rows];
		
		for (int a = 0; a < check.length; a++) {
			check[a] = false;
		}
		
		//For each interaction [(0,0) (0,1) (1,1)]
		for (int i = 0; i < inter.size(); i++) {

			int[] current_inter = inter.get(i);
			//For each truth-table possible pairing
			for (int j = 0; j < tt_tester.size(); j++) {
				//For each row
				for (int k = 0; k < rows; k++) {		
					//gets current pairing to test against row in table
					int[] current_test = tt_tester.get(j);	
					//tests current pairing against row in table
					if (current_test[0] == table[k][current_inter[0]] 
							&& current_test[1] == table[k][current_inter[1]]) {
						check[k] = true;
						break;
					}
				}
			}
		}
		
		for (int c = 0; c < rows; c++) {
			if (check[c]) {
				for (int d = 0; d < width; d++) {
					System.out.print(table[c][d] + "\t");
				}
				System.out.print("\n");
			}
		}
		
		return check;
	}
	
	/**
	 * Makes 2x2 truth-table filled and useable for a cover array
	 * @return ArrayList of Integer Array tester  A useable cover array
	 */
	public static ArrayList<int[]> makeTester() {
		ArrayList<int[]> tester = new ArrayList<int[]>();
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int[] pair = new int[2];

				pair[0] = i;
				pair[1] = j;
				tester.add(pair);
			}
		}
		
		return tester;
	}
	
	/**
	 * Main program init.
	 * @ param args  the user's arguments/input
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
            System.out.println("Please enter at least two parameters!");
            System.exit(0);
        }
		
		StringBuffer list = new StringBuffer();
		int width = args.length;
		int rows = (int) Math.pow(2, width);
		
		for (int i = 0; i < width; i++) {
			if (args[i].length() > 10) {
				args[i] = args[i].substring(0, 10);
			}
			list.append(args[i] + "\t");
		}
		int[][] table = createTruthTable(width, rows);
		
		ArrayList<int[]> inter = createInteractions(width);
		System.out.println(list.toString());
		boolean[] amt = cover(table, inter, rows, width);
	}
	
	
	
}