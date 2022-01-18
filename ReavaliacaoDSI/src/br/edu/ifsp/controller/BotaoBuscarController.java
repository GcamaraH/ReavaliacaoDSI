package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.produtoDAO.ProdutoDAO;
import br.edu.ifsp.model.Produto;
import br.edu.ifsp.view.TelaHome;
import br.edu.ifsp.view.TelaRemocao;
import br.edu.ifsp.view.TelaEdicao;
import br.edu.ifsp.view.TelaSelecaoBusca;

public class BotaoBuscarController implements ActionListener {

	private TelaHome telaHome;
	private TelaEdicao windowEdit;
	private int optionControler;
	private TelaRemocao windowDelete;

	public BotaoBuscarController(TelaHome telaHome) {
		this.telaHome = telaHome;

		telaHome.getBtnFetch().addActionListener(this);

		optionControler = 0;
	}

	public BotaoBuscarController(TelaEdicao windowEdit) {
		this.windowEdit = windowEdit;

		windowEdit.getBtnBusca().addActionListener(this);

		optionControler = 1;
	}

	public BotaoBuscarController(TelaRemocao windowDelete) {
		this.windowDelete = windowDelete;

		windowDelete.getBtnBusca().addActionListener(this);

		optionControler = 2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (optionControler) {
		case 0: {
			TelaSelecaoBusca wsf = new TelaSelecaoBusca(telaHome);
			telaHome.dispose();
			break;
		}
		case 1: {
			RevisarCampo cg = new RevisarCampo();
			if (cg.isBlank(windowEdit.getFldBusca(), windowEdit.getFldBusca(), " precisa ser preenchido.")) {
				
				ProdutoDAO produtoDAO = new ProdutoDAO();
				
				Produto p = produtoDAO.fetchProdutoById(Integer.valueOf(windowEdit.getFldBusca().getText()));
				
				if (p != null) {
					
					windowEdit.setFldNome(p.getNome());
					windowEdit.setFldDescricao(p.getDescricao());
					windowEdit.setFldPreco(p.getPreco());
					windowEdit.setFldEstoque(p.getEstoque());
					
					windowEdit.getFldBusca().setEditable(false);
					windowEdit.getBtnBusca().setEnabled(false);
					
					windowEdit.getBtnConfirm().setEnabled(true);
					
				} else {
					windowEdit.setFldBusca("");
					windowEdit.getFldBusca().requestFocusInWindow();
				}
			}
			break;
		}
		case 2: {
			RevisarCampo cg = new RevisarCampo();
			if (cg.isBlank(windowDelete.getFldBusca(), windowDelete.getLblBusca(), " precisa ser preenchido.")) {

				ProdutoDAO produtoDAO = new ProdutoDAO();

				Produto p = produtoDAO.fetchProdutoById(Integer.valueOf(windowDelete.getFldBusca().getText()));

				if (p != null) {

					windowEdit.setFldNome(p.getNome());
					windowEdit.setFldDescricao(p.getDescricao());
					windowEdit.setFldPreco(p.getPreco());
					windowEdit.setFldEstoque(p.getEstoque());

					windowDelete.getFldBusca().setEditable(false);
					windowDelete.getBtnBusca().setEnabled(false);
					
					windowDelete.getBtnConfirm().setEnabled(true);
					
				} else {
					windowDelete.setFldBusca("");
					windowDelete.getFldBusca().requestFocusInWindow();
				}
			}
			break;
		}

		}
	}
}
