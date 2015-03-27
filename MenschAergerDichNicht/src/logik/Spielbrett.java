package logik;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import basis.IRegeln;

public class Spielbrett {

	private List<Spieler> spieler;
	private IRegeln regeln;
	private Iterator<Spieler> werIstDran = spieler.iterator();
	private Spieler amZug = werIstDran.next();
	private int anzahlWuerfe = 0;
	private Map<Integer, Spielfigur> figurAusPosition = new HashMap<>();
	
	
	public Spielbrett (List<Spieler> spieler, IRegeln regeln) {
		this.spieler = spieler;	
		this.regeln = regeln;
	}
	
	public void bewegeFigur(Spielfigur figur, int felderVor) {
		regeln.bewegeFigur(spieler, figur, felderVor);
		aktualisiereMap();
		if(!regeln.nochMalWuerfeln(amZug, anzahlWuerfe, felderVor)) {
			zugFertig();
		}
	}
	
	public void setzeFigurInsFeld(Spielfigur figur) {
		int startfeld = figur.getSpieler().getStartfeld();
		figur.setPosition(startfeld);
		figurAusPosition.put(startfeld, figur);
	}
	
	public boolean bewegenMoeglich(Spielfigur figur, int augenzahl) {
		return regeln.bewegenMoeglich(spieler, figur, augenzahl);
	}
	
	private void aktualisiereMap() {
		figurAusPosition = new HashMap<>();
		for(Spieler spieler: spieler) {
			for(Spielfigur spielfigur: spieler.getSpielfiguren()) {
				if(spielfigur.getPosition() >= 0) {
					figurAusPosition.put(spielfigur.getPosition(), spielfigur);
				}
			}
		}
	}
	
	public int wuerfeln() {
		anzahlWuerfe++;
		return regeln.wuerfel();
	}
	
	public Spielfigur gibFigurAufPosition(int position) {
		if(figurAusPosition.containsKey(position)) {
			return figurAusPosition.get(position);
		}
		return null;
	}
	

	public void zugFertig() {
		anzahlWuerfe = 0;
		if(werIstDran.hasNext()) {
			amZug = werIstDran.next();
		}
		else {
			werIstDran = spieler.iterator();
			amZug = werIstDran.next();
		}
	}

	public List<Spieler> getSpieler() {
		return spieler;
	}
	
	public Spieler getAmZug() {
		return amZug;
	}
	

}
