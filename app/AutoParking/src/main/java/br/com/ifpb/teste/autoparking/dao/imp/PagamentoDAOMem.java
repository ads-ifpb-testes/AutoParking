package br.com.ifpb.teste.autoparking.dao.imp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import br.com.ifpb.teste.autoparking.dao.ClienteDAO;
import br.com.ifpb.teste.autoparking.dao.EstacionamentoDAO;
import br.com.ifpb.teste.autoparking.dao.PagamentoDAO;
import br.com.ifpb.teste.autoparking.dao.PrecoDAO;
import br.com.ifpb.teste.autoparking.dao.VeiculoDAO;
import br.com.ifpb.teste.autoparking.model.Cliente;
import br.com.ifpb.teste.autoparking.model.Estacionamento;
import br.com.ifpb.teste.autoparking.model.Pagamento;
import br.com.ifpb.teste.autoparking.model.Pagamento.TipoPagamento;

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
	
	public boolean pagamentoExiste(Pagamento pagamento) {
		return pagamentos.contains(pagamento);
	}

	public double valorDevido(int id) {
		Estacionamento estacionamento = estacionamentoDAO.buscarEstacionamento(id);
		if (estacionamento == null)
			return 0;
		long minutos = Duration.between(estacionamento.getDhChegada(), LocalDateTime.now()).toMinutes();
		return precoDAO.calcularPreco(minutos);
	}

	public double calcularTroco(int id, double valorPago) {
		double valor = valorDevido(id);
		return valorPago - valor;
	}

	public void registrarPagamento(int id) {
		Estacionamento estacionamento = estacionamentoDAO.buscarEstacionamento(id);
		if (estacionamento == null)
			return;
		if(estacionamento.isQuitado() || estacionamento.isFinalizado())
			return;
		double valor = valorDevido(id);
		estacionamento.setQuitado(true);
		estacionamento.setDhPagamento(LocalDateTime.now());
		estacionamento.setValor(valor);
	}

	public void incluirCredito(String cpf, double valor) {
		Cliente cliente = clienteDAO.buscarCliente(cpf);
		if(cliente == null)
			return;
		double atual = cliente.getCredito();
		cliente.setCredito(atual + valor);
	}

	public boolean cadastrarPagamento(Pagamento pagamento) {
		if (pagamentoExiste(pagamento))
			return false;		
		return pagamentos.add(pagamento);
	}

	public boolean excluirPagamento(Pagamento pagamento) {
		if(!pagamentoExiste(pagamento))
			return false;
		return pagamentos.remove(pagamento);
	}

	public Pagamento buscarPagamento(int id) {
		ArrayList<Pagamento> lista = new ArrayList<Pagamento>(pagamentos);
		for(Pagamento pagamento: lista) {
			if(pagamento.getIdServico()==id)
				return pagamento;
		}
		return null;
	}

	public List<Pagamento> buscarPagamentoCpf(String cpf) {
		ArrayList<Pagamento> lista = new ArrayList<Pagamento>(pagamentos);
		ArrayList<Pagamento> rsp = new ArrayList<Pagamento>();
		for (Pagamento pagamento: lista) {
			if(pagamento.getTipoPagamento()==TipoPagamento.CREDITO) {
				if(pagamento.getCpfCliente().equals(cpf)) {
					rsp.add(pagamento);
				}
			}
		}
		return rsp;
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
