package br.com.ifpb.teste.auto_parking.dao.imp;

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
		// TODO Auto-generated method stub
		return false;		
	}

	public Veiculo buscarVeiculo(String placa) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}
}
