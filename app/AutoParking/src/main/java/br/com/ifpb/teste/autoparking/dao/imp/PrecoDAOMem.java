package br.com.ifpb.teste.autoparking.dao.imp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import br.com.ifpb.teste.autoparking.dao.PrecoDAO;
import br.com.ifpb.teste.autoparking.model.Preco;

public class PrecoDAOMem implements PrecoDAO {
	
	private HashSet<Preco> precos = null;
	
	public PrecoDAOMem() {
		precos = new HashSet<Preco>();
	}
		
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
		if(!precoExiste(preco))
			return false;
		return precos.remove(preco);		
	}

	public float calcularPreco(long duracaoMinutos) {
		float rspPreco = 0f;
		ArrayList<Preco> tmpPreco = new ArrayList<Preco>(precos);
		for(Preco preco: tmpPreco) {
			boolean isMaiorIgual = duracaoMinutos >= preco.getDuracaoInicial();
			boolean isIntervalo = (isMaiorIgual && (( duracaoMinutos <= preco.getDuracaoFinal())||(preco.getDuracaoFinal() == 0)));
			float precoMinuto = (float)preco.getPrecoPorHora() / 60.0f;
			if(isMaiorIgual) {
				if(preco.isPrecoFixo()) {
					rspPreco += preco.getPrecoPorHora();
				} else {
					if(isIntervalo) {
						rspPreco += precoMinuto * (duracaoMinutos - preco.getDuracaoInicial());						
					} else {
						rspPreco += precoMinuto * (preco.getDuracaoFinal() - preco.getDuracaoInicial());
					}
				}				
			}			
		}
		return rspPreco;
	}

	public List<Preco> listarPrecos() {
		ArrayList<Preco> tmpPreco = new ArrayList<Preco>(precos);
		return tmpPreco;
	}

}
