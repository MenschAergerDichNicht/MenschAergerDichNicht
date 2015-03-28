package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class HauptFenster extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HauptFenster frame = new HauptFenster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HauptFenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel spielTitel = new JLabel("Mensch Ärgere Dich Nicht");
		spielTitel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		spielTitel.setHorizontalAlignment(SwingConstants.CENTER);
		spielTitel.setBounds(0, 0, 688, 24);
		panel.add(spielTitel);
		
		JLabel einstellungen = new JLabel("Einstellungen");
		einstellungen.setFont(new Font("Dialog", Font.BOLD, 15));
		einstellungen.setBounds(47, 47, 123, 24);
		panel.add(einstellungen);
		
		JLabel regeln = new JLabel("Regeln");
		regeln.setFont(new Font("Dialog", Font.BOLD, 15));
		regeln.setBounds(494, 47, 123, 24);
		panel.add(regeln);
		
		JLabel spielbrett = new JLabel("Spielbrett");
		spielbrett.setBounds(25, 93, 104, 15);
		panel.add(spielbrett);
		
		String[] spielfeldgroessen = {"4 Spieler Feld", "6 Spieler Feld"};
		JComboBox groessenComboBox = new JComboBox(spielfeldgroessen);
		groessenComboBox.setBounds(20, 110, 150, 24);
		panel.add(groessenComboBox);
		
		JLabel spielfeld = new JLabel("Spielfeld");
		spielfeld.setBounds(475, 93, 104, 15);
		panel.add(spielfeld);
		
		JComboBox felderComboBox = new JComboBox(new Object[]{"normal","sichere Felder"});
		felderComboBox.setBounds(470, 110, 160, 24);
		panel.add(felderComboBox);
		
		JLabel rauswerfen = new JLabel("Rauswerf-Regel");
		rauswerfen.setBounds(475, 168, 130, 15);
		panel.add(rauswerfen);
		
		JComboBox rauswerfenComboBox = new JComboBox(new Object[]{"mit rauswerfen","ohne rauswerfen"});
		rauswerfenComboBox.setBounds(470, 185, 160, 24);
		panel.add(rauswerfenComboBox);
		
		JLabel heimregel = new JLabel("Heim-Regel");
		heimregel.setBounds(475, 243, 130, 15);
		panel.add(heimregel);
		
		JComboBox heimregelComboBox = new JComboBox(new Object[]{"nicht überspringen","überspringen"});
		heimregelComboBox.setBounds(470, 260, 160, 24);
		panel.add(heimregelComboBox);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		Border disabledBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);
		
		JLabel farbe = new JLabel("Farbe");
		farbe.setHorizontalAlignment(SwingConstants.CENTER);
		farbe.setBounds(132, 150, 60, 30);
		farbe.setBorder(border);
		panel.add(farbe);
		
		JLabel computer = new JLabel("Computer");
		computer.setHorizontalAlignment(SwingConstants.CENTER);
		computer.setBounds(202, 150, 80, 30);
		computer.setBorder(border);
		panel.add(computer);
		
		JLabel spieler1 = new JLabel("Spieler 1");
		spieler1.setHorizontalAlignment(SwingConstants.CENTER);
		spieler1.setBounds(20, 185, 100, 30);
		spieler1.setBorder(border);
		panel.add(spieler1);
		
		JLabel spieler2 = new JLabel("Spieler 2");
		spieler2.setHorizontalAlignment(SwingConstants.CENTER);
		spieler2.setBounds(20, 220, 100, 30);
		spieler2.setBorder(border);
		panel.add(spieler2);
		
		JCheckBox checkBoxComputerSpieler2 = new JCheckBox("");
		checkBoxComputerSpieler2.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxComputerSpieler2.setBounds(202, 220, 80, 30);
		panel.add(checkBoxComputerSpieler2);
		
		JLabel spieler3 = new JLabel("Spieler 3");
		spieler3.setHorizontalAlignment(SwingConstants.CENTER);
		spieler3.setBounds(20, 255, 100, 30);
		spieler3.setBorder(border);
		panel.add(spieler3);
		
		JCheckBox checkBoxComputerSpieler3 = new JCheckBox("");
		checkBoxComputerSpieler3.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxComputerSpieler3.setBounds(202, 255, 80, 30);
		panel.add(checkBoxComputerSpieler3);
		
		JLabel spieler4 = new JLabel("Spieler 4");
		spieler4.setHorizontalAlignment(SwingConstants.CENTER);
		spieler4.setBounds(20, 290, 100, 30);
		spieler4.setBorder(border);
		panel.add(spieler4);
		
		JCheckBox checkBoxComputerSpieler4 = new JCheckBox("");
		checkBoxComputerSpieler4.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxComputerSpieler4.setBounds(202, 290, 80, 30);
		panel.add(checkBoxComputerSpieler4);
		
		JLabel spieler5 = new JLabel("Spieler 5");
		spieler5.setForeground(Color.LIGHT_GRAY);
		spieler5.setHorizontalAlignment(SwingConstants.CENTER);
		spieler5.setBounds(20, 325, 100, 30);
		spieler5.setBorder(disabledBorder);
		panel.add(spieler5);
		
		JCheckBox checkBoxComputerSpieler5 = new JCheckBox("");
		checkBoxComputerSpieler5.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxComputerSpieler5.setBounds(202, 325, 80, 30);
		checkBoxComputerSpieler5.setVisible(false);
		panel.add(checkBoxComputerSpieler5);
		
		JLabel spieler6 = new JLabel("Spieler 6");
		spieler6.setForeground(Color.LIGHT_GRAY);
		spieler6.setHorizontalAlignment(SwingConstants.CENTER);
		spieler6.setBounds(20, 360, 100, 30);
		spieler6.setBorder(disabledBorder);
		panel.add(spieler6);
		
		JCheckBox checkBoxComputerSpieler6 = new JCheckBox("");
		checkBoxComputerSpieler6.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxComputerSpieler6.setBounds(202, 360, 80, 30);
		checkBoxComputerSpieler6.setVisible(false);
		panel.add(checkBoxComputerSpieler6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 402, 688, 15);
		panel.add(separator);
		
		JButton startButton = new JButton("Start");
		startButton.setBounds(575, 420, 80, 25);
		panel.add(startButton);
		
		JButton regelnButton = new JButton("Regeln");
		regelnButton.setBounds(470, 420, 90, 25);
		panel.add(regelnButton);
	}
}
