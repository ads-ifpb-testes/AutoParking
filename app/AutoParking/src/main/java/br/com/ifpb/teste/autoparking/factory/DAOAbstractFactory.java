package br.com.ifpb.teste.autoparking.factory;

import br.com.ifpb.teste.autoparking.dao.ClienteDAO;
import br.com.ifpb.teste.autoparking.dao.EstacionamentoDAO;
import br.com.ifpb.teste.autoparking.dao.PagamentoDAO;
import br.com.ifpb.teste.autoparking.dao.PrecoDAO;
import br.com.ifpb.teste.autoparking.dao.VeiculoDAO;

public interface DAOAbstractFactory {
	public ClienteDAO criaClienteDAO();
	public VeiculoDAO criaVeiculoDAO();
	public PrecoDAO criaPrecoDAO();	
	public EstacionamentoDAO criaEstacionamentoDAO();
	public PagamentoDAO criaPagamentoDAO(
			ClienteDAO clienteDAO,
			VeiculoDAO veiculoDAO,
			PrecoDAO precoDAO,
			EstacionamentoDAO estacionamentoDAO
			);
}
