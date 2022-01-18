package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.view.SubTelaBusca;
import br.edu.ifsp.view.TelaHome;
import br.edu.ifsp.view.TelaCadastro;
import br.edu.ifsp.view.TelaRemocao;
import br.edu.ifsp.view.TelaEdicao;
import br.edu.ifsp.view.TelaBusca;
import br.edu.ifsp.view.TelaSelecaoBusca;

public class BotaoCancelarController implements ActionListener {

	private TelaHome home;
	private TelaCadastro windowAdd;
	private TelaSelecaoBusca windowSelectFetch;
	private SubTelaBusca internalFrameFetch;
	private TelaBusca windowFetch;

	private int optionSelected;
	private TelaEdicao windowEdit;
	private TelaRemocao windowDelete;

	public BotaoCancelarController(TelaCadastro windowAdd, TelaHome home) {
		this.home = home;

		this.windowAdd = windowAdd;
		this.windowAdd.getBtnCancel().addActionListener(this);

		optionSelected = 0;
	}

	public BotaoCancelarController(TelaSelecaoBusca windowSelectFetch, TelaHome home) {
		this.home = home;
		
		this.windowSelectFetch = windowSelectFetch;
		this.windowSelectFetch.getBtnCancel().addActionListener(this);

		optionSelected = 1;
	}

	public BotaoCancelarController(SubTelaBusca internalFrameFetch, TelaSelecaoBusca windowSelectFetch, TelaBusca windowFetch) {
		this.windowSelectFetch = windowSelectFetch;
		this.windowFetch = windowFetch;
		
		this.internalFrameFetch = internalFrameFetch;
		this.internalFrameFetch.getBtnCancel().addActionListener(this);

		optionSelected = 2;
	}

	public BotaoCancelarController(TelaEdicao windowEdit, TelaHome home) {
		this.home = home;
		
		this.windowEdit = windowEdit;
		this.windowEdit.getBtnCancel().addActionListener(this);

		optionSelected = 3;
	}

	public BotaoCancelarController(TelaRemocao windowDelete, TelaHome home) {
		this.home = home;
		
		this.windowDelete = windowDelete;
		this.windowDelete.getBtnCancel().addActionListener(this);

		optionSelected = 4;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (optionSelected) {
		case 0: {
			this.windowAdd.dispose();
			this.home.setVisible(true);
			break;
		}
		case 1: {
			this.windowSelectFetch.dispose();
			this.home.setVisible(true);
			break;
		}
		case 2: {
			this.internalFrameFetch.dispose();
			this.windowFetch.dispose();
			this.windowSelectFetch.setVisible(true);
			break;
		}
		case 3: {
			this.windowEdit.dispose();
			this.home.setVisible(true);
			break;
		}
		case 4: {
			this.windowDelete.dispose();
			this.home.setVisible(true);
			break;
		}
		}
	}
}
