package Regeln;

import java.util.List;
import java.util.Map;

import logik.Spieler;
import logik.Spielfigur;
import basis.IRegeln;

/**
 * Diese Klasse liefert die Regeln f�r das Spiel, wenn das Rauswerfen verboten wurde
 * @author lea
 */
public class OhneRauswerfen extends MitRauswerfen implements IRegeln{

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
		int momPos = figur.getPosition();
		int neuePos = momPos+felderVor;
		if(bewegenMoeglich(figurAusPosition, figur, felderVor) == true){
			figurAusPosition.put(neuePos, figur);
		}
	}

	@Override
	public boolean bewegenMoeglich(Map<Integer, Spielfigur> figurAusPosition,
			Spielfigur figur, int augenzahl) {
		// TODO Auto-generated method stub
		int neuePos = figur.getPosition() + augenzahl;
		int zaehler=0;
		
		//Bei 6 nur aus Haus ziehen
		if(augenzahl==6 && figur.getPosition()>0 && ( figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(1).getPosition()<0
			||figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(2).getPosition()<0||
			figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(3).getPosition()<0||
			figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(4).getPosition()<0)){
			return false;
		}
		
		//Wenn fremde/eigene Figur da steht
		if(figurAusPosition.get(neuePos) != null) {
			return false;
		}
		
		//Wenn alle im Haus stehen und keine 6 gew�rfelt wurde
				for(int i=1; i<=4; i++){
					if(augenzahl != 6 && figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(i).getPosition() < 0){
						zaehler++;
					}
					if(zaehler == 4){
						return false;
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
