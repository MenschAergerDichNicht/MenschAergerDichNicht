package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

class Kreis extends JComponent implements Observer{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	private int feldnummer;

	
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
		  g.fillOval(0, 0, getHeight(), getWidth());
		  g.setColor(color);
		  int randbreite = (int) (getWidth() * 0.10);
		  g.fillOval(randbreite, randbreite, getWidth() - (2 * randbreite), getHeight() - (2 * randbreite));
	    }

	@Override
	public void update(Observable o, Object arg) {
		
	} 
}
