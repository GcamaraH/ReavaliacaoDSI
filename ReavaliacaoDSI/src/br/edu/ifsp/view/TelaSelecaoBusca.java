package br.edu.ifsp.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifsp.controller.BotaoCancelarController;
import br.edu.ifsp.controller.BotaoListarTudoController;
import br.edu.ifsp.controller.BotaoSelecionaBuscaController;
import br.edu.ifsp.controller.EncerrarPrograma;
import br.edu.ifsp.controller.CriaBotao;
import br.edu.ifsp.controller.CriaLabel;
import br.edu.ifsp.controller.CarregaPainelRestricao;

public class TelaSelecaoBusca extends JFrame {

	private JPanel pnl;
	private GridBagLayout gridBag;
	private JLabel lblInfo;
	private JButton btnByName;
	private JButton btnListALL;
	private JButton btnCancel;
	public TelaSelecaoBusca(TelaHome home) {
		createWindow();
		loadWindow();

		new BotaoSelecionaBuscaController(this, home);
		new BotaoListarTudoController(this);
		new BotaoCancelarController(this, home);
		
		new EncerrarPrograma(this, home);
	}

	private void createWindow() {
		gridBag = new GridBagLayout();

		pnl = new JPanel(gridBag);

		lblInfo = new CriaLabel().setLabel(lblInfo, "Busca:", "Arial", 0, 20);

		btnByName = new CriaBotao().setButton(btnByName,   "Identificador", "Arial", 0, 20, "");
		
		btnListALL = new CriaBotao().setButton(btnListALL, "Listar todos", "Arial", 0, 20, "");

		btnCancel = new CriaBotao().setButton(btnCancel,   "  Cancelar  ", "Arial", 0, 20, "");

		btnByName.setPreferredSize(new Dimension(172, 30));
		btnListALL.setPreferredSize(new Dimension(172, 30));
		btnCancel.setPreferredSize(new Dimension(172, 30));
		
		addComponents(gridBag);
	}

	private void addComponents(GridBagLayout gridBag) {
		CarregaPainelRestricao lcp = new CarregaPainelRestricao();
		GridBagConstraints gbc = new GridBagConstraints();

		lcp.setLoadConstraintPanel(pnl, lblInfo, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnl, btnByName, gbc, gridBag, 1, 0, 2, 1, 5, 10, GridBagConstraints.CENTER);
		lcp.setLoadConstraintPanel(pnl, btnListALL, gbc, gridBag, 2, 0, 2, 1, 5, 10, GridBagConstraints.CENTER);

		lcp.setLoadConstraintPanel(pnl, btnCancel, gbc, gridBag, 3, 0, 2, 1, 5, 10, GridBagConstraints.CENTER);

		add(pnl);

	}

	private void loadWindow() {
		setTitle("");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public JButton getBtnByName() {
		return btnByName;
	}

	public JButton getBtnListALL() {
		return btnListALL;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
	
}
