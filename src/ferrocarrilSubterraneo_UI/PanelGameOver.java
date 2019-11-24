package ferrocarrilSubterraneo_UI;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PanelGameOver extends JPanel{

	private FerrocarrilSubTerraneoFrame principal;
	
	private JLabel ImgNivel;
	
	public PanelGameOver (FerrocarrilSubTerraneoFrame obj) {
		
		principal = obj;
		principal.setSize(500, 500);
		principal.setLocationRelativeTo(null);
		
		ImgNivel = new JLabel(new ImageIcon("./media/youDied.gif"));
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(ImgNivel, constraints);
	}	
	
}
