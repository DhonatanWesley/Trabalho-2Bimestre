package br.univel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeitorLista {
	
	public List<Produto> lerProdutos(String strUrl) throws Exception{
		List<Produto> lista = new ArrayList<>();
		
		URL url = new URL(strUrl);
		URLConnection urlCon = url.openConnection();//abre a conexao com a URL		
		
		try(
			InputStream is = urlCon.getInputStream();//desenha o caminho do site ate aqui
			InputStreamReader isr = new InputStreamReader(is);//seleciona por caracteres
			BufferedReader in = new BufferedReader(isr)){//jogando os caracteres no BufferedReader
			
			String linha;
			while((linha = in.readLine()) != null){
				if(linha.matches("[0-9]+.*")){
					Produto p = lerProduto(linha);
					lista.add(p);
				}
			}
		}
		
		return lista;
		
	}
	private Pattern pattern = Pattern.compile("([0-9]+)(.*)US\\$(.*)");
	
	private Produto lerProduto(String linha){		
		
		Matcher mat = pattern.matcher(linha);
		Produto produto = new Produto();
		
		if(mat.matches()){
			
			String strId = mat.group(1).trim();
			produto.setId(Integer.parseInt(strId));
			
			String desc = mat.group(2).trim();
			produto.setNome(desc);
			
			String strValorOrg = mat.group(3).trim();
			String strValorSemponto = strValorOrg.replaceAll("\\.", "");
			String strValor = strValorSemponto.replaceAll(",", ".");
			produto.setValor(new BigDecimal(strValor));

			
		}else{
			throw new RuntimeException("Linha invalida: "+ linha);
		}
		
		return produto;
		
	}

}
