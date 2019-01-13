package br.com.ifpb.teste.auto_parking.dao.imp;

import java.util.HashSet;
import java.util.List;

import br.com.ifpb.teste.auto_parking.dao.ClienteDAO;
import br.com.ifpb.teste.auto_parking.model.Cliente;

public class ClienteDAOMem implements ClienteDAO{
	private HashSet<Cliente> clientes = null;
	
	public ClienteDAOMem() {
		clientes = new HashSet<Cliente>();
	}
	
	public void cadastrarCliente(Cliente cliente) {
				
	}
	
	public boolean editarCliente(Cliente cliente) {
		return false;
	}
	
	public boolean excluirCliente(Cliente cliente) {
		return false;
	}
	
	public Cliente buscarCliente(String cpf) {
		return null;
	}
	
	public List<Cliente> buscarClientes(String nome){
		return null;
	}
	
	public List<Cliente> listarClientes(){
		return null;
	}
}
