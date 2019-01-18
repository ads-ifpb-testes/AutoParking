package br.com.ifpb.teste.auto_parking;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import br.com.ifpb.teste.auto_parking.model.Cliente;
import br.com.ifpb.teste.auto_parking.model.Estacionamento;
import br.com.ifpb.teste.auto_parking.model.Pagamento;
import br.com.ifpb.teste.auto_parking.model.Pagamento.TipoPagamento;
import br.com.ifpb.teste.auto_parking.model.Preco;
import br.com.ifpb.teste.auto_parking.model.Veiculo;

public class PagamentoDAOMemTeste {
	private static ArrayList<Preco> listaPreco = new ArrayList<Preco>();
	private static ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
	private static ArrayList<Cliente> listaNomes = new ArrayList<Cliente>();
	private static ArrayList<Estacionamento> listaEstacionamento = new ArrayList<Estacionamento>();
	private static ArrayList<Pagamento> listaPagamento = new ArrayList<Pagamento>();	
	private PagamentoDAOMem pagamentoDAO = null;
	ClienteDAO clienteDAOMock = null;
	VeiculoDAO veiculoDAOMock = null;
	PrecoDAO precoDAOMock = null;
	EstacionamentoDAO estacionamentoDAOMock = null;
	
	@BeforeClass
	public static void criarPagamentos() {
		/*//Precos
		listaPreco.add(new Preco(true, 0, 0, 5.5f));       //   valor fixo
		listaPreco.add(new Preco(false, 31, 60, 10.3f));   //  31 ~ 60  minutos
		listaPreco.add(new Preco(false, 61, 120, 9.5f));   //  61 ~ 120 minutos
		listaPreco.add(new Preco(false, 121, 180, 9.1f));  // 121 ~ 180 minutos
		listaPreco.add(new Preco(false, 181, 0, 8.7f));    // 181 ~ ... minutos - Relativo aos minutos
		//Clientes
		listaNomes.add(new Cliente("Bruno Raimundo Isaac da Silva", "858.209.873-14"));
		listaNomes.add(new Cliente("Esther Luana Simone dos Santos", "431.201.150-88"));
		listaNomes.add(new Cliente("Fábio Enzo Giovanni das Neves", "322.258.588-10"));
		listaNomes.add(new Cliente("Mariana Elisa Stefany das Neves", "599.837.460-69"));	
		//Veículo
		listaVeiculos.add(new Veiculo("858.209.873-14","MKI-5381","Jeep","Grand Cherokee SRT8 6.1 V8 16V 432cv Aut","Dourado",2010));
		listaVeiculos.add(new Veiculo("431.201.150-88","JJK-1373","Land Rover","Defender 90 TDI SW Diesel","Laranja",2015));
		listaVeiculos.add(new Veiculo("322.258.588-10","HRL-8233","Lexus","NX-200t F-Sport 2.0 16v 238cv Aut.","Dourado",2011));
		listaVeiculos.add(new Veiculo("599.837.460-69","NBB-4738","Volvo","V70 R 2.5 300cv AWD Mec.","Branco",2004));
		listaVeiculos.add(new Veiculo("431.201.150-88","JOE-8330","TAC","Stark 2.3 4WD 127cv TDI Diesel 3p","Preto",2010));
		listaVeiculos.add(new Veiculo("858.209.873-14","EFH-9373","Honda","Civic Sedan LX 1.6 16V Mec. 4p","Laranja",1997));
		//Estacionamento
		listaEstacionamento.add(new Estacionamento(1, true, true, "LWG-4724", LocalDateTime.now().minusHours(1), LocalDateTime.now().minusMinutes(30), LocalDateTime.now(), 5.5));
		listaEstacionamento.add(new Estacionamento(2, true, false, "MOK-4656", LocalDateTime.now().minusHours(1), LocalDateTime.now().minusMinutes(29), null, 7.8));
		listaEstacionamento.add(new Estacionamento(3, true, false, "NAA-1077", LocalDateTime.now().minusHours(2), LocalDateTime.now().minusMonths(1), null, 5.5));
		listaEstacionamento.add(new Estacionamento(4, false, false, "JJK-1373", LocalDateTime.now().minusHours(2), null, null, null));
		*/
		//Pagamento		
		listaPagamento.add(new Pagamento(LocalDateTime.now(), 5.5f, 1));
		listaPagamento.add(new Pagamento(LocalDateTime.now(), 7.8f, 2));
		listaPagamento.add(new Pagamento(LocalDateTime.now(), 5.5f, 3));
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
	
	@Test
	public void buscarPagamentoIdTeste() {
		for(Pagamento pagamento: listaPagamento) {
			if(pagamento.getTipoPagamento()==TipoPagamento.AVULSO) {
				Assert.assertEquals(pagamento, pagamentoDAO.buscarPagamento(pagamento.getIdServico()));
			}				
		}
		Assert.assertNull(pagamentoDAO.buscarPagamento(10));
	}
	
	@Test
	public void buscarPagamentoCpfTeste() {
		for(Pagamento pagamento: listaPagamento) {
			if(pagamento.getTipoPagamento() == TipoPagamento.CREDITO) {
				Assert.assertEquals(pagamento, pagamentoDAO.buscarPagamentoCpf(pagamento.getCpfCliente()));
			}
		}		
		Assert.assertNull(pagamentoDAO.buscarPagamentoCpf("000.000.000-00"));
	}
	
	@Test
	public void buscarPagamentoPlacaTeste() {
		Estacionamento estacionamento1 = new Estacionamento(1, true, true, "LWG-4724", LocalDateTime.now().minusHours(1), LocalDateTime.now().minusMinutes(30), LocalDateTime.now(), 5.5);
		when(estacionamentoDAOMock.buscarIdPlaca("LWG-4724")).thenReturn(estacionamento1.getId());	
		List<Pagamento> pagamentos =  pagamentoDAO.buscarPagamentoPlaca("LWG-4724");
		Assert.assertEquals(1,pagamentos.size());
		Assert.assertEquals(1, pagamentos.get(0).getIdServico());
	}
	
	@Test
	public void calcularTrocoTeste() {
		Estacionamento estacionamento1 = new Estacionamento(1, true, false, "LWG-4724", LocalDateTime.now().minusHours(1), null, null, null);
		when(estacionamentoDAOMock.buscarEstacionamento(1)).thenReturn(estacionamento1);
		when(precoDAOMock.calcularPreco(60)).thenReturn(15.8f);
		Assert.assertEquals(20f - 15.8f, pagamentoDAO.calcularTroco(1, 20),0.01f);
	}
	
	
	
	
}
