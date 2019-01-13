package br.com.ifpb.teste.auto_parking.dao;

public interface PagamentoDAO {
	
	void gerarValor(int id);
	double valorDevido(int id);
	double calcularTroco(int id, double valorPago);
	void registrarPagamento(int id);	
	void incluirCredito(double valor);

}
