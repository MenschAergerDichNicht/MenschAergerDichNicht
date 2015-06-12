package regeln;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import logik.Spieler;
import logik.Spielfigur;
import basis.IRegeln;

/**
 * Diese Klasse liefert die Regeln fï¿œr das Spiel, wenn das Rauswerfen erlaubt wurde
 * @author lea
 */
public class MitRauswerfen implements IRegeln{
	
	private final int SPIELFELDGROESSE = 39;
	private final boolean sichereFelder;
	private final boolean mitRauswerfen;
	private final boolean nichtUeberspringen;
	
	public MitRauswerfen(boolean sichereFelder, 
			boolean mitRauswerfen, 
			boolean nichtUeberspringen) {
		
		this.sichereFelder = sichereFelder;
		this.mitRauswerfen = mitRauswerfen;
		this.nichtUeberspringen = nichtUeberspringen;
		
	}
	
	private boolean jemandImHaus (Spielfigur figur){
		int zaehler=0;
		for (int i=0; i<4; i++){
			if(figur.getSpieler().getSpielfiguren().get(i).getPosition()<0 && figur.getSpieler().getSpielfiguren().get(i).getHeimatfeld()==0){
				zaehler++;
			}
		}
		
		if(zaehler>0){
			return true;
		}
		return false;
	}
	
	private int positionFigur(Spielfigur figur, int i){
		return figur.getSpieler().getSpielfiguren().get(i).getPosition();
	}

	/**Reprï¿œsentiert den Wï¿œrfel
	 * @return die Augenanzahl des Wï¿œrfels
	 */
	@Override
	public int wuerfel() {
		// TODO Auto-generated method stub
		Random rn = new Random();
		int anzahl = rn.nextInt(6) + 1;
		return anzahl;
	}

	/**
	 * ï¿œberprï¿œft, ob nochmal gewï¿œrfelt werden darf
	 * @param spieler der spieler der grade am Zug ist.
	 * @param wieOftSchonGewuerfelt wie oft hat man schon gewï¿œrfelt.
	 * @param letzteAugenzahl was war die letzte gewï¿œrfelte Augenzahl des Spielers
	 * @return true wenn man nochmal wï¿œrfeln darf, sonst false
	 */
	@Override
	public boolean nochMalWuerfeln(Spieler spieler, int wieOftSchonGewuerfelt,
			int letzteAugenzahl) {
		// TODO Auto-generated method stub
		//wenn noch nicht 3mal gewï¿œrftelt wurde und alle im Haus stehen
		if(wieOftSchonGewuerfelt < 3 && spieler.getSpielfiguren().get(0).getPosition() < 0 && spieler.getSpielfiguren().get(0).getHeimatfeld()==0
					&& spieler.getSpielfiguren().get(1).getPosition() < 0  && spieler.getSpielfiguren().get(1).getHeimatfeld()==0
					&& spieler.getSpielfiguren().get(2).getPosition() < 0 && spieler.getSpielfiguren().get(2).getHeimatfeld()==0
					&& spieler.getSpielfiguren().get(3).getPosition() < 0 && spieler.getSpielfiguren().get(3).getHeimatfeld()==0){
				return true;
			}//6 gewï¿œrfelt muss vom Startfeld runter
			else if(letzteAugenzahl == 6){
				return true;
			}
			else if(wieOftSchonGewuerfelt == 0) {
				return true;
			}
		return false;
	}

	/**
	 * Die Figur wird vorwï¿œrts bewegt
	 * @param figurAusPosition die Map fï¿œr das Spiel
	 * @param figur die Figur die bewegt werden soll
	 * @param felderVor die geï¿œrfelte Augenzahl
	 */
	@Override
	public void bewegeFigur(Map<Integer, Spielfigur> figurAusPosition,
			Spielfigur figur, int felderVor) {
		/*
		int momPos = figur.getPosition();
		int neuePos = momPos+felderVor;
		
		if(bewegenMoeglich(figurAusPosition, figur, felderVor) == true && neuePos < 40){
			//andere Figur schmeiï¿œen
			for(int i=0; i<4;i++){
				if(figurAusPosition.get(neuePos) != null && 
						figur.getSpieler() != figurAusPosition.get(neuePos).getSpieler() ){
					figurAusPosition.get(neuePos).setPosition(-1);
				}
			}
			figur.setPosition(neuePos);
		}
		
		if(neuePos >= 40){
			int felderZuLaufen = felderVor;
			for(; momPos<=38; felderZuLaufen--){
				figur.setPosition(momPos+1);
				momPos++;
			}
			figur.setHeimatfeld(felderZuLaufen);
		}
		*/
		if(figur.getHeimatfeld() > 0) {
			figur.setHeimatfeld(figur.getHeimatfeld() + felderVor);
		}
		else {
			int felderBisherGelaufen = getFelderBewegt(figur.getStartfeld(), 
					figur.getPosition());
			int felderJetztGelaufen = felderBisherGelaufen + felderVor;
			int neuePosition = figur.getPosition() + felderVor;
			if(neuePosition > SPIELFELDGROESSE) {
				neuePosition = neuePosition - SPIELFELDGROESSE - 1;
			}
			
			//Ob der Platz ausreicht, sollte bewegenMoeglich abdecken.
			if (felderJetztGelaufen > SPIELFELDGROESSE) {
				figur.setPosition(-1);
				figur.setHeimatfeld(felderJetztGelaufen - SPIELFELDGROESSE);
			}
			else {
				Spielfigur figurAufZielposition = 
						figurAusPosition.get(neuePosition);
				/*
				 * Schlagen.
				 * Ob die andere Figur die eines Gegners ist,
				 * sollte bewegenMoeglich abdecken 
				 */
				
				if(figurAufZielposition != null) {
					figurAufZielposition.setPosition(-1);
				}
				
				figur.setPosition(neuePosition);
			}
		}
	}
	
