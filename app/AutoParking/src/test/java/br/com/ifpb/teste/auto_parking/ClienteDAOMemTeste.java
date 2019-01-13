package br.com.ifpb.teste.auto_parking;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.ifpb.teste.auto_parking.dao.imp.ClienteDAOMem;
import br.com.ifpb.teste.auto_parking.model.Cliente;

public class ClienteDAOMemTeste {
	
	private static ArrayList<Cliente> listaNomes = new ArrayList<Cliente>();
	private ClienteDAOMem clienteDAO = null;
	
	
	@BeforeClass
	public static void criarClientes(){
		listaNomes.add(new Cliente("Bruno Raimundo Isaac da Silva", "858.209.873-14"));
		listaNomes.add(new Cliente("Esther Luana Simone dos Santos", "431.201.150-88"));
		listaNomes.add(new Cliente("Fábio Enzo Giovanni das Neves", "322.258.588-10"));
		listaNomes.add(new Cliente("Mariana Elisa Stefany das Neves", "599.837.460-69"));		
	}	
	
	@Before
	public void inicioTeste() {
		clienteDAO = new ClienteDAOMem();
		for(Cliente cliente: listaNomes) {
			clienteDAO.cadastrarCliente(cliente);			
		}		
	}
	
	@After
	public void finalTeste() {
		clienteDAO = null;		
	}
	
	
	@Test
	public void cadastrarClienteTeste() {
		Cliente novoCliente = new Cliente("João das Couves", "000.000.000-00");
		
		Assert.assertTrue(clienteDAO.cadastrarCliente(novoCliente));
		
		List<Cliente> listaClientes = clienteDAO.listarClientes();
		
		Assert.assertTrue(listaClientes.contains(novoCliente));
		
		Assert.assertFalse(clienteDAO.cadastrarCliente(novoCliente));
	}
	
	@Test
	public void buscarClienteTeste() {	
		for(Cliente cliente: listaNomes){
			Assert.assertEquals(cliente ,clienteDAO.buscarCliente(cliente.getCpf()));			
		}
	}
	
	@Test
	public void editarClienteTeste() {
		
		Cliente novoCliente = new Cliente("João das Couves","000.000.000-00");
		Assert.assertFalse(clienteDAO.editarCliente(novoCliente));
		
		for(Cliente cliente: listaNomes) {
			novoCliente.setCpf(cliente.getCpf());
			Assert.assertTrue(clienteDAO.editarCliente(novoCliente));
			
			Assert.assertEquals("João das Couves", clienteDAO.buscarCliente(cliente.getCpf()).getNome());
			
		}		
	}
	
	@Test
	public void excluirClientTeste() {
		List<Cliente> clientes = null;		
		for (Cliente cliente : listaNomes) {			
			Assert.assertTrue(clienteDAO.clienteExiste(cliente));
			Assert.assertTrue(clienteDAO.excluirCliente(cliente));
			clientes = clienteDAO.listarClientes();
			Assert.assertFalse(clientes.contains(cliente));
			Assert.assertFalse(clienteDAO.clienteExiste(cliente));			
		}
		
		Assert.assertTrue(clientes.isEmpty());		 
	}

}
