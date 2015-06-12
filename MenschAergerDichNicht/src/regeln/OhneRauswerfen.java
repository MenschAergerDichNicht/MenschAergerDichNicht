package regeln;


import java.util.Map;
import logik.Spielfigur;
import basis.IRegeln;

/**
 * Diese Klasse liefert die Regeln f�r das Spiel, wenn das Rauswerfen verboten wurde
 * @author lea
 */
public class OhneRauswerfen extends MitRauswerfen implements IRegeln{
	
	public OhneRauswerfen(boolean sichereFelder, boolean mitRauswerfen,
			boolean nichtUeberspringen) {
		super(sichereFelder, mitRauswerfen, nichtUeberspringen);
	}
	
	private int positionFigur(Spielfigur figur, int i){
		return figur.getSpieler().getSpielfiguren().get(i).getPosition();
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

	@Override
	public boolean bewegenMoeglich(Map<Integer, Spielfigur> figurAusPosition,
			Spielfigur figur, int augenzahl) {
		// TODO Auto-generated method stub
		int zaehler=0;
		int neuePosFeld= figur.getPosition() + augenzahl;	
		
		//immer von Startfeld möglich, außer eigene Figur steht auf neuer Position
		if(figur.getPosition() == figur.getStartfeld() && (figurAusPosition.get(neuePosFeld) == null)){
			return true;
		}
		
		//Figur steht nicht auf Startfeld, aber andere eigene die ziehen kann(keine Figur im Weg) au�er niemand mehr im Haus
		if(jemandImHaus(figur)==true){
		for(int i=0; i<4; i++){
			if(figur.getPosition() != figur.getStartfeld() &&
					(positionFigur(figur, i) == figur.getStartfeld()
					&& (figurAusPosition.get(positionFigur(figur, i) + augenzahl) == null
					|| (figurAusPosition.get(positionFigur(figur, i) + augenzahl) != null
					&& figurAusPosition.get(neuePosFeld) != null)))){ 
						return false; 
			}
		}
		}
		
		//Bei 6 nicht aus Haus, wenn jemand auf Startfeld steht
		if(augenzahl==6 && figur.getPosition()<0 && figur.getHeimatfeld()==0 
				&& figurAusPosition.get(figur.getStartfeld())!=null){
			return false;
		}
		
		//Bei 6 nur aus Haus ziehen
		if(augenzahl==6 && figur.getPosition() >= 0){
			for(int i=0;i<4;i++){
				if (positionFigur(figur, i)<0 && figur.getSpieler().getSpielfiguren().get(i).getHeimatfeld() == 0
						&& (figurAusPosition.get(figur.getStartfeld())==null)){
					return false;
				}
			}
		}
		
		//Wenn Figur da steht (im Feld)   
		if (figur.getPosition()>=0 &&(figurAusPosition.get(neuePosFeld) != null  && figur.getHeimatfeld() == 0)){
			return false;
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
			
		return true;
	}



}
