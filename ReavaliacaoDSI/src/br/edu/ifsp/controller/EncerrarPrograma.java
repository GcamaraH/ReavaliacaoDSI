package br.edu.ifsp.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import br.edu.ifsp.view.TelaHome;
import br.edu.ifsp.view.TelaCadastro;
import br.edu.ifsp.view.TelaRemocao;
import br.edu.ifsp.view.TelaEdicao;
import br.edu.ifsp.view.TelaBusca;
import br.edu.ifsp.view.TelaSelecaoBusca;

public class EncerrarPrograma implements WindowListener {
	private TelaHome home;
	private TelaSelecaoBusca selecaoOpcaoBusca;
	private TelaBusca busca;
	private TelaEdicao edicao;

	private int opFechamento;
	private TelaRemocao remocao;
	private TelaCadastro cadastro;

	public EncerrarPrograma(TelaHome home) {
		this.home = home;
		this.home.addWindowListener(this);

		opFechamento = 0;
	}

	public EncerrarPrograma(TelaSelecaoBusca selecaoOpcaoBusca, TelaHome home) {
		this.home = home;
		
		this.selecaoOpcaoBusca = selecaoOpcaoBusca;
		this.selecaoOpcaoBusca.addWindowListener(this);

		opFechamento = 1;
	}

	public EncerrarPrograma(TelaBusca busca, TelaSelecaoBusca selecaoOpcaoBusca) {
		this.selecaoOpcaoBusca = selecaoOpcaoBusca;
		
		this.busca = busca;
		this.busca.addWindowListener(this);

		opFechamento = 2;
	}

	public EncerrarPrograma(TelaEdicao edicao, TelaHome home) {
		this.home = home;
		
		this.edicao = edicao;
		this.edicao.addWindowListener(this);

		opFechamento = 3;
	}

	public EncerrarPrograma(TelaRemocao remocao, TelaHome home) {
		this.home = home;
		
		this.remocao = remocao;
		this.remocao.addWindowListener(this);

		opFechamento = 4;
	}

	public EncerrarPrograma(TelaCadastro cadastro, TelaHome home) {
		this.home = home;
		
		this.cadastro = cadastro;
		this.cadastro.addWindowListener(this);

		opFechamento = 5;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		switch (opFechamento) {
		case 0: {
			if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Deseja finalizar o programa?", "Alerta de fechamneto",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE)) {
				System.exit(0);

			}
			break;
		}
		case 1: {
			selecaoOpcaoBusca.dispose();
			home.setVisible(true);
			break;
		}
		case 2: {
			busca.dispose();
			selecaoOpcaoBusca.setVisible(true);
			break;
		}
		case 3: {
			edicao.dispose();
			home.setVisible(true);
			break;
		}
		case 4: {
			remocao.dispose();
			home.setVisible(true);
			break;
		}
		case 5: {
			cadastro.dispose();
			home.setVisible(true);
			break;
		}
		}

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

}
