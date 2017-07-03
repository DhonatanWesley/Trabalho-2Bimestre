package br.univel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridLayout;

public class OrcamentoBase extends JPanel {
	protected JTextField txfIdCliente;
	protected final String nomeCliente = "";
	protected JTable table;
	protected JTextField txfIdProduto;
	protected JLabel lblIdCliente;
	protected JLabel lblCliente;
	protected JLabel lblNomeCliente;
	protected JLabel lblProduto;
	protected JLabel lblIdProduto;
	protected JButton btnAdicionarProduto;
	protected JLabel lblTotal;
	protected JPanel panel_5;
	protected JButton btnImprimir;
	protected JButton btnFechar;

	/**
	 * Create the panel.
	 */
	public OrcamentoBase() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblCliente = new JLabel("Pressione F2 para Buscar");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.WEST;
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 0;
		panel.add(lblCliente, gbc_lblCliente);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblIdCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblIdCliente = new GridBagConstraints();
		gbc_lblIdCliente.insets = new Insets(0, 0, 0, 5);
		gbc_lblIdCliente.anchor = GridBagConstraints.EAST;
		gbc_lblIdCliente.gridx = 0;
		gbc_lblIdCliente.gridy = 0;
		panel_1.add(lblIdCliente, gbc_lblIdCliente);
		
		txfIdCliente = new JTextField();
		GridBagConstraints gbc_txtIdCliente = new GridBagConstraints();
		gbc_txtIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCliente.insets = new Insets(0, 0, 0, 5);
		gbc_txtIdCliente.gridx = 1;
		gbc_txtIdCliente.gridy = 0;
		panel_1.add(txfIdCliente, gbc_txtIdCliente);
		txfIdCliente.setColumns(6);
		
		lblNomeCliente = new JLabel(nomeCliente);
		GridBagConstraints gbc_lblNomeCliente = new GridBagConstraints();
		gbc_lblNomeCliente.anchor = GridBagConstraints.WEST;
		gbc_lblNomeCliente.gridx = 2;
		gbc_lblNomeCliente.gridy = 0;
		panel_1.add(lblNomeCliente, gbc_lblNomeCliente);
		
		lblProduto = new JLabel("Produtos");
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.gridwidth = 2;
		gbc_lblProduto.anchor = GridBagConstraints.WEST;
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 0;
		gbc_lblProduto.gridy = 2;
		add(lblProduto, gbc_lblProduto);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		lblIdProduto = new JLabel("ID Produto");
		GridBagConstraints gbc_lblIdProduto = new GridBagConstraints();
		gbc_lblIdProduto.insets = new Insets(0, 0, 0, 5);
		gbc_lblIdProduto.anchor = GridBagConstraints.EAST;
		gbc_lblIdProduto.gridx = 0;
		gbc_lblIdProduto.gridy = 0;
		panel_3.add(lblIdProduto, gbc_lblIdProduto);
		
		txfIdProduto = new JTextField();
		GridBagConstraints gbc_txtIdProduto = new GridBagConstraints();
		gbc_txtIdProduto.insets = new Insets(0, 0, 0, 5);
		gbc_txtIdProduto.anchor = GridBagConstraints.WEST;
		gbc_txtIdProduto.gridx = 1;
		gbc_txtIdProduto.gridy = 0;
		panel_3.add(txfIdProduto, gbc_txtIdProduto);
		txfIdProduto.setColumns(6);
		
		btnAdicionarProduto = new JButton("Adicionar Produto");
		GridBagConstraints gbc_btnAdicionarProduto = new GridBagConstraints();
		gbc_btnAdicionarProduto.anchor = GridBagConstraints.EAST;
		gbc_btnAdicionarProduto.gridx = 2;
		gbc_btnAdicionarProduto.gridy = 0;
		panel_3.add(btnAdicionarProduto, gbc_btnAdicionarProduto);
		
		JLabel lblProdutos = new JLabel("Produtos");
		GridBagConstraints gbc_lblProdutos = new GridBagConstraints();
		gbc_lblProdutos.gridwidth = 2;
		gbc_lblProdutos.insets = new Insets(0, 0, 5, 5);
		gbc_lblProdutos.gridx = 0;
		gbc_lblProdutos.gridy = 4;
		add(lblProdutos, gbc_lblProdutos);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 5;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_2.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 2;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		lblTotal = new JLabel("Total:");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.gridwidth = 2;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 0;
		panel_4.add(lblTotal, gbc_lblTotal);
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 2;
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_4.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		btnImprimir = new JButton("Imprimir");
		GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
		gbc_btnImprimir.anchor = GridBagConstraints.EAST;
		gbc_btnImprimir.insets = new Insets(0, 0, 0, 5);
		gbc_btnImprimir.gridx = 0;
		gbc_btnImprimir.gridy = 0;
		panel_5.add(btnImprimir, gbc_btnImprimir);
		
		btnFechar = new JButton("Fechar");
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.anchor = GridBagConstraints.WEST;
		gbc_btnFechar.gridx = 1;
		gbc_btnFechar.gridy = 0;
		panel_5.add(btnFechar, gbc_btnFechar);

	}

}
