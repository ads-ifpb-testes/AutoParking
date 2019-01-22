package br.com.ifpb.teste.auto_parking;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.ifpb.teste.autoparking.dao.imp.VeiculoDAOMem;
import br.com.ifpb.teste.autoparking.model.Veiculo;

public class VeiculoDAOMemTeste {
	
	private static ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
	private VeiculoDAOMem veiculoDAO = null;
	
	@BeforeClass
	public static void criarVeiculos() {
		listaVeiculos.add(new Veiculo("858.209.873-14","MKI-5381","Jeep","Grand Cherokee SRT8 6.1 V8 16V 432cv Aut","Dourado",2010));
		listaVeiculos.add(new Veiculo("431.201.150-88","JJK-1373","Land Rover","Defender 90 TDI SW Diesel","Laranja",2015));
		listaVeiculos.add(new Veiculo("322.258.588-10","HRL-8233","Lexus","NX-200t F-Sport 2.0 16v 238cv Aut.","Dourado",2011));
		listaVeiculos.add(new Veiculo("599.837.460-69","NBB-4738","Volvo","V70 R 2.5 300cv AWD Mec.","Branco",2004));
		listaVeiculos.add(new Veiculo("431.201.150-88","JOE-8330","TAC","Stark 2.3 4WD 127cv TDI Diesel 3p","Preto",2010));
		listaVeiculos.add(new Veiculo("858.209.873-14","EFH-9373","Honda","Civic Sedan LX 1.6 16V Mec. 4p","Laranja",1997));
	}
	
	@Before
	public void inicioTeste() {
		veiculoDAO = new VeiculoDAOMem();
		for(Veiculo veiculo: listaVeiculos) {
			veiculoDAO.cadastrarVeiculo(veiculo);
		}
	}
	
	@After
	public void finalTeste() {
		veiculoDAO = null;
	}
	
	@Test
	public void cadastrarVeiculoTest() {
		Veiculo novoVeiculo = new Veiculo("858.209.873-14","MQK-0295","Kia Motors","Besta EST Full 2.7 Diesel (10/12lug.)","Verde",2008);
		Assert.assertTrue(veiculoDAO.cadastrarVeiculo(novoVeiculo));
		List<Veiculo> lista = veiculoDAO.listarVeiculos();
		
		Assert.assertTrue(lista.contains(novoVeiculo));
		
		Assert.assertFalse(veiculoDAO.cadastrarVeiculo(novoVeiculo));
		
		for(Veiculo veiculo: listaVeiculos) {
			Assert.assertTrue(lista.contains(veiculo));
		}
	}
	
	@Test
	public void buscarVeiculoTeste() {
		
		Assert.assertNull(veiculoDAO.buscarVeiculo("XXX-0000"));
		for(Veiculo veiculo: listaVeiculos) {
			Assert.assertEquals(veiculo, veiculoDAO.buscarVeiculo(veiculo.getPlaca()));
		}
		
		List<Veiculo> lista = null;
		for(Veiculo aVeiculo: listaVeiculos) {
			lista = veiculoDAO.buscarVeiculos(aVeiculo.getCpfProprietario());
			for(Veiculo bVeiculo: lista) {
				Assert.assertEquals(aVeiculo.getCpfProprietario(),bVeiculo.getCpfProprietario());
			}
		}		
	}
	
	@Test
	public void editarVeiculoTeste() {
		Veiculo novoVeiculo = new Veiculo("858.209.873-14","MQK-0295","Kia Motors","Besta EST Full 2.7 Diesel (10/12lug.)","Verde",2008);
		Assert.assertFalse(veiculoDAO.editarVeiculo(novoVeiculo));
		
		for(Veiculo veiculo: listaVeiculos) {
			novoVeiculo.setPlaca(veiculo.getPlaca());
			Assert.assertTrue(veiculoDAO.editarVeiculo(novoVeiculo));
			Veiculo editado = veiculoDAO.buscarVeiculo(veiculo.getPlaca()); 
			
			Assert.assertEquals(novoVeiculo.getCor(),editado.getCor());
			
			Assert.assertEquals(novoVeiculo.getCpfProprietario(),editado.getCpfProprietario());
			
			Assert.assertEquals(novoVeiculo.getMarca(),editado.getMarca());
			
			Assert.assertEquals(novoVeiculo.getModelo(),editado.getModelo());
			
			Assert.assertEquals(novoVeiculo.getCor(),editado.getCor());
			
			Assert.assertTrue(novoVeiculo.getAno()==editado.getAno());
		}		
	}
	
	@Test
	public void excluirVeiculoTeste() {
		List<Veiculo> veiculos = null;
		for(Veiculo veiculo: listaVeiculos) {
			Assert.assertTrue(veiculoDAO.VeiculoExiste(veiculo));
			Assert.assertTrue(veiculoDAO.excluirVeiculo(veiculo));
			veiculos = veiculoDAO.listarVeiculos();
			Assert.assertFalse(veiculos.contains(veiculo));
			Assert.assertFalse(veiculoDAO.VeiculoExiste(veiculo));
			Assert.assertFalse(veiculoDAO.excluirVeiculo(veiculo));
		}
		Assert.assertTrue(veiculos.isEmpty());
	}

}
