package ferrocarrilSubterraneo_Logica;

public class FerrocarrilSubterraneo {
	
	public static final String nivel_1 = "./Maps/Nivel1.png";
	public static final String nivel_2 = "./Maps/Nivel2.png";
	
	private int posicion;
	private int puntaje;
	private int puntajeMinimo;
	
	private Mapa nivel;

	public FerrocarrilSubterraneo (int nivelSelecionado, boolean modelo) {
		
		puntaje = 100;
		mostrarMapa(nivelSelecionado);
		nivel = new Mapa(nivelSelecionado, modelo);
	}
	
	public String mostrarMapa(int level){
		if(level == 1)
			return nivel_1;
		else
			return nivel_2;
	}
	
	public boolean mover(int destino) {
				
		int costo = nivel.estaConectado(posicion, destino);
			
		if(costo > 0) {
			decresePuntaje(costo);
			posicion = destino;
			return true;
		}
		else
			return false;		
	}
	
	public int location(int x, int y) {
		
		Vertice[] vertices = nivel.getVertices();
		boolean found = false;
		int vertice = -1;
		
		for(int i = 0; i < vertices.length && !found;  i++){
			if(x > vertices[i].getX() && x < (vertices[i].getX() + 60))
				if(y > vertices[i].getY() && y < (vertices[i].getY() + 80)) {
					vertice = i;
					found = true;
				}
		}
		return vertice;
	}
	
	public void calcuarDificultad(int vertice) {
		nivel.calcularDificultad(vertice);
		puntajeMinimo = nivel.puntajeMinimo(vertice, puntaje);
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public int getPuntajeMinimo() {
		return puntajeMinimo;
	}
	
	public void decresePuntaje(int costo) {
		puntaje -= costo;
	}
	
	public boolean win() {
		if(puntaje >=  puntajeMinimo)
			return true;
		else
			return false;
	}
	
	public void cambiarModelo() {
		nivel.cambiarModelo();
	}
	
	public boolean getModelo() {
		return nivel.getModelo();
	}
	
	public void setPosicion(int inicio) {
		posicion = inicio;
	}
}
