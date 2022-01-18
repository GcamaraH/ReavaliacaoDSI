package br.edu.ifsp.controller;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class CriaCampoFormatado {

	public JFormattedTextField setFormattedField(JFormattedTextField field, int columns, String mask, String font,
			int style, int size, boolean editable) throws ParseException {

		field = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat(mask))));
		field.setColumns(columns);
		field.setFont(new Font(font, style, size));
		field.setEditable(editable);

		return field;
	}

	public JFormattedTextField setFormattedField(JFormattedTextField field, int columns, String mask, boolean editable)
			throws ParseException {

		field = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat(mask))));
		field.setColumns(columns);
		field.setEditable(editable);

		return field;
	}
}
