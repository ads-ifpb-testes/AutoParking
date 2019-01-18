package br.com.ifpb.teste.auto_parking;

import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.ifpb.teste.auto_parking.dao.ClienteDAO;
import br.com.ifpb.teste.auto_parking.dao.EstacionamentoDAO;
import br.com.ifpb.teste.auto_parking.dao.PrecoDAO;
import br.com.ifpb.teste.auto_parking.dao.VeiculoDAO;
import br.com.ifpb.teste.auto_parking.dao.imp.PagamentoDAOMem;
import br.com.ifpb.teste.auto_parking.model.Pagamento;

public class PagamentoDAOMemTeste {
	
	private static ArrayList<Pagamento> listaPagamento = new ArrayList<Pagamento>();
	private PagamentoDAOMem pagamentoDAO = null;
	ClienteDAO clienteDAOMock = null;
	VeiculoDAO veiculoDAOMock = null;
	PrecoDAO precoDAOMock = null;
	EstacionamentoDAO estacionamentoDAOMock = null;
	
	@BeforeClass
	public static void criarPagamentos() {
		listaPagamento.add(new Pagamento(LocalDateTime.now(), 5.5f, 1));
		listaPagamento.add(new Pagamento(LocalDateTime.now(), 12.5f, 2));
		listaPagamento.add(new Pagamento(LocalDateTime.now(), 45.5f, 3));
		listaPagamento.add(new Pagamento(LocalDateTime.now(), 5.5f, "431.201.150-88"));
		listaPagamento.add(new Pagamento(LocalDateTime.now(), 50.0f, "322.258.588-10"));
		listaPagamento.add(new Pagamento(LocalDateTime.now(), 125.0f, "599.837.460-69"));		
	}
	
	@Before 
	public void inicioTeste() {
		clienteDAOMock = mock(ClienteDAO.class);
		veiculoDAOMock = mock(VeiculoDAO.class);
		precoDAOMock = mock(PrecoDAO.class);
		estacionamentoDAOMock = mock(EstacionamentoDAO.class);
		
		pagamentoDAO = new PagamentoDAOMem(clienteDAOMock, veiculoDAOMock, precoDAOMock, estacionamentoDAOMock);
		
		for(Pagamento pagamento: listaPagamento) {
			pagamentoDAO.cadastrarPagamento(pagamento);
		}
	}
	
	@After
	public void finalTeste() {
		clienteDAOMock = null;
		veiculoDAOMock = null;
		precoDAOMock = null;
		estacionamentoDAOMock = null;
		
		pagamentoDAO = new PagamentoDAOMem(clienteDAOMock, veiculoDAOMock, precoDAOMock, estacionamentoDAOMock);		
	}
	
	@Test
	public void cadastrarPagamentoTeste() {
		Pagamento pag1 = new Pagamento(LocalDateTime.now(), 10.5, 1);
		Pagamento pag2 = new Pagamento(LocalDateTime.now(), 10.5, 4);
		Pagamento pag3 = new Pagamento(LocalDateTime.now(), 5.5, "858.209.873-14");
		
		Assert.assertFalse(pagamentoDAO.cadastrarPagamento(pag1));
		Assert.assertTrue(pagamentoDAO.cadastrarPagamento(pag2));
		Assert.assertTrue(pagamentoDAO.cadastrarPagamento(pag3));		
	}

}
