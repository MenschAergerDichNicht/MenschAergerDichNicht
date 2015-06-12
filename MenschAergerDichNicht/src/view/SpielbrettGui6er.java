package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import regeln.MitRauswerfen;
import logik.*;


public class SpielbrettGui6er extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int[][] feldKoordinatenZuPosition = {
			{ 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00},
			{ 00, 00, 00,105,106, 00, 00,  0, 53, 52, 00, 00,205,206, 00, 00},
			{ 00, 00, 00,107,108, 00, 00,  1,201, 51, 00, 00,207,208, 00, 00},
			{ 00, 00, 00, 00, 00, 00, 00,  2,202, 50, 00, 00, 00, 00, 00, 00},
			{ 00, 00, 00,  7,  6,  5,  4,  3,203, 49, 48, 47, 46, 45, 00, 00},
			{ 00, 00, 00,  8,101,102,103,104,204,304,303,302,301, 44, 00, 00},
			{ 00, 00, 00,  9, 10, 11, 00, 00, 00, 00, 00, 41, 42, 43, 00, 00},
			{ 00,605,606, 00, 00, 12, 00, 00, 00, 00, 00, 40, 00, 00,305,306},
			{ 00,607,608, 00, 00, 13, 00, 00, 00, 00, 00, 39, 00, 00,307,308},
			{ 00, 00, 00, 16, 15, 14, 00, 00, 00, 00, 00, 38, 37, 36, 00, 00},
			{ 00, 00, 00, 17,601,602,603,604,504,404,403,402,401, 35, 00, 00},
			{ 00, 00, 00, 18, 19, 20, 21, 22,503, 30, 31, 32, 33, 34, 00, 00},
			{ 00, 00, 00, 00, 00, 00, 00, 23,502, 29, 00, 00, 00, 00, 00, 00},
			{ 00, 00, 00,505,506, 00, 00, 24,501, 28, 00, 00,405,406, 00, 00},
			{ 00, 00, 00,507,508, 00, 00, 25, 26, 27, 00, 00,407,408, 00, 00},
			{ 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00 ,00},
	};
	
	private SpielController controller;
	private Spielbrett spielbrett;
	private Map<Integer, Kreis> alleFelder = new HashMap<>();
	
