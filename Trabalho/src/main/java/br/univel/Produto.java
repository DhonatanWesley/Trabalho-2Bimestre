package br.univel;

import java.math.BigDecimal;

public class Produto {
	
	private int id;
	private String nome;
	private BigDecimal valor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal dadosFicticios) {
		this.valor = dadosFicticios;
	}
	

}
