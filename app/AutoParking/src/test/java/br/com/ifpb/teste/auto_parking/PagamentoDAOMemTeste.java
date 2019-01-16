package br.com.ifpb.teste.auto_parking;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.BeforeClass;

import br.com.ifpb.teste.auto_parking.dao.imp.PagamentoDAOMem;
import br.com.ifpb.teste.auto_parking.model.Pagamento;

public class PagamentoDAOMemTeste {
	
	private static ArrayList<Pagamento> listaPagamento = new ArrayList<Pagamento>();
	private PagamentoDAOMem pagamentoDAO = null;
	
	@BeforeClass
	public static void criarPagamentos() {
		listaPagamento.add(new Pagamento(LocalDateTime.now(), 5.5f, 1));
	}
	
	@Before 
	public void inicioTeste() {
		pagamentoDAO = new PagamentoDAOMem(clienteDAO, veiculoDAO, precoDAO, estacionamentoDAO)
	}

}
