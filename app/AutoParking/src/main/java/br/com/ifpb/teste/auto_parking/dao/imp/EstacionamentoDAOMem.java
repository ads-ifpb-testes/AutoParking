package br.com.ifpb.teste.auto_parking.dao.imp;

import java.util.HashSet;
import java.util.List;

import br.com.ifpb.teste.auto_parking.dao.EstacionamentoDAO;
import br.com.ifpb.teste.auto_parking.model.Estacionamento;

public class EstacionamentoDAOMem implements EstacionamentoDAO {
	
	private HashSet<Estacionamento> estacionamento = null;
	
	public EstacionamentoDAOMem() {
		estacionamento = new HashSet<Estacionamento>(); 		
	}

	public boolean cadastrarEstacionamento(Estacionamento estacionamento) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editarEstacionamento(Estacionamento estacionemtno) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean excluirEstacionemtno(Estacionamento estacionamento) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Estacionamento> listarEstacionamento() {
		// TODO Auto-generated method stub
		return null;
	}

	public int registrarEntrada(String placa) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int buscarIdPlaca(String placa) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Estacionamento buscarEstacionamento(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Estacionamento> buscarEstacionamento(String placa) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean autorizarSaida(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean finalizarServico(int id) {
		// TODO Auto-generated method stub
		return false;		
	}

	public boolean estacionamentoExiste(Estacionamento estacionamento) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
