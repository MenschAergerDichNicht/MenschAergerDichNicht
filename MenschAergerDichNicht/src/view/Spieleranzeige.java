package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import logik.Spielbrett;
import logik.Spieler;

import java.awt.Font;


public class Spieleranzeige extends JPanel implements Observer{
	
	private List<JLabel> labelliste = new ArrayList<>();
	Spielbrett spielbrett;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Spieleranzeige(Spielbrett brett) {
		spielbrett = brett;
		setLayout(new GridLayout(0, 1, 0, 0));
		
		for(Spieler spieler:brett.getSpieler()) {
			if(spieler.getName() != null) {
				JLabel label = new JLabel(spieler.getName());
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 17));
				labelliste.add(label);
				this.add(label);
			}
		}
		
		markiereSpieler();
	}
	
	private void markiereSpieler() {
		
		for(JLabel label:labelliste) {
			label.setForeground(Color.DARK_GRAY);
		}
		
		for (JLabel label:labelliste) {
			if(label.getText().equals(spielbrett.getAmZug().getName())) {
				label.setForeground(spielbrett.getAmZug().getFarbe());
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg.getClass().equals(Spieler.class)) {
			markiereSpieler();
		}
	}
}
