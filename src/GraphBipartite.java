import java.util.ArrayDeque;

public class GraphBipartite {
	
	public static void checkGraph(boolean A[][]) {
		System.out.println(">> ������� ��������� >\n");
		
		Matrix.printBOOLEAN(A, 'x', 'x'); 
		System.out.println("\n");
				        
		boolean b = isGraphBipartite(A);	
		if (b) System.out.println(">> ���� �������� ����������");
			else System.out.println(">> ���� �� �������� ����������");
				        
		System.out.println("\n\n");
	}
	
	
	public static boolean isGraphBipartite(boolean[][] G) {
		
		int mark[] = new int[G.length]; // ������ ����� ������
		for (int i : mark) i = 0;		// ���������� ������ (������� �� ����������� �� � ����� �� �����)
		mark[0] = 1;					// ������ ������� �������� � ������ ����
		
		ArrayDeque<Integer> Q = new ArrayDeque<>(); // ������� ������
		Q.addLast(0);								// ������ ������� -- �������
		
		while (!Q.isEmpty()) {						// ����� � ������ 			
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
