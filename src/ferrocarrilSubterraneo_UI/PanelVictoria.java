package ferrocarrilSubterraneo_UI;

import javax.swing.*;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@SuppressWarnings("serial")
public class PanelVictoria extends JPanel{
	
	public static final String AUDIO = "./media/win.wav";
	
	private FerrocarrilSubTerraneoFrame principal;
	
	private JLabel ImgNivel;
	
	public PanelVictoria (FerrocarrilSubTerraneoFrame obj) {
		
		principal = obj;
		principal.setSize(500, 500);
		principal.setLocationRelativeTo(null);
		
		ImgNivel = new JLabel(new ImageIcon("./media/win.gif"));
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(ImgNivel, constraints);
		
		JOptionPane.showMessageDialog(null, "Tu puntaje " + principal.puntaje() + "\n Puntaje minimo " + principal.puntajeMinimo(), "Tu Puntaje fue:", 1);
		music();
	}	
	
	void music() {
		
		try {
			
			InputStream music;
			music = new FileInputStream(new File(AUDIO));
			AudioStream audio = new AudioStream(music);
			AudioPlayer.player.start(audio);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Directorio no encontrado");
		}		
	}
}
