package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class SpielerEinstellungen {
	JTextField spielername;
	JButton farbe;
	JCheckBox computer;
	public SpielerEinstellungen(
			JTextField textfield, JButton button
			) {
		this(textfield, button, null);
	}
	
	public SpielerEinstellungen(
			JTextField textfield, JButton button, JCheckBox checkbox
			) {
		spielername = textfield;
		farbe = button;
		computer = checkbox;
	}
	
	public String getName() {
		return spielername.getText();
	}
	
	public Color getFarbe() {
		return farbe.getBackground();
	}
	
	public boolean isComputer() {
		if(computer == null) {
			return false;
		}
		return computer.isSelected();
	}
	
	public String toString() {
		return getName() + " " + getFarbe().toString() + " ";
	}
}
