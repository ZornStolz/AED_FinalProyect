package ferrocarrilSubterraneo_Logica;

public class Mapa {

	public static final int nivel_1 = 1;
	public static final int nivel_2 = 2;
	
	private int[][] matrizPesos;
	private ZonaSegura[] listaPesos;
	
	/**
	 * si modelo es true => modelo es Matriz
	 * si modelo es false => modelo es Lista
	 */
	private boolean modelo;
	
	public Mapa(int nivelElegido, boolean tipoModelo) {
		modelo = tipoModelo;
		
		switch (nivelElegido) {
		
		case nivel_1:
			
			
			
			break;

		case nivel_2:
			
			
			
			break;
		}
		
	}
	
	public void calcularDificultad(int verticeinicial){
		
	}
	
	public void asignarDificultad(int[] dificultadesDelosVertices) {
		
	}
	
	public int puntajeMinimo(int verticeInicial) {
		return 0;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int estaConectado(int a, int b) {
		return 0;
	}

	public void cambiarModelo() {
		
	}
}
