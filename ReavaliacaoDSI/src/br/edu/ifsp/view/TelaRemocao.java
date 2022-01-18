package br.edu.ifsp.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.ifsp.controller.BotaoCancelarController;
import br.edu.ifsp.controller.BotaoConfirmaCadastroController;
import br.edu.ifsp.controller.BotaoBuscarController;
import br.edu.ifsp.controller.EncerrarPrograma;
import br.edu.ifsp.controller.CriaBotao;
import br.edu.ifsp.controller.CriaCampo;
import br.edu.ifsp.controller.CriaFieldArea;
import br.edu.ifsp.controller.CriaCampoFormatado;
import br.edu.ifsp.controller.CriaLabel;
import br.edu.ifsp.controller.CarregaPainelRestricao;

public class TelaRemocao extends JFrame {

	private GridBagLayout gridBag;
	private JPanel panelBusca;
	private JLabel lblBusca;
	private JFormattedTextField fldBusca;
	private JButton btnBusca;

	private JPanel panelDelete;
	private JPanel panelFields;
	private JLabel lblNome;
	private JTextField fldNome;
	private JLabel lblDescriçao;
	private JTextArea fldDescricao;
	private JScrollPane scroll;
	private JLabel lblPreco;
	private JFormattedTextField fldPreco;
	private JLabel lblEstoque;
	private JFormattedTextField fldEstoque;

	private JPanel panelButtons;
	private JButton btnConfirm;
	private JButton btnCancel;

	private CarregaPainelRestricao lcp;
	private GridBagConstraints gbc;

	public TelaRemocao(TelaHome home) {
		criaComponentes();
		montaTela();
		
		new BotaoBuscarController(this);
		new BotaoConfirmaCadastroController(this, home);
		new BotaoCancelarController(this, home);

		new EncerrarPrograma(this, home);
	}

	private void criaComponentes() {
		gridBag = new GridBagLayout();

		panelBusca = new JPanel(gridBag);
		panelBusca.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lblBusca = new CriaLabel().setLabel(lblBusca, "ID", "Arial", 0, 15);
		try {
			fldBusca = new CriaCampoFormatado().setFormattedField(fldBusca, 34, "####", "Arial", 0, 12, true);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnBusca = new CriaBotao().setButton(btnBusca, "Buscar", "Arial", 0, 15, "");

		panelDelete = new JPanel(gridBag);
		panelDelete.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panelFields = new JPanel(gridBag);
		lblNome = new CriaLabel().setLabel(lblNome, "Título", "Arial", 0, 15);
		fldNome = new CriaCampo().setField(fldNome, 34, "Arial", 0, 12, false);

		lblDescriçao = new CriaLabel().setLabel(lblDescriçao, "Descrição", "Arial", 0, 15);
		fldDescricao = new CriaFieldArea().setFieldArea(fldDescricao, 5, 34, "Arial", 0,12 , false);
		scroll = new JScrollPane(fldDescricao);

		lblPreco = new CriaLabel().setLabel(lblPreco, "Valor", "Arial", 0, 15);
		try {
			fldPreco = new CriaCampoFormatado().setFormattedField(fldPreco, 7, "#,##0.00", "Arial", 0,12 , false);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		lblEstoque = new CriaLabel().setLabel(lblEstoque, "Quantidade", "Arial", 0, 15);
		try {
			fldEstoque = new CriaCampoFormatado().setFormattedField(fldEstoque, 3, "###", "Arial", 0,12 , false);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		panelButtons = new JPanel(gridBag);
		btnConfirm = new CriaBotao().setButton(btnConfirm, "Confirmar", "Arial", 0, 15, "");
		btnConfirm.setEnabled(false);

		btnCancel = new CriaBotao().setButton(btnCancel, "Cancelar", "Arial", 0, 15, "");

		addComponents(gridBag);
	}

	private void addComponents(GridBagLayout gridBag) {
		lcp = new CarregaPainelRestricao();
		gbc = new GridBagConstraints();

		lcp.setLoadConstraintPanel(panelBusca, lblBusca, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(panelBusca, fldBusca, gbc, gridBag, 0, 1, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(panelBusca, btnBusca, gbc, gridBag, 1, 1, 1, 1, 5, 10, GridBagConstraints.LINE_END);

		lcp.setLoadConstraintPanel(panelFields, lblNome, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(panelFields, fldNome, gbc, gridBag, 0, 1, 3, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(panelFields, lblDescriçao, gbc, gridBag, 1, 0, 1, 1, 5, 10, GridBagConstraints.EAST);

		lcp.setLoadConstraintPanel(panelFields, scroll, gbc, gridBag, 1, 1, 3, 1, 5, 10, GridBagConstraints.WEST);

		lcp.setLoadConstraintPanel(panelFields, lblPreco, gbc, gridBag, 4, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(panelFields, fldPreco, gbc, gridBag, 4, 1, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(panelFields, lblEstoque, gbc, gridBag, 4, 2, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(panelFields, fldEstoque, gbc, gridBag, 4, 3, 1, 1, 5, 10, GridBagConstraints.WEST);

		lcp.setLoadConstraintPanel(panelButtons, btnConfirm, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(panelButtons, btnCancel, gbc, gridBag, 0, 1, 1, 1, 5, 10, GridBagConstraints.WEST);

		lcp.setLoadConstraintPanel(panelDelete, panelFields, gbc, gridBag, 0, 0, 1, 1, 5, 5,
				GridBagConstraints.ABOVE_BASELINE);
		lcp.setLoadConstraintPanel(panelDelete, panelButtons, gbc, gridBag, 1, 0, 1, 1, 5, 5,
				GridBagConstraints.BELOW_BASELINE);

		add(panelBusca, "North");
		add(panelDelete, "South");

	}

	private void montaTela() {
		setTitle("Excluir Produto");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public JButton getBtnBusca() {
		return btnBusca;
	}

	public JButton getBtnConfirm() {
		return btnConfirm;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JLabel getLblBusca() {
		return lblBusca;
	}

	public JFormattedTextField getFldBusca() {
		return fldBusca;
	}

	public void setFldBusca(String string) {
		this.fldBusca.setText(string);
	}

	public void setFldNome(String string) {
		this.fldNome.setText(string);
	}
	
	public JTextField getFldNome() {
		return fldNome;

	}

	public void setFldDescricao(String string) {
		this.fldDescricao.setText(string);
	}


	public void setFldPreco(String string) {
		this.fldPreco.setText(string);
	}

	public void setFldEstoque(String string) {
		this.fldEstoque.setText(string);
	}
	
	
}
