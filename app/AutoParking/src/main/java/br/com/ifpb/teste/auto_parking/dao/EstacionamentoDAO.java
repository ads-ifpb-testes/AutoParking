package br.com.ifpb.teste.auto_parking.dao;

import java.util.List;

import br.com.ifpb.teste.auto_parking.model.Estacionamento;

public interface EstacionamentoDAO {
	boolean cadastrarEstacionamento(Estacionamento estacionamento);	
	boolean editarEstacionamento(Estacionamento estacionemtno);
	boolean excluirEstacionemtno(Estacionamento estacionamento);
	List<Estacionamento> listarEstacionamento();
	int registrarEntrada(String placa);
	int buscarIdPlaca(String placa);
	Estacionamento buscarEstacionamento(int id);
	List<Estacionamento> buscarEstacionamento(String placa);
	boolean autorizarSaida(int id);
	void finalizarServico(int id);
}
