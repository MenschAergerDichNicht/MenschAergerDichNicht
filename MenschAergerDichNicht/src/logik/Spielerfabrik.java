package logik;

import java.awt.Color;

/**
 * @author ole
 * Diese Klasse sollte verwendet werden, um Spielerinstanzen zu erzeugen.
 * Sie behält eine Übersicht über das aktuell zu vergebene Startfeld.
 */
public class Spielerfabrik {

	private int spieleranzahl;
	private int startfeld = 0;

	/**
	 * @param spieleranzahl die Anzahl möglicher Spieler auf dem Brett. 4 oder 6. 
	 */
	public Spielerfabrik(int spieleranzahl) {
		this.spieleranzahl = spieleranzahl;
	}
	
	/**
	 * Gibt die Spielerinstanz zurück.
	 * @param farbe die gewählte Farbe des Spielers.
	 * @param name der gewählte Name des Spielers
	 * @return die Spielerinstanz.
	 */
	public Spieler getSpieler(Color farbe, String name) {
		Spieler spieler = new Spieler(farbe, startfeld, name);
		if(spieleranzahl > 4) {
			startfeld += 8;
		}
		else {
			startfeld += 10;
		}
		return spieler; 	
	}
	
}
