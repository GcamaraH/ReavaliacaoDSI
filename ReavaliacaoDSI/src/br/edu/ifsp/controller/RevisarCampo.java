package br.edu.ifsp.controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RevisarCampo {

	public RevisarCampo() {

	}

	public Boolean isBlank(JTextField field, JLabel jLabel, String text) {
		if (field.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "O campo " + jLabel.getText() + text, "Menssagem", 0, new ImageIcon(""));
			field.requestFocusInWindow();
			return false;
		}
		return true;
	}

	public boolean isBlank(JTextArea field, JLabel label, String text) {
		if (field.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "O campo " + label.getText() + text, "Menssagem", 0, new ImageIcon(""));
			field.requestFocusInWindow();
			return false;
		}
		return true;
	}
}
