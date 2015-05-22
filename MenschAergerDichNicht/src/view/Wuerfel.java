package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Wuerfel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int TIMER_START_DELAY = 1;
	private static final int TIMER_END_DELAY = 150;
	
	// zahl ist zwischen 1-6 und gibt an wie der Würfel gezeichnet wird
	int zahl = (int) (Math.random()*6)+1;
	public Wuerfel() {
		// Der Timer der den Würfel zählen lässt
		final Timer timer = new Timer(TIMER_START_DELAY, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Timer timer = (Timer)e.getSource();

				if(timer.getDelay() < TIMER_END_DELAY) {
					incrementZahl();
					// Sorgt für die Verlangsamung des zählers
					timer.setDelay(timer.getDelay() + 3);
				} else {
					timer.stop();
				}
			}
		});
		// bei Mausklick aktiviert
		this.addMouseListener(new MouseListener() {
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				timer.setDelay(TIMER_START_DELAY);
				timer.start();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		switch(zahl) {
		case 1:
			drawDot(g, this.getWidth() / 2, this.getHeight() / 2, this.getHeight() / 10);
			break;
		case 2:
			drawDot(g, this.getWidth() / 4, this.getHeight() / 4, this.getHeight() / 10);
			drawDot(g, (this.getWidth() / 4)*3, (this.getHeight() / 4) * 3, this.getHeight() / 10);
			break;
		case 3:
			drawDot(g, this.getWidth() / 2, this.getHeight() / 2, this.getHeight() / 10);
			
			drawDot(g, this.getWidth() / 4, this.getHeight() / 4, this.getHeight() / 10);
			drawDot(g, (this.getWidth() / 4)*3, (this.getHeight() / 4) * 3, this.getHeight() / 10);
			break;
		case 4:
			drawDot(g, this.getWidth() / 4, this.getHeight() / 4, this.getHeight() / 10);
			drawDot(g, (this.getWidth() / 4)*3, (this.getHeight() / 4) * 3, this.getHeight() / 10);

			drawDot(g, this.getWidth() / 4, (this.getHeight() / 4) * 3, this.getHeight() / 10);
			drawDot(g, (this.getWidth() / 4)*3, this.getHeight() / 4, this.getHeight() / 10);
			break;
		case 5:
			drawDot(g, this.getWidth() / 2, this.getHeight() / 2, this.getHeight() / 10);

			drawDot(g, this.getWidth() / 4, this.getHeight() / 4, this.getHeight() / 10);
			drawDot(g, (this.getWidth() / 4)*3, (this.getHeight() / 4) * 3, this.getHeight() / 10);

			drawDot(g, this.getWidth() / 4, (this.getHeight() / 4) * 3, this.getHeight() / 10);
			drawDot(g, (this.getWidth() / 4)*3, this.getHeight() / 4, this.getHeight() / 10);
			break;
		case 6:

			drawDot(g, this.getWidth() / 4, this.getHeight() / 4, this.getHeight() / 10);
			drawDot(g, (this.getWidth() / 4)*3, (this.getHeight() / 4) * 3, this.getHeight() / 10);

			drawDot(g, this.getWidth() / 4, (this.getHeight() / 4) * 3, this.getHeight() / 10);
			drawDot(g, (this.getWidth() / 4)*3, this.getHeight() / 4, this.getHeight() / 10);

			drawDot(g, this.getWidth() / 4, this.getHeight() / 2, this.getHeight() / 10);
			drawDot(g, (this.getWidth() / 4)*3, this.getHeight() / 2, this.getHeight() / 10);
			break;
		
		}
	}
	
	private void drawDot(Graphics g, int centerx, int centery, int size) {
		g.fillArc(centerx - size / 2, centery - size / 2, size, size, 0, 360);
	}
	
	
	private void incrementZahl() {
		if(zahl > 5)
			zahl = 1;
		else
			zahl++;
		
		this.repaint();
	}
}