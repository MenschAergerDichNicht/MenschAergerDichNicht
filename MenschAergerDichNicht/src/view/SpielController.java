package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import logik.Spielbrett;
import logik.Spieler;
import logik.Spielfigur;

public class SpielController implements ActionListener, MouseListener, MouseMotionListener {
	Spielbrett spielbrett;
	Spieler letzterAgierenderSpieler;
	Wuerfel wuerfel;
	
	public SpielController(Spielbrett brett) {
		spielbrett = brett;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().getClass().equals(Kreis.class)) {
			Kreis kreis = (Kreis) e.getSource();
			Spielfigur figur = kreis.getBesetzer();
			if(spielbrett.bewegenMoeglich(figur)) {
				if(figur.imAnfangsfeld()) {
					spielbrett.setzeFigurInsFeld(figur);
				}
				else {
					spielbrett.bewegeFigur(figur);
				}
				kreis.repaint();
				letzterAgierenderSpieler = spielbrett.getAmZug();
			}
		}
		else if(e.getSource().getClass().equals(Wuerfel.class)) {
			if(spielbrett.getNochmalWuerfeln()) {
				wuerfel = (Wuerfel) e.getSource();
				if(!wuerfel.isRunning()) {
					wuerfel.zeigeZahl(spielbrett.wuerfeln());
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"Bitte das Wurfergebnis abwarten.");
				}
				
			}
			System.out.println(spielbrett.getNochmalWuerfeln());
		}
		
		else if(e.getSource().getClass().equals(JButton.class)) {
			spielbrett.zugFertig();
		}
		

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().getClass().equals(Kreis.class)) {
			Kreis kreis = (Kreis) e.getSource();
			if(spielbrett.bewegenMoeglich(kreis.getBesetzer())) {
				kreis.setKomplement();
			}
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().getClass().equals(Kreis.class)) {
			Kreis kreis = (Kreis) e.getSource();
			kreis.setNormaleFarbe();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
