package ferrocarrilSubterraneo_UI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PanelInicio extends JPanel implements ActionListener{

	public static final String Level_1 = "Nivel 1";
	public static final String Level_2 = "Nivel 2";
	
	private FerrocarrilSubTerraneoFrame principal;
	
	private JLabel labBienvenido;
	private JLabel labModelo;
	private JTextArea labIntroduccion;
	private JTextArea labInstrucciones;
	
	private JButton butLevel1;
	private JButton butLevel2;
	
	private JTextField txtModelo;
	
	public PanelInicio (FerrocarrilSubTerraneoFrame obj) {
		principal = obj;
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		labBienvenido = new JLabel("Bienvenido");
		labInstrucciones  = new JTextArea("Escoge un punto de incio entre los 3 con color azul, \n"
										+ "debes clickear en el. Muevete clickeando en las zo- \n"
										+ "nas adyacentes que esten conectadas por caminos. \n" 
										+ "Finaliza con la mayor cantidad de esclavos posible. \n \n"
										+ "Para elegir el modelo del grafo escoge 0 para la ma \n" 
										+ "triz de pesos y 1 para la lista de adyacencia con \n"
										+ "pesos.");
		labInstrucciones.setEditable(false);
		labIntroduccion = new JTextArea(  "Eres miembro del Ferrocarril subterráneo y tendrás \n"
										+ "que guiar a un grupo de esclavos a su libertad.\n "
										+ "El camino estará lleno de peligros y deberás ser \n "
										+ "cauteloso para no perder a ninguno de tu grupo. \n "
										+ "Tu objetivo es llevarlos a un estado seguro, Libre \n "
										+ "del control del sur, pasando por puntos seguros o \n "
										+ "de descanso.");		
		labIntroduccion.setEditable(false);
		
		labModelo = new JLabel("Modelo");
		txtModelo = new JTextField("0");
		
		butLevel1 = new JButton(Level_1);
		butLevel1.setActionCommand(Level_1);
		butLevel1.addActionListener(this);
		
		butLevel2 = new JButton(Level_2);
		butLevel2.setActionCommand(Level_2);
		butLevel2.addActionListener(this);
		
		constraints.gridx = 0;
		constraints.gridy = 0; 
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		add(labBienvenido, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1; 
		add(labIntroduccion, constraints);
		constraints.gridx = 0;
		constraints.gridy = 3; 
		add(butLevel1, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 4; 
		add(butLevel2, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 5; 
		add(labInstrucciones, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2; 
		constraints.gridwidth = 1;
		constraints.weightx  = 4;	
		add(labModelo, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2; 
		constraints.weightx  = 5;	
		constraints.fill  = GridBagConstraints.HORIZONTAL;
		add(txtModelo, constraints);		
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		boolean modelo;

		switch (evento.getActionCommand()) {
		case Level_1:
			
			
			if(txtModelo.getText().equals("0"))
				modelo = true;
			else
				modelo = false;
			
			principal.juego(1, modelo);
			
			break;

		case Level_2:
			

			if(txtModelo.getText().equals("0"))
				modelo = true;
			else
				modelo = false;
			
			principal.juego(2, modelo);
			
			break;
		}				
	}	
}
