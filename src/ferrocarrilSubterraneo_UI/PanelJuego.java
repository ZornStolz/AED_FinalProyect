package ferrocarrilSubterraneo_UI;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements ActionListener, MouseListener{

	public  static final String Cambiar = "Cambiar Modelo";
	
	private FerrocarrilSubTerraneoFrame principal;
	
	private JLabel ImgNivel;
	private JLabel labPuntaje;
	private JButton butCambiar;
	private JLabel labPosicion;
	
	private int empezo;
	private AudioStream audio;
	
	public PanelJuego(FerrocarrilSubTerraneoFrame obj, String nivel, AudioStream song) {
		
		principal = obj;
		principal.setLocation(0, 0);
		principal.setSize(1280, 650);
		addMouseListener(this);
		empezo = -1;
		audio = song;
		
		ImgNivel = new JLabel(new ImageIcon(nivel));
		
		labPuntaje = new JLabel("Puntaje: " + principal.puntaje());
		labPosicion = new JLabel();
		
		butCambiar = new JButton(Cambiar);
		butCambiar.setActionCommand(Cambiar);
		butCambiar.addActionListener(this);
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		add(butCambiar, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		add(labPuntaje, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		add(labPosicion, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		add(ImgNivel, constraints);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		principal.cambiarModelo();
		
		if(principal.getModelo())
			JOptionPane.showMessageDialog(null, "Modelo cambio de Lista de adyacencia con pesos a matriz de pesos", "Modelo Cambiado", 1);
		else
			JOptionPane.showMessageDialog(null, "Modelo cambio de matriz de pesos a Lista de adyacencia con pesos", "Modelo Cambiado", 1);
	}
	
	@Override
	public void mouseClicked(MouseEvent mouse) {
		
		int vertice = principal.location(mouse.getX(), mouse.getY());
		
		if(empezo < 0) {
			if (vertice > -1 && vertice < 3) {
				empezo = vertice;
				principal.cargar(vertice);
				labPosicion.setText("Posicion actual: " + vertice);
			}else
				JOptionPane.showMessageDialog(null, "seleccione una entrada valida");				
		}
		
		else if(empezo > -1 && vertice > -1) {
			if(principal.mover(vertice)) {
				labPuntaje.setText("Puntaje: " + principal.puntaje());
				labPosicion.setText("Posicion actual: " + vertice);
				revalidate();
			} else
				JOptionPane.showMessageDialog(null, "seleccione una entrada valida");					
		} else
			JOptionPane.showMessageDialog(null, "seleccione una entrada valida");
		
		if(principal.getNivelElegido() == 1) {
			if(vertice == 19) {
				AudioPlayer.player.stop(audio);
				principal.finDelJuego();
			}
		} else {
			if(vertice == 23) {
				AudioPlayer.player.stop(audio);
				principal.finDelJuego();
			}
		}
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent mouse) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
