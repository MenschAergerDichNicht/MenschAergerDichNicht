package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class Einstellungen extends JFrame{
	
	private Map<Integer, SpielerEinstellungen> spielereinstellungen = 
			new HashMap<>();
	public Spieleinstellungen spieleinstellungen;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Einstellungen frame = new Einstellungen(new EinstellungsController());
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
	public Einstellungen(EinstellungsController controller) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel spielTitel = new JLabel("Mensch \u00C4rgere Dich Nicht");
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
		regeln.setBounds(519, 47, 123, 24);
		panel.add(regeln);
		
		JLabel spielbrett = new JLabel("Spielbrett");
		spielbrett.setBounds(25, 93, 104, 15);
		panel.add(spielbrett);
		
//		String[] spielfeldgroessen = {"4 Spieler Feld", "6 Spieler Feld"};
		String[] spielfeldgroessen = {"4 Spieler Feld"};
		JComboBox<String> groessenComboBox = new JComboBox<>(spielfeldgroessen);
		groessenComboBox.setBounds(20, 110, 150, 24);
		groessenComboBox.addActionListener(controller);
		groessenComboBox.setActionCommand("groesse");
		panel.add(groessenComboBox);
		
		JLabel spielfeld = new JLabel("Spielfeld");
		spielfeld.setBounds(500, 93, 104, 15);
		panel.add(spielfeld);
		
		JComboBox<String> felderComboBox = new JComboBox<>(new String[]{"normal","sichere Felder"});
		felderComboBox.setBounds(495, 110, 160, 24);
		panel.add(felderComboBox);
		
		JLabel rauswerfen = new JLabel("Rauswerf-Regel");
		rauswerfen.setBounds(500, 168, 130, 15);
		panel.add(rauswerfen);
		
		JComboBox<String> rauswerfenComboBox = new JComboBox<>(new String[]{"mit rauswerfen","ohne rauswerfen"});
		rauswerfenComboBox.setBounds(495, 185, 160, 24);
		panel.add(rauswerfenComboBox);
		
		JLabel heimregel = new JLabel("Heim-Regel");
		heimregel.setBounds(500, 243, 130, 15);
		panel.add(heimregel);
		
		JComboBox<String> heimregelComboBox = new JComboBox<>(new String[]{"nicht \u00FCberspringen","\u00FCberspringen"});
		heimregelComboBox.setBounds(495, 260, 160, 24);
		panel.add(heimregelComboBox);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		Border disabledBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);
		
		JLabel farbe = new JLabel("Farbe");
		farbe.setHorizontalAlignment(SwingConstants.CENTER);
		farbe.setBounds(132, 150, 60, 30);
		panel.add(farbe);
		
		JLabel computer = new JLabel("Computer");
		computer.setHorizontalAlignment(SwingConstants.CENTER);
		computer.setBounds(202, 150, 80, 30);
		computer.setVisible(false);
		panel.add(computer);
		
		JTextField spieler1 = new JTextField("Spieler 1");
		spieler1.setForeground(Color.GRAY);
		spieler1.setHorizontalAlignment(SwingConstants.CENTER);
		spieler1.setBounds(20, 185, 100, 30);
		spieler1.setBorder(border);
		spieler1.addMouseListener(controller);
		panel.add(spieler1);
		
		JButton spieler1Farbe = new JButton();
		spieler1Farbe.setBounds(155, 192, 15, 15);
		spieler1Farbe.setBackground(Color.RED);
		spieler1Farbe.setActionCommand("farbe1");
		spieler1Farbe.addActionListener(controller);
		panel.add(spieler1Farbe);
		
		spielereinstellungen.put(1, new SpielerEinstellungen(spieler1, spieler1Farbe));
		
		JTextField spieler2 = new JTextField("Spieler 2");
		spieler2.setForeground(Color.GRAY);
		spieler2.setHorizontalAlignment(SwingConstants.CENTER);
		spieler2.setBounds(20, 220, 100, 30);
		spieler2.setBorder(border);
		spieler2.addMouseListener(controller);
		panel.add(spieler2);
		
		JButton spieler2Farbe = new JButton();
		spieler2Farbe.setBounds(155, 227, 15, 15);
		spieler2Farbe.setBackground(Color.GREEN);
		spieler2Farbe.setActionCommand("farbe2");
		spieler2Farbe.addActionListener(controller);
		panel.add(spieler2Farbe);
		
		JCheckBox checkBoxComputerSpieler2 = new JCheckBox("");
		checkBoxComputerSpieler2.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxComputerSpieler2.setBounds(202, 220, 80, 30);
		checkBoxComputerSpieler2.setVisible(false);
		panel.add(checkBoxComputerSpieler2);
		
		spielereinstellungen.put(2, new SpielerEinstellungen(
				spieler2, spieler2Farbe, checkBoxComputerSpieler2)
		);
		
		JTextField spieler3 = new JTextField("Spieler 3");
		spieler3.setForeground(Color.GRAY);
		spieler3.setHorizontalAlignment(SwingConstants.CENTER);
		spieler3.setBounds(20, 255, 100, 30);
		spieler3.setBorder(border);
		spieler3.addMouseListener(controller);
		panel.add(spieler3);
		
		JButton spieler3Farbe = new JButton();
		spieler3Farbe.setBounds(155, 262, 15, 15);
		spieler3Farbe.setBackground(Color.YELLOW);
		spieler3Farbe.setActionCommand("farbe3");
		spieler3Farbe.addActionListener(controller);
		panel.add(spieler3Farbe);
		
		JCheckBox checkBoxComputerSpieler3 = new JCheckBox("");
		checkBoxComputerSpieler3.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxComputerSpieler3.setBounds(202, 255, 80, 30);
		checkBoxComputerSpieler3.setVisible(false);
		panel.add(checkBoxComputerSpieler3);
		
		spielereinstellungen.put(3, new SpielerEinstellungen(
				spieler3, spieler3Farbe, checkBoxComputerSpieler3)
		);
		
		JTextField spieler4 = new JTextField("Spieler 4");
		spieler4.setForeground(Color.GRAY);
		spieler4.setHorizontalAlignment(SwingConstants.CENTER);
		spieler4.setBounds(20, 290, 100, 30);
		spieler4.setBorder(border);
		spieler4.addMouseListener(controller);
		panel.add(spieler4);
		
		JButton spieler4Farbe = new JButton();
		spieler4Farbe.setBounds(155, 297, 15, 15);
		spieler4Farbe.setBackground(Color.BLUE);
		spieler4Farbe.setActionCommand("farbe4");
		spieler4Farbe.addActionListener(controller);
		panel.add(spieler4Farbe);
		
		JCheckBox checkBoxComputerSpieler4 = new JCheckBox();
		checkBoxComputerSpieler4.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxComputerSpieler4.setBounds(202, 290, 80, 30);
		checkBoxComputerSpieler4.setVisible(false);
		panel.add(checkBoxComputerSpieler4);
		
		spielereinstellungen.put(4, new SpielerEinstellungen(
				spieler4, spieler4Farbe, checkBoxComputerSpieler4)
		);
		
		JTextField spieler5 = new JTextField("Spieler 5");
		spieler5.setForeground(Color.GRAY);
		spieler5.setHorizontalAlignment(SwingConstants.CENTER);
		spieler5.setBounds(20, 325, 100, 30);
		spieler5.setBorder(disabledBorder);
		spieler5.setVisible(false);
		spieler5.addMouseListener(controller);
		panel.add(spieler5);
		
		JButton spieler5Farbe = new JButton();
		spieler5Farbe.setBounds(155, 332, 15, 15);
		spieler5Farbe.setVisible(false);
		spieler5Farbe.setBackground(Color.MAGENTA);
		spieler5Farbe.setActionCommand("farbe5");
		spieler5Farbe.addActionListener(controller);
		panel.add(spieler5Farbe);
		
		JCheckBox checkBoxComputerSpieler5 = new JCheckBox();
		checkBoxComputerSpieler5.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxComputerSpieler5.setBounds(202, 325, 80, 30);
		checkBoxComputerSpieler5.setVisible(false);
		checkBoxComputerSpieler5.setActionCommand("computerSpieler5");
		panel.add(checkBoxComputerSpieler5);

		spielereinstellungen.put(5, new SpielerEinstellungen(
				spieler5, spieler5Farbe, checkBoxComputerSpieler5)
		);
		
		JTextField spieler6 = new JTextField("Spieler 6");
		spieler6.setForeground(Color.GRAY);
		spieler6.setHorizontalAlignment(SwingConstants.CENTER);
		spieler6.setBounds(20, 360, 100, 30);
		spieler6.setBorder(disabledBorder);
		spieler6.setVisible(false);
		spieler6.addMouseListener(controller);
		panel.add(spieler6);
		
		JButton spieler6Farbe = new JButton();
		spieler6Farbe.setBounds(155, 367, 15, 15);
		spieler6Farbe.setVisible(false);
		spieler6Farbe.setBackground(Color.BLACK);
		spieler6Farbe.setActionCommand("farbe6");
		spieler6Farbe.addActionListener(controller);
		panel.add(spieler6Farbe);
		
		JCheckBox checkBoxComputerSpieler6 = new JCheckBox("");
		checkBoxComputerSpieler6.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxComputerSpieler6.setBounds(202, 360, 80, 30);
		checkBoxComputerSpieler6.setVisible(false);
		checkBoxComputerSpieler6.setActionCommand("computerSpieler6");
		panel.add(checkBoxComputerSpieler6);
		
		spielereinstellungen.put(6, new SpielerEinstellungen(
				spieler6, spieler6Farbe, checkBoxComputerSpieler6)
		);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 402, 688, 15);
		panel.add(separator);
		
		JButton startButton = new JButton("Start");
		startButton.setBounds(575, 420, 80, 25);
		startButton.setActionCommand("start");
		startButton.addActionListener(controller);
		panel.add(startButton);
		
		JButton regelnButton = new JButton("Regeln");
		regelnButton.setBounds(470, 420, 90, 25);
		regelnButton.setActionCommand("regeln");
		regelnButton.addActionListener(controller);
		panel.add(regelnButton);
		
		spieleinstellungen = new Spieleinstellungen(
				spielereinstellungen,
				groessenComboBox,
				felderComboBox,
				rauswerfenComboBox,
				heimregelComboBox				
				);
	}
}
