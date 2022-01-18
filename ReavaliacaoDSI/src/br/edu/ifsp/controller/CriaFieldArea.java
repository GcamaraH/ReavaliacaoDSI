package br.edu.ifsp.controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class CriaFieldArea {

	public JTextArea setFieldArea(JTextArea field, int rows, int columns, String font, int style,
			int size, boolean editable) {
		field = new JTextArea(rows, columns);
		field.setFont(new Font(font, style, size));
		field.setEditable(editable);
		if(!editable) {
			field.setBackground(new Color(235, 235, 235));
		}
		return field;
	}

	public JTextArea setFieldArea(JTextArea field, int rows, int columns, boolean editable) {
		field = new JTextArea(rows, columns);
		field.setEditable(editable);
		
		return field;
	}

}
