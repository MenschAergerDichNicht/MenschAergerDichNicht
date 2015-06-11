package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import logik.Spielbrett;
import logik.Spieler;
import logik.Spielfigur;

class Kreis extends JComponent implements Observer{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	private int feldnummer;
	private Spielfigur besetzer;
	private Spielfigur ersterBesetzer;
	private boolean komplement = false;
	private boolean heimatfeld = false;

	
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
			  
			  int viertelbreit = getWidth() / 4;
			  int viertelhoch = getHeight() / 4;
			  int halbbreit = getWidth() / 2;
			  int halbhoch = getHeight() / 2;
			  
			  randbreite = (int) (halbhoch * 0.10);
			  Color figurfarbe = besetzer.getFarbe();
			  
			  Color komplementaerFarbe = new Color(
					  255 - figurfarbe.getRed(), 
					  255 - figurfarbe.getGreen(), 
					  255 - figurfarbe.getBlue());
			  
			  g.setColor(komplementaerFarbe);
			  
			  g.fillOval(viertelbreit + randbreite,
					  viertelhoch + randbreite,
					  halbbreit, halbhoch);
			  
			  g.drawOval(viertelbreit,
					  viertelhoch,
					  halbbreit, halbhoch);
			  
			  if(komplement) {
				  figurfarbe = new Color(
						  255 - figurfarbe.getRed(), 
						  255 - figurfarbe.getGreen(), 
						  255 - figurfarbe.getBlue());
			  }
			  g.setColor(figurfarbe);
			  g.fillOval(viertelbreit, viertelhoch, halbbreit, halbhoch);
		  }
	    }

	@Override
	public void update(Observable o, Object arg) {
		if(arg.getClass().equals(HashMap.class)) {
			if(!heimatfeld) {
				@SuppressWarnings("unchecked")
				Map<Integer, Spielfigur> figurAusPosition = (Map<Integer, Spielfigur>) arg;
				Spielfigur neuerBesetzer = figurAusPosition.get(feldnummer);
				
				if(neuerBesetzer != besetzer) {
					besetzer = neuerBesetzer;
					repaint();
				}
			}
			else {
				if(besetzer == null 
						&& ersterBesetzer != null 
						&& ersterBesetzer.imAnfangsfeld()) {
					besetzer = ersterBesetzer;
					repaint();
				}
			}
			
			if(!heimatfeld && feldnummer >= 100) {
				boolean gefunden = false;
				Spielbrett brett = (Spielbrett) o;
				for(Spieler spieler:brett.getSpieler()) {
					for(Spielfigur figur: spieler.getSpielfiguren()) {
						if(figur.getHeimatfeld() >= 1) {
							int ermittelteFeldnummer = 
									(spieler.getNummer() * 100) + figur.getHeimatfeld();
							
							System.out.println(ermittelteFeldnummer);
							
							if(feldnummer == ermittelteFeldnummer) {
								besetzer = figur;
								repaint();
								gefunden = true;
								break;
							}
						}
					}
					if(gefunden) {
						break;
					}
				}
			}
		}
	}
	
	public void setBesetzer(Spielfigur figur) {
		if(ersterBesetzer == null) {
			ersterBesetzer = figur;
		}
		if(figur != besetzer) {
			besetzer = figur;
			repaint();
		}
	}
	
	public Spielfigur getBesetzer() {
		return besetzer;
	}
	
	public void setKomplement() {
		komplement = true;
		repaint();
	}
	
	public void setNormaleFarbe() {
		if(komplement) {
			komplement = false;
			repaint();
		}
	}
	
	public void setHeimatfeld() {
		heimatfeld = true;
	}
}
