package br.com.ifpb.teste.auto_parking.factory;

import br.com.ifpb.teste.auto_parking.dao.ClienteDAO;
import br.com.ifpb.teste.auto_parking.dao.EstacionamentoDAO;
import br.com.ifpb.teste.auto_parking.dao.PagamentoDAO;
import br.com.ifpb.teste.auto_parking.dao.PrecoDAO;
import br.com.ifpb.teste.auto_parking.dao.VeiculoDAO;

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
