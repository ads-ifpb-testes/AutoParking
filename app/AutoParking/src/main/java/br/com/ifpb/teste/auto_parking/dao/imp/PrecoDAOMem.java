package br.com.ifpb.teste.auto_parking.dao.imp;

import java.util.HashSet;
import java.util.List;

import br.com.ifpb.teste.auto_parking.dao.PrecoDAO;
import br.com.ifpb.teste.auto_parking.model.Preco;

public class PrecoDAOMem implements PrecoDAO {
	
	private HashSet<Preco> precos = null;
		
	public boolean precoExiste(Preco preco) {		
		return precos.contains(preco);
	}

	public boolean cadastrarPreco(Preco preco) {
		if(precoExiste(preco))
			return false;		
		return precos.add(preco);
	}

	public boolean editarPreco(Preco preco) {
		if(!precoExiste(preco))
			return false;
		if (!precos.remove(preco))
			return false;
		return precos.add(preco);
	}

	public boolean excluirPreco(Preco preco) {
		// TODO Auto-generated method stub
		return false;
	}

	public float calcularPreco(long duracao) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Preco> listarPrecos() {
		// TODO Auto-generated method stub
		return null;
	}

}
