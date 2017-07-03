package br.univel;

import javax.swing.JPanel;

import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PainelBusca extends JPanel {
	private JTextField textField;
	private JTable table;
	private Consumer<Produto> consumerOnOk;
	private Runnable runnableOnCancel;

	/**
	 * Create the panel.
	 */
	public PainelBusca() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 0);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		add(lblNome, gbc_lblNome);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		
		// O WindowBuilder vai ignorar o código que está
		// dentro desses comentários:
		
		// $hide>>$
		configuraTela();
		// $hide<<$
	}

	private void configuraTela() {
		TabelaProduto model = new TabelaProduto(null);
		table.setModel(model);

		
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					busca(textField.getText().trim());
				}

				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					// Seleciona o primeiro item na tabela.
					table.getSelectionModel().setSelectionInterval(0, 0);
					// Transfere o foco pra frente.
					textField.transferFocus();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PainelBusca.this.runnableOnCancel != null) {
						PainelBusca.this.runnableOnCancel.run();
					}
				}
			}
		});
		
		table.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					table.transferFocusBackward();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					// Pra cancelar a ação padrão que já existe
					// na JTable com a tecla Enter.
					e.consume();
					
					int idx = table.getSelectedRow();
					if (idx != -1) {
						Produto produto = ((TabelaProduto)table.getModel()).getProdutoAt(idx);
						if (produto == null) {
							return;
						}
						PainelBusca.this.consumerOnOk.accept(produto);
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PainelBusca.this.runnableOnCancel != null) {
						PainelBusca.this.runnableOnCancel.run();
					}
				}
			}
		});
	}

	protected void busca(String palavra) {

		List<Produto> lista = buscaNoBanco(palavra);

		((TabelaProduto) table.getModel()).preencherResultado(lista);

	}

	
	List<Cliente> lista = new ArrayList<>();
	public PainelBusca(List<Cliente> list) {
		this.lista = list;
	}
	private List<Produto> buscaNoBanco(String palavra) {

		List<Produto> lista = new ArrayList<Produto>();

		for (int i = 0; i < DADOS_FICTICIOS.length; i++) {
			if (DADOS_FICTICIOS[i][1].toLowerCase().startsWith(palavra)) {
				Produto pet = new Produto();

				pet.setId(Integer.parseInt(DADOS_FICTICIOS[i][0]));
				pet.setNome(DADOS_FICTICIOS[i][1]);
				pet.setValor(DADOS_FICTICIOS[i][2]);

				lista.add(pet);
			}
		}

		return lista;
	}

	public void setOnOk(Consumer<Produto> consumer) {
		this.consumerOnOk = consumer;
	}

	public void setOnCancel(Runnable r) {
		this.runnableOnCancel = r;
	}

	@Override
	public void setVisible(boolean arg0) {
		
		super.setVisible(arg0);
		
		// Depois que ficar visivel e terminar tudo
		// o que foi agendado para a EDT, solicita o
		// foco do teclado para o textField.
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				textField.requestFocusInWindow();
			}
		});
	}
	private static final String[][] DADOS_FICTICIOS = new String[][] {
		{ "254", "Dhonatan", "99887766" },
		{ "255", "Wesley", "11223344" },
		{ "256", "Rodrigo", "99887766" },
		{ "257", "Valderi", "77886633" },
		{ "258", "Nego", "00998877" },
		{ "259", "Vanderlei", "99887655" }, 
		{ "260", "Jo�o", "66449966" }};

}

	