//	public static void main(String args[]) {
//		SpielbrettGui6er sbg = new SpielbrettGui6er();
//		sbg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		sbg.setSize(825, 615);
//		sbg.setVisible(true);
//	}
	
	public static void main(String args[]) {
		LinkedList<Spieler> spieler = new LinkedList<>();
		Spielerfabrik fabrik = new Spielerfabrik(6);
		
		spieler.add(fabrik.getSpieler(Color.RED, "Ole"));
		spieler.add(fabrik.getSpieler(Color.GREEN, "Franzi"));
		spieler.add(fabrik.getSpieler(Color.BLUE, "Laura"));
		spieler.add(fabrik.getSpieler(Color.YELLOW, "Alex"));
		spieler.add(fabrik.getSpieler(Color.DARK_GRAY, "test"));
		spieler.add(fabrik.getSpieler(Color.MAGENTA, "test2"));
		
//		for(Spieler spiel:spieler) {
//			if(spiel.getName().equals("Ole"))
//			spiel.setComputer();
//		}
		
		Spielbrett brett = new Spielbrett(spieler, new MitRauswerfen(false, true, false));
		SpielbrettGui6er sbg = new SpielbrettGui6er(brett);
		sbg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sbg.setSize(825, 615);
		sbg.setVisible(true);
	}
	
	public SpielbrettGui6er(Spielbrett brett) {
		
		spielbrett = brett;
		spielbrett.addObserver(this);
		controller = new SpielController(brett, this);
		
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(getSpielfeld(), BorderLayout.CENTER);
		pane.add(getAnzeige(), BorderLayout.EAST);
		setzeAlleFigurenInsHeim();
	}
	
	protected JComponent getSpielfeld() {
		JPanel spielfeld = new JPanel();
		spielfeld.setLayout(new GridBagLayout());
		spielfeld.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		spielfeld.setPreferredSize(new Dimension(600, 680));
		
		
		//Array der Spielfelder, noch mit spieler verbinden
		byte[][] weiss = {{6,7,6,8,6,8,3,4,5,6,8,9,10,11,12,2,12,2,3,4,10,11,4,10,4,10,3,4,10,11,12,2,12,2,3,4,5,6,8,9,10,11,6,8,6,8,7,8},{0,0,1,1,2,2,3,3,3,3,3,3,3,3,3,4,4,5,5,5,5,5,6,6,7,7,8,8,8,8,8,9,9,10,10,10,10,10,10,10,10,10,11,11,12,12,13,13}};
		byte[][] spieler1 = {{2,3,2,3,2,3,4,5,6},{0,0,1,1,3,4,4,4,4}};
		byte[][] spieler2 = {{11,12,11,12,8,7,7,7,7},{0,0,1,1,0,1,2,3,4}};
		byte[][] spieler3 = {{13,13,14,14,12,8,9,10,11},{6,7,6,7,5,4,4,4,4}};
		byte[][] spieler4 = {{11,11,12,12,12,8,9,10,11},{12,13,12,13,10,9,9,9,9}};
		byte[][] spieler5 = {{2,3,2,3,6,7,7,7,7},{12,12,13,13,13,9,10,11,12}};
		byte[][] spieler6 = {{0,0,1,1,2,3,4,5,6},{6,7,6,7,8,9,9,9,9}};
		
		zeichnen(weiss, spielfeld, Color.WHITE);
		zeichnen(spieler1, spielfeld, spielbrett.getSpieler().get(0).getFarbe());
		zeichnen(spieler2, spielfeld, spielbrett.getSpieler().get(1).getFarbe());
		zeichnen(spieler3, spielfeld, spielbrett.getSpieler().get(2).getFarbe());
		zeichnen(spieler4, spielfeld, spielbrett.getSpieler().get(3).getFarbe());
		zeichnen(spieler5, spielfeld, spielbrett.getSpieler().get(4).getFarbe());
		zeichnen(spieler6, spielfeld, spielbrett.getSpieler().get(5).getFarbe());
		
		return spielfeld;
	}
	protected void zeichnen(byte[][] x, JComponent jc, Color color) {
		for(int i = 0; i < x.length-1; i++) {
			for(int j = 0; j < x[i].length; j++) {
				int feldnummer = feldKoordinatenZuPosition[x[i][j]][x[i+1][j]];
				Kreis kreis = new Kreis(color, feldnummer);
				alleFelder.put(feldnummer, kreis);
				spielbrett.addObserver(kreis);
				kreis.addMouseListener(controller);
				kreis.addMouseMotionListener(controller);
				jc.add(new Kreis(color, j), getPosition(x[i][j], x[i+1][j]));
			}
		}
	}
	
	private void setzeFigurenInsHeim(int spieler) {
		Spieler spielerobjekt = spielbrett.getSpieler().get(spieler - 1);

		int basisfeldnummer = (spieler * 100) + 5;
		for(Spielfigur figur:spielerobjekt.getSpielfiguren()) {
				alleFelder.get(basisfeldnummer).setHeimatfeld();
			if(figur.getPosition() < 0 && figur.getHeimatfeld() < 1) {
				alleFelder.get(basisfeldnummer).setBesetzer(figur);
			}
			else {
				alleFelder.get(basisfeldnummer).setBesetzer(null);
			}
			basisfeldnummer++;
		}
		
	}
	
	private void setzeAlleFigurenInsHeim() {
		for(int i = 1; i <= spielbrett.getSpieler().size(); i++) {
			setzeFigurenInsHeim(i);
		}
	}
	
	protected JComponent getAnzeige() {
		JPanel anzeige = new JPanel();
		anzeige.setLayout(new BorderLayout());
		anzeige.setPreferredSize(new Dimension(200, 800));
		anzeige.add(getSpieler(), BorderLayout.CENTER);
		anzeige.add(getWuerfel(), BorderLayout.SOUTH);
		JButton button = new JButton("Zug beenden");
		button.addMouseListener(controller);
		anzeige.add(button, BorderLayout.NORTH);
		return anzeige;
	}
	
	protected JComponent getSpieler() {
		Spieleranzeige anzeige = new Spieleranzeige(spielbrett);
		spielbrett.addObserver(anzeige);
		anzeige.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		return anzeige;
	}
	
	protected JComponent getWuerfel() {
		Wuerfel wuerfel = new Wuerfel();
		wuerfel.setPreferredSize(new Dimension(180, 200));
		wuerfel.addMouseListener(controller);
		wuerfel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		return wuerfel;
	}
	/**
	 * Position der einzelnen Kreise
	 * */
	protected GridBagConstraints getPosition (int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridx = x;
		gbc.gridy = y;
		return gbc;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg.getClass().equals(Spielfigur.class)) {
			setzeAlleFigurenInsHeim();
			repaint();
		}
	}
}