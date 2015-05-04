package Regeln;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import logik.Spieler;
import logik.Spielfigur;
import basis.IRegeln;

/**
 * Diese Klasse liefert die Regeln f�r das Spiel, wenn das Rauswerfen erlaubt wurde
 * @author lea
 */
public class MitRauswerfen implements IRegeln{

	/**Repr�sentiert den W�rfel
	 * @return die Augenanzahl des W�rfels
	 */
	@Override
	public int wuerfel() {
		// TODO Auto-generated method stub
		Random rn = new Random();
		int anzahl = rn.nextInt(6) + 1;
		return anzahl;
	}

	/**
	 * �berpr�ft, ob nochmal gew�rfelt werden darf
	 * @param spieler der spieler der grade am Zug ist.
	 * @param wieOftSchonGewuerfelt wie oft hat man schon gew�rfelt.
	 * @param letzteAugenzahl was war die letzte gew�rfelte Augenzahl des Spielers
	 * @return true wenn man nochmal w�rfeln darf, sonst false
	 */
	@Override
	public boolean nochMalWuerfeln(Spieler spieler, int wieOftSchonGewuerfelt,
			int letzteAugenzahl) {
		// TODO Auto-generated method stub
		//wenn noch nicht 3mal gew�rftelt wurde und alle im Haus stehen
			if(wieOftSchonGewuerfelt < 3 && spieler.getSpielfiguren().get(0).getPosition() < 0
					&& spieler.getSpielfiguren().get(1).getPosition() < 0 && spieler.getSpielfiguren().get(2).getPosition() < 0
					&& spieler.getSpielfiguren().get(3).getPosition() < 0){
				return true;
			}//6 gew�rfelt muss vom Startfeld runter
			else if(letzteAugenzahl == 6){
				return true;
			}
		return false;
	}

	/**
	 * Die Figur wird vorw�rts bewegt
	 * @param figurAusPosition die Map f�r das Spiel
	 * @param figur die Figur die bewegt werden soll
	 * @param felderVor die ge�rfelte Augenzahl
	 */
	@Override
	public void bewegeFigur(Map<Integer, Spielfigur> figurAusPosition,
			Spielfigur figur, int felderVor) {
		// TODO Auto-generated method stub
		int momPos = figur.getPosition();
		int neuePos = momPos+felderVor;
		
		if(bewegenMoeglich(figurAusPosition, figur, felderVor) == true){
			//andere Figur schmei�en
			for(int i=0; i<4;i++){
				if(figurAusPosition.get(neuePos) != null && 
						figur.getSpieler() != figurAusPosition.get(neuePos).getSpieler() ){
					figurAusPosition.get(neuePos).setPosition(-1);
				}
			}
			figur.setPosition(neuePos);
		}
	}

	/**
	 * �berpr�ft, ob sich die Spielfigur bewegen darf
	 * @param figurAusPosition die Map des Spiels
	 * @param figur Welche Figur ist am Zug?
	 * @param augenzahl was war die letzte gew�rfelte Augenzahl des Spielers
	 * @return true wenn die Spielfigur sich nach vorn bewegen darf, sonst false
	 */
	@Override
	public boolean bewegenMoeglich(Map<Integer, Spielfigur> figurAusPosition,
			Spielfigur figur, int augenzahl) {
		// TODO Auto-generated method stub
		Spieler spieler;
		spieler = figur.getSpieler();
		int zaehler=0;
		int neuePos = figur.getPosition() + augenzahl;
		
		//Bei 6 nur aus Haus ziehen
		if(augenzahl==6 && figur.getPosition()>0 && ( figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(0).getPosition()<0
			||figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(1).getPosition()<0||
			figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(2).getPosition()<0||
			figurAusPosition.get(figur).getSpieler().getSpielfiguren().get(3).getPosition()<0)){
			return false;
		}
		
		//Wenn eigene Figur da steht    
		if (figurAusPosition.get(neuePos) != null  &&
				figurAusPosition.get(neuePos).getSpieler() == figur.getSpieler()){
			return false;
		}
		
		//Wenn alle im Haus stehen und keine 6 gew�rfelt wurde
		for(int i=0; i<=3; i++){
			if(augenzahl != 6 && figur.getSpieler().getSpielfiguren().get(i).getPosition() < 0){
				zaehler++;
			}
			if(zaehler == 4){
				return false;
			}
		}
			
		return true;
	}

	/**
	 * Liefert Liste mit allen Spielfiguren des Spielers, die sich bewegen d�rfen
	 * @param figurAusPosition die Map des Spiels
	 * @param amZug der Spieler der grade an der Reihe ist
	 * @param augenzahl die gew�rfelte Augenzahl des Spielers
	 * @return Liste mit Spielfiguren
	 */
	@Override
	public List<Spielfigur> getOptionen(
			Map<Integer, Spielfigur> figurAusPosition, Spieler amZug,
			int augenzahl) {
		// TODO Auto-generated method stub
		List<Spielfigur> liste = new ArrayList<>();
		for (int i=0; i<4; i++){
			if (bewegenMoeglich(figurAusPosition, amZug.getSpielfiguren().get(i), augenzahl) == true){
				liste.add(amZug.getSpielfiguren().get(i));
			}
		}
		return liste;
	}

	/**
	 * �berpr�ft, ob ein Spieler gewonnen hat
	 * @param spieler der spieler der grade am Zug ist.
	 * @return true wenn er gewonnen hat, sonst false
	 */
	@Override
	public boolean gewonnen(Spieler spieler) {
		// TODO Auto-generated method stub
		int zaehler=0;
		for(int i=0; i<4; i++){
			if(spieler.getSpielfiguren().get(i).getPosition() == spieler.getSpielfiguren().get(i).getHeimatfeld()){
				zaehler++;
			}
		}
		if(zaehler == 4){
			return true;
		}else{
			return false;
		}
	}
}
