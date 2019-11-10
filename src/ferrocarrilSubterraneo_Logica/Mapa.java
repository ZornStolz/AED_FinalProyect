package ferrocarrilSubterraneo_Logica;

public class Mapa {

	private int[][] matrizPesos;
	private ZonaSegura[] listaPesos;
	
	/**
	 * si modelo es true => modelo es Matriz
	 * si modelo es false => modelo es Lista
	 */
	private boolean modelo;
	
	public Mapa(int[][] nivelElegido, boolean tipoModelo) {
		modelo = tipoModelo;
		
		// llenaar la lista y la matriz
		
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
