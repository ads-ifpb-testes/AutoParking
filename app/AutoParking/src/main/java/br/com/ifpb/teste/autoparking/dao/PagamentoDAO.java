package br.com.ifpb.teste.autoparking.dao;

import java.util.List;

import br.com.ifpb.teste.autoparking.model.Pagamento;

public interface PagamentoDAO {
	boolean pagamentoExiste(Pagamento pagamento);
	boolean cadastrarPagamento(Pagamento pagamento);
	boolean excluirPagamento(Pagamento pagamento);
	Pagamento buscarPagamento(int id);
	List<Pagamento> buscarPagamentoCpf(String  cpf);
	List<Pagamento> buscarPagamentoPlaca(String  placa);	
	List<Pagamento> listarPagamento();
	double valorDevido(int id);
	double calcularTroco(int id, double valorPago);
	void registrarPagamento(int id);	
	void incluirCredito(String cpf, double valor);
}
