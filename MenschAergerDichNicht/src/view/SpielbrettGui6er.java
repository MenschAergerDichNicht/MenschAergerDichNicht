package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SpielbrettGui6er extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String args[]) {
		SpielbrettGui6er sbg = new SpielbrettGui6er();
		sbg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sbg.setSize(825, 615);
		sbg.setVisible(true);
	}
	
	public SpielbrettGui6er() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(getSpielfeld(), BorderLayout.CENTER);
		pane.add(getAnzeige(), BorderLayout.EAST);
	}
	
	protected JComponent getSpielfeld() {
		JPanel spielfeld = new JPanel();
		spielfeld.setLayout(new GridBagLayout());
		spielfeld.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		spielfeld.setPreferredSize(new Dimension(600, 680));
		
		
		//Array der Spielfelder, noch mit spieler verbinden
		byte[][] weiss = {{6,7,6,8,6,8,3,4,5,6,8,9,10,11,12,2,12,2,3,4,10,11,4,10,4,10,3,4,10,11,12,2,12,2,3,4,5,6,8,9,10,11,6,8,6,8,7,8},{0,0,1,1,2,2,3,3,3,3,3,3,3,3,3,4,4,5,5,5,5,5,6,6,7,7,8,8,8,8,8,9,9,10,10,10,10,10,10,10,10,10,11,11,12,12,13,13}};
		byte[][] spieler1 = {{2,3,2,3,2},{0,0,1,1,3}};
		byte[][] spieler2 = {{11,12,11,12,8},{0,0,1,1,0}};
		byte[][] spieler3 = {{13,13,14,14,12},{6,7,6,7,5}};
		byte[][] spieler4 = {{11,11,12,12,12},{12,13,12,13,10}};
		byte[][] spieler5 = {{2,3,2,3,6},{12,12,13,13,13}};
		byte[][] spieler6 = {{0,0,1,1,2},{6,7,6,7,8}};
		
		zeichnen(weiss, spielfeld, Color.WHITE);
		zeichnen(spieler1, spielfeld, Color.RED);
		zeichnen(spieler2, spielfeld, Color.GREEN);
		zeichnen(spieler3, spielfeld, Color.BLUE);
		zeichnen(spieler4, spielfeld, Color.YELLOW);
		zeichnen(spieler5, spielfeld, Color.CYAN);
		zeichnen(spieler6, spielfeld, Color.MAGENTA);
		
		return spielfeld;
	}
	protected void zeichnen(byte[][] x, JComponent jc, Color color) {
		for(int i = 0; i < x.length-1; i++) {
			for(int j = 0; j < x[i].length; j++) {
				jc.add(new Kreis(color, j), getPosition(x[i][j], x[i+1][j]));
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