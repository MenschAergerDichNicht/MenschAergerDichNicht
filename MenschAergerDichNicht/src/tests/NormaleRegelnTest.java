package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import logik.Spielbrett;
import logik.Spieler;
import logik.Spielerfabrik;
import logik.Spielfigur;

import org.junit.Before;
import org.junit.Test;

import Regeln.MitRauswerfen;
import basis.IRegeln;

public class NormaleRegelnTest {
	
	Spielbrett brett;
	List<Spieler> spielerliste;
	IRegeln regeln;
	Spielerfabrik fabrik;

	@Before
	public void setUp() throws Exception {
		spielerliste = new LinkedList<>();
		regeln = new MitRauswerfen();
		fabrik = new Spielerfabrik(2);
		spielerliste.add(fabrik.getSpieler(Color.BLUE, "ole"));
		spielerliste.add(fabrik.getSpieler(Color.RED, "lea"));
		
	}

	@Test
	public void testWuerfel() {
		int zufallszahl;
		for(int i = 0; i < 100000; i++) {
			zufallszahl = regeln.wuerfel();
			assertTrue(zufallszahl >= 1 && zufallszahl <= 6);
		}
	}
	
	@Test
	public void testNochMalWuerfeln() {
		Spieler ole = spielerliste.get(0);
		for(int anzahlWuerfe = 0; anzahlWuerfe <= 2; anzahlWuerfe++){
			for(int i = 1; i <= 6; i++) {
				assertTrue(regeln.nochMalWuerfeln(ole, anzahlWuerfe, i));
			}
		}
		
		for(int i = 1; i <= 5; i++) {
			assertFalse(regeln.nochMalWuerfeln(ole, 3, i));
		}
		assertTrue(regeln.nochMalWuerfeln(ole, 3, 6));
		
		ole.getSpielfiguren().get(0).setPosition(0); 
		
		for(int i = 1; i <= 5; i++) {
			assertFalse(regeln.nochMalWuerfeln(spielerliste.get(0), 0, i));
		}
		assertTrue(regeln.nochMalWuerfeln(spielerliste.get(0), 0, 6));
		
	}
	
	@Test
	public void testBewegeFigur() {
		Spieler ole = spielerliste.get(0);
		Spieler lea = spielerliste.get(1);
		
		Spielfigur olesFigur = ole.getSpielfiguren().get(0);
		Spielfigur leasFigur = lea.getSpielfiguren().get(0);
		
		brett = new Spielbrett(spielerliste, regeln);
		
		brett.setzeFigurInsFeld(olesFigur);
		brett.setzeFigurInsFeld(leasFigur);
		
		assertEquals(olesFigur.getPosition(), 0);
		assertEquals(leasFigur.getPosition(), 10);
		
		brett.bewegeFigur(olesFigur, 6);
		
		assertEquals(olesFigur.getPosition(), 6);
		
		brett.bewegeFigur(olesFigur, 4);
		
		assertEquals(olesFigur.getPosition(), 10);
		assertTrue(leasFigur.getPosition() < 0);
		
		//TODO Ziehen ins Zielfeld
		
	}
	
	@Test
	public void testBewegenMoeglich() {
		Spieler ole = spielerliste.get(0);
		Spieler lea = spielerliste.get(1);
		
		Spielfigur olesFigur = ole.getSpielfiguren().get(0);
		Spielfigur leasFigur = lea.getSpielfiguren().get(0);
		
		brett = new Spielbrett(spielerliste, regeln);
		
		while (brett.wuerfeln() == 6) {
			brett = new Spielbrett(spielerliste, regeln);
		}
		assertFalse(brett.bewegenMoeglich(olesFigur));
		
		brett.setzeFigurInsFeld(olesFigur);
		brett.setzeFigurInsFeld(leasFigur);

		//TODO Bewegen möglich wenn Spieler nicht am Zug?
		//TODO Bewegen möglich wenn eigene Figur im Weg?
		//TODO Bewegen möglich wenn eigene Figur im Zielfeld im Weg?
	}
	
	@Test
	public void testGetOptionen() {
		//TODO Repariere Bewegung
		fail("Noch nicht geschrieben.");
	}
	
	@Test
	public void testGewonnen() {
		//TODO Schreiben ;)
		fail("Noch nicht geschrieben.");
	}
}
