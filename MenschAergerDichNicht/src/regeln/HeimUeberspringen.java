package regeln;

import java.util.List;
import java.util.Map;

import logik.Spieler;
import logik.Spielfigur;
import basis.IRegeln;

/**
 * Diese Klasse liefert die Regeln f�r das Spiel, wenn man das Heimfeld erreicht hat und dort seine
 * eigenen Spielfiguren �berspringen darf
 * @author lea
 */
public class HeimUeberspringen extends MitRauswerfen implements IRegeln{

	public int wuerfel(){
		return super.wuerfel();
	}
	
	public boolean nochMalWuerfeln(Spieler spieler, int wieOftSchonGewuerfelt, int letzteAugenzahl){
		return super.nochMalWuerfeln(spieler, wieOftSchonGewuerfelt, letzteAugenzahl);
	}
	
	public void bewegeFigur(Map<Integer, Spielfigur> figurAusPosition, Spielfigur figur, int felderVor){
		super.bewegeFigur(figurAusPosition, figur, felderVor);
	}
	
	public boolean bewegenMoeglich(Map<Integer, Spielfigur> figurAusPosition, Spielfigur figur, int augenzahl){
		int neuePos = figur.getPosition() + augenzahl;
		//Wenn die Augenzahlen nicht aufgehen f�r das Heimatfeld
		if(figurAusPosition.put(neuePos, figur).getPosition() == figur.getHeimatfeld() && figur.getHeimatfeld()>=4){
			return false;
		}//wenn man im Heimatfeld steht und jemand auf diesem Feld steht 
		else if(figurAusPosition.put(neuePos, figur).getPosition() == figur.getHeimatfeld() 
				&& figurAusPosition.get(neuePos) != null){
			return false;
		}
		
		return true;
	}
	public List<Spielfigur> getOptionen(Map<Integer, Spielfigur> figurAusPosition, Spieler amZug, int augenzahl){
		return super.getOptionen(figurAusPosition, amZug, augenzahl);
	}
	public boolean gewonnen(Spieler spieler){
		return super.gewonnen(spieler);
	}
}
