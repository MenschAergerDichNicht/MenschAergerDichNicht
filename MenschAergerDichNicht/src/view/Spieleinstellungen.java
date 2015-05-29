package view;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;

import logik.Spieler;
import logik.Spielerfabrik;

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
	
	public boolean sichereFelder() {
		if(felderComboBox.getSelectedIndex() == 0) {
			return false;
		}
		return true;
	}
	
	public boolean mitRauswerfen() {
		if(rauswerfenComboBox.getSelectedIndex() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean ueberspringenimHeimatbereich() {
		if(heimregelComboBox.getSelectedIndex() == 0) {
			return false;
		}
		return true;
	}
	
	public SpielerEinstellungen getSpielereinstellungen(int spielernummer) {
		return spielereinstellungen.get(spielernummer);
	}
	
	public List<Spieler> getSpieler() {
		List<Spieler> liste = new LinkedList<>();
		Spielerfabrik fabrik = new Spielerfabrik(getSpielfeldGroesse());
		
		for(int spieler = 1; spieler <= getSpielfeldGroesse(); spieler++) {
			Color farbe = spielereinstellungen.get(spieler).getFarbe();
			String name = spielereinstellungen.get(spieler).getName();

			if(spieler < 3) {
				liste.add(fabrik.getSpieler(farbe, name));
			}
			else if(!name.equals("Spieler " + spieler)) {
					liste.add(fabrik.getSpieler(farbe, name));
			}
			else if(name.equals("Spieler " + spieler)) {
				liste.add(Spielerfabrik.getLeerenSpieler(farbe));
		}
		}
		
		return liste;
	}
}
