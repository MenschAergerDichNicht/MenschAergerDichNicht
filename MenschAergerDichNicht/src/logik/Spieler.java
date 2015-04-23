package logik;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ole
 * Instanzen dieser Klasse repräsentieren Spieler, die das Spiel spielen.
 */
public class Spieler {
	
	private final Color farbe;
	private List<Spielfigur> spielfiguren;
	private int startfeld;
	private String name;
	private final int anzahlSpielfiguren = 4;
	
	/**
	 * @param farbe die vom Spieler gewählte Farbe
	 * @param startfeld das Feld auf dem die Figuren das Feld betreten
	 * @param name der angegebene Name des Spielers
	 */
	public Spieler(Color farbe, int startfeld, String name) {
		this.farbe = farbe;
		this.name = name;
		this.startfeld = startfeld;
		spielfiguren = new ArrayList<>();
		for(int i = 0; i < anzahlSpielfiguren; i++) {
			spielfiguren.add(new Spielfigur(this));
		}
		spielfiguren = Collections.unmodifiableList(spielfiguren);
	}
	
	/**
	 * @return die Farbe des Spielers und seiner Figuren.
	 */
	public Color getFarbe() {
		return farbe;
	}
	
	/**
	 * @return eine Liste der Spielfigurinstanzen die diesem Spieler gehören.
	 */
	public List<Spielfigur> getSpielfiguren() {
		return spielfiguren;
	}
	
	/**
	 * @return den Integer der das Feld repräsentiert auf dem die Figuren dieses Spielers das Brett betreten.
	 */
	public int getStartfeld(){
		return startfeld;
	}
	
	/**
	 * @return den angegebenen Namen des Spielers
	 */
	public String getName(){
		return name;
	}
	
	//TODO implementieren!
	/**
	 * @return true, wenn sich alle Spielfiguren im Heimfeld befinden.
	 * false, wenn nicht.
	 */
	public boolean gewonnen() {
		return false;
	}
}
