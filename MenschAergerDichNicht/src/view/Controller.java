package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Controller implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand().substring(0, 5)) {
		case "farbe":
			JButton button = (JButton) e.getSource();
			Color farbe = JColorChooser.showDialog(null, "Farbe auswählen", button.getBackground());
			if(farbe != null) {
				button.setBackground(farbe);
			}
			break;
		
		case "groes":
			JComboBox<?> combobox = (JComboBox<?>) e.getSource();
			// Einstellungen für Spieler 5 und 6 Verfügbar machen.
			if(combobox.getSelectedIndex() == 1) {
				for(Component component:combobox.getParent().getComponents()) {
					if(component.getForeground().equals(Color.LIGHT_GRAY)) {
						JLabel label = (JLabel) component;
						label.setForeground(Color.BLACK);
						label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
					}
					if(!component.isVisible()) {
						component.setVisible(true);
					}
				}
				
			}
			// Einstellungen für Spieler 5 und 6 wieder verstecken.
			else {
				for(Component component:combobox.getParent().getComponents()) {
					if(component.getClass().equals(JLabel.class)) {
						JLabel label = (JLabel) component;
						if(label.getText().equals("Spieler 5") ||
								label.getText().equals("Spieler 6")) {
							label.setForeground(Color.LIGHT_GRAY);
							label.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
						}
					}
					else if(component.getClass().equals(JCheckBox.class)
							|| component.getClass().equals(JButton.class)) {
						AbstractButton abutton = (AbstractButton) component;
						if(abutton.getActionCommand().equals("farbe5") 
								|| abutton.getActionCommand().equals("farbe6")
								|| abutton.getActionCommand().equals("computerSpieler5")
								|| abutton.getActionCommand().equals("computerSpieler6")){
							abutton.setVisible(false);
						}
					}
				}
			}
			break;

		
		}
	}

}
