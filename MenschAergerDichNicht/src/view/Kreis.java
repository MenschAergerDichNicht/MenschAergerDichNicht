package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import logik.Spielfigur;

class Kreis extends JComponent implements Observer{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	private int feldnummer;
	private Spielfigur besetzer;

	
	public Kreis(Color color, int feldnummer) {
//	public Kreis(Color color) {
		  this.color = color;
		  this.feldnummer = feldnummer;
	  }
	
	public int getFeldnummer() {
		return feldnummer;
	}

	  @Override
	  public void paintComponent(Graphics g) {
		  g.setColor(Color.BLACK);
		  g.fillOval(0, 0, getWidth(), getHeight());
		  g.setColor(color);
		  int randbreite = (int) (getHeight() * 0.10);
		  g.fillOval(randbreite, randbreite, getWidth() - (2 * randbreite), getHeight() - (2 * randbreite));
		  
		  if(besetzer != null) {
			  g.setColor(Color.BLACK);
			  g.drawOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
			  g.setColor(besetzer.getFarbe());
			  g.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
		  }
	    }

	@Override
	public void update(Observable o, Object arg) {
		if(arg.getClass().equals(Map.class)) {
			@SuppressWarnings("unchecked")
			Map<Integer, Spielfigur> figurAusPosition = (Map<Integer, Spielfigur>) arg;
			besetzer = figurAusPosition.get(feldnummer);
			
			if(besetzer != null) {
				repaint();
			}
		}
	}
	
	public void setBesetzer(Spielfigur figur) {
		if(figur != besetzer) {
			besetzer = figur;
			repaint();
		}
	}
	
	public Spielfigur getBesetzer(Spielfigur figur) {
		return besetzer;
	}
}
