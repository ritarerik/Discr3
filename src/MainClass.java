import java.util.Scanner;

public class MainClass {

	public static void main(String args[])
	{
		
		boolean exit = false;
		Scanner in = new Scanner(System.in);
		
		while (!exit) {
			
			System.out.println("> Размерность матрицы >> (4;8)");
			System.out.println("> Выход >> 0");
			System.out.print("\n  >> ");
			
			int size = 0;			
			
			try { 
				size = in.nextInt(); 
				
				if (size == 0) exit = true;
				else if (size < 4 || size > 8) throw new Exception();
				
			} catch (Exception e) { 
				System.out.println("\n> Неверный ввод, пожалуйста, введите число (4;8)\n");
				continue; 
			}
			
			if (!exit) {			
				System.out.println();
				
				System.out.println(">> МАТРИЦА СМЕЖНОСТИ >\n");
//				boolean A[][] = Matrix.createBOOLEAN(size);
//				boolean A[][] = {{false, true, true, false, true, false}, 
//								 {false, true, false, false, true, false}, 
//								 {false, false, false, false, false, false}, 
//								 {false, false, true, false, false, false}, 
//								 {false, false, false, true, false, false}, 
//								 {true, false, false, false, true, true}};
				boolean A[][] = {{false, true,  true,  false, false, false, false, false, false},
								 {false, false, false, true,  false, false, false, false, false},
								 {false, false, false, true,  false, false, false, false, false},
								 {false, false, false, false, true,  false, false, false, false},
								 {false, false, false, false, false, true,  true,  true,  false},
								 {false, false, false, false, false, false, false, false, false},
								 {false, false, false, false, false, false, false, false, false},
								 {false, false, false, false, false, false, false, false, true},
								 {false, false, false, false, false, false, false, false, false}};
		        Matrix.printBOOLEAN(A, 'x', 'x'); 
		        System.out.println("\n");
		        
		        boolean b = Matrix.isGraphBipartite(A, 0);	
		        if (b) System.out.println(">> ГРАФ ЯВЛЯЕТСЯ ДВУДОЛЬНЫМ");
		        	else System.out.println(">> ГРАФ НЕ ЯВЛЯЕТСЯ ДВУДОЛЬНЫМ");		        
		        
		        System.out.println("\n\n");	
		        
			} 
		}
		
		in.close();
		
	}
	
	
}
