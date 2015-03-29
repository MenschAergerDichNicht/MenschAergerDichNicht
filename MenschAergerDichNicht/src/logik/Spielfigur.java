package logik;

import java.awt.Color;

/**
 * @author ole
 * 
 * Diese Klasse repräsentiert eine Spielfigur. Sie enthält einen Verweis auf
 * ihren Besitzer (Spieler).
 */
public class Spielfigur {

	private final Spieler spieler;
	private int position = -1;
	private int heimatfeld;
	
	/**
	 * @param spieler der Spieler, welcher die Figur besitzt.
	 */
	public Spielfigur (Spieler spieler) {
		this.spieler = spieler;
	}
	
	
	/**
	 * Die Farbe der Spielfigur.
	 * @return den Farbwert.
	 */
	public Color getFarbe() {
		return spieler.getFarbe();
	}
	
	/**
	 * @return den Spieler, der diese Figur besitzt.
	 */
	public Spieler getSpieler() {
		return spieler;
	}
	
	/**
	 * Das Startfeld ist das Feld, auf dem die Spielfigur gesetzt wird, nachdem
	 * sie "heraus" kommt.
	 * @return den Integer, der das Startfeld repräsentiert.
	 */
	public int getStartfeld() {
		return spieler.getStartfeld();
	}
	
	/**
	 * 
	 * @param position der Integer, der die neue Position repräsentiert
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	public void setHeimatfeld(int heimatfeld) {
		this.heimatfeld = heimatfeld;
	}
	
	public int getHeimatfeld() {
		return heimatfeld;
	}

	public int getPosition() {
		return position;
	}

}
