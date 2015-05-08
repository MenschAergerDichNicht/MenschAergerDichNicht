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
		
		assertEquals(0, olesFigur.getPosition());
		assertEquals(10, leasFigur.getPosition());
		
		brett.bewegeFigur(olesFigur, 6);
		
		assertEquals(6, olesFigur.getPosition());
		
		brett.bewegeFigur(olesFigur, 4);
		
		assertEquals(10, olesFigur.getPosition());
		assertTrue(leasFigur.getPosition() < 0);
		
		olesFigur.setPosition(0);
		
		Spielfigur olesZweiteFigur = ole.getSpielfiguren().get(1);
		
		brett.bewegeFigur(olesFigur, 3);
		brett.setzeFigurInsFeld(olesZweiteFigur);
		brett.bewegeFigur(olesZweiteFigur, 3);
		
		assertEquals(0, olesZweiteFigur.getPosition());
		
		brett.setzeFigurInsFeld(ole.getSpielfiguren().get(2));
		
		assertTrue(ole.getSpielfiguren().get(2).getPosition() < 0);
		
		olesFigur.setPosition(39);
		brett.bewegeFigur(olesFigur, 1);
		assertTrue(olesFigur.getPosition() < 0);
		assertEquals(1, olesFigur.getHeimatfeld());
		
		olesFigur.setPosition(-1);
		olesFigur.setHeimatfeld(1);
		olesZweiteFigur.setPosition(-1);
		olesZweiteFigur.setHeimatfeld(2);
		
		for(int i = 0; i <= 3; i++) {
			brett.bewegeFigur(olesFigur, i);
		}
		
		assertEquals(1, olesFigur.getHeimatfeld());
		
		
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
		
		//TODO Bewegen möglich wenn Figur im Weg?
		//TODO Bewegen möglich wenn Figur im Zielfeld im Weg?
		//TODO Bewegen möglich wenn Figur anderswo schlagbar?
		
		
		//assertEquals(10, leasFigur.getPosition()); //Im Controller oder Modell überprüfen?

	}
	
	@Test
	public void testGetOptionen() {
		//TODO Vier Optionen wenn 6 zu Beginn?
		//TODO Eine Option wenn Figur auf Startfeld?
		//TODO Die richtige Option, wenn eine Figur auf dem Startfeld, andere im Weg?
		//TODO Die richtge Option, wenn eine Figur schlagbar?
		//TODO Zwei Optionen wenn eine Figur im Zielfeld, die andere auf dem Feld?
	}
	
	@Test
	public void testGewonnen() {
		for(int i = 0; i <= 3; i++) {
			spielerliste.get(0).getSpielfiguren().get(i).setHeimatfeld(i + 1);
		}
		
		assertTrue(regeln.gewonnen(spielerliste.get(0)));
	}
}
