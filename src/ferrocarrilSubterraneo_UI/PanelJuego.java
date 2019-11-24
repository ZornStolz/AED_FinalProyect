package ferrocarrilSubterraneo_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel implements ActionListener, MouseListener{

	public  static final String Cambiar = "Cambiar Modelo";
	
	private FerrocarrilSubTerraneoFrame principal;
	
	private JLabel ImgNivel;
	private JLabel labPuntaje;
	private JButton butCambiar;
	
	private int empezo;
	
	public PanelJuego(FerrocarrilSubTerraneoFrame obj, String nivel) {
		
		principal = obj;
		principal.setLocation(0, 0);
		principal.setSize(1280, 650);
		addMouseListener(this);
		empezo = -1;
		
		ImgNivel = new JLabel(new ImageIcon(nivel));
		
		labPuntaje = new JLabel("" + principal.getPuntaje());
		
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
		constraints.gridwidth = 2;
		add(ImgNivel, constraints);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent mouse) {
		
		int vertice = principal.location(mouse.getX(), mouse.getY());
		
		if(empezo < 0) {
			if (vertice > -1 && vertice < 3) {
				empezo = vertice;
				principal.cargar(vertice);
				System.out.println("se cargo");
			}else
				JOptionPane.showMessageDialog(null, "seleccione una entrada valida");				
		}
		
		else if(empezo > -1 && vertice > -1) {
			if(principal.mover(vertice)) {
				// visualizar cambio
				System.out.println(principal.getPuntaje());
			} else
				JOptionPane.showMessageDialog(null, "seleccione una entrada valida");					
		} else
			JOptionPane.showMessageDialog(null, "seleccione una entrada valida");
		
		if(principal.getNivelElegido() == 1) {
			if(vertice == 19) 
				principal.finDelJuego();
		} else {
			if(vertice == 23) 
				principal.finDelJuego();
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
