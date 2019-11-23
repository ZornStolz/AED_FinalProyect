package ferrocarrilSubterraneo_UI;

import java.awt.*;
import javax.swing.*;
import ferrocarrilSubterraneo_Logica.FerrocarrilSubterraneo;

@SuppressWarnings("serial")
public class FerrocarrilSubTerraneoFrame extends JFrame{
	
	private PanelInicio panelInicio;
	private PanelJuego panelJuego;
	private PanelGameOver panelGameOver;
	private PanelVictoria panelVictoria;
	
	private FerrocarrilSubterraneo logica;
	
	public FerrocarrilSubTerraneoFrame(){
		
		setTitle("~~~ Ferrocarril Subterraneo ~~~");
		setSize(255, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		inicio();		
	}
	
	void inicio(){
		panelInicio = new PanelInicio(this);
		add(panelInicio);
		revalidate();
	}
	
	void  juego(int nivel, boolean modelo) {
		remove(panelInicio);
		
		logica = new FerrocarrilSubterraneo(nivel, modelo);
		panelJuego = new PanelJuego(this, logica.mostrarMapa(nivel));
		add(panelJuego);
		revalidate();
	}
	
	void gameOver() {
		
	}
	
	void victoria() {
		
	}
	
	public int puntoInicio(int x, int y) {
		return logica.location(x, y);
	}
	
	public boolean mover(int destino) {
		return logica.mover(destino);
	}
	
	public int location(int x, int y) {
		return logica.location(x, y);
	}
	
	public void cargar(int inicio) {
		logica.setPosicion(inicio);
		logica.calcuarDificultad(inicio);
	}
	
	public int getPuntaje() {
		return logica.getPuntaje();
	}

	public static void main(String[] args) {	
		FerrocarrilSubTerraneoFrame ventana = new FerrocarrilSubTerraneoFrame();
		ventana.setVisible(true);		
	}	
}
