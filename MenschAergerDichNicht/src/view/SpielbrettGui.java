package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import logik.Spielbrett;
import logik.Spieler;

public class SpielbrettGui extends JFrame {

	public static void main(String args[]) {
		SpielbrettGui sbg = new SpielbrettGui();
		sbg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sbg.setExtendedState(JFrame.MAXIMIZED_BOTH);
		sbg.setVisible(true);
	}
	
	public SpielbrettGui() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(getSpielfeld(), BorderLayout.CENTER);
		pane.add(getAnzeige(), BorderLayout.EAST);
	}
	
	protected JComponent getSpielfeld() {
		JPanel spielfeld = new JPanel();
		spielfeld.setLayout(new GridBagLayout());
		
		//Array der Spielfelder, noch mit spieler verbinden
		int[][] weiss = {{5,6,5,7,5,7,5,7,2,3,4,5,7,8,9,10,11,1,11,1,2,3,4,5,7,8,9,10,5,7,5,7,5,7,6,7},{1,1,2,2,3,3,4,4,5,5,5,5,5,5,5,5,5,6,6,7,7,7,7,7,7,7,7,7,8,8,9,9,10,10,11,11}};
		int[][] spieler1 = {{1,1,2,2,5,6,6,6,6},{10,11,10,11,11,7,8,9,10}};
		int[][] spieler2 = {{1,2,1,2,1,2,3,4,5},{1,1,2,2,5,6,6,6,6}};
		int[][] spieler3 = {{7,6,6,6,6,11,11,10,10},{1,2,3,4,5,1,2,1,2}};
		int[][] spieler4 = {{10,11,11,10,11,7,8,9,10},{11,11,10,10,7,6,6,6,6}};
		
		//for-Schleifen um die weissen Kreise hinzuzufuegen
		for(int i = 0; i < weiss.length-1; i++) {
			for(int j = 0; j < weiss[i].length; j++) {
				spielfeld.add(new Kreis(Color.WHITE), getPosition(weiss[i][j], weiss[i+1][j]));
			}
		}
		
		//for-Schleifen fuer die Kreise von Spieler 1
		for(int i = 0; i < spieler1.length-1; i++) {
			for(int j = 0; j < spieler1[i].length; j++) {
				spielfeld.add(new Kreis(Color.RED), getPosition(spieler1[i][j], spieler1[i+1][j]));
			}
		}
		
		//for-Schleife fuer die Kreise von Spieler 2
		for(int i = 0; i < spieler2.length-1; i++) {
			for(int j = 0; j < spieler2[i].length; j++) {
				spielfeld.add(new Kreis(Color.YELLOW), getPosition(spieler2[i][j], spieler2[i+1][j]));
			}
		}
		
		//for-Schleife fuer die Kreise von Spieler 3
		for(int i = 0; i < spieler3.length-1; i++) {
			for(int j = 0; j < spieler3[i].length; j++) {
				spielfeld.add(new Kreis(Color.BLUE), getPosition(spieler3[i][j], spieler3[i+1][j]));
			}
		}
		
		//for-Schleife fuer die Kreise von Spieler 4
		for(int i = 0; i < spieler4.length-1; i++) {
			for(int j = 0; j < spieler4[i].length; j++) {
				spielfeld.add(new Kreis(Color.GREEN), getPosition(spieler4[i][j], spieler4[i+1][j]));
			}
		}
		return spielfeld;
	}
	
	protected JComponent getAnzeige() {
		JPanel anzeige = new JPanel();
		anzeige.setLayout(new BorderLayout());
		anzeige.setSize(250, getHeight());
		return anzeige;
	}
	
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