import java.util.ArrayList;
import java.util.Random;

// создание матрицы с рандомными элементами 

public class Matrix {
	
	public static boolean[][] createBOOLEAN(int size) {
		
		boolean A[][] = new boolean[size][size];
		
		Random rnd = new Random(System.currentTimeMillis());
		
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				A[i][j] = rnd.nextBoolean();
		
		return A;
		
	}
	
	//--------------------------------------------------------------//
	public static void printBOOLEAN(boolean A[][], char c1, char c2) {
		
		System.out.print("        |");
		for (int i = 0; i < A[0].length; i++) {
			System.out.print(c1 + "(" + i + ") ");
		}
		System.out.println();
		
		System.out.print("        |ЧЧЧЧ");
		for (int i = 0; i < A[0].length - 1; i++) {
			System.out.print("ЧЧЧЧЧ");
		}
		System.out.println();

		for (int i = 0; i < A.length; i++) {
			System.out.print("   " + c2 + "(" + i + ") |");
			for (int j = 0; j < A[0].length; j++) {				
				if (A[i][j] == true) System.out.print("  " + 1 + " ");
					else System.out.print("  " + 0 + " ");
				if (j < A[0].length - 1) System.out.print(" ");	        				
			}			
			if (i < A.length - 1) System.out.print("\n");	        			
		}		
	}
	
	public static void printDescription(int A[][]) {	  	
		
		for (int i = 0; i < A.length; i ++)  
			System.out.println("        a(" + i + ") = {x(" + A[i][0] + "), x(" + A[i][1] + ")}");
		
	}
	
	//---------------------------------------------------------//
	public static boolean[][] getIncidenceMatrix(boolean A[][]) {
		
		int num = 0; // число дуг
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < A[0].length; j++) 
				if (A[i][j]) num++;
		
		boolean B[][] = new boolean[A.length][num];
		
		int k = 0;
		for (int i = 0; i < A.length; i++) 			
			for (int j = 0; j < A[0].length; j++) 
				if (A[i][j] && (i != j)) {
					B[i][k] = true;
					B[j][k] = true;
					k++;
				}

		return B;
		
	}
	
	public static int[][] getDescription(boolean A[][]) { // A -- матрица инциденций
		
		int B[][] = new int[A[0].length][2];
		
		int k = 0;
		boolean f = true;
		
		for (int i = 0; i < A[0].length; i++) 
			for (int j = 0; j < A.length; j++) 
				if (A[j][i]) {
					
					if (f) {
						B[k][0] = j;						
					} else {
						B[k][1] = j;
						k++;
					}
					
					f = !f;					
				}
		
		
		return B;
		
	}
	
}
