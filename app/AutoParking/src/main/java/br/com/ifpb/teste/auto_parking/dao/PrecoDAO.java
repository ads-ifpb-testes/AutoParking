package br.com.ifpb.teste.auto_parking.dao;

import java.util.List;

import br.com.ifpb.teste.auto_parking.model.Preco;

public interface PrecoDAO {
	boolean PrecoExiste(Preco preco);
	boolean cadastrarPreco(Preco preco);
	boolean editarPreco(Preco preco);
	boolean excluirPreco(Preco preco);
	Preco calcularPreco(long duracao);
	List<Preco> listarPrecos();	
}
