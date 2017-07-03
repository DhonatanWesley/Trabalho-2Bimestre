package br.univel;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
	List<Produto> lista;
	Connection con = ConexaoBanco.getInstance().getConexao();
	
	public ProdutoDAO() {
	}
	
	public List<Produto> getTodos(){
		try {
			String sql_todos = "SELECT * FROM produto ORDER BY id_produto";
			PreparedStatement ps;
			ps = con.prepareStatement(sql_todos);
			ResultSet rs = ps.executeQuery();
			List<Produto> lista = new ArrayList<>();
			
			while(rs.next()){
				Produto p = new Produto();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setValor(BigDecimal.valueOf(rs.getDouble(3)));
				lista.add(p);
			}
			return lista;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
