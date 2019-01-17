package br.com.ifpb.teste.auto_parking.dao.imp;

import java.util.HashSet;
import java.util.List;

import br.com.ifpb.teste.auto_parking.dao.*;
import br.com.ifpb.teste.auto_parking.model.*;

public class PagamentoDAOMem implements PagamentoDAO {
	
	private HashSet<Pagamento> pagamentos = null;
	private EstacionamentoDAO estacionamentoDAO;
	private PrecoDAO precoDAO;
	private ClienteDAO clienteDAO;
	private VeiculoDAO veiculoDAO;
	
	public PagamentoDAOMem(ClienteDAO clienteDAO, VeiculoDAO veiculoDAO, PrecoDAO precoDAO,
			EstacionamentoDAO estacionamentoDAO){
		this.estacionamentoDAO = estacionamentoDAO;
		this.precoDAO = precoDAO;
		this.clienteDAO = clienteDAO;
		this.veiculoDAO = veiculoDAO;
		pagamentos = new HashSet<Pagamento>();
	}

	public void gerarValor(int id) {
		// TODO Auto-generated method stub

	}

	public double valorDevido(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double calcularTroco(int id, double valorPago) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void registrarPagamento(int id) {
		// TODO Auto-generated method stub

	}

	public void incluirCredito(double valor) {
		// TODO Auto-generated method stub

	}

	public boolean cadastrarPagamento(Pagamento pagamento) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editarPagamento(Pagamento pagamento) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean excluirPagamento(Pagamento pagamento) {
		// TODO Auto-generated method stub
		return false;
	}

	public Pagamento buscarPagamento(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pagamento> buscarPagamentoCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pagamento> buscarPagamentoPlaca(String placa) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pagamento> listarPagamento() {
		// TODO Auto-generated method stub
		return null;
	}

}
