package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import logik.Spielbrett;
import logik.Spieler;
import logik.Spielerfabrik;
import logik.Spielfigur;

import org.junit.Before;
import org.junit.Test;

import regeln.MitRauswerfen;
import basis.IRegeln;

public class NormaleRegelnTest {
	
	Spielbrett brett;
	List<Spieler> spielerliste;
	IRegeln regeln;
	Spielerfabrik fabrik;

	@Before
	public void setUp() throws Exception {
		spielerliste = new LinkedList<>();
		regeln = new MitRauswerfen(false, true, true);
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
		
	}
	
	@Test
	public void testBewegenMoeglich() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = Spielbrett.class.getDeclaredField("figurAusPosition");
		field.setAccessible(true);
		
		
		Spieler ole = spielerliste.get(0);
		Spieler lea = spielerliste.get(1);
		
		Spielfigur olesFigur = ole.getSpielfiguren().get(0);
		Spielfigur olesZweiteFigur = ole.getSpielfiguren().get(1);
		Spielfigur leasFigur = lea.getSpielfiguren().get(0);
		
		brett = new Spielbrett(spielerliste, regeln);
		
		while (brett.wuerfeln() == 6) {
			brett = new Spielbrett(spielerliste, regeln);
		}
		assertFalse(brett.bewegenMoeglich(olesFigur));
		
		brett.setzeFigurInsFeld(olesFigur);
				
		olesFigur.setPosition(-1);
		olesZweiteFigur.setPosition(-1);
		
		olesFigur.setHeimatfeld(1);
		olesZweiteFigur.setHeimatfeld(2);

		@SuppressWarnings("unchecked")
		Map<Integer, Spielfigur> figurAusPosition = (Map<Integer, Spielfigur>) field.get(brett);
		for(int i = 1; i <=4; i++) {
			assertFalse(regeln.bewegenMoeglich(figurAusPosition, olesFigur, i));
		}
		
		
		//Bewegen möglich wenn Figur anderswo schlagbar?
		Map<Integer, Spielfigur> figurAusPositionNeu = new HashMap<>();
		
		figurAusPositionNeu.put(0, olesFigur);
		figurAusPositionNeu.put(1, leasFigur);
		figurAusPositionNeu.put(2, olesZweiteFigur);
		
		olesFigur.setPosition(0);
		olesZweiteFigur.setPosition(2);
		leasFigur.setPosition(1);
		
		//Bewegen sollte für die zweite Figur nicht möglich sein, da leas Figur auf 1 schlagbar ist.
		assertFalse(regeln.bewegenMoeglich(figurAusPositionNeu, olesZweiteFigur, 1));
		
		
		//assertEquals(10, leasFigur.getPosition()); //Im Controller oder Modell überprüfen?

	}
	
	@Test
	public void testGetOptionen() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Field field = Spielbrett.class.getDeclaredField("figurAusPosition");
		field.setAccessible(true);
		brett = new Spielbrett(spielerliste, regeln);
		
		@SuppressWarnings("unchecked")
		Map<Integer, Spielfigur> figurAusPosition = (Map<Integer, Spielfigur>) field.get(brett);
		//Vier Optionen wenn 6 zu Beginn?
		Spieler ole = spielerliste.get(0);
		assertEquals(4, regeln.getOptionen(figurAusPosition, ole, 6).size());
		
		Spielfigur olesFigur = ole.getSpielfiguren().get(0);
		
		brett.setzeFigurInsFeld(olesFigur);
		
		//Eine Option wenn Figur auf Startfeld?
		
		for(int i = 1; i <= 6; i++) {
			assertEquals(1, regeln.getOptionen(figurAusPosition, ole, i).size());
		}
		
		Spielfigur olesZweiteFigur = ole.getSpielfiguren().get(1);
		Spieler lea = spielerliste.get(1);
		Spielfigur leasFigur = lea.getSpielfiguren().get(0);
		
		olesZweiteFigur.setPosition(2);
		leasFigur.setPosition(1);
		
		figurAusPosition.put(0, olesFigur);
		figurAusPosition.put(1, leasFigur);
		figurAusPosition.put(2, olesZweiteFigur);
		
		//Die richtige Option, wenn eine Figur auf dem Startfeld, andere im Weg?
		assertTrue(regeln.getOptionen(figurAusPosition, ole, 2).get(0) == olesZweiteFigur);
		
		//Die richtge Option, wenn eine Figur schlagbar?
		assertTrue(regeln.getOptionen(figurAusPosition, ole, 1).get(0) == olesFigur);
		assertEquals(1, regeln.getOptionen(figurAusPosition, ole, 1).size());
		
		//Zwei Optionen wenn eine Figur im Zielfeld, die andere auf dem Feld?
		figurAusPosition.remove(0);
		olesFigur.setHeimatfeld(1);
		olesFigur.setPosition(-1);
		
		for(int i = 1; i <= 3; i++) {
			assertEquals(2, regeln.getOptionen(figurAusPosition, ole, i).size());
		}
		
	}
	
	@Test
	public void testGewonnen() {
		for(int i = 0; i <= 3; i++) {
			spielerliste.get(0).getSpielfiguren().get(i).setHeimatfeld(i + 1);
		}
		
		assertTrue(regeln.gewonnen(spielerliste.get(0)));
	}
}
