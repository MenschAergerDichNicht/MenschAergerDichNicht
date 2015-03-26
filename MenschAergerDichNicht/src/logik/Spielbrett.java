package logik;

import java.util.List;

public class Spielbrett {

	private List<Spieler> spieler;
	//Wenn Iterator bei der Liste verwendet wird nicht notwendig.
	private int werIstDran = 0;
	
	
	public Spielbrett (List<Spieler> spieler) {
		this.spieler = spieler;	

	}
	
	public void bewegeFigur(Spielfigur figur, int felderVor) {
		figur.bewegeFigur(felderVor);
	}
	
	public boolean bewegenMoeglich(Spielfigur figur, int felderVor) {
		return false;
	}
	
	//Doppelte for-Schleife alle Spieler -> alle Figuren
	private Spielfigur gibFigurAufPosition(int position) {
		return null;
	}
	
	
	
	//Setzt den Zeiger auf den nächsten Spieler
	//TODO den List-Iterator verwenden. Viel eleganter.
	public void zugFertig() {
		if (werIstDran < spieler.size()) {
			werIstDran++;
		}
		else {
			werIstDran = 0;
		}
	}

	public List<Spieler> getSpieler() {
		return spieler;
	}
	
	

}
