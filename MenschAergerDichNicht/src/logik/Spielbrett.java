package logik;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import basis.IRegeln;

/**
 * Repräsentation des Spielbretts auf dem das Spiel stattfindet. Jede View
 * sollte ausschließlich mit einer Instanz dieser Klasse zusammenarbeiten.
 * @author ole
 */
public class Spielbrett extends Observable{

	private List<Spieler> spieler;
	private IRegeln regeln;
	private Iterator<Spieler> werIstDran;
	private Spieler amZug;
	private int anzahlWuerfe = 0;
	private int letzteAugenzahl = 0;
	private Map<Integer, Spielfigur> figurAusPosition = new HashMap<>();
	
	
	/**
	 * @param spieler eine Liste von Spielern die Teilnehmen
	 * @param regeln das Regelobjekt für den gewünschten Spielablauf
	 */
	public Spielbrett (List<Spieler> spieler, IRegeln regeln) {
		this.spieler = spieler;	
		this.regeln = regeln;
		
		werIstDran = spieler.iterator();
		amZug = werIstDran.next();
	}
	
	/**
	 * Eine Figur vorwärts bewegen.
	 * @param figur die Figur die Vorwärts bewegt werden soll.
	 * @param felderVor die Augenzahl des Würfels.
	 */
	public void bewegeFigur(Spielfigur figur, int felderVor) {
		regeln.bewegeFigur(figurAusPosition, figur, felderVor);
		aktualisiereMap();
		
		setChanged();
		notifyObservers(figur);
		
		if(!regeln.nochMalWuerfeln(amZug, anzahlWuerfe, felderVor)) {
			zugFertig();
		}
	}
	
	/**
	 * Setzt eine Figur auf das Startfeld ihres Spielers. Wenn dort bereits
	 * eine Figur des eigenen Spielers steht, passiert nichts.
	 * Wenn dort die Figur eines anderen Spielers steht, wird sie geschlagen.
	 * @param figur die Figur, die auf das zum Spieler gehörende Startfeld gesetzt werden soll.
	 */
	public void setzeFigurInsFeld(Spielfigur figur) {
		int startfeld = figur.getSpieler().getStartfeld();
		if(figurAusPosition.get(startfeld) == null) {
			figur.setPosition(startfeld);
			figurAusPosition.put(startfeld, figur);
		}
		else if(figurAusPosition.get(startfeld).getSpieler() != figur.getSpieler()) {
			figurAusPosition.get(startfeld).setPosition(-1);
			figur.setPosition(startfeld);
			figurAusPosition.put(startfeld, figur);
		}
	}
	
	/**
	 * @param figur die Figur, die überprüft werde soll.
	 * @return true, wenn sie mit der vorliegenden Augenzahl bewegt werden kann.
	 */
	public boolean bewegenMoeglich(Spielfigur figur) {
		return regeln.bewegenMoeglich(figurAusPosition, figur, letzteAugenzahl);
	}
	
	/**
	 * Aktualisiert die Map, welche Positionsinteger nimmt und die zugehörigen
	 * Figuren ausgibt. Wird nur dann ausgeführt, wenn eine Figur bewegt wird.
	 */
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
	
	/**
	 * Liefert nicht nur eine zufällige Augenzahl zurück, sondern speichert das
	 * Ergebnis als letzte Augenzahl im Spielbrett.
	 * @return die Augenzahl des Würfels der im Regelobjekt definiert ist.
	 */
	public int wuerfeln() {
		anzahlWuerfe++;
		letzteAugenzahl = regeln.wuerfel();
		setChanged();
		notifyObservers(letzteAugenzahl);
		return letzteAugenzahl;
	}
	
	/**
	 * @param position der Integer der eine Position auf dem Spielfeld repräsentiert.
	 * @return die Figur auf dem Spielfeld, null wenn keine Figur vorhanden.
	 */
	public Spielfigur gibFigurAufPosition(int position) {
		if(figurAusPosition.containsKey(position)) {
			return figurAusPosition.get(position);
		}
		return null;
	}
	

	/**
	 * Dies beendet den Zug des Spielers der gerade dran ist.
	 */
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
		notifyObservers(amZug);
	}

	/**
	 * @return eine Liste von Spielern
	 */
	public List<Spieler> getSpieler() {
		return spieler;
	}
	
	/**
	 * @return der Spieler der gerade dran ist.
	 */
	public Spieler getAmZug() {
		return amZug;
	}

	/**
	 * @return eine Liste von Figuren, die mit der aktuellen Augenzahl ziehen können. Die Liste ist leer, wenn keine solche Option existiert.
	 */
	public List<Spielfigur> getOptionen() {
		return regeln.getOptionen(figurAusPosition, amZug, letzteAugenzahl);
	}
	
}
