package basis;

import java.util.List;

import logik.Spieler;
import logik.Spielfigur;

public interface IRegeln {
	public int wuerfel();
	public boolean nochMalWuerfeln(Spieler spieler, int wieOftSchonGewuerfelt, int letzteAugenzahl);
	public void positionsKonflikt(Spielfigur ziehender, Spielfigur stehender);
	public void bewegeFigur(List<Spieler> alleSpieler, Spielfigur figur, int felderVor);
	public boolean bewegenMoeglich(List<Spieler> alleSpieler, Spielfigur figur, int augenzahl);
	public List<Spielfigur> getOptionen(List<Spieler> alleSpieler, Spieler amZug, int augenzahl);
	public boolean gewonnen(Spieler spieler);
}
