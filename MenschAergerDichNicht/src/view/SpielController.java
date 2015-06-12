package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import logik.Spielbrett;
import logik.Spieler;
import logik.Spielerfabrik;
import logik.Spielfigur;

public class SpielController implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
	Spielbrett spielbrett;
	Spieler letzterAgierenderSpieler;
	Wuerfel wuerfel;
	JFrame spielframe;
	
	public SpielController(Spielbrett brett, JFrame spielframe) {
		spielbrett = brett;
		this.spielframe = spielframe;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().getClass().equals(Kreis.class)) {
			Kreis kreis = (Kreis) e.getSource();
			Spielfigur figur = kreis.getBesetzer();
			if(spielbrett.bewegenMoeglich(figur)) {
				if(figur.imAnfangsfeld()) {
					spielbrett.setzeFigurInsFeld(figur);
					kreis.setBesetzer(null);
				}
				else {
					spielbrett.bewegeFigur(figur);
					if(figur.getSpieler().gewonnen()) {
						int anzahlNichtGewonnen = 0;
						boolean weiter = false;
						for(Spieler spieler:spielbrett.getSpieler()) {
							if(!spieler.gewonnen())
								anzahlNichtGewonnen++;
						}
						if(anzahlNichtGewonnen > 1)
							weiter = true;
						GewonnenFenster gewonnenFenster = 
								new GewonnenFenster(
										figur.getSpieler(), this, weiter
										);
						gewonnenFenster.setVisible(true);
						gewonnenFenster.addMouseListener(this);
						spielframe.setEnabled(false);
					}
				}
				kreis.repaint();
				letzterAgierenderSpieler = spielbrett.getAmZug();
			}
		}
		else if(e.getSource().getClass().equals(Wuerfel.class)) {
			/*
			 * Es darf nur gewürfelt werden, wenn es die Regeln erlauben und
			 * bereits gezogen worden ist, oder es keine Optionen gibt dies
			 * zu tun.
			 */
			if(spielbrett.getNochmalWuerfeln()
					&& (spielbrett.wurdeGezogen() 
							|| spielbrett.getOptionen().isEmpty())
					) {
				wuerfel = (Wuerfel) e.getSource();
				if(!wuerfel.isRunning()) {
					wuerfel.zeigeZahl(spielbrett.wuerfeln());
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"Bitte das Wurfergebnis abwarten.");
				}
				
			}
		}
		
		else if(e.getSource().getClass().equals(JButton.class)) {
			JButton button = (JButton) e.getSource();
			if(button.getText().equals("Zug beenden")
					/*
					 * Wenn der Spieler nicht noch einmal würfeln darf
					 * und er gezogen hat oder keine Option hat dies zu tun
					 * kann der Zug beendet werden.
					 */
					&& !spielbrett.getNochmalWuerfeln()
					&& (spielbrett.wurdeGezogen() 
							|| spielbrett.getOptionen().isEmpty())
			) {
				zugFertig();
			}
			
			else if(button.getText().equals("Beenden")) {
				System.exit(0);
			}
			
			else if(button.getText().equals("Neues Spiel")) {
				spielframe.dispose();
				Einstellungen einstellungen = new Einstellungen(new EinstellungsController());
				einstellungen.setVisible(true);
				((JFrame) button.getTopLevelAncestor()).dispose();
			}
			
			else if(button.getText().equals("Nochmal")) {
				Spielerfabrik fabrik = new Spielerfabrik(spielbrett.getSpieler().size());
				List<Spieler> neueSpielerListe = new LinkedList<>();
				for(Spieler spieler:spielbrett.getSpieler()) {
					neueSpielerListe.add(fabrik.getSpieler(spieler.getFarbe(), spieler.getName()));
				}
				Spielbrett neuesBrett = new Spielbrett(neueSpielerListe, spielbrett.getRegeln());
				SpielbrettGui neuerFrame = new SpielbrettGui(neuesBrett, false);
				neuerFrame.setBounds(spielframe.getBounds());
				spielframe.dispose();
				neuerFrame.setVisible(true);
				((JFrame) button.getTopLevelAncestor()).dispose();
			}
			
			else if(button.getText().equals("Weiter")) {
				spielframe.setEnabled(true);
				((JFrame) button.getTopLevelAncestor()).dispose();
			}
		}
		

	}
	
	private void zugFertig() {
		spielbrett.zugFertig();
		if(spielbrett.getAmZug().gewonnen())
			zugFertig();

//		while(spielbrett.getAmZug().isComputer()) {
//			try {
//				computerZug();
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
	
	public void computerZug() throws InterruptedException {

		while (spielbrett.getNochmalWuerfeln() || !spielbrett.getOptionen().isEmpty()) {
			wuerfel.zeichneZahl(spielbrett.wuerfeln());

			List<Spielfigur> optionen = spielbrett.getOptionen();
			if(!optionen.isEmpty()) {
				Spielfigur figur = optionen.get(0);
				if(figur.imAnfangsfeld()) {
					spielbrett.setzeFigurInsFeld(figur);
				}
				else {
					spielbrett.bewegeFigur(figur);
				}
			}
		}
		spielbrett.zugFertig();	
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		GewonnenFenster gewonnenFenster = new GewonnenFenster(spielbrett.getAmZug(), this, true);
		gewonnenFenster.setVisible(true);
		gewonnenFenster.addMouseListener(this);
		gewonnenFenster.setFocusable(true);
		spielframe.setEnabled(false);
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
	
}
