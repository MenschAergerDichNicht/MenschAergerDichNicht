package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

class Kreis extends JComponent {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	  public Kreis(Color color) {
		  this.color = color;
	  }
	  @Override
	  public void paintComponent(Graphics g) {
		  g.setColor(Color.BLACK);
		  g.fillOval(0, 0, getHeight(), getWidth());
		  g.setColor(color);
		  int randbreite = (int) (getWidth() * 0.10);
		  g.fillOval(randbreite, randbreite, getWidth() - (2 * randbreite), getHeight() - (2 * randbreite));
	    } 
}
