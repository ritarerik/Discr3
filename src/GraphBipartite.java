import java.util.ArrayDeque;
import java.util.ArrayList;

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
	
	
	public static boolean isGraphBipartite(boolean G[][]) {
		
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
		
		printParts(mark);		
		return true;		
		
	}
	
	private static void printParts(int mark[]) {
		
		ArrayList<Integer> A = new ArrayList<>();	// ����� A
		ArrayList<Integer> B = new ArrayList<>();	// ����� B
		
		for (int i = 0; i < mark.length; i++) {
			
			if (mark[i] == 1) A.add(i);
				else B.add(i);
			
		}
		
		System.out.println(">> ���� 'A' >\n        {");
		for (int i = 0; i < A.size(); i++) {			
			System.out.print("        x(" + A.get(i) + ")");			
			if (i < A.size() - 1) System.out.print(", ");			
		}
		System.out.println("\n}");
		
		System.out.println(">> ���� 'B' >\n");
		
		
	}
	
	private static int getMark(int previous) {		
		if (previous == 1) return 2;
		else return 1;		
	}
	
}
