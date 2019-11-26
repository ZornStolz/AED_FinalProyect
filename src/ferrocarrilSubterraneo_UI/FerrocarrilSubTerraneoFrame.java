package ferrocarrilSubterraneo_UI;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.swing.*;
import ferrocarrilSubterraneo_Logica.FerrocarrilSubterraneo;

@SuppressWarnings("serial")
public class FerrocarrilSubTerraneoFrame extends JFrame{
	
	public static final String AUDIO = "./media/CenterOfTheEarth.wav";
	
	private PanelInicio panelInicio;
	private PanelJuego panelJuego;
	private PanelGameOver panelGameOver;
	private PanelVictoria panelVictoria;
	
	private AudioStream audio;
	
	private FerrocarrilSubterraneo logica;
	
	private int nivelElegido;
	
	public FerrocarrilSubTerraneoFrame(){
		
		setTitle("~~~ Ferrocarril Subterraneo ~~~");
		setSize(300, 400);
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
		nivelElegido = nivel;
		panelJuego = new PanelJuego(this, logica.mostrarMapa(nivel), audio);
		add(panelJuego);
		revalidate();
		music();
	}
	
	void gameOver() {
		remove(panelJuego);
		
		panelGameOver = new PanelGameOver(this);
		add(panelGameOver);
		revalidate();
	}
	
	void victoria() {
		remove(panelJuego);
		
		panelVictoria = new PanelVictoria(this);
		add(panelVictoria);
		revalidate();
	}
	
	@SuppressWarnings("resource")
	void music() {
		
		try {
			
//			AudioData data = new AudioStream(new FileInputStream(AUDIO)).getData();
//			ContinuousAudioDataStream sound = new ContinuousAudioDataStream(data);
//			AudioPlayer.player.start(sound);
			
			InputStream music;
			music = new FileInputStream(new File(AUDIO));
			audio = new AudioStream(music);
			AudioPlayer.player.start(audio);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Directorio no encontrado");
		}		
	}	
	
	public void finDelJuego() {
		if(logica.win())
			victoria();
		else
			gameOver();		
	}
	
	public int puntaje() {
		return logica.getPuntaje();
	}
	
	public int puntajeMinimo() {
		return logica.getPuntajeMinimo();
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
	
	public int getNivelElegido() {
		return nivelElegido;
	}
	
	public void cambiarModelo() {
		logica.cambiarModelo();
	}
	
	public boolean getModelo() {
		return logica.getModelo();
	}
	
	public static void main(String[] args) {	
		FerrocarrilSubTerraneoFrame ventana = new FerrocarrilSubTerraneoFrame();
		ventana.setVisible(true);		
	}	
}
