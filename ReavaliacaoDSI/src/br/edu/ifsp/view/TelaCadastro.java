package br.edu.ifsp.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;

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
import br.edu.ifsp.controller.EncerrarPrograma;
import br.edu.ifsp.controller.CriaBotao;
import br.edu.ifsp.controller.CriaCampo;
import br.edu.ifsp.controller.CriaFieldArea;
import br.edu.ifsp.controller.CriaCampoFormatado;
import br.edu.ifsp.controller.CriaLabel;
import br.edu.ifsp.controller.CarregaPainelRestricao;

public class TelaCadastro extends JFrame {
	private JPanel panel;

	private JPanel panelFields;
	private JLabel lblNome;
	private JTextField fldNome;
	private JLabel lblDescricao;
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
	private GridBagLayout gridBag;

	private TelaHome telaHome;

	public TelaCadastro(TelaHome telaHome) {
		this.telaHome = telaHome;
		
		criaComponentes();
		montaTela();

		BotaoConfirmaCadastroController bcac = new BotaoConfirmaCadastroController(this, telaHome);
		BotaoCancelarController bcc = new BotaoCancelarController(this, telaHome);
		
		EncerrarPrograma window = new EncerrarPrograma(this, telaHome);
		
	}
	
	private void criaComponentes() {
		gridBag = new GridBagLayout();

		panel = new JPanel(gridBag);

		panelFields = new JPanel(gridBag);
		lblNome = new CriaLabel().setLabel(lblNome, "Nome", "Arial", 0, 15);
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

		panelButtons = new JPanel(gridBag);
		btnConfirm = new CriaBotao().setButton(btnConfirm, "Confirmar", "Arial", 0, 15, "");

		btnCancel = new CriaBotao().setButton(btnCancel, "Cancelar", "Arial", 0, 15, "");

		addComponents(gridBag);
	}

	private void addComponents(GridBagLayout gridBag) {
		lcp = new CarregaPainelRestricao();
		gbc = new GridBagConstraints();

		lcp.setLoadConstraintPanel(panelFields, lblNome, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(panelFields, fldNome, gbc, gridBag, 0, 1, 3, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(panelFields, lblDescricao, gbc, gridBag, 1, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		
		lcp.setLoadConstraintPanel(panelFields, scroll, gbc, gridBag, 1, 1, 3, 1, 5, 10, GridBagConstraints.WEST);

		lcp.setLoadConstraintPanel(panelFields, lblPreco, gbc, gridBag, 4, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(panelFields, fldPreco, gbc, gridBag, 4, 1, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(panelFields, lblEstoque, gbc, gridBag, 4, 2, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(panelFields, fldEstoque, gbc, gridBag, 4, 3, 1, 1, 5, 10, GridBagConstraints.WEST);

		lcp.setLoadConstraintPanel(panelButtons, btnConfirm, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(panelButtons, btnCancel, gbc, gridBag, 0, 1, 1, 1, 5, 10, GridBagConstraints.WEST);

		lcp.setLoadConstraintPanel(panel, panelFields, gbc, gridBag, 0, 0, 1, 1, 5, 5,
				GridBagConstraints.ABOVE_BASELINE);
		lcp.setLoadConstraintPanel(panel, panelButtons, gbc, gridBag, 1, 0, 1, 1, 5, 5,
				GridBagConstraints.BELOW_BASELINE);

		add(panel);

	}

	private void montaTela() {
		setName("Cadastrar Produto");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
	
}
