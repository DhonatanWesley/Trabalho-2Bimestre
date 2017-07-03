package br.univel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaCliente extends AbstractTableModel {

	List<Cliente> lista = new ArrayList<>();
	public TabelaCliente(List<Cliente> list) {
		this.lista = list;
	}
	
	void preencherResultado(List<Cliente> resultado) {
		this.lista = resultado;
		
		// O comando abaixo solicita atualização da visão.
		fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
		case 0:
			return lista.get(row).getId();
		case 1:
			return lista.get(row).getNome();
		case 2:
			return lista.get(row).getTelefone();

		}
		return "DEU RUIM";
	}
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2: 
			return "Telefone";

		}
		return "Nao sei";
	}
	
	public Cliente getClienteAt(int idx) {
		if (idx >= this.lista.size()) {
			return null;
		}
		return this.lista.get(idx);
	}


}
