package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class SpielBrettGui2 extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpielBrettGui2 frame = new SpielBrettGui2();
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SpielBrettGui2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setPreferredSize(new Dimension(1024, 768));
		//setBounds(0, 0, 1024, 768);
		GridBagLayout gridBagLayout = new GridBagLayout();
//		GridBagConstraints gbc = new GridBagConstraints();
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.anchor = GridBagConstraints.CENTER;
//		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		getContentPane().setBackground(Color.YELLOW);
		
		Kreis btnNewButton = new Kreis(Color.YELLOW);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
//		gbc.gridx = 1;
//		gbc.gridy = 1;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		Kreis btnTesttest = new Kreis(Color.YELLOW);
		GridBagConstraints gbc_btnTesttest = new GridBagConstraints();
		gbc_btnTesttest.insets = new Insets(0, 0, 5, 5);
		gbc_btnTesttest.gridx = 2;
		gbc_btnTesttest.gridy = 1;
//		gbc.gridx = 2;
//		gbc.gridy = 1;
		getContentPane().add(btnTesttest, gbc_btnTesttest);
		
		Kreis btnNormal_9 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_9 = new GridBagConstraints();
		gbc_btnNormal_9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_9.gridx = 5;
		gbc_btnNormal_9.gridy = 1;
		getContentPane().add(btnNormal_9, gbc_btnNormal_9);
		
		Kreis btnNormal_10 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_10 = new GridBagConstraints();
		gbc_btnNormal_10.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_10.gridx = 6;
		gbc_btnNormal_10.gridy = 1;
		getContentPane().add(btnNormal_10, gbc_btnNormal_10);
		
		Kreis btnStartBlau = new Kreis(Color.BLUE);
		GridBagConstraints gbc_btnStartBlau = new GridBagConstraints();
		gbc_btnStartBlau.insets = new Insets(0, 0, 5, 5);
		gbc_btnStartBlau.gridx = 7;
		gbc_btnStartBlau.gridy = 1;
		getContentPane().add(btnStartBlau, gbc_btnStartBlau);
		
		Kreis btnTest = new Kreis(Color.YELLOW);
		GridBagConstraints gbc_btnTest = new GridBagConstraints();
		gbc_btnTest.insets = new Insets(0, 0, 5, 5);
		gbc_btnTest.gridx = 1;
		gbc_btnTest.gridy = 2;
		getContentPane().add(btnTest, gbc_btnTest);
		
		Kreis btnNewButton_1 = new Kreis(Color.YELLOW);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 2;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		Kreis btnNormal_8 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_8 = new GridBagConstraints();
		gbc_btnNormal_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_8.gridx = 5;
		gbc_btnNormal_8.gridy = 2;
		getContentPane().add(btnNormal_8, gbc_btnNormal_8);
		
		Kreis btnHomeBlau_3 = new Kreis(Color.BLUE);
		GridBagConstraints gbc_btnHomeBlau_3 = new GridBagConstraints();
		gbc_btnHomeBlau_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeBlau_3.gridx = 6;
		gbc_btnHomeBlau_3.gridy = 2;
		getContentPane().add(btnHomeBlau_3, gbc_btnHomeBlau_3);
		
		Kreis btnNormal_11 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_11 = new GridBagConstraints();
		gbc_btnNormal_11.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_11.gridx = 7;
		gbc_btnNormal_11.gridy = 2;
		getContentPane().add(btnNormal_11, gbc_btnNormal_11);
		
		Kreis btnNormal_7 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_7 = new GridBagConstraints();
		gbc_btnNormal_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_7.gridx = 5;
		gbc_btnNormal_7.gridy = 3;
		getContentPane().add(btnNormal_7, gbc_btnNormal_7);
		
		Kreis btnHomeBlau_2 = new Kreis(Color.BLUE);
		GridBagConstraints gbc_btnHomeBlau_2 = new GridBagConstraints();
		gbc_btnHomeBlau_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeBlau_2.gridx = 6;
		gbc_btnHomeBlau_2.gridy = 3;
		getContentPane().add(btnHomeBlau_2, gbc_btnHomeBlau_2);
		
		Kreis btnNormal_12 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_12 = new GridBagConstraints();
		gbc_btnNormal_12.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_12.gridx = 7;
		gbc_btnNormal_12.gridy = 3;
		getContentPane().add(btnNormal_12, gbc_btnNormal_12);
		
		Kreis btnNormal_6 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_6 = new GridBagConstraints();
		gbc_btnNormal_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_6.gridx = 5;
		gbc_btnNormal_6.gridy = 4;
		getContentPane().add(btnNormal_6, gbc_btnNormal_6);
		
		Kreis btnHomeBlau_1 = new Kreis(Color.BLUE);
		GridBagConstraints gbc_btnHomeBlau_1 = new GridBagConstraints();
		gbc_btnHomeBlau_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeBlau_1.gridx = 6;
		gbc_btnHomeBlau_1.gridy = 4;
		getContentPane().add(btnHomeBlau_1, gbc_btnHomeBlau_1);
		
		Kreis btnNormal_13 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_13 = new GridBagConstraints();
		gbc_btnNormal_13.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_13.gridx = 7;
		gbc_btnNormal_13.gridy = 4;
		getContentPane().add(btnNormal_13, gbc_btnNormal_13);
		
		Kreis btnNormal_16 = new Kreis(Color.YELLOW);
		GridBagConstraints gbc_btnNewButton_16 = new GridBagConstraints();
		gbc_btnNewButton_16.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_16.gridx = 1;
		gbc_btnNewButton_16.gridy = 5;
		getContentPane().add(btnNormal_16, gbc_btnNewButton_16);
		
		Kreis btnNormal_2 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_2 = new GridBagConstraints();
		gbc_btnNormal_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_2.gridx = 2;
		gbc_btnNormal_2.gridy = 5;
		getContentPane().add(btnNormal_2, gbc_btnNormal_2);
		
		Kreis btnNormal_3 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_3 = new GridBagConstraints();
		gbc_btnNormal_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_3.gridx = 3;
		gbc_btnNormal_3.gridy = 5;
		getContentPane().add(btnNormal_3, gbc_btnNormal_3);
		
		Kreis btnNormal_4 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_4 = new GridBagConstraints();
		gbc_btnNormal_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_4.gridx = 4;
		gbc_btnNormal_4.gridy = 5;
		getContentPane().add(btnNormal_4, gbc_btnNormal_4);
		
		Kreis btnNormal_5 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_5 = new GridBagConstraints();
		gbc_btnNormal_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_5.gridx = 5;
		gbc_btnNormal_5.gridy = 5;
		getContentPane().add(btnNormal_5, gbc_btnNormal_5);
		
		Kreis btnHomeBlau = new Kreis(Color.BLUE);
		GridBagConstraints gbc_btnHomeBlau = new GridBagConstraints();
		gbc_btnHomeBlau.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeBlau.gridx = 6;
		gbc_btnHomeBlau.gridy = 5;
		getContentPane().add(btnHomeBlau, gbc_btnHomeBlau);
		
		Kreis btnNormal_14 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_14 = new GridBagConstraints();
		gbc_btnNormal_14.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_14.gridx = 7;
		gbc_btnNormal_14.gridy = 5;
		getContentPane().add(btnNormal_14, gbc_btnNormal_14);
		
		Kreis btnNormal_15 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_15 = new GridBagConstraints();
		gbc_btnNormal_15.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_15.gridx = 8;
		gbc_btnNormal_15.gridy = 5;
		getContentPane().add(btnNormal_15, gbc_btnNormal_15);
		
		Kreis btnNormal_30 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_30 = new GridBagConstraints();
		gbc_btnNormal_30.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_30.gridx = 9;
		gbc_btnNormal_30.gridy = 5;
		getContentPane().add(btnNormal_30, gbc_btnNormal_30);
		
		Kreis btnNormal_17 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_17 = new GridBagConstraints();
		gbc_btnNormal_17.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_17.gridx = 10;
		gbc_btnNormal_17.gridy = 5;
		getContentPane().add(btnNormal_17, gbc_btnNormal_17);
		
		Kreis btnNormal_21 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_21 = new GridBagConstraints();
		gbc_btnNormal_21.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_21.gridx = 11;
		gbc_btnNormal_21.gridy = 5;
		getContentPane().add(btnNormal_21, gbc_btnNormal_21);
		
		Kreis btnNewButton_15 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_15 = new GridBagConstraints();
		gbc_btnNewButton_15.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_15.gridx = 1;
		gbc_btnNewButton_15.gridy = 6;
		getContentPane().add(btnNewButton_15, gbc_btnNewButton_15);
		
		Kreis btnHomeGelb_3 = new Kreis(Color.YELLOW);
		GridBagConstraints gbc_btnHomeGelb_3 = new GridBagConstraints();
		gbc_btnHomeGelb_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGelb_3.gridx = 2;
		gbc_btnHomeGelb_3.gridy = 6;
		getContentPane().add(btnHomeGelb_3, gbc_btnHomeGelb_3);
		
		Kreis btnHomeGelb_2 = new Kreis(Color.YELLOW);
		GridBagConstraints gbc_btnHomeGelb_2 = new GridBagConstraints();
		gbc_btnHomeGelb_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGelb_2.gridx = 3;
		gbc_btnHomeGelb_2.gridy = 6;
		getContentPane().add(btnHomeGelb_2, gbc_btnHomeGelb_2);
		
		Kreis btnHomeGelb_1 = new Kreis(Color.YELLOW);
		GridBagConstraints gbc_btnHomeGelb_1 = new GridBagConstraints();
		gbc_btnHomeGelb_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGelb_1.gridx = 4;
		gbc_btnHomeGelb_1.gridy = 6;
		getContentPane().add(btnHomeGelb_1, gbc_btnHomeGelb_1);
		
		Kreis btnHomeGelb = new Kreis(Color.YELLOW);
		GridBagConstraints gbc_btnHomeGelb = new GridBagConstraints();
		gbc_btnHomeGelb.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGelb.gridx = 5;
		gbc_btnHomeGelb.gridy = 6;
		getContentPane().add(btnHomeGelb, gbc_btnHomeGelb);
		
		Kreis btnHomeGruen = new Kreis(Color.GREEN);
		GridBagConstraints gbc_btnHomeGruen = new GridBagConstraints();
		gbc_btnHomeGruen.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen.gridx = 7;
		gbc_btnHomeGruen.gridy = 6;
		getContentPane().add(btnHomeGruen, gbc_btnHomeGruen);
		
		Kreis btnHomeGruen_1 = new Kreis(Color.GREEN);
		GridBagConstraints gbc_btnHomeGruen_1 = new GridBagConstraints();
		gbc_btnHomeGruen_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_1.gridx = 8;
		gbc_btnHomeGruen_1.gridy = 6;
		getContentPane().add(btnHomeGruen_1, gbc_btnHomeGruen_1);
		
		Kreis btnHomeGruen_2 = new Kreis(Color.GREEN);
		GridBagConstraints gbc_btnHomeGruen_2 = new GridBagConstraints();
		gbc_btnHomeGruen_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_2.gridx = 9;
		gbc_btnHomeGruen_2.gridy = 6;
		getContentPane().add(btnHomeGruen_2, gbc_btnHomeGruen_2);
		
		Kreis btnHomeGruen_3 = new Kreis(Color.GREEN);
		GridBagConstraints gbc_btnHomeGruen_3 = new GridBagConstraints();
		gbc_btnHomeGruen_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_3.gridx = 10;
		gbc_btnHomeGruen_3.gridy = 6;
		getContentPane().add(btnHomeGruen_3, gbc_btnHomeGruen_3);
		
		Kreis btnHomeGruen_20 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnHomeGruen_20 = new GridBagConstraints();
		gbc_btnHomeGruen_20.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_20.gridx = 11;
		gbc_btnHomeGruen_20.gridy = 6;
		getContentPane().add(btnHomeGruen_20, gbc_btnHomeGruen_20);
		
		Kreis btnNormal_1 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_1 = new GridBagConstraints();
		gbc_btnNormal_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_1.gridx = 1;
		gbc_btnNormal_1.gridy = 7;
		getContentPane().add(btnNormal_1, gbc_btnNormal_1);
		
		Kreis btnNormal = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal = new GridBagConstraints();
		gbc_btnNormal.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal.gridx = 2;
		gbc_btnNormal.gridy = 7;
		getContentPane().add(btnNormal, gbc_btnNormal);
		
		Kreis btnNewButton_14 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_14 = new GridBagConstraints();
		gbc_btnNewButton_14.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_14.gridx = 3;
		gbc_btnNewButton_14.gridy = 7;
		getContentPane().add(btnNewButton_14, gbc_btnNewButton_14);
		
		Kreis btnNewButton_13 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_13 = new GridBagConstraints();
		gbc_btnNewButton_13.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_13.gridx = 4;
		gbc_btnNewButton_13.gridy = 7;
		getContentPane().add(btnNewButton_13, gbc_btnNewButton_13);
		
		Kreis btnNewButton_12 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_12.gridx = 5;
		gbc_btnNewButton_12.gridy = 7;
		getContentPane().add(btnNewButton_12, gbc_btnNewButton_12);
		
		Kreis btnHomeRot_3 = new Kreis(Color.RED);
		GridBagConstraints gbc_btnHomeRot_3 = new GridBagConstraints();
		gbc_btnHomeRot_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeRot_3.gridx = 6;
		gbc_btnHomeRot_3.gridy = 7;
		getContentPane().add(btnHomeRot_3, gbc_btnHomeRot_3);
		
		Kreis btnNewButton_5 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 7;
		gbc_btnNewButton_5.gridy = 7;
		getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
		
		Kreis btnNewButton_6 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 8;
		gbc_btnNewButton_6.gridy = 7;
		getContentPane().add(btnNewButton_6, gbc_btnNewButton_6);
		
		Kreis btnNewButton_7 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 9;
		gbc_btnNewButton_7.gridy = 7;
		getContentPane().add(btnNewButton_7, gbc_btnNewButton_7);
		
		Kreis btnNormal_18 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNormal_18 = new GridBagConstraints();
		gbc_btnNormal_18.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_18.gridx = 10;
		gbc_btnNormal_18.gridy = 7;
		getContentPane().add(btnNormal_18, gbc_btnNormal_18);
		
		Kreis btnNormal_19 = new Kreis(Color.GREEN);
		GridBagConstraints gbc_btnNormal_19 = new GridBagConstraints();
		gbc_btnNormal_19.insets = new Insets(0, 0, 5, 5);
		gbc_btnNormal_19.gridx = 11;
		gbc_btnNormal_19.gridy = 7;
		getContentPane().add(btnNormal_19, gbc_btnNormal_19);
		
		Kreis btnNewButton_11 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 5;
		gbc_btnNewButton_11.gridy = 8;
		getContentPane().add(btnNewButton_11, gbc_btnNewButton_11);
		
		Kreis btnHomeRot_2 = new Kreis(Color.RED);
		GridBagConstraints gbc_btnHomeRot_2 = new GridBagConstraints();
		gbc_btnHomeRot_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeRot_2.gridx = 6;
		gbc_btnHomeRot_2.gridy = 8;
		getContentPane().add(btnHomeRot_2, gbc_btnHomeRot_2);
		
		Kreis btnNewButton_4 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 7;
		gbc_btnNewButton_4.gridy = 8;
		getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		
		Kreis btnNewButton_10 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_10.gridx = 5;
		gbc_btnNewButton_10.gridy = 9;
		getContentPane().add(btnNewButton_10, gbc_btnNewButton_10);
		
		Kreis btnHomeRot_1 = new Kreis(Color.RED);
		GridBagConstraints gbc_btnHomeRot_1 = new GridBagConstraints();
		gbc_btnHomeRot_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeRot_1.gridx = 6;
		gbc_btnHomeRot_1.gridy = 9;
		getContentPane().add(btnHomeRot_1, gbc_btnHomeRot_1);
		
		Kreis btnNewButton_3 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 7;
		gbc_btnNewButton_3.gridy = 9;
		getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		
		Kreis btnNewButton_9 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_9.gridx = 5;
		gbc_btnNewButton_9.gridy = 10;
		getContentPane().add(btnNewButton_9, gbc_btnNewButton_9);
		
		Kreis btnHomeRot = new Kreis(Color.RED);
		GridBagConstraints gbc_btnHomeRot = new GridBagConstraints();
		gbc_btnHomeRot.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeRot.gridx = 6;
		gbc_btnHomeRot.gridy = 10;
		getContentPane().add(btnHomeRot, gbc_btnHomeRot);
		
		Kreis btnNewButton_2 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 7;
		gbc_btnNewButton_2.gridy = 10;
		getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		
		Kreis btnGruen_2 = new Kreis(Color.GREEN);
		GridBagConstraints gbc_btnGruen_2 = new GridBagConstraints();
		gbc_btnGruen_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnGruen_2.gridx = 10;
		gbc_btnGruen_2.gridy = 10;
		getContentPane().add(btnGruen_2, gbc_btnGruen_2);
		
		Kreis btnGruen = new Kreis(Color.GREEN);
		GridBagConstraints gbc_btnGruen = new GridBagConstraints();
		gbc_btnGruen.insets = new Insets(0, 0, 5, 0);
		gbc_btnGruen.gridx = 11;
		gbc_btnGruen.gridy = 10;
		getContentPane().add(btnGruen, gbc_btnGruen);
		
		Kreis btnStartRot = new Kreis(Color.RED);
		GridBagConstraints gbc_btnStartRot = new GridBagConstraints();
		gbc_btnStartRot.insets = new Insets(0, 0, 0, 5);
		gbc_btnStartRot.gridx = 5;
		gbc_btnStartRot.gridy = 11;
		getContentPane().add(btnStartRot, gbc_btnStartRot);
		
		Kreis btnNewButton_8 = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_8.gridx = 6;
		gbc_btnNewButton_8.gridy = 11;
		getContentPane().add(btnNewButton_8, gbc_btnNewButton_8);
		
		Kreis btnStartGruen = new Kreis(Color.WHITE);
		GridBagConstraints gbc_btnStartGruen = new GridBagConstraints();
		gbc_btnStartGruen.insets = new Insets(0, 0, 0, 5);
		gbc_btnStartGruen.gridx = 7;
		gbc_btnStartGruen.gridy = 11;
		getContentPane().add(btnStartGruen, gbc_btnStartGruen);
		
		Kreis btnGruen_3 = new Kreis(Color.GREEN);
		GridBagConstraints gbc_btnGruen_3 = new GridBagConstraints();
		gbc_btnGruen_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnGruen_3.gridx = 10;
		gbc_btnGruen_3.gridy = 11;
		getContentPane().add(btnGruen_3, gbc_btnGruen_3);
		
		Kreis btnGruen_1 = new Kreis(Color.GREEN);
		GridBagConstraints gbc_btnGruen_1 = new GridBagConstraints();
		gbc_btnGruen_1.gridx = 11;
		gbc_btnGruen_1.gridy = 11;
		getContentPane().add(btnGruen_1, gbc_btnGruen_1);
		
		Kreis btnHomeGruen_22 = new Kreis(Color.BLUE);
		GridBagConstraints gbc_btnHomeGruen_22 = new GridBagConstraints();
		gbc_btnHomeGruen_22.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_22.gridx = 11;
		gbc_btnHomeGruen_22.gridy = 1;
		getContentPane().add(btnHomeGruen_22, gbc_btnHomeGruen_22);
		
		Kreis btnHomeGruen_23 = new Kreis(Color.BLUE);
		GridBagConstraints gbc_btnHomeGruen_23 = new GridBagConstraints();
		gbc_btnHomeGruen_23.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_23.gridx = 11;
		gbc_btnHomeGruen_23.gridy = 2;
		getContentPane().add(btnHomeGruen_23, gbc_btnHomeGruen_23);
		
		Kreis btnHomeGruen_24 = new Kreis(Color.BLUE);
		GridBagConstraints gbc_btnHomeGruen_24 = new GridBagConstraints();
		gbc_btnHomeGruen_24.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_24.gridx = 10;
		gbc_btnHomeGruen_24.gridy = 1;
		getContentPane().add(btnHomeGruen_24, gbc_btnHomeGruen_24);
		
		Kreis btnHomeGruen_25 = new Kreis(Color.BLUE);
		GridBagConstraints gbc_btnHomeGruen_25 = new GridBagConstraints();
		gbc_btnHomeGruen_25.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_25.gridx = 10;
		gbc_btnHomeGruen_25.gridy = 2;
		getContentPane().add(btnHomeGruen_25, gbc_btnHomeGruen_25);
		
		Kreis btnHomeGruen_26 = new Kreis(Color.RED);
		GridBagConstraints gbc_btnHomeGruen_26 = new GridBagConstraints();
		gbc_btnHomeGruen_26.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_26.gridx = 1;
		gbc_btnHomeGruen_26.gridy = 10;
		getContentPane().add(btnHomeGruen_26, gbc_btnHomeGruen_26);
		
		Kreis btnHomeGruen_27 = new Kreis(Color.RED);
		GridBagConstraints gbc_btnHomeGruen_27 = new GridBagConstraints();
		gbc_btnHomeGruen_27.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_27.gridx = 1;
		gbc_btnHomeGruen_27.gridy = 11;
		getContentPane().add(btnHomeGruen_27, gbc_btnHomeGruen_27);
		
		Kreis btnHomeGruen_28 = new Kreis(Color.RED);
		GridBagConstraints gbc_btnHomeGruen_28 = new GridBagConstraints();
		gbc_btnHomeGruen_28.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_28.gridx = 2;
		gbc_btnHomeGruen_28.gridy = 10;
		getContentPane().add(btnHomeGruen_28, gbc_btnHomeGruen_28);
		
		Kreis btnHomeGruen_29 = new Kreis(Color.RED);
		GridBagConstraints gbc_btnHomeGruen_29 = new GridBagConstraints();
		gbc_btnHomeGruen_29.insets = new Insets(0, 0, 5, 5);
		gbc_btnHomeGruen_29.gridx = 2;
		gbc_btnHomeGruen_29.gridy = 11;
		getContentPane().add(btnHomeGruen_29, gbc_btnHomeGruen_29);
		
		
		
	}

}
