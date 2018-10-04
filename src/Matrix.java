import java.util.Random;

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
	
	//--------------------------------------------------------------//
	public static boolean isGraphBipartite(boolean[][] graph, int v) {
		
		int vNum = graph.length; // количество вершин
		
		boolean[] used = new boolean [vNum]; // массив пометок
        int[] queue = new int [vNum]; // очередь
        
        int qH = 0; // голова очереди
        int qT = 0; // хвост
         
        // обработка вершины v
        used[v] = true; // помечаем исходную вершину
        queue[qT++] = v; // помещаем ее в очередь 
         
        while (qH < qT) { // пока очередь не пуста
            v = queue[qH++]; // извлекаем текущую вершину
            for (int nv = 0; nv < vNum; nv++) { // перебираем вершины
                if (!used[nv] && graph[v][nv]) { // если nv не помечена и смежна с v
                    
                	// обработка вершины nv
                    used[nv] = true; // помечаем ее
                    queue[qT++] = nv; // и добавл€ем в очередь
                    
                }
            }
        }
		
		return false;		
		
	}
	
}
