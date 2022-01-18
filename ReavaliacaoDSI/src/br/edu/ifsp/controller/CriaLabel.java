package br.edu.ifsp.controller;

import java.awt.Font;

import javax.swing.JLabel;

public class CriaLabel extends JLabel {

	public CriaLabel() {

	}

	public JLabel setLabel(JLabel label, String text, String font, int style, int size) {
		label = new JLabel(text);
		label.setFont(new Font(font, style, size));

		return label;
	}

	public JLabel setLabel(JLabel label, String text) {
		label = new JLabel(text);

		return label;
	}

}
