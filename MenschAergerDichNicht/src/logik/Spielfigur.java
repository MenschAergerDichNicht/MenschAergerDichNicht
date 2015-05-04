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
	 * Wenn dieser Wert < 0 ist, steht die Figur nicht auf dem Feld.
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * Die Zielfelder, in die die Spielfiguren zuletzt einlaufen müssen.
	 * Sollten von 1 bis 4 gehen.
	 * @param heimatfeld der Integer, der das aktuelle Heimatfeld repräsentiert.
	 */
	public void setHeimatfeld(int heimatfeld) {
		if(heimatfeld > 0) {
			position = -1;
		}
		this.heimatfeld = heimatfeld;
	}
	
	/**
	 * Die Zielfelder, in die die Spielfiguren zuletzt einlaufen müssen.
	 * Sollten von 1 bis 4 gehen.
	 * @return heimatfeld der Integer, der das aktuelle Heimatfeld repräsentiert.
	 */
	public int getHeimatfeld() {
		return heimatfeld;
	}

	/**
	 * @return der Integer, der die aktuelle Position auf dem Spielfeld repräsentiert.
	 * Wenn dieser Wert < 0 ist, steht die Figur nicht auf dem Feld.
	 */
	public int getPosition() {
		return position;
	}

}
