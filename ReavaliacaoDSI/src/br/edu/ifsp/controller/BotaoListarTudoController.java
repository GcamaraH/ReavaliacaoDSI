package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import br.edu.ifsp.produtoDAO.ProdutoDAO;
import br.edu.ifsp.model.Produto;
import br.edu.ifsp.view.TelaBusca;
import br.edu.ifsp.view.TelaExibeBusca;
import br.edu.ifsp.view.TelaSelecaoBusca;

public class BotaoListarTudoController implements ActionListener {

	private TelaSelecaoBusca selecaoOpcaoBusca;

	public BotaoListarTudoController(TelaSelecaoBusca selecaoOpcaoBusca) {
		this.selecaoOpcaoBusca = selecaoOpcaoBusca;
		this.selecaoOpcaoBusca.getBtnListALL().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> l =  produtoDAO.fetchProdutoByName();
		
		TelaBusca wfn = new TelaBusca(selecaoOpcaoBusca);
		wfn.createWindowName(new TelaExibeBusca(wfn, l));
		
		selecaoOpcaoBusca.dispose();

	}

}
