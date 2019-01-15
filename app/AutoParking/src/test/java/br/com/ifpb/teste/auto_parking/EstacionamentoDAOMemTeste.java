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
		listaEstacionamento.add(new Estacionamento(2, false, false, "JOE-8330", LocalDateTime.now().minusHours(1), null, null, null));
		listaEstacionamento.add(new Estacionamento(3, true, false, "EFH-9373", LocalDateTime.now().minusHours(2), LocalDateTime.now().minusMonths(1), LocalDateTime.now(), 5.5));
		listaEstacionamento.add(new Estacionamento(4, false, false, "JJK-1373", LocalDateTime.now().minusHours(2), null, null, null));
	}
	
	@Before
	public void inicioTeste() {
		estacionamentoDAO = new EstacionamentoDAOMem();
		for(Estacionamento estacionamento: listaEstacionamento) {
			estacionamentoDAO.cadastrarEstacionamento(estacionamento);
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
}
