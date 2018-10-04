import java.util.ArrayDeque;

public class GraphBipartite {
	
	public static void checkGraph(boolean A[][]) {
		System.out.println(">> МАТРИЦА СМЕЖНОСТИ >\n");
		
		Matrix.printBOOLEAN(A, 'x', 'x'); 
		System.out.println("\n");
				        
		boolean b = isGraphBipartite(A);	
		if (b) System.out.println(">> ГРАФ ЯВЛЯЕТСЯ ДВУДОЛЬНЫМ");
			else System.out.println(">> ГРАФ НЕ ЯВЛЯЕТСЯ ДВУДОЛЬНЫМ");
				        
		System.out.println("\n\n");
	}
	
	
	public static boolean isGraphBipartite(boolean[][] G) {
		
		int mark[] = new int[G.length]; // массив меток вершин
		for (int i : mark) i = 0;		// заполнение нулями (вершина не принадлежит ни к одной из долей)
		mark[0] = 1;					// первая вершина заведомо в первой доле
		
		ArrayDeque<Integer> Q = new ArrayDeque<>(); // очередь вершин
		Q.addLast(0);								// первая вершина -- нулевая
		
		while (!Q.isEmpty()) {						// обход в ширину 			
			int i = Q.removeFirst();			
			if (mark[i] != 0) {			
				for (int j = 0; j < G[0].length; j++)
					
					if (G[i][j]) {
						if (mark[j] == 0) {
							mark[j] = getMark(i);
							Q.addLast(j);
						} else if (mark[j] != getMark(i)) return false;
					} 
			}			
		}
		
		return true;		
		
	}
	
	
	private static int getMark(int previous) {		
		if (previous == 1) return 2;
		else return 1;		
	}
	
}
