package br.com.ifpb.teste.auto_parking.dao.imp;

import java.time.LocalDateTime;
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
		if (!cadastrarEstacionamento(novoEstacionamento))
			return 0;
		return novoEstacionamento.getId();
	}

	private int proximoNumeroId() {
		ArrayList<Estacionamento> lista = new ArrayList<Estacionamento>(estacionamentos);
		int maior = 0;
		for(Estacionamento estacionamento: lista) {
			maior = (maior > estacionamento.getId())?maior:estacionamento.getId();
		}		
		return ++maior;
	}

	public int buscarIdPlaca(String placa) {
		ArrayList<Estacionamento> lista = new ArrayList<Estacionamento>(estacionamentos);
		for(Estacionamento estacionamento: lista) {
			if((!estacionamento.isFinalizado())&&(estacionamento.getPlaca().equals(placa)))
				return estacionamento.getId();
		}
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
		Estacionamento estacionamento = buscarEstacionamento(id);
		if (estacionamento == null)
			return false;
		boolean sair = true;
		sair = sair && (!estacionamento.isFinalizado());
		sair = sair && (estacionamento.isQuitado());		
		sair = sair && (estacionamento.getDhPagamento().plusMinutes(30).isAfter(LocalDateTime.now()));
		return sair;
	}

	public boolean finalizarServico(int id) {
		Estacionamento estacionamento = buscarEstacionamento(id);
		if (estacionamento == null)
			return false;
		if(!autorizarSaida(id))
			return false;
		estacionamento.setFinalizado(true);
		estacionamento.setDhSaida(LocalDateTime.now());
		return editarEstacionamento(estacionamento);
	}

	public boolean estacionamentoExiste(Estacionamento estacionamento) {		
		return estacionamentos.contains(estacionamento) ;
	}
	
}
