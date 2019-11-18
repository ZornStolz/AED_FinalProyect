package ferrocarrilSubterraneo_Logica;

import grafos.*;

public class Mapa {

	public static final int nivel_1 = 1;
	public static final int nivel_2 = 2;
	public static final int infinito = 100;
	
	private int[][] nivel;
	
	private int[][] matrizPesos;
	private ZonaSegura[] listaPesos;
	
	private AlgoritmosGrafos algoritmos;
	
	/**
	 * si modelo es true => modelo es Matriz
	 * si modelo es false => modelo es Lista
	 */
	private boolean modelo;
	
	public Mapa(int nivelElegido, boolean tipoModelo, int inicio) {
		modelo = tipoModelo;
		algoritmos = new AlgoritmosGrafos();
		
		switch (nivelElegido) {
		
		case nivel_1:

			cargarNivel1();			
			calcularDificultad(inicio);
			
			break;

		case nivel_2:
			
			cargarNivel2();
			calcularDificultad(inicio);
			
			break;
		}
		
		matrizPesos = new int[nivel.length][nivel.length];
		
		for(int i = 0; i < matrizPesos.length; i++)
			for(int j = 0; j < matrizPesos.length; j++)
				matrizPesos[i][j] = infinito;
			
		for(int i = 0; i < matrizPesos.length; i++)
			matrizPesos[i][i] = 0;
		
		for(int i = 0; i < matrizPesos.length; i++)
			for(int j = 0; j < matrizPesos.length; j++)
				if(nivel[i][j] > 0)
					matrizPesos[i][j] = nivel[i][j];
		
		listaPesos = new ZonaSegura[nivel.length];
		
		for(int i = 0; i < nivel.length; i++)
			for(int j = 0; j < nivel.length; j++)
				if(nivel[i][j] > 0)
					if(listaPesos[i] != null) {
						
						ZonaSegura last = listaPesos[i];
						
						while(last.getSiguiente() != null)
							last = last.getSiguiente();
						
						last.setSiguiente(new ZonaSegura(j, nivel[i][j]));
					}
					else
						listaPesos[i] = new ZonaSegura(j, nivel[i][j]);		
	}
	
	/**
	 * carga el nivel 1. elabora la matriz de adyacencia
	 */
	private void cargarNivel1(){
		
		nivel = new int[20][20];
		
		nivel[0][3] = 1;		nivel[3][0] = 1;
		nivel[1][4] = 1;		nivel[4][1] = 1;
		nivel[2][7] = 1;		nivel[7][2] = 1;
		nivel[3][5] = 1;		nivel[5][3] = 1;
		nivel[3][6] = 1;		nivel[6][3] = 1;
		nivel[4][9] = 1;		nivel[9][4] = 1;
		nivel[5][10] = 1;		nivel[10][5] = 1;
		nivel[6][8] = 1;		nivel[8][6] = 1;
		nivel[7][12] = 1;		nivel[12][7] = 1;
		nivel[8][13] = 1;		nivel[13][8] = 1;
		nivel[9][11] = 1;		nivel[11][9] = 1;
		nivel[10][15] = 1;		nivel[15][10] = 1;
		nivel[11][16] = 1;		nivel[16][11] = 1;
		nivel[12][14] = 1;		nivel[14][12] = 1;
		nivel[13][19] = 1;		nivel[19][13] = 1;
		nivel[14][18] = 1;		nivel[18][14] = 1;
		nivel[15][17] = 1;		nivel[17][15] = 1;
		nivel[16][19] = 1;		nivel[19][16] = 1;
		nivel[17][19] = 1;		nivel[19][17] = 1;
		nivel[18][19] = 1;		nivel[19][18] = 1;
		
	}
	