	private int getFelderBewegt(int start, int position) {
		if(position <= SPIELFELDGROESSE && position >= start) {
			return position - start;
		}
		return SPIELFELDGROESSE - start + position + 1;
	}

	/**
	 * ï¿œberprï¿œft, ob sich die Spielfigur bewegen darf
	 * @param figurAusPosition die Map des Spiels
	 * @param figur Welche Figur ist am Zug?
	 * @param augenzahl was war die letzte gewï¿œrfelte Augenzahl des Spielers
	 * @return true wenn die Spielfigur sich nach vorn bewegen darf, sonst false
	 */
	@Override
	public boolean bewegenMoeglich(Map<Integer, Spielfigur> figurAusPosition,
			Spielfigur figur, int augenzahl) {
		// TODO Auto-generated method stub
		int zaehler=0;
		int neuePosFeld= figur.getPosition() + augenzahl;	
		
		//immer von Startfeld möglich, außer eigene Figur steht auf neuer Position
		if(figur.getPosition() == figur.getStartfeld() 
				&& (figurAusPosition.get(neuePosFeld) == null
					||( figurAusPosition.get(neuePosFeld) != null 
						&&figurAusPosition.get(neuePosFeld).getSpieler() != figur.getSpieler())
					)
		){
			return true;
		}
		
		//Figur steht nicht auf Startfeld, aber andere eigene die ziehen kann(keine eigene im Weg) au�er niemand mehr im Haus
		if(jemandImHaus(figur)==true){
		for(int i=0; i<4; i++){
			if(figur.getPosition() != figur.getStartfeld() &&
					(positionFigur(figur, i) == figur.getStartfeld()
					&& (figurAusPosition.get(positionFigur(figur, i) + augenzahl) == null
					|| (figurAusPosition.get(positionFigur(figur, i) + augenzahl) != null
					&& figurAusPosition.get(positionFigur(figur, i) + augenzahl).getSpieler()
					!= figur.getSpieler())))){ 
						return false; 
			}
		}
		}
		
		//Schlagzwang
		for(int i=0; i<4; i++){
			if(augenzahl != 6 && figur.getSpieler().getSpielfiguren().get(i).getPosition() >= 0 &&
					(figurAusPosition.get(neuePosFeld) == null && (
					figurAusPosition.get(positionFigur(figur, i) + augenzahl) != null 
					&& figurAusPosition.get(positionFigur(figur, i) + augenzahl).getSpieler() != figur.getSpieler()))) {
				return false;
			}
		}
		
		//Bei 6 nicht aus Haus, wenn jemand auf Startfeld steht
		if(augenzahl==6 && figur.getPosition()<0 && figur.getHeimatfeld()==0 
				&& (figurAusPosition.get(figur.getStartfeld())!=null && figur.getSpieler() == figurAusPosition.get(figur.getStartfeld()).getSpieler())){
			return false;
		}
		
		//Bei 6 nur aus Haus ziehen
		if(augenzahl==6 && (figur.getPosition() >= 0 || figur.getHeimatfeld() > 0)){
			for(int i=0;i<4;i++){
				if (positionFigur(figur, i)<0 
						&& figur.getSpieler().getSpielfiguren().get(i).getHeimatfeld() < 1
						&& (figurAusPosition.get(figur.getStartfeld()) == null 
						|| figurAusPosition.get(figur.getStartfeld()).getSpieler() != figur.getSpieler())){
					return false;
				}
			}
		}
		
		//Wenn eigene Figur da steht (im Feld)   
		if (figur.getPosition()>=0 &&(figurAusPosition.get(neuePosFeld) != null  &&
				figurAusPosition.get(neuePosFeld).getSpieler() == figur.getSpieler())
				&& figur.getHeimatfeld() ==	0){
			return false;
		}
		
		if(!mitRauswerfen) {
			//Wenn Figur da steht (im Feld)   
			if (figur.getPosition()>=0 &&(figurAusPosition.get(neuePosFeld) != null  && figur.getHeimatfeld() == 0)){
				return false;
			}
		}
		
		//Wenn eigene Figur da steht (im Haus)
		if(figur.getHeimatfeld() > 0 ) {
			for(int i=1; i<=augenzahl; i++){
				for(int spieler=0; spieler<4; spieler++){
					if(figur.getSpieler().getSpielfiguren().get(spieler).getHeimatfeld() > 0
							&&figur.getHeimatfeld() + i == figur.getSpieler().getSpielfiguren().get(spieler).getHeimatfeld()){
						return false;
					}
				}
			}
		}
		
		//Wenn Figur in Haus steht und keine 6 gewürfelt wurde
		if(augenzahl != 6 && figur.getPosition() < 0 && figur.getHeimatfeld() == 0){
			return false;
		}
		
		//Wenn alle im Haus stehen und keine 6 gewï¿œrfelt wurde
		for(int i=0; i<=3; i++){
			if(augenzahl != 6 && positionFigur(figur, i) < 0  
					&& figur.getHeimatfeld() == 0){
				zaehler++;
			}
			if(zaehler == 4){
				return false;
			}
		}
		
		//Wenn die Augenzahl zu hoch ist und über das Feld hinaus gehen würde
				
		if(figur.getPosition() >= 0) {
			int felderBisherGelaufen = getFelderBewegt(figur.getStartfeld(), 
					figur.getPosition());
			int felderJetztGelaufen = felderBisherGelaufen + augenzahl;
			
			if(felderJetztGelaufen > SPIELFELDGROESSE + 4)
				return false;
		}
		else if(figur.getHeimatfeld() > 0) {
			if((4 - figur.getHeimatfeld() - augenzahl) < 0)
				return false;
		}
		
		//Wenn eine eigene Figur im Zielfeld im Weg steht
		
		int neuePosition = getFelderBewegt(figur.getStartfeld(), 
				figur.getPosition()) + augenzahl;
		if(neuePosition > SPIELFELDGROESSE) {
			int zielfeldPosition = neuePosition - SPIELFELDGROESSE;
			for(int i = 0; i < 4; i++) {
				Spielfigur andereFigur = figur.getSpieler().getSpielfiguren().get(i);
				if (andereFigur != figur) {
					if(nichtUeberspringen) {
						if(andereFigur.getHeimatfeld() > 0 
								&& andereFigur.getHeimatfeld() <= zielfeldPosition
							)
							return false;
					}
					else {
						if(andereFigur.getHeimatfeld() > 0 
								&& andereFigur.getHeimatfeld() == zielfeldPosition
							)
							return false;
					}
					
				}
			}
		}
		
		if(sichereFelder) {
			//Bei Sternfeldern nicht schlagen
			if((figurAusPosition.get(neuePosFeld) != null && (
					figurAusPosition.get(neuePosFeld).getPosition() == 2 
					|| figurAusPosition.get(neuePosFeld).getPosition() == 6
					|| figurAusPosition.get(neuePosFeld).getPosition() == 12 
					|| figurAusPosition.get(neuePosFeld).getPosition() == 16
					|| figurAusPosition.get(neuePosFeld).getPosition() == 22
					|| figurAusPosition.get(neuePosFeld).getPosition() == 26
					|| figurAusPosition.get(neuePosFeld).getPosition() == 32 
					|| figurAusPosition.get(neuePosFeld).getPosition() == 36)
				)
			){
				return false;
			}
		}
		
		
			
		return true;
		
		
	}

	/**
	 * Liefert Liste mit allen Spielfiguren des Spielers, die sich bewegen dï¿œrfen
	 * @param figurAusPosition die Map des Spiels
	 * @param amZug der Spieler der grade an der Reihe ist
	 * @param augenzahl die gewï¿œrfelte Augenzahl des Spielers
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
	 * ï¿œberprï¿œft, ob ein Spieler gewonnen hat
	 * @param spieler der spieler der grade am Zug ist.
	 * @return true wenn er gewonnen hat, sonst false
	 */
	@Override
	public boolean gewonnen(Spieler spieler) {
		// TODO Auto-generated method stub
		int zaehler=0;
		for(int i=0; i<4; i++){
			if(spieler.getSpielfiguren().get(i).getHeimatfeld() == 1 || spieler.getSpielfiguren().get(i).getHeimatfeld() == 2
					|| spieler.getSpielfiguren().get(i).getHeimatfeld() == 3 || spieler.getSpielfiguren().get(i).getHeimatfeld() == 4){
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