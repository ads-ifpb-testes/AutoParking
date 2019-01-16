package br.com.ifpb.teste.auto_parking;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.ifpb.teste.auto_parking.dao.imp.EstacionamentoDAOMem;
import br.com.ifpb.teste.auto_parking.model.Estacionamento;

public class EstacionamentoDAOMemTeste {

	private static ArrayList<Estacionamento> listaEstacionamento = new ArrayList<Estacionamento>();
	private EstacionamentoDAOMem estacionamentoDAO = null;
	
	@BeforeClass
	public static void criarEstacionamentos() {
		//listaEstacionamento.add(new Estacionamento(id, quitado, finalizado, placa, dhChegada, dhPagamento, dhSaida, valor));
		listaEstacionamento.add(new Estacionamento(1, true, true, "JJK-1373", LocalDateTime.now().minusHours(1), LocalDateTime.now().minusMinutes(30), LocalDateTime.now(), 5.5));
		listaEstacionamento.add(new Estacionamento(2, true, false, "JOE-8330", LocalDateTime.now().minusHours(1), LocalDateTime.now().minusMinutes(30), null, 7.8));
		listaEstacionamento.add(new Estacionamento(3, true, false, "EFH-9373", LocalDateTime.now().minusHours(2), LocalDateTime.now().minusMonths(1), LocalDateTime.now(), 5.5));
		listaEstacionamento.add(new Estacionamento(4, false, false, "JJK-1373", LocalDateTime.now().minusHours(2), null, null, null));
	}
	
	@Before
	public void inicioTeste() {
		estacionamentoDAO = new EstacionamentoDAOMem();
		for(Estacionamento estacionamento: listaEstacionamento) {
			estacionamentoDAO.cadastrarEstacionamento(
					new Estacionamento(
							estacionamento.getId(),
							estacionamento.isQuitado(),
							estacionamento.isFinalizado(),
							estacionamento.getPlaca(),
							estacionamento.getDhChegada(),
							estacionamento.getDhPagamento(),
							estacionamento.getDhSaida(),
							estacionamento.getValor()));
		}
	}
	
	@After
	public void finalTeste() {
		estacionamentoDAO = null; 
	}
	
	@Test
	public void cadastrarEstacionamentoTeste() {
		Estacionamento novoEstacionamento = new Estacionamento(5, false, false, "HRL-8233", LocalDateTime.now(), null, null, null);
		Assert.assertTrue(estacionamentoDAO.cadastrarEstacionamento(novoEstacionamento));
		List<Estacionamento> lista = estacionamentoDAO.listarEstacionamento();
		Assert.assertTrue(lista.contains(novoEstacionamento));
		
		Assert.assertFalse(estacionamentoDAO.cadastrarEstacionamento(novoEstacionamento));
		
		for(Estacionamento estacionamento: listaEstacionamento) {
			Assert.assertTrue(lista.contains(estacionamento));
		}
	}
	
	@Test
	public void buscarEstacionamentoTeste() {
		
		Assert.assertNull(estacionamentoDAO.buscarEstacionamento(5));
		
		for(Estacionamento estacionamento: listaEstacionamento) {
			Assert.assertEquals(estacionamento, estacionamentoDAO.buscarEstacionamento(estacionamento.getId()));
		}
		
		List<Estacionamento> lista = null;
		for(Estacionamento aEstacionamento: listaEstacionamento) {
			lista = estacionamentoDAO.buscarEstacionamento(aEstacionamento.getPlaca());
			for(Estacionamento bEstacionamento: lista) {
				Assert.assertEquals(aEstacionamento.getPlaca(), bEstacionamento.getPlaca());
			}
		}
	}	
	
	@Test
	public void buscarIdPlacaTeste() {
		
		Assert.assertEquals(0, estacionamentoDAO.buscarIdPlaca("XXX-0000"));
		
		for(Estacionamento estacionamento: listaEstacionamento) {
			if(!estacionamento.isFinalizado()) {
				Assert.assertEquals(estacionamento.getId(),estacionamentoDAO.buscarIdPlaca(estacionamento.getPlaca()));
			}
		}
		
	}
	
