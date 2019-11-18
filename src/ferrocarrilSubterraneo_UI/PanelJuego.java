package ferrocarrilSubterraneo_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;

import javax.swing.event.MouseInputListener;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements ActionListener, MouseInputListener
{

	public  static final String Cambiar = "Cambiar Modelo";
	
	private FerrocarrilSubTerraneoFrame principal;
	
	private JLabel ImgNivel;
	private JLabel labPuntaje;
	private JButton butCambiar;
	
	public PanelJuego(FerrocarrilSubTerraneoFrame obj, String nivel) {
		
		principal = obj;
		principal.setLocation(0, 50);
		principal.setSize(1280, 600);
		
		ImgNivel = new JLabel(new ImageIcon(nivel));
		
		labPuntaje = new JLabel("100");
		
		butCambiar = new JButton(Cambiar);
		butCambiar.setActionCommand(Cambiar);
		butCambiar.addActionListener(this);
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(butCambiar, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		add(labPuntaje, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		add(ImgNivel, constraints);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
