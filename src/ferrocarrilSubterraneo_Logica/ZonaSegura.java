package ferrocarrilSubterraneo_Logica;

/**
 * Esta clase ayuda a modelar los vertices del grafo Mapa cuando 
 * se usa una lista de adyacencia con ponderamiento.
 * @author JuanDavid
 */
public class ZonaSegura {
	
	private int vertice;
	private int nivelDePeligro;
	private ZonaSegura siguiente;
	
	public ZonaSegura(int vertice, int nivelDePeligro) {
		this.vertice = vertice;
		this.nivelDePeligro = nivelDePeligro;
		siguiente = null;
	}

	public ZonaSegura getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(ZonaSegura siguiente) {
		this.siguiente = siguiente;
	}

	public int getVertice() {
		return vertice;
	}

	public int getNivelDePeligro() {
		return nivelDePeligro;
	}	
}
