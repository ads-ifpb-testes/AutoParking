package br.com.ifpb.teste.auto_parking.dao;

import java.util.List;

import br.com.ifpb.teste.auto_parking.model.Pagamento;

public interface PagamentoDAO {
	
	boolean cadastrarPagamento(Pagamento pagamento);
	boolean editarPagamento(Pagamento pagamento);
	boolean excluirPagamento(Pagamento pagamento);
	List<Pagamento> buscarPagamento(int id);
	List<Pagamento> buscarPagamentoCpf(String  cpf);
	List<Pagamento> buscarPagamentoPlaca(String  placa);	
	List<Pagamento> listarPagamento();
	void gerarValor(int id);
	double valorDevido(int id);
	double calcularTroco(int id, double valorPago);
	void registrarPagamento(int id);	
	void incluirCredito(double valor);
	

}
