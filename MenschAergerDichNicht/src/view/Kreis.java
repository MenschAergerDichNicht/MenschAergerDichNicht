package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class Kreis extends JPanel {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	  public Kreis(Color color) {
		  this.color = color;
	  }
	  public void paintComponent(Graphics g) {
		  Graphics2D g2d = (Graphics2D) g;
		  g2d.setColor(Color.BLACK);
		  g2d.drawOval(0, 0, this.getHeight(), this.getHeight());
		  g2d.setColor(color);
		  g2d.fillOval(0, 0, this.getHeight(), this.getHeight());
	    } 
}
