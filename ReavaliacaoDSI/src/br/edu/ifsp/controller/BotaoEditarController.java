package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.view.TelaHome;
import br.edu.ifsp.view.TelaEdicao;

public class BotaoEditarController implements ActionListener {

	private TelaHome home;

	public BotaoEditarController(TelaHome home) {
		this.home = home;
		this.home.getBtnEdit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TelaEdicao edicao = new TelaEdicao(home);
		home.dispose();
	}

	
}
