package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


public class Stern extends Kreis {




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public Stern(Color color, int feldnummer) {
		super(color, feldnummer);
	}
	

	@Override
	public void paintComponent(Graphics g) {
//        Polygon dreieck = new Polygon();
//        dreieck.addPoint((int)(getWidth()*0.5),(int)(getHeight()*0.167));//200,50*
//        dreieck.addPoint((int)(getWidth()*0.55),(int)(getHeight()*0.3));//220,90*
//        dreieck.addPoint((int)(getWidth()*0.6625),(int)(getHeight()*0.2833));//265,85*
//        dreieck.addPoint((int)(getWidth()*0.6),(int)(getHeight()*0.4));//240,120
//        dreieck.addPoint((int)(getWidth()*0.6625),(int)(getHeight()*0.5166));//265,155
//        dreieck.addPoint((int)(getWidth()*0.55),(int)(getHeight()*0.5));//220,150
//        
//        dreieck.addPoint((int)(getWidth()*0.5),(int)(getHeight()*0.6333));//200,190
//        dreieck.addPoint((int)(getWidth()*0.45),(int)(getHeight()*0.5));//180,150
//        dreieck.addPoint((int)(getWidth()*0.3375),(int)(getHeight()*0.5166));//135,155
//        dreieck.addPoint((int)(getWidth()*0.4),(int)(getHeight()*0.4));//160,120
//        dreieck.addPoint((int)(getWidth()*0.3375),(int)(getHeight()*0.2833));//135,85
//        dreieck.addPoint((int)(getWidth()*0.45),(int)(getHeight()*0.3));//180,90
//       
// 
//        
//        g.setColor(Color.YELLOW);
//        g.fillPolygon(dreieck);
		
		Polygon dreieckEins = new Polygon();
		dreieckEins.addPoint(getWidth() / 2, 0);
		dreieckEins.addPoint(0, (int)(getHeight() *  0.727272727));
		dreieckEins.addPoint(getWidth(), (int)(getHeight() *  0.727272727));
		
		Polygon dreieckZwei = new Polygon();
		dreieckZwei.addPoint(0, (int)(getHeight() *  0.272727273));
		dreieckZwei.addPoint(getWidth(), (int)(getHeight() *  0.272727273));
		dreieckZwei.addPoint(getWidth() / 2, getHeight());
		
		g.setColor(Color.YELLOW);
		g.fillPolygon(dreieckEins);
		g.fillPolygon(dreieckZwei);
		
        
        int randbreite = (int) (getHeight() * 0.10);
        
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

}
