package br.univel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.TableModel;

public class PainelCliente extends ClienteBase{
	JTabbedPane tabbedPane;
	Connection con = ConexaoBanco.getInstance().getConexao();
	TabelaCliente model;
	private int selecionado = -1;
	
	public PainelCliente(JTabbedPane tabbedPane) {
		super();
		configuraTabela();
		this.tabbedPane = tabbedPane;
		
		configuraBotoes();
		
	
	}
	
	private void configuraTabela() {
		
		String sql_todos = "SELECT * FROM cliente ORDER BY id_cliente";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql_todos);
			ResultSet rs = ps.executeQuery();
			List<Cliente> lista = new ArrayList<>();
			
			while(rs.next()){
				Cliente c = new Cliente();
				c.setId(rs.getInt(1));
				c.setNome(rs.getString(2));
				c.setTelefone(rs.getString(3));
				lista.add(c);
			}
			model = new TabelaCliente(lista);
			super.table.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.table.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					int idx = table.getSelectedRow();
					Cliente c = model.lista.get(idx);
					carregarLinha(c);
					selecionado = idx;
					btnExcluir.setEnabled(true);
				}
				
			}
		});
		
		
		
	}

	protected void carregarLinha(Cliente c) {
		super.txfId.setText(String.valueOf(c.getId()));
		super.txfNome.setText(c.getNome());
		super.txfTelefone.setText(c.getTelefone());
	}

	private void configuraBotoes() {
		super.btnExcluir.setEnabled(false);
		super.btnFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fecharAba();
			}
		});
		super.btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		super.btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		super.btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					excluirCliente();
			
			}
		});
	}

	protected void excluirCliente() {
		int idx = table.getSelectedRow();
		Cliente c = model.lista.get(idx);
		
		String sql_delete = "DELETE FROM cliente WHERE id_cliente=" + c.getId();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql_delete);
			ps.executeQuery();
		} catch (SQLException e) {
			if(e.getMessage().contains("Nenhum resultado foi retornado pela consulta")){
				System.out.println("cliente excluido!");
			}
			else{
				System.out.println("Não vai da não");
				e.printStackTrace();
			}
		}
		selecionado = -1;
		limparCampos();
		super.btnExcluir.setEnabled(false);
		configuraTabela();
	}

	protected void salvar() {
		
		if(selecionado==-1){
			System.out.println("entrou");
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO Cliente VALUES(");
			sb.append(Integer.parseInt(super.txfId.getText()));
			sb.append(",'");
			sb.append(super.txfNome.getText());
			sb.append("','");
			sb.append(super.txfTelefone.getText());
			sb.append("');");
			
			try {
				PreparedStatement ps = con.prepareStatement(sb.toString());
				ps.executeQuery();
			} catch (SQLException e) {
				if(e.getMessage().contains("Nenhum resultado foi retornado pela consulta")){
					System.out.println("Cadastro OK");
				}
				else{
					System.out.println("não vai dar não");
					e.printStackTrace();
				}
			}
		}
		else{
			String delete = "DELETE FROM cliente WHERE id_cliente=" + this.model.lista.get(selecionado).getId();
			System.out.println(delete);
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO cliente VALUES(");
			sb.append(Integer.parseInt(super.txfId.getText()));
			sb.append(",'");
			sb.append(super.txfNome.getText());
			sb.append("','");
			sb.append(super.txfTelefone.getText());
			sb.append("');");
			
			try {
				
				PreparedStatement ps = con.prepareStatement(delete);
				ps.executeQuery();

				
			} catch (SQLException e) {
				
			}finally {
				
			
				try {
					PreparedStatement ps = con.prepareStatement(sb.toString());
					ps.executeQuery();
				} catch (SQLException e) {
					if(e.getMessage().contains("Nenhum resultado foi retornado pela consulta")){
						System.out.println("Cliente alterado com sucesso!");
					}
					else{
						System.out.println("Algo deu errado");
					}
				}

			}
			
		}
		selecionado = -1;
		super.btnExcluir.setEnabled(false);
		limparCampos();
		configuraTabela();
	}

	private void limparCampos() {
		selecionado = -1;
		super.txfId.setText("");
		super.txfNome.setText("");
		super.txfTelefone.setText("");
	}

	protected void fecharAba() {
		tabbedPane.remove(this);
	}
}
