package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.view.TelaHome;
import br.edu.ifsp.view.TelaRemocao;

public class BotaoDeletarController implements ActionListener {

	private TelaHome home;

	public BotaoDeletarController(TelaHome home) {
		this.home = home;
		this.home.getBtnDelete().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.home.dispose();
		TelaRemocao remocao = new TelaRemocao(home);

	}

}
