package logik;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spieler {
	
	private final Color farbe;
	private List<Spielfigur> spielfiguren;
	private int startfeld;
	private final int anzahlSpielfiguren = 4;
	
	public Spieler(Color farbe, int startfeld) {
		this.farbe = farbe;
		spielfiguren = new ArrayList<>();
		for(int i = 0; i < anzahlSpielfiguren; i++) {
			spielfiguren.add(new Spielfigur(this));
		}
		spielfiguren = Collections.unmodifiableList(spielfiguren);
	}
	
	public Color getFarbe() {
		return farbe;
	}
	
	public List<Spielfigur> getSpielfiguren() {
		return spielfiguren;
	}
	
	public int getStartfeld(){
		return startfeld;
	}
	
	public boolean gewonnen() {
		return false;
	}
}
