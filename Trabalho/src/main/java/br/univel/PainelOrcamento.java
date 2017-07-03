package br.univel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class PainelOrcamento extends OrcamentoBase{
	
	JTabbedPane tabbedPane;
	List<Produto> orcamento = new ArrayList<>();
	public PainelOrcamento(JTabbedPane tabbedPane) {
		super();
		this.tabbedPane = tabbedPane;
		configuraTabela();
		configuraBotoes();
		configuraBusca();
		
		
	}

	private void configuraBusca() {
		txfIdProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F2) {
					abreBusca();
				}
			}
		});
		
	}

	protected void abreBusca() {
		PainelBusca painelBusca = new PainelBusca();

		painelBusca.setOnOk(new Consumer<Produto>() {
			@Override
			public void accept(Produto t) {
				getGlassPane().setVisible(false);
				preencher(t);
			}
		});

		painelBusca.setOnCancel(new Runnable() {

			@Override
			public void run() {
				limparCampos();
				getGlassPane().setVisible(false);
			}
		});

		setGlassPane(painelBusca);
		painelBusca.setVisible(true);
	}
	
	protected void limparCampos() {
		txfIdProduto.setText("");

	}



	private void configuraBotoes() {
		super.btnAdicionarProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adicionarProduto();
			}
		});
		super.btnFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fechaAba();
			}
		});
	}
	
	protected void adicionarProduto() {
		int id = Integer.parseInt(super.txfIdProduto.getText());
		int idx = -1;
		
		ProdutoDAO pdao = new ProdutoDAO();
		
		List<Produto> listaProdutos = pdao.getTodos();
		for(int i =0;i<listaProdutos.size();i++){
			if(listaProdutos.get(i).getId()==id){
				idx = i;
				System.out.println("Achou!");
				break;
			}
		}
		if(idx == -1){
			System.out.println("Deu não!");
		}
		else{
			orcamento.add(listaProdutos.get(idx));
			configuraTabela();
		}
	}
	
	protected void fechaAba() {
		tabbedPane.remove(this);
	}


	private void configuraTabela() {
		super.table.setModel(new TabelaOrcamento(orcamento));
	}
	protected void preencher(Produto t) {
		txfIdProduto.setText(String.valueOf(t.getId()));;
	}
}
