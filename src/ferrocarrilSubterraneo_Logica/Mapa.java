package ferrocarrilSubterraneo_Logica;

import grafos.*;

public class Mapa {

	public static final int nivel_1 = 1;
	public static final int nivel_2 = 2;
	public static final int infinito = 100;
	
	private int[][] nivel;
	
	private int[][] matrizPesos;
	private ZonaSegura[] listaPesos;
	
	private Vertice[] listaVertices;
	
	private AlgoritmosGrafos algoritmos;
	
	/**
	 * si modelo es true => modelo es Matriz
	 * si modelo es false => modelo es Lista
	 */
	private boolean modelo;
	
	public Mapa(int nivelElegido, boolean tipoModelo) {
		modelo = tipoModelo;
		algoritmos = new AlgoritmosGrafos();
		
		switch (nivelElegido) {
		
		case nivel_1:

			cargarNivel1();	
			
			break;

		case nivel_2:
			
			cargarNivel2();
			
			break;
		}	
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
				
		listaVertices = new Vertice[20];
		
		listaVertices[0] = new Vertice(26, 53);		listaVertices[7] = new Vertice(400,494);		listaVertices[14] = new Vertice(732,441);
		listaVertices[1] = new Vertice(59,300);		listaVertices[8] = new Vertice(475,166);		listaVertices[15] = new Vertice(848,98);
		listaVertices[2] = new Vertice(95,504);		listaVertices[9] = new Vertice(475,349);		listaVertices[16] = new Vertice(855,308);
		listaVertices[3] = new Vertice(146,156);	listaVertices[10] = new Vertice(556,42);		listaVertices[17] = new Vertice(1015,59);
		listaVertices[4] = new Vertice(188,377);	listaVertices[11] = new Vertice(605,329);		listaVertices[18] = new Vertice(987,473);
		listaVertices[5] = new Vertice(312,88);		listaVertices[12] = new Vertice(579,517);		listaVertices[19] = new Vertice(1157,276);
		listaVertices[6] = new Vertice(336,269);	listaVertices[13] = new Vertice(680,177);		
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
		nivel[20][23] = 1;		nivel[23][20] = 1;
		nivel[21][23] = 1;		nivel[23][21] = 1;
		nivel[22][23] = 1;		nivel[23][22] = 1;
		
		listaVertices = new Vertice[24];
		
		listaVertices[0] = new Vertice(4,234);		listaVertices[7] = new Vertice(334,301);		listaVertices[14] = new Vertice(703,521);	listaVertices[21] = new Vertice(1112,511);	
		listaVertices[1] = new Vertice(79,87);		listaVertices[8] = new Vertice(324,478);		listaVertices[15] = new Vertice(762,119);	listaVertices[22] = new Vertice(1189,133);
		listaVertices[2] = new Vertice(70,511);		listaVertices[9] = new Vertice(447,184);		listaVertices[16] = new Vertice(795,315);	listaVertices[23] = new Vertice(1200,317);
		listaVertices[3] = new Vertice(108,326);	listaVertices[10] = new Vertice(438,407);		listaVertices[17] = new Vertice(903,151);
		listaVertices[4] = new Vertice(189,194);	listaVertices[11] = new Vertice(577,99);		listaVertices[18] = new Vertice(89,459);
		listaVertices[5] = new Vertice(187,472);	listaVertices[12] = new Vertice(592,310);		listaVertices[19] = new Vertice(1025,36);
		listaVertices[6] = new Vertice(338,83);		listaVertices[13] = new Vertice(532,527);		listaVertices[20] = new Vertice(1047,299);
	}
	
	/**
	 * calcula el nivel del vertice llendo de 1 a 3 e iniciando de nuevo
	 * @param verticeinicial punto de inicio del jugador
	 */
	public void calcularDificultad(int verticeinicial){		
		
		asignarDificultad(algoritmos.bfsLevelsHastaEl3(verticeinicial, nivel));		
		
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
	
	public Vertice[] getVertices() {
		return listaVertices;
	}
}
