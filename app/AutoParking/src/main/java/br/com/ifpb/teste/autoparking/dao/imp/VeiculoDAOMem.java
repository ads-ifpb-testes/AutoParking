package br.com.ifpb.teste.autoparking.dao.imp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import br.com.ifpb.teste.autoparking.dao.VeiculoDAO;
import br.com.ifpb.teste.autoparking.model.Veiculo;

public class VeiculoDAOMem implements VeiculoDAO{
	
	private HashSet<Veiculo> veiculos = null;
	
	public VeiculoDAOMem() {
		veiculos = new HashSet<Veiculo>();
	}
	
	public boolean VeiculoExiste(Veiculo veiculo) {		
		return veiculos.contains(veiculo);
	}

	public boolean cadastrarVeiculo(Veiculo veiculo) {
		if (VeiculoExiste(veiculo))
			return false;		
		return veiculos.add(veiculo);
	}

	public Veiculo buscarVeiculo(String placa) {
		ArrayList<Veiculo> tmpVeiculos = new ArrayList<Veiculo>(veiculos);
		for(Veiculo veiculo: tmpVeiculos) {
			if(veiculo.getPlaca().equals(placa))
				return veiculo;
		}		
		return null;
	}

	public List<Veiculo> buscarVeiculos(String cpf) {
		ArrayList<Veiculo> tmpVeiculos = new ArrayList<Veiculo>(veiculos);
		ArrayList<Veiculo> rspVeiculos = new ArrayList<Veiculo>();
		for(Veiculo veiculo: tmpVeiculos) {
			if(veiculo.getCpfProprietario().equals(cpf))
				rspVeiculos.add(veiculo);
		}
		return rspVeiculos;
	}

	public boolean editarVeiculo(Veiculo veiculo) {
		if (!veiculos.contains(veiculo))
			return false;
		if(!excluirVeiculo(veiculo))
			return false;
		return cadastrarVeiculo(veiculo);
	}

	public boolean excluirVeiculo(Veiculo veiculo) {
		if (!VeiculoExiste(veiculo))
			return false;		
		return veiculos.remove(veiculo);
	}

	public List<Veiculo> listarVeiculos() {
		ArrayList<Veiculo> tmpVeiculo = new ArrayList<Veiculo>(veiculos);
		return tmpVeiculo;
	}
}
