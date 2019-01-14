package br.com.ifpb.teste.auto_parking;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.ifpb.teste.auto_parking.dao.imp.PrecoDAOMem;
import br.com.ifpb.teste.auto_parking.model.Preco;

public class PrecoDAOMemTeste {
	
	private static ArrayList<Preco> listaPreco = new ArrayList<Preco>();
	private PrecoDAOMem precoDAO = null;
	
	@BeforeClass
	public static void criarPrecos() {
		listaPreco.add(new Preco(true, 0, 0, 5.5f));        //   valor fixo
		listaPreco.add(new Preco(false, 31, 60, 0.18f)); //  31 ~ 60  minutos
		listaPreco.add(new Preco(false, 61, 120, 0.16f));//  61 ~ 120 minutos
		listaPreco.add(new Preco(false, 121, 180, 0.14f));  // 121 ~ 180 minutos
		listaPreco.add(new Preco(false, 181, 0, 0.1f));    // 181 ~ ... minutos - Relativo aos minutos
	}
	
	@Before
	public void inicioTeste() {
		precoDAO = new PrecoDAOMem();
		for(Preco preco: listaPreco) {
			precoDAO.cadastrarPreco(preco);
		}
	}
	
	@After
	public void finalTeste() {
		precoDAO = null;
	}
	
	@Test
	public void calcularPrecoTeste() {		
		Assert.assertEquals(5.5f, precoDAO.calcularPreco(0), 0.001f);
		Assert.assertEquals(5.5f, precoDAO.calcularPreco(15), 0.001f);
		Assert.assertEquals(5.5f, precoDAO.calcularPreco(30), 0.001f);
		// 31 ~ 60
		Assert.assertEquals(5.5f + (0.18f * (31 - 31)) , precoDAO.calcularPreco(31), 0.001f);
		Assert.assertEquals(5.5f + (0.18f * (46 - 31)) , precoDAO.calcularPreco(46), 0.001f);
		Assert.assertEquals(5.5f + (0.18f * (60 - 31)) , precoDAO.calcularPreco(60), 0.001f);
		//61 ~ 120
		Assert.assertEquals(5.5f + 5.22f + (0.16f * (61 - 61)) , precoDAO.calcularPreco(61), 0.001f);
		Assert.assertEquals(5.5f + 5.22f + (0.16f * (91 - 61)) , precoDAO.calcularPreco(91), 0.001f);
		Assert.assertEquals(5.5f + 5.22f + (0.16f * (120 - 61)) , precoDAO.calcularPreco(120), 0.001f);
		//121 ~ 180
		Assert.assertEquals(5.5f + 5.22f + 9.44f + (0.14f * (121 - 121)) , precoDAO.calcularPreco(121), 0.001f);
		Assert.assertEquals(5.5f + 5.22f + 9.44f + (0.14f * (151 - 121)) , precoDAO.calcularPreco(151), 0.001f);
		Assert.assertEquals(5.5f + 5.22f + 9.44f + (0.14f * (180 - 121)) , precoDAO.calcularPreco(180), 0.001f);
		//181 ~ ...
		Assert.assertEquals(5.5f + 5.22f + 9.44f + 8.85f + (0.1f * (181 - 181)) , precoDAO.calcularPreco(181), 0.001f);
		Assert.assertEquals(5.5f + 5.22f + 9.44f + 8.85f + (0.1f * (300 - 181)) , precoDAO.calcularPreco(300), 0.001f);
		Assert.assertEquals(5.5f + 5.22f + 9.44f + 8.85f + (0.1f * (900 - 181)) , precoDAO.calcularPreco(900), 0.001f);
	}
	
	@Test
	public void cadastrarPrecoTeste() {
		Preco novoPreco = new Preco(false, 260, 0, 0.3335f);
		Assert.assertTrue(precoDAO.cadastrarPreco(novoPreco));
		List<Preco> lista = precoDAO.listarPrecos();
		Assert.assertTrue(lista.contains(novoPreco));
		for(Preco preco: listaPreco) {
			Assert.assertFalse(precoDAO.cadastrarPreco(preco));
		}
	}
	
	@Test
	public void precoExisteTeste() {
		Preco novoPreco = new Preco(false, 260, 0, 0.3335f);
		Assert.assertFalse(precoDAO.precoExiste(novoPreco));
		for(Preco preco: listaPreco) {
			Assert.assertTrue(precoDAO.precoExiste(preco));
		}		
	}
	
	@Test
	public void listarPrecosTeste() {
		List<Preco> lista = precoDAO.listarPrecos();
		Assert.assertTrue(lista.size()==listaPreco.size());
		
		for(Preco preco: lista) {
			Assert.assertTrue(listaPreco.contains(preco));
		}		
	}
	
	@Test
	public void editarPrecoTeste() {
		Preco novoPreco = new Preco(false, 260, 0, 0.3335f);
		Assert.assertFalse(precoDAO.editarPreco(novoPreco));
		for(Preco preco: listaPreco) {
			novoPreco.setDuracaoInicial(preco.getDuracaoInicial());
			novoPreco.setDuracaoFinal(preco.getDuracaoFinal());			
			Assert.assertTrue(precoDAO.editarPreco(novoPreco));
			Assert.assertTrue(precoDAO.precoExiste(novoPreco));
		}
	}
	
	@Test
	public void excluirPrecoTeste() {
		Preco novoPreco = new Preco(false, 260, 0, 0.3335f);
		Assert.assertFalse(precoDAO.excluirPreco(novoPreco));
		for(Preco preco: listaPreco) {
			Assert.assertTrue(precoDAO.excluirPreco(preco));
			Assert.assertFalse(precoDAO.precoExiste(preco));
		}
		List<Preco> lista = precoDAO.listarPrecos();
		Assert.assertTrue(lista.isEmpty());
	}

}
