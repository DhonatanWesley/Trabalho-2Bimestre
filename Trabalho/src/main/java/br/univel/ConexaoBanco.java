package br.univel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	
	private static ConexaoBanco self;
	
	private Connection con;
	
	private ConexaoBanco() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Master10", "postgres", "1234");
			Runtime.getRuntime()
			.addShutdownHook(new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						ConexaoBanco.this.con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}));
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public final static synchronized ConexaoBanco getInstance(){
		if(self == null){
			self = new ConexaoBanco();
		}
		return self;
	}
	
	public Connection getConexao(){
		
		return con;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("NAO VAI CLONAR NAO");
	}
}
