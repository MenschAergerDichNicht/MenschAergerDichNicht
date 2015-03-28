package logik;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import basis.IRegeln;

public class Spielbrett extends Observable{

	private List<Spieler> spieler;
	private IRegeln regeln;
	private Iterator<Spieler> werIstDran = spieler.iterator();
	private Spieler amZug = werIstDran.next();
	private int anzahlWuerfe = 0;
	private int letzteAugenzahl = 0;
	private Map<Integer, Spielfigur> figurAusPosition = new HashMap<>();
	
	
	public Spielbrett (List<Spieler> spieler, IRegeln regeln) {
		this.spieler = spieler;	
		this.regeln = regeln;
	}
	
	public void bewegeFigur(Spielfigur figur, int felderVor) {
		regeln.bewegeFigur(spieler, figur, felderVor);
		aktualisiereMap();
		
		setChanged();
		notifyObservers();
		
		if(!regeln.nochMalWuerfeln(amZug, anzahlWuerfe, felderVor)) {
			zugFertig();
		}
	}
	
	public void setzeFigurInsFeld(Spielfigur figur) {
		int startfeld = figur.getSpieler().getStartfeld();
		figur.setPosition(startfeld);
		figurAusPosition.put(startfeld, figur);
	}
	
	public boolean bewegenMoeglich(Spielfigur figur) {
		return regeln.bewegenMoeglich(spieler, figur, letzteAugenzahl);
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
		letzteAugenzahl = regeln.wuerfel();
		setChanged();
		notifyObservers();
		return letzteAugenzahl;
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
		setChanged();
		notifyObservers();
	}

	public List<Spieler> getSpieler() {
		return spieler;
	}
	
	public Spieler getAmZug() {
		return amZug;
	}

	public List<Spielfigur> getOptionen() {
		return regeln.getOptionen(spieler, amZug, letzteAugenzahl);
	}
	
}
