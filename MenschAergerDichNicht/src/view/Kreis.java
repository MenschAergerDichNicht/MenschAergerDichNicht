package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

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
		  g2d.setBackground(Color.BLACK);
		  //g2d.setColor(color);
		  g2d.drawOval(0, 0, this.getWidth(), this.getHeight());
		  g2d.setColor(color);
		  g2d.fillOval(0, 0, this.getWidth(), this.getHeight());
		  int mx = 50;
		  int my = 50;
		  int r = 2000;
		  Ellipse2D.Double kreis = new Ellipse2D.Double(mx-r, my-r, 2*r, 2*r);
		  
		  g2d.draw(kreis);
	    } 
}