	/**
	 * carga el nivel 2. elabora la matriz de adyacencia
	 */
	private void cargarNivel2(){
		
		nivel = new int[24][24];
		
		nivel[0][1] = 1;		nivel[1][0] = 1;
		nivel[0][3] = 1;		nivel[3][0] = 1;
		nivel[1][4] = 1;		nivel[4][1] = 1;
		nivel[1][6] = 1;		nivel[6][1] = 1;
		nivel[2][3] = 1;		nivel[3][2] = 1;
		nivel[2][5] = 1;		nivel[5][2] = 1;
		nivel[3][5] = 1;		nivel[5][3] = 1;
		nivel[3][4] = 1;		nivel[4][3] = 1;
		nivel[4][7] = 1;		nivel[7][4] = 1;
		nivel[4][8] = 1;		nivel[8][4] = 1;
		nivel[5][8] = 1;		nivel[8][5] = 1;
		nivel[6][7] = 1;		nivel[7][6] = 1;
		nivel[6][9] = 1;		nivel[9][6] = 1;
		nivel[6][11] = 1;		nivel[11][6] = 1;
		nivel[7][10] = 1;		nivel[10][7] = 1;
		nivel[8][13] = 1;		nivel[13][8] = 1;
		nivel[9][11] = 1;		nivel[11][9] = 1;
		nivel[10][12] = 1;		nivel[12][10] = 1;
		nivel[11][15] = 1;		nivel[15][11] = 1;
		nivel[11][16] = 1;		nivel[16][11] = 1;
		nivel[12][16] = 1;		nivel[16][12] = 1;
		nivel[12][14] = 1;		nivel[14][12] = 1;
		nivel[12][13] = 1;		nivel[13][12] = 1;
		nivel[13][14] = 1;		nivel[14][13] = 1;
		nivel[14][18] = 1;		nivel[18][14] = 1;
		nivel[15][17] = 1;		nivel[17][15] = 1;
		nivel[15][19] = 1;		nivel[19][15] = 1;
		nivel[16][17] = 1;		nivel[17][16] = 1;
		nivel[16][18] = 1;		nivel[18][16] = 1;
		nivel[17][20] = 1;		nivel[20][17] = 1;
		nivel[18][20] = 1;		nivel[20][18] = 1;
		nivel[18][21] = 1;		nivel[21][18] = 1;
		nivel[19][22] = 1;		nivel[22][19] = 1;
		nivel[20][22] = 1;		nivel[22][20] = 1;
		nivel[20][23] = 1;		nivel[29][20] = 1;
		nivel[21][23] = 1;		nivel[23][21] = 1;
		nivel[22][23] = 1;		nivel[23][22] = 1;
		
	}
	
	/**
	 * calcula el nivel del vertice llendo de 1 a 3 e iniciando de nuevo
	 * @param verticeinicial punto de inicio del jugador
	 */
	public void calcularDificultad(int verticeinicial){		
		asignarDificultad(algoritmos.bfsLevelsHastaEl3(verticeinicial, nivel));		
	}
	
	private void asignarDificultad(int[] dificultadesDelosVertices) {
		
		int controlColumna = 1; // me permite mover desde la diagonal,  hacia  la derecha
		
		for(int i = 0; i < (nivel.length - 1); i++) {
			for(int j = controlColumna; j < nivel.length; j++) {
				if (nivel[i][j] > 0) {	// hay arista
					
					int costo = (int)(Math.random()*3+1);		// costo nivel 1
					
					switch (dificultadesDelosVertices[j]) {
					case 2:
						
						costo = (int)(Math.random()*(6-4+1)+4);
						nivel[i][j] = costo;
						nivel[j][i] = costo;
						
						break;
						
					case 3:
						
						costo = (int)(Math.random()*(10-7+1)+7);
						nivel[i][j] = costo;
						nivel[j][i] = costo;
						
						break;

					default: // nivel 1 o 0
						
						nivel[i][j] = costo;
						nivel[j][i] = costo;
						
						break;
					}
				}
			}
			controlColumna++;
		}		
	}
	
	public int puntajeMinimo(int verticeInicial, int puntajeInicial) {		
		int camino = algoritmos.dijkstra(matrizPesos, verticeInicial)[nivel.length - 1];
		return puntajeInicial - (camino + (int)(camino*0.3));
	}
	
	/**
	 * retorna el peso de la arista
	 * @param a
	 * @param b
	 * @return
	 */
	public int estaConectado(int a, int b) {
		
		if(modelo) {
			
			if(matrizPesos[a][b] > 0 && matrizPesos[a][b] < 100)
				return matrizPesos[a][b];
			else
				return -1;
			
		}else {
			
			ZonaSegura actual = listaPesos[a];
			int peso = -1;
			
			while(actual != null) {
				
				if(actual.getVertice()  ==  b) {
					
					peso = actual.getNivelDePeligro();
					break;
					
				}else
					actual  = actual.getSiguiente();				
			}
			return peso;
		}
	}

	public void cambiarModelo() {
		if(modelo)
			modelo = false;
		else
			modelo = true;
	}
	public int[][] getMatrizPesos(){
		return matrizPesos;
	}
}
