package basis;

import logik.Spieler;
import logik.Spielfigur;

public interface IRegeln {
	public int wuerfel();
	public boolean nochMalWuerfeln(Spieler spieler, int wieOftSchonGewuerfelt, int letzteAugenzahl);
	public void positionsKonflikt(Spielfigur ziehender, Spielfigur stehender);
	
}
