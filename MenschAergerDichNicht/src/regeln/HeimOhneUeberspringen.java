package regeln;

import java.util.List;
import java.util.Map;

import logik.Spieler;
import logik.Spielfigur;
import basis.IRegeln;

/**
 * Diese Klasse liefert die Regeln f�r das Spiel, wenn man das Heimfeld erreicht hat und dort nicht
 * �berspringen darf
 * @author lea
 */
public class HeimOhneUeberspringen extends MitRauswerfen implements IRegeln{

	public HeimOhneUeberspringen(boolean sichereFelder, boolean mitRauswerfen,
			boolean nichtUeberspringen) {
		super(sichereFelder, mitRauswerfen, nichtUeberspringen);
	}

	@Override
	public int wuerfel() {
		// TODO Auto-generated method stub
		return super.wuerfel();
	}

	@Override
	public boolean nochMalWuerfeln(Spieler spieler, int wieOftSchonGewuerfelt,
			int letzteAugenzahl) {
		// TODO Auto-generated method stub
		return super.nochMalWuerfeln(spieler, wieOftSchonGewuerfelt, letzteAugenzahl);
	}

	@Override
	public void bewegeFigur(Map<Integer, Spielfigur> figurAusPosition,
			Spielfigur figur, int felderVor) {
		// TODO Auto-generated method stub
		super.bewegeFigur(figurAusPosition, figur, felderVor);
	}

	@Override
	public boolean bewegenMoeglich(Map<Integer, Spielfigur> figurAusPosition,
			Spielfigur figur, int augenzahl) {
		// TODO Auto-generated method stub
		
		int neuePos = figur.getPosition() + augenzahl;
		//Wenn die Augenzahlen nicht aufgehen f�r das Heimatfeld
		if(figurAusPosition.put(neuePos, figur).getPosition() == figur.getHeimatfeld() && figur.getHeimatfeld()>=4){
			return false;
		}//wenn man im Heimatfeld steht und jemand auf diesem Feld steht 
		else if(figurAusPosition.put(neuePos, figur).getPosition() == figur.getHeimatfeld() 
				&& figurAusPosition.get(neuePos) != null){
			return false;
		}
		// Figur steht vorher im Weg ins Heimatfeld
		int figurImHeimatfeld=0;
		for(int i=1; i<=augenzahl; i++){
			if(figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(i).getPosition() == 
					figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(i).getHeimatfeld()){
				figurImHeimatfeld = figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(i).getHeimatfeld();
				if(figurImHeimatfeld < figurAusPosition.put(neuePos, figur).getPosition()){
					return false;
				}
			}
		}
		
		return true;
	}

	@Override
	public List<Spielfigur> getOptionen(
			Map<Integer, Spielfigur> figurAusPosition, Spieler amZug,
			int augenzahl) {
		// TODO Auto-generated method stub
		return super.getOptionen(figurAusPosition, amZug, augenzahl);
	}

	@Override
	public boolean gewonnen(Spieler spieler) {
		// TODO Auto-generated method stub
		return super.gewonnen(spieler);
	}
}
