package br.edu.ifsp.controller;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;

public class CarregaPainelRestricao {

	public CarregaPainelRestricao() {

	}

	public JComponent setLoadConstraintPanel(Container container, JComponent component, GridBagConstraints gbc,
			GridBagLayout gridBag, int row, int col, int width, int height, int spaceX, int spaceY, int anchor) {
		final int SPACE = 5;

		gbc.gridy = row;
		gbc.gridx = col;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.ipadx = spaceX;
		gbc.ipady = spaceY;
		gbc.anchor = anchor;
		gbc.insets.left = SPACE;
		gbc.insets.right = SPACE;
		gbc.insets.top = SPACE;
		gbc.insets.bottom = SPACE;

		gridBag.setConstraints(component, gbc);

		container.add(component);

		return component;
	}

}
