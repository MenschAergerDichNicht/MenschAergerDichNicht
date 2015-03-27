package logik;

import java.util.Map;



public class Spielfigur {

	private final Spieler spieler;
	private int position = -1;
	private int heimatfeld;
	
	public Spielfigur (Spieler spieler) {
		this.spieler = spieler;
	}
	
	public Color getFarbe() {
		return spieler.getFarbe();
	}
	
	public Spieler getSpieler() {
		return spieler;
	}
	
	public int getStartfeld() {
		return spieler.getStartfeld();
	}
	
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
