package br.com.ifpb.teste.autoparking.dao;

import java.util.List;

import br.com.ifpb.teste.autoparking.model.Estacionamento;

public interface EstacionamentoDAO {
	boolean cadastrarEstacionamento(Estacionamento estacionamento);	
	boolean editarEstacionamento(Estacionamento estacionemtno);
	boolean excluirEstacionemtno(Estacionamento estacionamento);
	List<Estacionamento> listarEstacionamento();
	boolean estacionamentoExiste(Estacionamento estacionamento);
	int registrarEntrada(String placa);
	int buscarIdPlaca(String placa);
	Estacionamento buscarEstacionamento(int id);
	List<Estacionamento> buscarEstacionamento(String placa);
	boolean autorizarSaida(int id);
	boolean finalizarServico(int id);
}
