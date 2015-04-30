package view;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;

public class Spieleinstellungen {
	
	private Map<Integer, SpielerEinstellungen> spielereinstellungen = 
			new HashMap<>();
	private JComboBox<String> felderComboBox;
	private JComboBox<String> groessenComboBox;
	private JComboBox<String> rauswerfenComboBox;
	private JComboBox<String> heimregelComboBox;
	
	public Spieleinstellungen(
			Map<Integer, SpielerEinstellungen> spielereinstellungen,
			JComboBox<String> groessenComboBox,
			JComboBox<String> felderComboBox,
			JComboBox<String> rauswerfenComboBox,
			JComboBox<String> heimregelComboBox
			) {
		this.spielereinstellungen = spielereinstellungen;
		this.felderComboBox = felderComboBox;
		this.groessenComboBox = groessenComboBox;
		this.rauswerfenComboBox = rauswerfenComboBox;
		this.heimregelComboBox = heimregelComboBox;
	}
	
	public int getSpielfeldGroesse() {
		if(groessenComboBox.getSelectedIndex() == 0) {
			return 4;
		}
		return 6;
	}
	
	
}
