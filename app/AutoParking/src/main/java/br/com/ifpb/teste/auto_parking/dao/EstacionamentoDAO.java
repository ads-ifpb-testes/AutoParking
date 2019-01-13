package br.com.ifpb.teste.auto_parking.dao;

public interface EstacionamentoDAO {
	int registrarEntrada(String placa);
	int buscarIdPlaca(String placa);
	boolean autorizarSaida(int id);
	void finalizarServico(int id);
}
