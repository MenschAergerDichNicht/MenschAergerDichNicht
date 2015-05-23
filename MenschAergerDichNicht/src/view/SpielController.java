package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import logik.Spielbrett;
import logik.Spieler;

public class SpielController implements ActionListener, MouseListener {
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
			System.out.println(kreis.getFeldnummer());
		}
		else if(e.getSource().getClass().equals(Wuerfel.class)) {
			if(letzterAgierenderSpieler == null 
					|| letzterAgierenderSpieler != spielbrett.getAmZug()
					|| spielbrett.getNochmalWuerfeln()) {
				wuerfel = (Wuerfel) e.getSource();
				if(spielbrett.getNochmalWuerfeln()) {
					wuerfel.zeigeZahl(spielbrett.wuerfeln());
				}
			}
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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
