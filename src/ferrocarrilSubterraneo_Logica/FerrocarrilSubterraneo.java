package ferrocarrilSubterraneo_Logica;

public class FerrocarrilSubterraneo {
	
	public static final String nivel_1 = "./Maps/Nivel1.png";
	public static final String nivel_2 = "./Maps/Nivel2.png";
	
	private int posicion;
	private int puntaje;
	private int puntajeMinimo;
	
	private int level;
	private boolean modelo;
	
	private Mapa nivel;

	public FerrocarrilSubterraneo (int nivelSelecionado, boolean modelo) {
		
		mostrarMapa(nivelSelecionado);
		puntaje = 100;
		this.modelo = modelo;
	}
	
	public String mostrarMapa(int level){
		if(level == 1)
			return nivel_1;
		else
			return nivel_2;
	}
	
	public void cargarMapa(int inicio) {
		posicion =  inicio;
		nivel = new Mapa(level, modelo, inicio);
		puntajeMinimo =	nivel.puntajeMinimo(inicio, puntaje);
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
	
	public int getPuntaje() {
		return puntaje;
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
}
