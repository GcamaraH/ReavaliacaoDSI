package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.view.SubTelaBusca;
import br.edu.ifsp.view.TelaHome;
import br.edu.ifsp.view.TelaBusca;
import br.edu.ifsp.view.TelaSelecaoBusca;

public class BotaoSelecionaBuscaController implements ActionListener {

	private TelaSelecaoBusca selecaoOpcaoBusca;
	private TelaHome home;

	public BotaoSelecionaBuscaController(TelaSelecaoBusca selecaoOpcaoBusca, TelaHome home) {
		this.home = home;
		
		this.selecaoOpcaoBusca = selecaoOpcaoBusca;
		this.selecaoOpcaoBusca.getBtnByName().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		TelaBusca wfn = new TelaBusca(selecaoOpcaoBusca);
		wfn.createWindowFetch(new SubTelaBusca(wfn, selecaoOpcaoBusca));
		
		selecaoOpcaoBusca.dispose();
	}

}
