package br.com.ifpb.teste.autoparking.dao;

import java.util.List;

import br.com.ifpb.teste.autoparking.model.Veiculo;

public interface VeiculoDAO {
	boolean VeiculoExiste(Veiculo veiculo);
	boolean cadastrarVeiculo(Veiculo veiculo);
	Veiculo buscarVeiculo(String placa);
	List<Veiculo> buscarVeiculos(String cpf);
	boolean editarVeiculo(Veiculo veiculo);
	boolean excluirVeiculo(Veiculo veiculo);
	List<Veiculo> listarVeiculos();	
}
