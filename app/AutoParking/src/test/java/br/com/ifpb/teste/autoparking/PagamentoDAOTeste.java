package br.com.ifpb.teste.autoparking;

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

import br.com.ifpb.teste.autoparking.dao.ClienteDAO;
import br.com.ifpb.teste.autoparking.dao.EstacionamentoDAO;
import br.com.ifpb.teste.autoparking.dao.PagamentoDAO;
import br.com.ifpb.teste.autoparking.dao.PrecoDAO;
import br.com.ifpb.teste.autoparking.dao.VeiculoDAO;
import br.com.ifpb.teste.autoparking.factory.DAOAbstractFactory;
import br.com.ifpb.teste.autoparking.factory.DAOFactory;
import br.com.ifpb.teste.autoparking.factory.DAOFactory.FactoryType;
import br.com.ifpb.teste.autoparking.model.Cliente;
import br.com.ifpb.teste.autoparking.model.Estacionamento;
import br.com.ifpb.teste.autoparking.model.Pagamento;
import br.com.ifpb.teste.autoparking.model.Pagamento.TipoPagamento;
import br.com.ifpb.teste.autoparking.model.Preco;
import br.com.ifpb.teste.autoparking.model.Veiculo;

public class PagamentoDAOTeste {
	
	private static DAOAbstractFactory daoFactory = null;
	private static ArrayList<Preco> listaPreco = new ArrayList<Preco>();
	private static ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
	private static ArrayList<Cliente> listaNomes = new ArrayList<Cliente>();
	private static ArrayList<Estacionamento> listaEstacionamento = new ArrayList<Estacionamento>();
	private static ArrayList<Pagamento> listaPagamento = new ArrayList<Pagamento>();	
	private PagamentoDAO pagamentoDAO = null;
	ClienteDAO clienteDAOMock = null;
	VeiculoDAO veiculoDAOMock = null;
	PrecoDAO precoDAOMock = null;
	EstacionamentoDAO estacionamentoDAOMock = null;
	
	@BeforeClass
	public static void criarPagamentos() {
		daoFactory = DAOFactory.createFactory(FactoryType.MEM);
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
		pagamentoDAO = daoFactory.criaPagamentoDAO(clienteDAOMock, veiculoDAOMock, precoDAOMock, estacionamentoDAOMock);
		
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
		
		pagamentoDAO = null;		
	}
	
	@Test
	public void cadastrarPagamentoTeste() {
		Pagamento pag1 = new Pagamento(LocalDateTime.now(), 10.5, 4);
		Pagamento pag2 = new Pagamento(LocalDateTime.now(), 5.5, "858.209.873-14");
		for(Pagamento pagamento: listaPagamento) {
			Assert.assertFalse(pagamentoDAO.cadastrarPagamento(pagamento));
		}
		Assert.assertTrue(pagamentoDAO.cadastrarPagamento(pag1));
		Assert.assertTrue(pagamentoDAO.cadastrarPagamento(pag2));		
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
				Assert.assertTrue(pagamentoDAO.buscarPagamentoCpf(pagamento.getCpfCliente()).contains(pagamento));
			}
		}		
		Assert.assertTrue(pagamentoDAO.buscarPagamentoCpf("000.000.000-00").isEmpty());
	}
	
	@Test
	public void buscarPagamentoPlacaTeste() {
		Estacionamento estacionamento1 = new Estacionamento(1, true, true, "LWG-4724", LocalDateTime.now().minusHours(1), LocalDateTime.now().minusMinutes(30), LocalDateTime.now(), 5.5);
		ArrayList<Estacionamento> lista = new ArrayList<Estacionamento>();
		lista.add(estacionamento1);
		when(estacionamentoDAOMock.buscarEstacionamento("LWG-4724")).thenReturn(lista);	
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
	
	@Test
	public void pagamentoExisteTeste() {
		for(Pagamento pagamento: listaPagamento) {
			Assert.assertTrue(pagamentoDAO.pagamentoExiste(pagamento));
		}
		Pagamento pag1 = new Pagamento(LocalDateTime.now(), 10.5, 6);
		Assert.assertFalse(pagamentoDAO.pagamentoExiste(pag1));
	}
	
	@Test
	public void excluirPagamentoTeste() {
		Pagamento pag1 = new Pagamento(LocalDateTime.now(), 10.5, 1);
		Assert.assertFalse(pagamentoDAO.excluirPagamento(pag1));
		for(Pagamento pagamento: listaPagamento) {
			Assert.assertTrue(pagamentoDAO.excluirPagamento(pagamento));
		}
	}
	
	@Test
	public void incluirCreditoTeste() {
		Cliente cliente1 = new Cliente("Bruno Raimundo Isaac da Silva", "858.209.873-14");
		cliente1.setCredito(100.0);
		when(clienteDAOMock.buscarCliente("858.209.873-14")).thenReturn(cliente1);
		pagamentoDAO.incluirCredito("858.209.873-14", 50.0);
		Assert.assertEquals(150.0, cliente1.getCredito(),0.01);
	}
	
	@Test
	public void listarPagamentoTeste() {
		Pagamento pag1 = new Pagamento(LocalDateTime.now(), 10.5, 1);
		Assert.assertFalse(listaPagamento.contains(pag1));
		List<Pagamento> lista = pagamentoDAO.listarPagamento();
		for (Pagamento pagamento: lista) {
			Assert.assertTrue(listaPagamento.contains(pagamento));
		}
	}
	
	@Test
	public void registrarPagamentoTeste() {
		Estacionamento estacionamento1 = new Estacionamento(4, false, false, "LWG-4724", LocalDateTime.now().minusHours(1), null, null, null);
		when(estacionamentoDAOMock.buscarEstacionamento(4)).thenReturn(estacionamento1);
		when(precoDAOMock.calcularPreco(60)).thenReturn(10.65f);		
		pagamentoDAO.registrarPagamento(4);		
		Assert.assertTrue(estacionamento1.isQuitado());
		Assert.assertEquals(10.65, estacionamento1.getValor(),0.01);
		Pagamento pag1 = pagamentoDAO.buscarPagamento(4);
		Assert.assertNotNull(pag1);
		Assert.assertEquals(10.65, pag1.getValor(),0.01);
		Assert.assertEquals(0, pag1.getDhPagamento().compareTo(estacionamento1.getDhPagamento()));		
	}
	
	@Test
	public void valorDevidoTeste() {
		Estacionamento estacionamento1 = new Estacionamento(4, false, false, "LWG-4724", LocalDateTime.now().minusHours(1), null, null, null);
		when(estacionamentoDAOMock.buscarEstacionamento(4)).thenReturn(estacionamento1);
		when(precoDAOMock.calcularPreco(60)).thenReturn(10.65f);	
		Assert.assertEquals(pagamentoDAO.valorDevido(4),10.65f,0.01f);
	}
	
	
}
