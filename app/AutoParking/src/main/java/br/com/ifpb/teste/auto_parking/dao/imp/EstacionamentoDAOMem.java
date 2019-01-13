package br.com.ifpb.teste.auto_parking.dao.imp;

import java.util.HashSet;

import br.com.ifpb.teste.auto_parking.dao.EstacionamentoDAO;
import br.com.ifpb.teste.auto_parking.model.*;

public class EstacionamentoDAOMem implements EstacionamentoDAO {
	
	private HashSet<Estacionamento> estacionamento = null;
	
	public EstacionamentoDAOMem() {
		estacionamento = new HashSet<Estacionamento>(); 		
	}

	public int registrarEntrada(String placa) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int buscarIdPlaca(String placa) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean autorizarSaida(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public void finalizarServico(int id) {
		// TODO Auto-generated method stub

	}

}
