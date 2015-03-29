package basis;

import java.util.List;
import java.util.Map;

import logik.Spieler;
import logik.Spielfigur;

/**
 * @author ole
 * Wird konsultiert, sobald regelrelevante Ereignisse stattfinden.
 */
public interface IRegeln {
	public int wuerfel();
	public boolean nochMalWuerfeln(Spieler spieler, int wieOftSchonGewuerfelt, int letzteAugenzahl);
	public void bewegeFigur(Map<Integer, Spielfigur> figurAusPosition, Spielfigur figur, int felderVor);
	public boolean bewegenMoeglich(Map<Integer, Spielfigur> figurAusPosition, Spielfigur figur, int augenzahl);
	public List<Spielfigur> getOptionen(Map<Integer, Spielfigur> figurAusPosition, Spieler amZug, int augenzahl);
	public boolean gewonnen(Spieler spieler);
}
