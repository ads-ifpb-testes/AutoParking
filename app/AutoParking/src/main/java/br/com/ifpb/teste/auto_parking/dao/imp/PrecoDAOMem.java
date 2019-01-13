package br.com.ifpb.teste.auto_parking.dao.imp;

import java.util.HashSet;
import java.util.List;

import br.com.ifpb.teste.auto_parking.dao.PrecoDAO;
import br.com.ifpb.teste.auto_parking.model.Preco;

public class PrecoDAOMem implements PrecoDAO {
	
	private HashSet<Preco> precos = null;
		
	public boolean PrecoExiste(Preco preco) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean cadastrarPreco(Preco preco) {
		// TODO Auto-generated method stub
		return false;		
	}

	public boolean editarPreco(Preco preco) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean excluirPreco(Preco preco) {
		// TODO Auto-generated method stub
		return false;
	}

	public Preco calcularPreco(long duracao) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Preco> listarPrecos() {
		// TODO Auto-generated method stub
		return null;
	}

}
