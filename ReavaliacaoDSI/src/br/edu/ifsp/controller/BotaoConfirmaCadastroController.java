package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.edu.ifsp.produtoDAO.ProdutoDAO;
import br.edu.ifsp.model.Produto;
import br.edu.ifsp.view.TelaHome;
import br.edu.ifsp.view.TelaCadastro;
import br.edu.ifsp.view.TelaRemocao;
import br.edu.ifsp.view.TelaEdicao;

public class BotaoConfirmaCadastroController implements ActionListener {

	private TelaHome home;
	private TelaCadastro telaCadastro;
	private TelaEdicao edicao;

	private int optionControler;
	private ProdutoDAO produtoDao;
	private TelaRemocao telaRemocao;

	public BotaoConfirmaCadastroController(TelaCadastro telaCadastro, TelaHome home) {
		this.home = home;

		this.telaCadastro = telaCadastro;
		this.telaCadastro.getBtnConfirm().addActionListener(this);

		optionControler = 0;
	}

	public BotaoConfirmaCadastroController(TelaEdicao edicao, TelaHome home) {
		this.home = home;

		this.edicao = edicao;
		this.edicao.getBtnConfirm().addActionListener(this);

		optionControler = 1;
	}

	public BotaoConfirmaCadastroController(TelaRemocao telaRemocao, TelaHome home) {
		this.home = home;

		this.telaRemocao = telaRemocao;
		this.telaRemocao.getBtnConfirm().addActionListener(this);

		optionControler = 2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RevisarCampo cg = new RevisarCampo();

		switch (optionControler) {
		case 0: {
			if (cg.isBlank(telaCadastro.getFldNome(), telaCadastro.getLblNome(), " é obrigatório.")
					&& cg.isBlank(telaCadastro.getFldDescricao(), telaCadastro.getLblDescricao(),
							" é obrigatório.")
					&& cg.isBlank(telaCadastro.getFldPreco(), telaCadastro.getLblPreco(),
							" precisa ser preenchido com números.")
					&& cg.isBlank(telaCadastro.getFldEstoque(), telaCadastro.getLblEstoque(),
							" precisa ser preenchido números.")) {
				
				Produto p = new Produto();
				p.setNome(telaCadastro.getFldNome().getText());
				p.setDescricao(telaCadastro.getFldDescricao().getText());;
				p.setPreco(Integer.parseInt(telaCadastro.getFldPreco().getText()));
				p.setEstoque(Integer.parseInt(telaCadastro.getFldEstoque().getText()));

				produtoDao = new ProdutoDAO();
				p = produtoDao.salvarProduto(p);

				if (p != null) {
					JOptionPane.showMessageDialog(null, telaCadastro.getFldNome().getText() + " Cadastrado", "", 0, new ImageIcon(""));

					telaCadastro.dispose();
					home.setVisible(true);
				}
			}
			break;
		}
		case 1: {
			if (cg.isBlank(edicao.getFldNome(), edicao.getLblNome(), " é obrigatório.")
					&& cg.isBlank(edicao.getFldDescricao(), edicao.getLblDescricao(),
							" é obrigatório.")
					&& cg.isBlank(edicao.getFldPreco(), edicao.getLblPreco(),
							" precisa ser um número.")
					&& cg.isBlank(edicao.getFldEstoque(), edicao.getLblEstoque(),
							" precisa ser um número.")) {

				Produto p = new Produto();
				p.setId(Integer.valueOf(edicao.getFldBusca().getText()));
				p.setNome(edicao.getFldNome().getText());
				p.setDescricao(edicao.getFldDescricao().getText());
				p.setPreco(Integer.parseInt(edicao.getFldPreco().getText()));
				p.setEstoque(Integer.parseInt(edicao.getFldEstoque().getText()));

				produtoDao = new ProdutoDAO();
				p = produtoDao.salvarProduto(p);

				if (p != null) {
					JOptionPane.showMessageDialog(null, edicao.getFldNome().getText() + " editado com sucesso!", "Menssagem", 0, new ImageIcon(""));

					edicao.dispose();
					home.setVisible(true);
				}
			}
			break;
		}
		case 2: {
			if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
					"Deseja excluir " + telaRemocao.getFldNome().getText() + "?", "", JOptionPane.YES_NO_OPTION,
					JOptionPane.ERROR_MESSAGE)) {

				produtoDao = new ProdutoDAO();
				produtoDao.removeProduto(Integer.valueOf(telaRemocao.getFldBusca().getText()));

				JOptionPane.showMessageDialog(null, telaRemocao.getFldNome().getText() + " excluido com sucesso!", "Menssagem", 0, new ImageIcon(""));

				telaRemocao.dispose();
				home.setVisible(true);
			}

			break;
		}
		}
	}

}
