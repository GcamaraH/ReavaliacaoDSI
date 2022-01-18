package br.edu.ifsp.view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifsp.controller.BotaoAdicionarController;
import br.edu.ifsp.controller.BotaoDeletarController;
import br.edu.ifsp.controller.BotaoEditarController;
import br.edu.ifsp.controller.BotaoBuscarController;
import br.edu.ifsp.controller.EncerrarPrograma;
import br.edu.ifsp.controller.CriaBotao;
import br.edu.ifsp.controller.CriaLabel;

public class TelaHome extends JFrame {

	private JPanel panel;

	private JPanel panelBtns;
	private JButton btnAdicionar;
	private JButton btnsBuscar;
	private JButton btnEditar;
	private JButton btnDeletar;

	public TelaHome() {
		criaComponentes();
		montaTela();

		BotaoAdicionarController bac = new BotaoAdicionarController(this);
		BotaoBuscarController bfc = new BotaoBuscarController(this);
		BotaoEditarController bec = new BotaoEditarController(this);
		BotaoDeletarController bdc = new BotaoDeletarController(this);
		
		EncerrarPrograma janela = new EncerrarPrograma(this);

	}

	private void criaComponentes() {
		panel = new JPanel(new GridLayout(2, 1));

		panelBtns = new JPanel(new GridLayout(1, 4));
		btnAdicionar = new CriaBotao().setButton(btnAdicionar, "Adicionar", "Arial", 0, 20, "");
		btnsBuscar= new CriaBotao().setButton(btnsBuscar, "Buscar", "Arial", 0, 20, "");
		btnEditar = new CriaBotao().setButton(btnEditar, "Editar", "Arial", 0, 20, "");
		btnDeletar = new CriaBotao().setButton(btnDeletar, "Excluir", "Arial", 0, 20, "");

		insereComponentes();
	}

	private void insereComponentes() {
		panelBtns.add(btnAdicionar);
		panelBtns.add(btnsBuscar);
		panelBtns.add(btnEditar);
		panelBtns.add(btnDeletar);

		panel.add(panelBtns);

		add(panel);

	}

	private void montaTela() {
		setTitle("Gerenciamento de Estoque");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public JButton getBtnAdd() {
		return btnAdicionar;
	}	

	public JButton getBtnFetch() {
		return btnsBuscar;
	}

	public JButton getBtnEdit() {
		return btnEditar;
	}

	public JButton getBtnDelete() {
		return btnDeletar;
	}
}
