package br.com.ifpb.teste.auto_parking.dao;

public interface GerenciaEstacionamentoDAO {
	int registraNovoVeiculo(String placa);
	double valorDuracao(int id);
	void quitaServico(int id);
	boolean solicitaSaida(int id);
	void finalizaServico(int id);
}
