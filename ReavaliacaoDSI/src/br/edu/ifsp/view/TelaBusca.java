package br.edu.ifsp.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.ifsp.controller.EncerrarPrograma;

public class TelaBusca extends JFrame {
	private JPanel panel;
	public TelaBusca(TelaSelecaoBusca windowSelectFetch) {
		new EncerrarPrograma(this, windowSelectFetch);
	}
	
	public void createWindowFetch(SubTelaBusca internalFrameFetch) {
		panel = new JPanel();
		panel.add(internalFrameFetch);
		
		add(panel);
		
		montaTela("Buscar produto");
	}

	public void createWindowName(TelaExibeBusca internalFrameName) {
		panel = new JPanel();
		panel.add(internalFrameName);
		
		add(panel);
		
		montaTela("Listar produto");
	}

	private void montaTela(String title) {
		setTitle(title);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		repaint();
		pack();
		setLocationRelativeTo(null);
	}

}
