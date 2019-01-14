package br.com.ifpb.teste.auto_parking.dao;

import java.util.List;

import br.com.ifpb.teste.auto_parking.model.Preco;

public interface PrecoDAO {
	boolean precoExiste(Preco preco);
	boolean cadastrarPreco(Preco preco);
	boolean editarPreco(Preco preco);
	boolean excluirPreco(Preco preco);
	float calcularPreco(long duracaoMinutos);
	List<Preco> listarPrecos();	
}
