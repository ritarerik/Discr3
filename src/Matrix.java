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
		
		System.out.print("        |����");
		for (int i = 0; i < A[0].length - 1; i++) {
			System.out.print("�����");
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
		
		int vNum = graph.length; // ���������� ������
		
		boolean[] used = new boolean [vNum]; // ������ �������
        int[] queue = new int [vNum]; // �������
        
        int qH = 0; // ������ �������
        int qT = 0; // �����
         
        // ��������� ������� v
        used[v] = true; // �������� �������� �������
        queue[qT++] = v; // �������� �� � ������� 
         
        while (qH < qT) { // ���� ������� �� �����
            v = queue[qH++]; // ��������� ������� �������
            for (int nv = 0; nv < vNum; nv++) { // ���������� �������
                if (!used[nv] && graph[v][nv]) { // ���� nv �� �������� � ������ � v
                    
                	// ��������� ������� nv
                    used[nv] = true; // �������� ��
                    queue[qT++] = nv; // � ��������� � �������
                    
                }
            }
        }
		
		return false;		
		
	}
	
}
