package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import regeln.MitRauswerfen;
import logik.Spielbrett;
import logik.Spieler;


public class SpielbrettGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int[][] feldKoordinatenZuPosition = {
			{00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00},
			{00, 00, 00, 00, 00, 10,  9,  8, 00, 00, 00, 00},
			{00, 00, 00, 00, 00, 11,201,  7, 00, 00, 00, 00},
			{00, 00, 00, 00, 00, 12,203,  6, 00, 00, 00, 00},
			{00, 00, 00, 00, 00, 13,204,  5, 00, 00, 00, 00},
			{00, 18, 17, 16, 15, 14,205,  4,  3,  2,  1,  0},
			{00, 19,301,302,303,304, 00,104,103,102,101, 39},
			{00, 20, 21, 22, 23, 24,404, 34, 35, 36, 37, 38},
			{00, 00, 00, 00, 00, 25,403, 33, 00, 00, 00, 00},
			{00, 00, 00, 00, 00, 26,402, 32, 00, 00, 00, 00},
			{00, 00, 00, 00, 00, 27,401, 31, 00, 00, 00, 00},
			{00, 00, 00, 00, 00, 28, 29, 30, 00, 00, 00, 00}
			};
	private SpielController controller;
	private Spielbrett spielbrett;
	
	public static void main(String args[]) {
		LinkedList<Spieler> spieler = new LinkedList<>();
		spieler.add(new Spieler(Color.RED, 0, "Ole"));
		spieler.add(new Spieler(Color.GREEN, 10, "Franzi"));
		spieler.add(new Spieler(Color.BLUE, 20, "Laura"));
		spieler.add(new Spieler(Color.YELLOW, 30, "Alex"));
		
		Spielbrett brett = new Spielbrett(spieler, new MitRauswerfen());
		
		SpielbrettGui sbg = new SpielbrettGui(brett);
		sbg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		sbg.setExtendedState(JFrame.MAXIMIZED_BOTH);
		sbg.setSize(800, 615);
		sbg.setVisible(true);
	}
	
	public SpielbrettGui(Spielbrett brett) {
		
		spielbrett = brett;
		controller = new SpielController(brett);
		
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(getSpielfeld(), BorderLayout.CENTER);
		pane.add(getAnzeige(), BorderLayout.EAST);
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
				System.out.println(i + "," + j);
				Kreis kreis = new Kreis(color, feldKoordinatenZuPosition[x[i][j]][x[i+1][j]]);
				spielbrett.addObserver(kreis);
				kreis.addMouseListener(controller);
				jc.add(kreis, getPosition(x[i][j], x[i+1][j]));
			}
		}
	}
	
	protected JComponent getAnzeige() {
		JPanel anzeige = new JPanel();
		anzeige.setLayout(new BorderLayout());
		anzeige.setPreferredSize(new Dimension(200, 800));
//		anzeige.add(getSpieler(), BorderLayout.NORTH);
		anzeige.add(getWuerfel(), BorderLayout.SOUTH);
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
}