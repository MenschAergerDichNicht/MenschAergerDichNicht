package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseListener;

import logik.Spieler;

public class GewonnenFenster extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public GewonnenFenster(Spieler spieler, MouseListener mouselistener, boolean weiter) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 252);
		this.setTitle ("Mensch \u00c4rger Dich Nicht");
		contentPane = new JPanel();
		contentPane.setBackground(spieler.getFarbe());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSpielerGewinnt = new JLabel(spieler.getName() +" gewinnt!", SwingConstants.CENTER);
		lblSpielerGewinnt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSpielerGewinnt.setBounds(0, 55, getWidth(), 31);
		
		contentPane.add(lblSpielerGewinnt);
		
		JButton btnNochmal = new JButton("Nochmal");
		btnNochmal.addMouseListener(mouselistener);
		btnNochmal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNochmal.setBounds(41, 133, 109, 23);
		contentPane.add(btnNochmal);
		
		JButton btnNeuesSpiel = new JButton("Neues Spiel");
		btnNeuesSpiel.addMouseListener(mouselistener);
		btnNeuesSpiel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNeuesSpiel.setBounds(160, 133, 110, 23);
		contentPane.add(btnNeuesSpiel);
		
		JButton btnWeiter = new JButton("Weiter");
		btnWeiter.addMouseListener(mouselistener);
		btnWeiter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnWeiter.setBounds(160, 179, 110, 23);
		contentPane.add(btnWeiter);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.addMouseListener(mouselistener);
		btnBeenden.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBeenden.setBounds(280, 133, 109, 23);
		contentPane.add(btnBeenden);
	}
}
