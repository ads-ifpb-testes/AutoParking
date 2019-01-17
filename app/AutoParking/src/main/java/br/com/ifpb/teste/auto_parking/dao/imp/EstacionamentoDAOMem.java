package br.com.ifpb.teste.auto_parking.dao.imp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import br.com.ifpb.teste.auto_parking.dao.EstacionamentoDAO;
import br.com.ifpb.teste.auto_parking.model.Estacionamento;

public class EstacionamentoDAOMem implements EstacionamentoDAO {
	
	private HashSet<Estacionamento> estacionamentos = null;
	
	public EstacionamentoDAOMem() {
		estacionamentos = new HashSet<Estacionamento>(); 		
	}

	public boolean cadastrarEstacionamento(Estacionamento estacionamento) {
		if (estacionamentoExiste(estacionamento))
			return false;
		return estacionamentos.add(estacionamento);
	}

	public boolean editarEstacionamento(Estacionamento estacionamento) {
		if(!estacionamentoExiste(estacionamento))
			return false;
		if(!excluirEstacionemtno(estacionamento))
			return false;
		return cadastrarEstacionamento(estacionamento);
	}

	public boolean excluirEstacionemtno(Estacionamento estacionamento) {
		if(!estacionamentoExiste(estacionamento))
			return false;
		return estacionamentos.remove(estacionamento);
	}

	public List<Estacionamento> listarEstacionamento() {
		ArrayList<Estacionamento> lista = new ArrayList<Estacionamento>(estacionamentos);		
		return lista;
	}

	public int registrarEntrada(String placa) {
		List<Estacionamento> lista = buscarEstacionamento(placa);
		for(Estacionamento estacionamento: lista) {
			if ((!estacionamento.isFinalizado()) && (estacionamento.getPlaca().equals(placa)))
				return 0;
		}
		Estacionamento novoEstacionamento = new Estacionamento(proximoNumeroId(), placa);
		if (!cadastrarEstacionamento(novoEstacionamento));
			return 0;
		return novoEstacionamento.getId();
	}

	public int buscarIdPlaca(String placa) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Estacionamento buscarEstacionamento(int id) {
		ArrayList<Estacionamento> lista = new ArrayList<Estacionamento>(estacionamentos);
		for (Estacionamento estacionamento: lista) {
			if(estacionamento.getId()==id)
				return estacionamento;
		}
		return null;
	}

	public List<Estacionamento> buscarEstacionamento(String placa) {
		ArrayList<Estacionamento> lista = new ArrayList<Estacionamento>(estacionamentos);
		ArrayList<Estacionamento> rspLista = new ArrayList<Estacionamento>();				
		for (Estacionamento estacionamento: lista) {
			if(estacionamento.getPlaca().equals(placa)) {
				rspLista.add(estacionamento);				
			}
		}
		return rspLista;
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
		return estacionamentos.contains(estacionamento) ;
	}
	
}
