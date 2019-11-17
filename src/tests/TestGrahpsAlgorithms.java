package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import grafos.AlgoritmosGrafos;

class TestGrahpsAlgorithms {

	public static final int infinito = 100;
	
	private int[][] matrizPesos;
	private AlgoritmosGrafos algoritmo;
	
	void setUp1(){

		algoritmo = new AlgoritmosGrafos();
		
		matrizPesos = new int[5][5];
		
		matrizPesos[0][2] = 4;		matrizPesos[2][0] = 4;
		matrizPesos[0][4] = 3;		matrizPesos[4][0] = 3;
		matrizPesos[1][3] = 3;		matrizPesos[3][1] = 3;
		matrizPesos[1][4] = 4;		matrizPesos[4][1] = 4;
		matrizPesos[2][4] = 2;		matrizPesos[4][2] = 2;
		matrizPesos[2][3] = 7;		matrizPesos[3][2] = 7;
		matrizPesos[3][4] = 8;		matrizPesos[4][3] = 8;
	}

	void setUp2(){

		algoritmo = new AlgoritmosGrafos();
		
		matrizPesos = new int[5][5];
		
		for(int i = 0; i < matrizPesos.length; i++)
			for(int j = 0; j < matrizPesos.length; j++)
				matrizPesos[i][j] = infinito;
			
		for(int i = 0; i < matrizPesos.length; i++)
			matrizPesos[i][i] = 0;
		
		matrizPesos[0][2] = 4;		matrizPesos[2][0] = 4;
		matrizPesos[0][4] = 3;		matrizPesos[4][0] = 3;
		matrizPesos[1][3] = 3;		matrizPesos[3][1] = 3;
		matrizPesos[1][4] = 4;		matrizPesos[4][1] = 4;
		matrizPesos[2][4] = 2;		matrizPesos[4][2] = 2;
		matrizPesos[2][3] = 7;		matrizPesos[3][2] = 7;
		matrizPesos[3][4] = 8;		matrizPesos[4][3] = 8;
	}
	
	void setUp3(){
		
		algoritmo = new AlgoritmosGrafos();
		
		matrizPesos = new int[9][9];
		
		for(int i = 0; i < matrizPesos.length; i++)
			for(int j = 0; j < matrizPesos.length; j++)
				matrizPesos[i][j] = infinito;
			
		for(int i = 0; i < matrizPesos.length; i++)
			matrizPesos[i][i] = 0;
		
		matrizPesos[0][1] = 6;		matrizPesos[1][0] = 6;
		matrizPesos[0][2] = 10;		matrizPesos[2][0] = 10;
		matrizPesos[0][4] = 8;		matrizPesos[4][0] = 8;
		matrizPesos[0][6] = 9;		matrizPesos[6][0] = 9;
		matrizPesos[1][3] = 5;		matrizPesos[3][1] = 5;
		matrizPesos[2][5] = 2;		matrizPesos[5][2] = 2;
		matrizPesos[3][4] = 3;		matrizPesos[4][3] = 3;
		matrizPesos[4][5] = 7;		matrizPesos[5][4] = 7;
		matrizPesos[6][7] = 1;		matrizPesos[7][6] = 1;
		matrizPesos[6][8] = 2;		matrizPesos[8][6] = 2;
		matrizPesos[7][8] = 4;		matrizPesos[8][7] = 4;
	}
	
	@Test
	void testBFS() {
		setUp1();
		System.out.println();
		System.out.println("BFS");
		System.out.println();
		for(int x: algoritmo.bfs(0, matrizPesos))
			System.out.print(" " + x);
		System.out.println();
	}
	
	@Test
	void testBFSNiveles() {
		setUp1();
		System.out.println();
		System.out.println("Niveles");
		System.out.println();
		int y = -1;
		for(int x: algoritmo.bfsLevels(0, matrizPesos))
			System.out.println((y+=1) + " " +x);
		System.out.println();
	}
	
	@Test
	void testDFS() {
		setUp1();
		
		System.out.println();
		System.out.println("DFS");
		System.out.println();
		for(int x: algoritmo.dfs(0, matrizPesos))
			System.out.print(" " + x);
		System.out.println();
	}
	
	@Test
	void testDijkstra() {
		setUp2();
		
		int y = -1;
		System.out.println();
		System.out.println("Dijkstra");
		System.out.println();
		
		for(int x: algoritmo.dijkstra(matrizPesos,3))
			System.out.println((y+=1) + " " +x);
	}
	
	@Test
	void testFloydWarshall() {
		setUp2();
		
		System.out.println("Floyd-Warshall");
		System.out.println();		
		
		int[][] fw = algoritmo.floydWarshall(matrizPesos);
		
		for(int i = 0; i < fw.length; i++) {
			for(int j = 0; j < fw.length; j++)
				System.out.print(" " + fw[i][j]);
			System.out.println();
		}
	}
	
	@Test
	void testPrim() {
		setUp3();		
		System.out.println();
		System.out.println("Prim");
		algoritmo.prim(matrizPesos);		
		System.out.println();
	}
	
	@Test
	void testKruskal() {
		
		setUp3();		
		System.out.println();
		System.out.println("kruskal");
		
		matrizPesos = algoritmo.Kruskal(matrizPesos, infinito);
		
		for(int i = 0; i < matrizPesos.length; i++) {
			for(int j = 0; j < matrizPesos.length; j++)
				System.out.print(" " + matrizPesos[i][j]);
			System.out.println();
		}
	}
}
