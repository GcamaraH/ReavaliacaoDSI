package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.produtoDAO.ProdutoDAO;
import br.edu.ifsp.model.Produto;
import br.edu.ifsp.view.TelaExibeBusca;
import br.edu.ifsp.view.SubTelaBusca;
import br.edu.ifsp.view.TelaEdicao;
import br.edu.ifsp.view.TelaBusca;
import br.edu.ifsp.view.TelaSelecaoBusca;

public class BuscarController implements ActionListener {

	private SubTelaBusca subTelaBusca;
	private TelaSelecaoBusca selecaoOpcaoBusca;
	private TelaBusca busca;
	private TelaEdicao edicao;

	public BuscarController(SubTelaBusca subTelaBusca, TelaSelecaoBusca selecaoOpcaoBusca,
			TelaBusca busca) {
		this.selecaoOpcaoBusca = selecaoOpcaoBusca;
		this.busca = busca;

		this.subTelaBusca = subTelaBusca;
		this.subTelaBusca.getBtnFetch().addActionListener(this);
	}

	public BuscarController(TelaEdicao edicao) {
		this.edicao = edicao;

		this.edicao.getBtnBusca().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RevisarCampo cg = new RevisarCampo();
		if (cg.isBlank(subTelaBusca.getFldFetch(), subTelaBusca.getLblFetch(),
				" precisa ser preenchido.")) {
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			
			Produto p = produtoDAO.fetchProdutoById(Integer.valueOf(subTelaBusca.getFldFetch().getText()));
			
			if (p != null) {
				
				this.subTelaBusca.dispose();
				this.busca.dispose();
				this.selecaoOpcaoBusca.dispose();
				
				TelaBusca wfn = new TelaBusca(selecaoOpcaoBusca);
				wfn.createWindowName(new TelaExibeBusca(wfn, p));
			}
			subTelaBusca.setFldFetch("");
		}
	}

}
