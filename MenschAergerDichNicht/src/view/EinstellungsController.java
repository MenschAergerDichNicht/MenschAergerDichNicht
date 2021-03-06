package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

import regeln.MitRauswerfen;
import logik.Spielbrett;
import logik.Spieler;

public class EinstellungsController implements ActionListener, MouseListener {

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
					if(component.getForeground().equals(Color.GRAY)) {
						JTextField textfield = (JTextField) component;
						textfield.setForeground(Color.GRAY);
						textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
					}
					if(!component.isVisible()) {
						component.setVisible(true);
					}
				}
				
			}
			// Einstellungen für Spieler 5 und 6 wieder verstecken.
			else {
				for(Component component:combobox.getParent().getComponents()) {
					if(component.getClass().equals(JTextField.class)) {
						JTextField textfield = (JTextField) component;
						if(textfield.getText().equals("Spieler 5") ||
								textfield.getText().equals("Spieler 6")) {
//							textfield.setForeground(Color.LIGHT_GRAY);
//							textfield.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
							textfield.setVisible(false);
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
		
		case "start":
			final Einstellungen einstellungsframe = (Einstellungen) (((JComponent) e.getSource()).getTopLevelAncestor());
			List<Spieler> spieler = einstellungsframe.spieleinstellungen.getSpieler();
			
			//TODO Regeln mit Einstellungen verbinden
			MitRauswerfen regeln = new MitRauswerfen(
					einstellungsframe.spieleinstellungen.sichereFelder(), 
					einstellungsframe.spieleinstellungen.mitRauswerfen(),
					!einstellungsframe.spieleinstellungen.ueberspringenimHeimatbereich());
			final Spielbrett brett = new Spielbrett(spieler, regeln);
			
			if(brett.getSpieler().size() < 4) {
				
			}
			
			SpielbrettGui frame = new SpielbrettGui(
					brett, einstellungsframe.spieleinstellungen.sichereFelder()
					);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 615);
			frame.setVisible(true);
			
			einstellungsframe.dispose();

			break;
			
		case "regel":
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Anleitung frame = new Anleitung();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			break;

		
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
