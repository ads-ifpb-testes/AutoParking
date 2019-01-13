package br.com.ifpb.teste.auto_parking.dao.imp;

import br.com.ifpb.teste.auto_parking.dao.ClienteDAO;
import br.com.ifpb.teste.auto_parking.dao.EstacionamentoDAO;
import br.com.ifpb.teste.auto_parking.dao.PagamentoDAO;
import br.com.ifpb.teste.auto_parking.dao.PrecoDAO;
import br.com.ifpb.teste.auto_parking.dao.VeiculoDAO;
import br.com.ifpb.teste.auto_parking.factory.DAOAbstractFactory;

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
