package br.univel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import org.postgresql.Driver;

public class TelaPrincipal extends TelaPrincipalBase{
	
	
	JTabbedPane tabbedPane = super.tabbedPane;
	List<Produto> listaMaster10;
	
	public TelaPrincipal() {
		super.setVisible(true);
		criarTabelas();
		configurarBotoes();
		inserirLista();

		
	}
	

	private void criarTabelas() {
		StringBuilder sb1 = new StringBuilder();
		sb1.append("CREATE TABLE produto(id_produto INTEGER, descricao VARCHAR(255), valor NUMERIC(17,2));"
				+ "CREATE TABLE cliente(id_cliente INTEGER, nome VARCHAR(100), telefone VARCHAR(11))");
		
		Connection con = ConexaoBanco.getInstance().getConexao();
		try {
			PreparedStatement ps = con.prepareStatement(sb1.toString());
			ps.executeQuery();
		} catch (SQLException e) {
		}
	}


	protected void inserirLista() {
		
		StringBuilder sb1 = new StringBuilder();
		sb1.append("DELETE FROM PRODUTO");
		
		Connection con = ConexaoBanco.getInstance().getConexao();
		try {
			PreparedStatement ps = con.prepareStatement(sb1.toString());
			ps.executeQuery();
		} catch (SQLException e) {
		}
		
		LeitorLista ll = new LeitorLista();
		try {
			listaMaster10 = ll.lerProdutos("http://www.master10.com.py/lista-txt/download");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		for(int i =1; i<listaMaster10.size();i++){
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO produto VALUES(");
			sb.append(listaMaster10.get(i).getId());
			sb.append(",'");
			sb.append(listaMaster10.get(i).getNome());
			sb.append("',");
			sb.append(listaMaster10.get(i).getValor());
			sb.append(")");
			
			Connection con1 = ConexaoBanco.getInstance().getConexao();
			try {
				PreparedStatement ps = con1.prepareStatement(sb.toString());
				ps.executeQuery();
			} catch (SQLException e) {
			}
		}
		
	}

	private void configurarBotoes() {
		super.btnOrcamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.addTab("Orcamento",new PainelOrcamento(tabbedPane));
			}
		});
		
		super.btnCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.addTab("Cliente", new PainelCliente(tabbedPane));
			}
		});
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TelaPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
