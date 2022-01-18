package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.view.TelaHome;
import br.edu.ifsp.view.TelaCadastro;

public class BotaoAdicionarController implements ActionListener{

	private TelaHome home;

	public BotaoAdicionarController(TelaHome home) {
		this.home = home;
		this.home.getBtnAdd().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TelaCadastro wa = new TelaCadastro(home);
		home.dispose();
	}

}
