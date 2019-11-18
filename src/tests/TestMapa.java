package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import ferrocarrilSubterraneo_Logica.Mapa;
import grafos.AlgoritmosGrafos;

class TestMapa {
	
	private Mapa mapa;
	private AlgoritmosGrafos algoritmos;
	
	void setUp1(){		
		mapa = new Mapa(1, true, 0);		
		algoritmos = new AlgoritmosGrafos();
	}

	@Test
	void test() {
		
		setUp1();
		
		int[][] matriz = mapa.getMatrizPesos();
		
		ArrayList<Integer> bfs = algoritmos.bfs(0, matriz);
		
		for(int i = 0; i < matriz.length; i++)
			System.out.print(" " + bfs.get(i));
		
		System.out.println();
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++)
				System.out.print(" " + matriz[i][j]);
			System.out.println();
		}
	}

}