	@Test
	public void editarEstacionamentoTeste() {
		Estacionamento novoEstacionamento = new Estacionamento(5, true, true, "MKI-5381", LocalDateTime.now().minusHours(3), LocalDateTime.now().minusMinutes(30), LocalDateTime.now(), 3.75);
		Assert.assertFalse(estacionamentoDAO.editarEstacionamento(novoEstacionamento));
		
		for(Estacionamento estacionamento: listaEstacionamento) {
			novoEstacionamento.setId(estacionamento.getId());
			assertTrue(estacionamentoDAO.editarEstacionamento(novoEstacionamento));
		}
		
	}
	
	@Test
	public void excluirEstacionamentoTeste() {
		Estacionamento novoEstacionamento = new Estacionamento(5, true, true, "MKI-5381", LocalDateTime.now().minusHours(3), LocalDateTime.now().minusMinutes(30), LocalDateTime.now(), 3.75);
		Assert.assertFalse(estacionamentoDAO.excluirEstacionemtno(novoEstacionamento));
		
		for(Estacionamento estacionamento: listaEstacionamento) {
			Assert.assertTrue(estacionamentoDAO.excluirEstacionemtno(estacionamento));
			Assert.assertFalse(estacionamentoDAO.estacionamentoExiste(estacionamento));			
		}
		List<Estacionamento> lista = estacionamentoDAO.listarEstacionamento();
		Assert.assertTrue(lista.isEmpty());		
	}
	
	@Test
	public void listarEstacionamentoTeste() {
		List<Estacionamento> lista = estacionamentoDAO.listarEstacionamento();
		Assert.assertEquals(listaEstacionamento.size(), lista.size());
		for(Estacionamento estacionamento: lista) {
			Assert.assertTrue(listaEstacionamento.contains(estacionamento));
		}
	}
	
	@Test 
	public void autorizarSaidaTeste() {
		Assert.assertTrue(estacionamentoDAO.autorizarSaida(listaEstacionamento.get(2).getId()));
		Assert.assertFalse(estacionamentoDAO.autorizarSaida(listaEstacionamento.get(2).getId()));
		Assert.assertFalse(estacionamentoDAO.autorizarSaida(listaEstacionamento.get(1).getId()));
		Assert.assertFalse(estacionamentoDAO.autorizarSaida(listaEstacionamento.get(3).getId()));
		Assert.assertFalse(estacionamentoDAO.autorizarSaida(listaEstacionamento.get(4).getId()));		
	}
	
	@Test
	public void finalizarServicoTeste() {
		Assert.assertFalse(estacionamentoDAO.finalizarServico(1));
		Assert.assertTrue(estacionamentoDAO.finalizarServico(2));
		Assert.assertTrue(estacionamentoDAO.finalizarServico(3));
		Assert.assertFalse(estacionamentoDAO.finalizarServico(4));
		
		Assert.assertFalse(estacionamentoDAO.finalizarServico(2));
		Assert.assertFalse(estacionamentoDAO.finalizarServico(3));		
	}
	
	@Test
	public void registrarEntradaTeste() {
		String placas[] = {"GTJ-3988", "MXG-6312", "JEX-9380", "LXZ-5691", "LXZ-5691"};
		for(int k = 0 ; k < placas.length; k++) {
			int id = estacionamentoDAO.registrarEntrada(placas[k]);		
			Assert.assertNotEquals(0, id);
			Estacionamento estacionamento = estacionamentoDAO.buscarEstacionamento(id);
			Assert.assertNotNull(estacionamento);
			Assert.assertNull(estacionamento.isFinalizado());
			Assert.assertNull(estacionamento.isQuitado());			
		}
	}
	
}
