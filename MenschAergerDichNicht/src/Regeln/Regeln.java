package Regeln;

import java.util.List;
import java.util.Map;

import logik.Spieler;
import logik.Spielfigur;
import basis.IRegeln;

public class Regeln implements IRegeln {
	IRegeln wuerfel;
	IRegeln nochMalWuerfeln;
	IRegeln bewegeFigur;
	IRegeln bewegenMoeglich;
	IRegeln getOptionen;
	IRegeln gewonnen;
	
	IRegeln standard = new MitRauswerfen();
	
	
	public Regeln(IRegeln wuerfel, 
			IRegeln nochMalWuerfeln,
			IRegeln bewegeFigur,
			IRegeln bewegenMoeglich,
			IRegeln getOptionen,
			IRegeln gewonnen) {
		this.nochMalWuerfeln = nochMalWuerfeln;
		this.bewegeFigur = bewegeFigur;
		this.bewegenMoeglich = bewegenMoeglich;
		this.wuerfel = wuerfel;
		this.getOptionen = getOptionen;
		this.gewonnen = gewonnen;
	}

	@Override
	public int wuerfel() {
		if(wuerfel != null) {
			return wuerfel.wuerfel();
		}
		return standard.wuerfel();
	}

	@Override
	public boolean nochMalWuerfeln(Spieler spieler, int wieOftSchonGewuerfelt,
			int letzteAugenzahl) {
		if(nochMalWuerfeln != null) {
			return nochMalWuerfeln.nochMalWuerfeln(spieler, wieOftSchonGewuerfelt, letzteAugenzahl);
		}
		return standard.nochMalWuerfeln(spieler, wieOftSchonGewuerfelt, letzteAugenzahl);
	}

	@Override
	public void bewegeFigur(Map<Integer, Spielfigur> figurAusPosition,
			Spielfigur figur, int felderVor) {
		if(bewegeFigur != null) {
			bewegeFigur.bewegeFigur(figurAusPosition, figur, felderVor);
		}
		standard.bewegeFigur(figurAusPosition, figur, felderVor);		
	}

	@Override
	public boolean bewegenMoeglich(Map<Integer, Spielfigur> figurAusPosition,
			Spielfigur figur, int augenzahl) {
		if(bewegenMoeglich != null) {
			return bewegenMoeglich.bewegenMoeglich(figurAusPosition, figur, augenzahl);
		}
		return standard.bewegenMoeglich(figurAusPosition, figur, augenzahl);
	}

	@Override
	public List<Spielfigur> getOptionen(
			Map<Integer, Spielfigur> figurAusPosition, Spieler amZug,
			int augenzahl) {
		if(getOptionen != null) {
			return getOptionen.getOptionen(figurAusPosition, amZug, augenzahl);
		}
		return standard.getOptionen(figurAusPosition, amZug, augenzahl);
	}

	@Override
	public boolean gewonnen(Spieler spieler) {
		if(gewonnen != null) {
			return gewonnen.gewonnen(spieler);
		}
		return standard.gewonnen(spieler);
	}

}
