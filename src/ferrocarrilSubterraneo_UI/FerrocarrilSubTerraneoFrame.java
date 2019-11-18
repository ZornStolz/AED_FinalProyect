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
	private int mapa;
	
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
		mapa = nivel;
		panelJuego = new PanelJuego(this, logica.mostrarMapa(nivel));
		add(panelJuego);
		revalidate();
	}
//	
//	public void  repaint() {
//		panelJuego.repaint();
//	}
	
	void gameOver() {
		
	}
	
	void victoria() {
		
	}

	public static void main(String[] args) {	
		FerrocarrilSubTerraneoFrame ventana = new FerrocarrilSubTerraneoFrame();
		ventana.setVisible(true);		
	}	
}
