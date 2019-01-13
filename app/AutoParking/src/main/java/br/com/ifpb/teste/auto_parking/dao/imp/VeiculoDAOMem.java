package br.com.ifpb.teste.auto_parking.dao.imp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import br.com.ifpb.teste.auto_parking.dao.VeiculoDAO;
import br.com.ifpb.teste.auto_parking.model.Veiculo;

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
		// TODO Auto-generated method stub
		return null;
	}

	public boolean editarVeiculo(Veiculo veiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean excluirVeiculo(Veiculo veiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Veiculo> listarVeiculos() {
		ArrayList<Veiculo> tmpVeiculo = new ArrayList<Veiculo>(veiculos);
		return tmpVeiculo;
	}
}
