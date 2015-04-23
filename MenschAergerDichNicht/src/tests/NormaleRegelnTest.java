package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import logik.Spielbrett;
import logik.Spieler;
import logik.Spielerfabrik;

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
		for(int i = 1; i <= 5; i++) {
			assertTrue(regeln.nochMalWuerfeln(ole, 2, i));
		}
		for(int i = 1; i <= 5; i++) {
			assertFalse(regeln.nochMalWuerfeln(ole, 3, i));
		}
		assertFalse("Zu Beginn darf man drei mal würfeln um die Figur"
				+ " herauszubringen. Unabhängig davon ob da eine sechs"
				+ " dabei ist oder nicht.",
				regeln.nochMalWuerfeln(ole, 3, 6));
		
		ole.getSpielfiguren().get(0).setPosition(0); 
		
		assertFalse(regeln.nochMalWuerfeln(spielerliste.get(0), 0, 4));
		assertTrue(regeln.nochMalWuerfeln(spielerliste.get(0), 0, 6));
		
	}
	
	@Test
	public void testBewegeFigur() {
		
	}
}
