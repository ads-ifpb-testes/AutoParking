package br.com.ifpb.teste.autoparking.dao.imp;

import br.com.ifpb.teste.autoparking.dao.ClienteDAO;
import br.com.ifpb.teste.autoparking.dao.EstacionamentoDAO;
import br.com.ifpb.teste.autoparking.dao.PagamentoDAO;
import br.com.ifpb.teste.autoparking.dao.PrecoDAO;
import br.com.ifpb.teste.autoparking.dao.VeiculoDAO;
import br.com.ifpb.teste.autoparking.factory.DAOAbstractFactory;

public class DAOFactoryMem implements DAOAbstractFactory{
	
	public ClienteDAO criaClienteDAO() {
		return new ClienteDAOMem();		
	}

	public VeiculoDAO criaVeiculoDAO() {	
		return new VeiculoDAOMem();
	}

	public PrecoDAO criaPrecoDAO() {
		return new PrecoDAOMem();
	}

	public EstacionamentoDAO criaEstacionamentoDAO() {
		return new EstacionamentoDAOMem();
	}

	public PagamentoDAO criaPagamentoDAO(ClienteDAO clienteDAO, VeiculoDAO veiculoDAO, PrecoDAO precoDAO,
			EstacionamentoDAO estacionamentoDAO) {
		return new PagamentoDAOMem(clienteDAO,veiculoDAO,precoDAO,estacionamentoDAO);
	}
	
	

}
