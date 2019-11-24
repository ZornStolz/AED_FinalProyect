package ferrocarrilSubterraneo_UI;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PanelVictoria extends JPanel{
	
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
	}	
	
}
