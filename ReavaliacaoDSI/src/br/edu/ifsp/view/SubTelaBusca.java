package br.edu.ifsp.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import br.edu.ifsp.controller.BotaoCancelarController;
import br.edu.ifsp.controller.CriaBotao;
import br.edu.ifsp.controller.CriaCampo;
import br.edu.ifsp.controller.CriaLabel;
import br.edu.ifsp.controller.BuscarController;
import br.edu.ifsp.controller.CarregaPainelRestricao;

public class SubTelaBusca extends JInternalFrame{
	private JPanel panel;
	private GridBagLayout gridBag;
	private JLabel lblBuscar;
	private JTextField fldBuscar;
	private JButton btnBuscar;
	private JButton btnCancelar;
	

	public SubTelaBusca(TelaBusca windowFetch, TelaSelecaoBusca windowSelectFetch) {
		criaComponentes();
		montaTela();
		
		new BotaoCancelarController(this, windowSelectFetch, windowFetch);
	}

	private void criaComponentes() {
		gridBag = new GridBagLayout();

		panel = new JPanel(gridBag);

		lblBuscar = new CriaLabel().setLabel(lblBuscar, "Identificador", "Arial", 0, 20);
		fldBuscar = new CriaCampo().setField(fldBuscar, 30, "Arial", 0, 20, true);
		
		btnBuscar = new CriaBotao().setButton(btnBuscar,   "Buscar", "Arial", 0, 20, "");
		btnCancelar = new CriaBotao().setButton(btnCancelar,   "Cancelar", "Arial", 0, 20, "");

		addComponents(gridBag);
	}

	private void addComponents(GridBagLayout gridBag) {
		CarregaPainelRestricao cPanel = new CarregaPainelRestricao();
		GridBagConstraints gbc = new GridBagConstraints();

		cPanel.setLoadConstraintPanel(panel, lblBuscar, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		cPanel.setLoadConstraintPanel(panel, fldBuscar, gbc, gridBag, 0, 1, 1, 1, 5, 10, GridBagConstraints.WEST);
		cPanel.setLoadConstraintPanel(panel, btnBuscar, gbc, gridBag, 1, 0, 1, 1, 5, 10, GridBagConstraints.EAST);

		cPanel.setLoadConstraintPanel(panel, btnCancelar, gbc, gridBag, 1, 1, 1, 1, 5, 10, GridBagConstraints.EAST);

		add(panel);

	}

	private void montaTela() {
		BasicInternalFrameUI bifui = (BasicInternalFrameUI) this.getUI();
		bifui.setNorthPane(null);
		pack();
		setVisible(true);
		setResizable(true);
	}

	public JButton getBtnFetch() {
		return btnBuscar;
	}

	public JButton getBtnCancel() {
		return btnCancelar;
	}

	public JLabel getLblFetch() {
		return lblBuscar;
	}
	
	public JTextField getFldFetch() {
		return fldBuscar;
	}

	public void setFldFetch(String string) {
		fldBuscar.setText(string);
		fldBuscar.requestFocusInWindow();
	}
	
}
