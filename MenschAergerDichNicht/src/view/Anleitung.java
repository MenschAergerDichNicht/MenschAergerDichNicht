package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


//import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.SwingConstants;

import java.awt.Font;

public class Anleitung extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel uberschriftpanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anleitung frame = new Anleitung();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Anleitung() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		uberschriftpanel = new JPanel();
		uberschriftpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		uberschriftpanel.setLayout(new BorderLayout(40, 30));
		setContentPane(uberschriftpanel);
		
//		JLabel ueberschrift = DefaultComponentFactory.getInstance().createTitle("<html><body><br>Regeln - Mensch \u00E4rger dich nicht");
		JLabel ueberschrift = new JLabel("<html><body><br>Regeln - Mensch \u00E4rger dich nicht");
		ueberschrift.setFont(new Font("Tahoma", Font.BOLD, 16));
		uberschriftpanel.add(ueberschrift, BorderLayout.NORTH);
		ueberschrift.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel spalteneinteilung = new JPanel();
		uberschriftpanel.add(spalteneinteilung, BorderLayout.CENTER);
		spalteneinteilung.setLayout(new BorderLayout(0, 0));
		
		JPanel spalte1 = new JPanel();
		spalteneinteilung.add(spalte1, BorderLayout.WEST);

		JPanel Spielbeschreibung = new JPanel();
		spalte1.add(Spielbeschreibung);
		Spielbeschreibung.setLayout(new BorderLayout(10, 10));
		
		JLabel spielbeschreibung = new JLabel("Spielbeschreibung");
		spielbeschreibung.setFont(new Font("Tahoma", Font.BOLD, 12));
		Spielbeschreibung.add(spielbeschreibung, BorderLayout.NORTH);
		
		JLabel spielbeschreibungText = new JLabel("<html><body>In diesem kurzweiligen Spiel geht es darum, seine<br>eigenen Spielfiguren so schnell wie m\u00F6glich von<br>seinem eigenen Startfeld aus \u00FCber eine<br>Spielfeldstrecke ins Ziel zu w\u00FCrfeln. Gleichzeitig<br>versucht man, die Mitspieler zu \u00E4rgern und deren<br>Spielsteine, so oft es geht, zu schlagen, damit sie<br>wieder von vorn anfangen m\u00FCssen.<br><br>Die wei\u00DFen Felder des Spielbretts stellen die<br>Laufbahn dar, die alle Spielfiguren zur\u00FCcklegen<br>m\u00FCssen. Auf den farbigen Startfeldern<br>beginnen die Spielsteine der jeweiligen Farbe<br>ihren Weg \u00FCber die wei\u00DFen Felder. Auf den<br>im Viereck angeordneten farbigen Feldern,<br>den Ausgangsfeldern, warten die Figuren auf<br>ihren Einsatz.<br><br>Wer seine vier Spielsteine als erster \u201Enach Hause\u201C<br>gebracht hat, gewinnt das Spiel.<br><br></body></html>");
		spielbeschreibungText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spielbeschreibungText.setHorizontalAlignment(SwingConstants.LEFT);
		spielbeschreibungText.setVerticalTextPosition(SwingConstants.TOP);
		
		spielbeschreibungText.setVerticalAlignment(SwingConstants.TOP);
		Spielbeschreibung.add(spielbeschreibungText, BorderLayout.CENTER);
				
				JPanel Spielablauf = new JPanel();
				Spielbeschreibung.add(Spielablauf, BorderLayout.SOUTH);
				Spielablauf.setLayout(new BorderLayout(10, 10));
				
				JLabel spielablauf = new JLabel("Spielablauf");
				spielablauf.setHorizontalAlignment(SwingConstants.LEFT);
				spielablauf.setFont(new Font("Tahoma", Font.BOLD, 12));
				Spielablauf.add(spielablauf, BorderLayout.NORTH);
				
				JLabel spielablaufText = new JLabel("<html><body>Der Spieler, der an der Reihe ist, w\u00FCrfelt<br>und setzt seinen Spielstein um die gew\u00FCrfelte <br>Augenzahl auf der Laufbahn vor. Eigene und<br>fremde Steine k\u00F6nnen \u00FCbersprungen werden,<br> die besetzten Felder werden aber mitgez\u00E4hlt.<br><br>Wer mehrere Spielsteine auf der Laufbahn stehen<br>hat, kann sich aussuchen, mit welchem Stein er<br>weiterzieht.</body></html>");
				spielablaufText.setFont(new Font("Tahoma", Font.PLAIN, 11));
				spielablaufText.setHorizontalAlignment(SwingConstants.LEFT);
				
						Spielablauf.add(spielablaufText, BorderLayout.CENTER);
		
		JPanel spalte2 = new JPanel();
		spalteneinteilung.add(spalte2, BorderLayout.CENTER);
		
		JPanel restSpielablauf = new JPanel();
		spalte2.add(restSpielablauf);
		restSpielablauf.setLayout(new BorderLayout(10, 10));
		
		JLabel restText = new JLabel("<html><body>Wer mit dem letzten Punkt seiner Augenzahl auf<br>ein Feld trifft, das von einer fremden Spielfigur<br>besetzt ist, schl\u00E4gt diese Figur und setzt seinen<br>eigenen Stein auf ihren Platz.Geschlagene<br>Steine werden auf den Ausgangsfeldern ihrer Farbe<br>zur\u00FCckgestellt. Eigene Steine k\u00F6nnen nicht geschlagen<br>werden. Der Spieler muss dann mit einer anderen Figur<br>ziehen, da auf jedem Feld immer nur ein Spielstein<br>stehen darf.<br><br>So lange noch weitere Steine auf der Ausgangsposition<br>auf ihren Spieleinsatz warten, darf keine eigene<br>Figur auf dem Startfeld stehen bleiben. Sie muss<br>das Feld frei machen, sobald sie die M\u00F6glichkeit dazu hat.<br><br>Die Steine, die auf den Ausgangsfeldern stehen,<br>k\u00F6nnen nur mit einer \u201E6\u201C ins Spiel gebracht und<br>damit auf das Startfeld gesetzt werden.<br><br></body></html>");
		restText.setVerticalAlignment(SwingConstants.TOP);
		restSpielablauf.add(restText, BorderLayout.NORTH);
		restText.setHorizontalAlignment(SwingConstants.LEFT);
		restText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel Wuerfel = new JPanel();
		restSpielablauf.add(Wuerfel, BorderLayout.CENTER);
		Wuerfel.setLayout(new BorderLayout(10, 10));
		
		JLabel wuerfelzahl = new JLabel("Besonderheiten der W\u00FCrfelzahl \u201E6\u201C");
		wuerfelzahl.setHorizontalAlignment(SwingConstants.LEFT);
		Wuerfel.add(wuerfelzahl, BorderLayout.NORTH);
		wuerfelzahl.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel wuerfelText = new JLabel("<html><body>Wer eine \u201E6\u201C w\u00FCrfelt, hat nach seinem Zug einen<br>weiteren Wurf frei. Erzielt er dabei wieder eine \u201E6\u201C,<br>darf er erneut nach dem Ziehen w\u00FCrfeln.<br><br>Bei einer \u201E6\u201C muss man einen neuen Stein ins Spiel<br>bringen, so lange noch Spielfiguren auf den eigenen<br>Ausgangsfeldern stehen. Der neue Stein wird dann<br>auf das Startfeld der eigenen Farbe gestellt. Ist<br>dieses Feld noch von einer anderen eigenen Spielfigur <br>besetzt, muss dieser Stein erst mit der \u201E6\u201C weitergezogen<br>werden. Steht dagegen eine fremde Figur auf dem<br>Startfeld, wird sie geschlagen.</body></html>");
		wuerfelText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		wuerfelText.setHorizontalAlignment(SwingConstants.LEFT);
		wuerfelText.setVerticalAlignment(SwingConstants.TOP);
		Wuerfel.add(wuerfelText, BorderLayout.CENTER);
		
		JPanel spalte3 = new JPanel();
		spalteneinteilung.add(spalte3, BorderLayout.EAST);
		
		JPanel restWuerfel = new JPanel();
		spalte3.add(restWuerfel);
		restWuerfel.setLayout(new BorderLayout(10, 10));
		
		JLabel lblNewLabel = new JLabel("<html><body>Wer eine \u201E6\u201C w\u00FCrfelt und keinen Stein mehr auf<br>den Ausgangsfeldern hat, darf mit einer seiner Figuren<br>auf der Laufbahn sechs Felder weiterziehen und<br>dann noch einmal w\u00FCrfeln.<br><br>Wer mit einer \u201E6\u201C seinen letzten Spielstein nach Hause<br>bringt, braucht nicht noch einmal zu w\u00FCrfeln.<br><br></body></html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		restWuerfel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel ziel = new JPanel();
		restWuerfel.add(ziel, BorderLayout.CENTER);
		ziel.setLayout(new BorderLayout(10, 10));
		
		JLabel zielfelder = new JLabel("Betreten der Heimfelder");
		zielfelder.setVerticalAlignment(SwingConstants.TOP);
		zielfelder.setHorizontalAlignment(SwingConstants.LEFT);
		ziel.add(zielfelder, BorderLayout.NORTH);
		zielfelder.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel zielfelderText = new JLabel("<html><body>Wer mit einer Spielfigur die ganze Laufbahn einmal<br>vollst\u00E4ndig durchlaufen hat, zieht mit ihr auf<br>die Heimfelder seiner Farbe vor. Auch die Heimfelder<br>werden beim Vorr\u00FCcken einzeln gez\u00E4hlt. Auf den<br>Heimfeldern d\u00FCrfen keine Spielsteine \u00FCbersprungen<br>werden.<br><br></body></html>");
		zielfelderText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		zielfelderText.setHorizontalAlignment(SwingConstants.LEFT);
		zielfelderText.setVerticalAlignment(SwingConstants.TOP);
		ziel.add(zielfelderText, BorderLayout.CENTER);
		
		JPanel ende = new JPanel();
		ziel.add(ende, BorderLayout.SOUTH);
		ende.setLayout(new BorderLayout(10, 10));
		
		JLabel spielende = new JLabel("Ende des Spiels");
		spielende.setVerticalAlignment(SwingConstants.TOP);
		spielende.setHorizontalAlignment(SwingConstants.LEFT);
		spielende.setFont(new Font("Tahoma", Font.BOLD, 12));
		ende.add(spielende, BorderLayout.NORTH);
		
		JLabel spielendeText = new JLabel("<html><body>Der Spieler, der als erster alle seine Spielfiguren<br>"
				+ "auf seine Zielfelder gebracht hat, gewinnt das<br>"
				+ "Spiel.</body></html>");
		spielendeText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spielendeText.setVerticalAlignment(SwingConstants.TOP);
		ende.add(spielendeText, BorderLayout.CENTER);
	}

}
