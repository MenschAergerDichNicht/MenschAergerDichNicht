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
import logik.Spielbrett;
import logik.Spieler;
import logik.Spielerfabrik;
import logik.Spielfigur;


public class SpielbrettGui extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int[][] feldKoordinatenZuPosition = {
			{00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00},
			{00,205,206, 00, 00, 10,  9,  8, 00, 00,105,106},
			{00,207,208, 00, 00, 11,201,  7, 00, 00,107,108},
			{00, 00, 00, 00, 00, 12,202,  6, 00, 00, 00, 00},
			{00, 00, 00, 00, 00, 13,203,  5, 00, 00, 00, 00},
			{00, 18, 17, 16, 15, 14,204,  4,  3,  2,  1,  0},
			{00, 19,301,302,303,304, 00,104,103,102,101, 39},
			{00, 20, 21, 22, 23, 24,404, 34, 35, 36, 37, 38},
			{00, 00, 00, 00, 00, 25,403, 33, 00, 00, 00, 00},
			{00, 00, 00, 00, 00, 26,402, 32, 00, 00, 00, 00},
			{00,305,306, 00, 00, 27,401, 31, 00, 00,405,406},
			{00,307,308, 00, 00, 28, 29, 30, 00, 00,407,408}
			};
	private SpielController controller;
	private Spielbrett spielbrett;
	private Map<Integer, Kreis> alleFelder = new HashMap<>();
	
	public static void main(String args[]) {
		LinkedList<Spieler> spieler = new LinkedList<>();
		Spielerfabrik fabrik = new Spielerfabrik(4);
		
		spieler.add(fabrik.getSpieler(Color.RED, "Ole"));
		spieler.add(fabrik.getSpieler(Color.GREEN, "Franzi"));
		spieler.add(fabrik.getSpieler(Color.BLUE, "Laura"));
		spieler.add(fabrik.getSpieler(Color.YELLOW, "Alex"));
		
		for(Spieler spiel:spieler) {
			if(!spiel.getName().equals("Ole"))
			spiel.setComputer();
		}
		
		Spielbrett brett = new Spielbrett(spieler, new MitRauswerfen());
		
		SpielbrettGui sbg = new SpielbrettGui(brett);
		sbg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		sbg.setExtendedState(JFrame.MAXIMIZED_BOTH);
		sbg.setSize(800, 615);
		sbg.setVisible(true);
	}
	
	public SpielbrettGui(Spielbrett brett) {
		
		spielbrett = brett;
		spielbrett.addObserver(this);
		controller = new SpielController(brett);
		
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
		spielfeld.setPreferredSize(new Dimension(600, 615));
		
		
		//Array der Spielfelder, noch mit spieler verbinden
		byte[][] weiss = {{5,6,5,7,5,7,5,7,2,3,4,5,7,8,9,10,11,1,11,1,2,3,4,5,7,8,9,10,5,7,5,7,5,7,6,7},{1,1,2,2,3,3,4,4,5,5,5,5,5,5,5,5,5,6,6,7,7,7,7,7,7,7,7,7,8,8,9,9,10,10,11,11}};
		byte[][] spieler1 = {{1,1,2,2,5,6,6,6,6},{10,11,10,11,11,7,8,9,10}};
		byte[][] spieler2 = {{1,2,1,2,1,2,3,4,5},{1,1,2,2,5,6,6,6,6}};
		byte[][] spieler3 = {{7,6,6,6,6,11,11,10,10},{1,2,3,4,5,1,2,1,2}};
		byte[][] spieler4 = {{10,11,11,10,11,7,8,9,10},{11,11,10,10,7,6,6,6,6}};
		
		zeichnen(weiss, spielfeld, Color.WHITE);
		zeichnen(spieler1, spielfeld, spielbrett.getSpieler().get(0).getFarbe());
		zeichnen(spieler2, spielfeld, spielbrett.getSpieler().get(1).getFarbe());
		zeichnen(spieler3, spielfeld, spielbrett.getSpieler().get(2).getFarbe());
		zeichnen(spieler4, spielfeld, spielbrett.getSpieler().get(3).getFarbe());
		
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
				jc.add(kreis, getPosition(x[i][j], x[i+1][j]));
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
		
		JButton button = new JButton("Zug Beenden");
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
		wuerfel.addMouseListener(controller);
		wuerfel.setPreferredSize(new Dimension(180, 200));
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