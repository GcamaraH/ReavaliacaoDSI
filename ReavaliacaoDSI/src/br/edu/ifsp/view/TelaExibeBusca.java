package br.edu.ifsp.view;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.model.Produto;

public class TelaExibeBusca extends JInternalFrame {
	private JPanel panel;
	private JScrollPane scroll;
	private JTable table;

	private DefaultTableModel model;
	private Produto produto;
	private List<Produto> list;

	public TelaExibeBusca(TelaBusca busca, Produto produto) {
		model = new DefaultTableModel();
		this.produto = produto;

		loadTable(0);
		criaComponentes();
		montaTela();
	}

	public TelaExibeBusca(TelaBusca busca, List<Produto> list) {
		this.list = list;
		model = new DefaultTableModel();

		loadTable(1);
		criaComponentes();
		montaTela();
	}

	private void montaTela() {
		panel = new JPanel();

		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(800, 200));

		addComponents();
	}

	private void addComponents() {
		panel.add(scroll);

		add(panel);
	}

	private void criaComponentes() {
		BasicInternalFrameUI bifui = (BasicInternalFrameUI) this.getUI();
		bifui.setNorthPane(null);
		pack();
		setVisible(true);
	}

	public void loadTable(int option) {
		table = new JTable(model);
		model.addColumn("Identificador");
		model.addColumn("Nome");
		model.addColumn("Descrição");
		model.addColumn("Preço");
		model.addColumn("Quantidade em Estoque");

		table.getColumnModel().getColumn(0).setMinWidth(4);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setMinWidth(40);
		table.getColumnModel().getColumn(3).setMinWidth(10);
		table.getColumnModel().getColumn(4).setMinWidth(10);
		switch (option) {
		case 0: {
			loadDataName(model);
			break;
		}
		case 1: {
			loadDataList(model);
			break;
		}
		}
		
	}

	private void loadDataName(DefaultTableModel model) {
		model.setNumRows(0);
		
		model.addRow(new Object[] { 
				produto.getId(), 
				produto.getNome(), 
				produto.getDescricao(), 
				produto.getPreco(),
				produto.getEstoque() });
	}
	
	private void loadDataList(DefaultTableModel model) {
		model.setNumRows(0);

		list.forEach((produto) -> {
            model.addRow(new Object[]{
            		produto.getId(), 
            		produto.getNome(), 
    				produto.getDescricao(), 
    				produto.getPreco(),
    				produto.getEstoque()
            });
        });
	}
}
