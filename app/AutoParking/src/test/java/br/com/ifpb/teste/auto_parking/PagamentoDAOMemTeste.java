package br.com.ifpb.teste.auto_parking;

import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;

import br.com.ifpb.teste.auto_parking.dao.ClienteDAO;
import br.com.ifpb.teste.auto_parking.dao.EstacionamentoDAO;
import br.com.ifpb.teste.auto_parking.dao.PrecoDAO;
import br.com.ifpb.teste.auto_parking.dao.VeiculoDAO;
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
		ClienteDAO clienteDAOMock = mock(ClienteDAO.class);
		VeiculoDAO veiculoDAOMock = mock(VeiculoDAO.class);
		PrecoDAO precoDAOMock = mock(PrecoDAO.class);
		EstacionamentoDAO estacionamentoDAOMock = mock(EstacionamentoDAO.class);
		
		pagamentoDAO = new PagamentoDAOMem(clienteDAOMock, veiculoDAOMock, precoDAOMock, estacionamentoDAOMock);
	}

}
