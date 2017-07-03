package br.univel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaOrcamento extends AbstractTableModel{
	List<Produto> lista = new ArrayList<>();
	
	public TabelaOrcamento(List<Produto> lista) {
		this.lista = lista;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
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
			return "U$ "+ lista.get(row).getValor().setScale(2,BigDecimal.ROUND_HALF_UP);
		case 3:
			return "R$ " + getReal(lista.get(row).getValor());

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
			return "Valor(U$)";
		case 3:
			return "Valor(R$)";

		}
		return "Nao sei";
	}
	private BigDecimal getReal(BigDecimal valor) {
		BigDecimal real = valor.multiply(new BigDecimal(3.42)).setScale(2, BigDecimal.ROUND_HALF_UP);
		return real;
	}

}
