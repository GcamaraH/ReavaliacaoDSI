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

public class TelaEdicao extends JFrame{
	private JPanel pnlBusca;
	private JLabel lblBusca;
	private JFormattedTextField fldBusca;
	private JButton btnBusca;
	
	private JPanel pnlEdit;

	private JPanel pnlFields;
	private JLabel lblNome;
	private JTextField fldNome;
	private JLabel lblDescricao;
	private JTextArea fldDescricao;
	private JScrollPane scroll;
	private JLabel lblPreco;
	private JFormattedTextField fldPreco;
	private JLabel lblEstoque;
	private JFormattedTextField fldEstoque;

	private JPanel pnlButtons;
	private JButton btnConfirm;
	private JButton btnCancel;

	private CarregaPainelRestricao lcp;
	private GridBagConstraints gbc;
	private GridBagLayout gridBag;
	
	private TelaHome home;

	public TelaEdicao(TelaHome home) {
		this.home = home;
		
		criaComponentes();
		montaTela();

		BotaoBuscarController bfc = new BotaoBuscarController(this);
		BotaoConfirmaCadastroController bcac = new BotaoConfirmaCadastroController(this, home);
		BotaoCancelarController bcc = new BotaoCancelarController(this, home);
		
		EncerrarPrograma window = new EncerrarPrograma(this, home);
	}
	
	private void criaComponentes() {
		gridBag = new GridBagLayout();
		
		pnlBusca = new JPanel(gridBag);
		pnlBusca.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lblBusca = new CriaLabel().setLabel(lblBusca, "ID", "Arial", 0, 15);
		try {
			fldBusca = new CriaCampoFormatado().setFormattedField(fldEstoque, 3, "####", "Arial", 0, 12, true);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		btnBusca = new CriaBotao().setButton(btnBusca,   "Buscar", "Arial", 0, 15, "");

		pnlEdit = new JPanel(gridBag);
		pnlEdit.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		pnlFields = new JPanel(gridBag);
		lblNome = new CriaLabel().setLabel(lblNome, "Produto", "Arial", 0, 15);
		fldNome = new CriaCampo().setField(fldNome, 34, "Arial", 0, 12, true);

		lblDescricao = new CriaLabel().setLabel(lblDescricao, "Descrição", "Arial", 0, 15);
		fldDescricao = new CriaFieldArea().setFieldArea(fldDescricao, 5, 34, "Arial", 0, 12, true);
		scroll = new JScrollPane(fldDescricao);

		lblPreco = new CriaLabel().setLabel(lblPreco, "Valor", "Arial", 0, 15);
		try {
			fldPreco = new CriaCampoFormatado().setFormattedField(fldPreco, 7, "#,##0.00", "Arial", 0, 12, true);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		lblEstoque = new CriaLabel().setLabel(lblEstoque, "Quantidade", "Arial", 0, 15);
		try {
			fldEstoque = new CriaCampoFormatado().setFormattedField(fldEstoque, 3, "###", "Arial", 0, 12, true);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		pnlButtons = new JPanel(gridBag);
		btnConfirm = new CriaBotao().setButton(btnConfirm, "Confirmar", "Arial", 0, 15, "");
		btnConfirm.setEnabled(false);

		btnCancel = new CriaBotao().setButton(btnCancel, "Cancelar", "Arial", 0, 15, "");

		addComponents(gridBag);
	}

	private void addComponents(GridBagLayout gridBag) {
		lcp = new CarregaPainelRestricao();
		gbc = new GridBagConstraints();

		lcp.setLoadConstraintPanel(pnlBusca, lblBusca, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlBusca, fldBusca, gbc, gridBag, 0, 1, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnlBusca, btnBusca, gbc, gridBag, 1, 1, 1, 1, 5, 10, GridBagConstraints.LINE_END);
		
		lcp.setLoadConstraintPanel(pnlFields, lblNome, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlFields, fldNome, gbc, gridBag, 0, 1, 3, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnlFields, lblDescricao, gbc, gridBag, 1, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		
		lcp.setLoadConstraintPanel(pnlFields, scroll, gbc, gridBag, 1, 1, 3, 1, 5, 10, GridBagConstraints.WEST);

		lcp.setLoadConstraintPanel(pnlFields, lblPreco, gbc, gridBag, 4, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlFields, fldPreco, gbc, gridBag, 4, 1, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnlFields, lblEstoque, gbc, gridBag, 4, 2, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlFields, fldEstoque, gbc, gridBag, 4, 3, 1, 1, 5, 10, GridBagConstraints.WEST);

		lcp.setLoadConstraintPanel(pnlButtons, btnConfirm, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlButtons, btnCancel, gbc, gridBag, 0, 1, 1, 1, 5, 10, GridBagConstraints.WEST);

		
		lcp.setLoadConstraintPanel(pnlEdit, pnlFields, gbc, gridBag, 0, 0, 1, 1, 5, 5,
				GridBagConstraints.ABOVE_BASELINE);
		lcp.setLoadConstraintPanel(pnlEdit, pnlButtons, gbc, gridBag, 1, 0, 1, 1, 5, 5,
				GridBagConstraints.BELOW_BASELINE);

		add(pnlBusca, "North");
		add(pnlEdit, "South");

	}

	private void montaTela() {
		setName("Editar produto");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	
	
	public JLabel getLblBusca() {
		return lblBusca;
	}

	public JTextField getFldBusca() {
		return fldBusca;
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

	public JLabel getLblNome() {
		return lblNome;
	}

	public JTextField getFldNome() {
		return fldNome;
	}

	public JLabel getLblDescricao() {
		return lblDescricao;
	}

	public JTextArea getFldDescricao() {
		return fldDescricao;
	}

	public JLabel getLblPreco() {
		return lblPreco;
	}

	public JFormattedTextField getFldPreco() {
		return fldPreco;
	}

	public JLabel getLblEstoque() {
		return lblEstoque;
	}

	public JFormattedTextField getFldEstoque() {
		return fldEstoque;
	}

	public void setFldBusca(String string) {
		this.fldBusca.setText(string);
	}

	public void setFldNome(String string) {
		this.fldNome.setText(string);
	}

	public void setFldDescricao(String string) {
		this.fldDescricao.setText(string);
	}

	public void setFldPreco(Integer integer) {
		this.fldPreco.setText(integer.toString());
	}

	public void setFldEstoque(Integer integer) {
		this.fldEstoque.setText(integer.toString());
	}

}
