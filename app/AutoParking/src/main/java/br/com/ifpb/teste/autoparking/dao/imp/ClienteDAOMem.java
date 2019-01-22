package br.com.ifpb.teste.autoparking.dao.imp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import br.com.ifpb.teste.autoparking.dao.ClienteDAO;
import br.com.ifpb.teste.autoparking.model.Cliente;

public class ClienteDAOMem implements ClienteDAO{
	private HashSet<Cliente> clientes = null;
	
	public boolean clienteExiste(Cliente cliente) {
		return clientes.contains(cliente);
	}
	
	public ClienteDAOMem() {
		clientes = new HashSet<Cliente>();
	}
	
	public boolean cadastrarCliente(Cliente cliente) {
		if(clienteExiste(cliente))
			return false;
		clientes.add(cliente);
		return true;
	}
	
	public boolean editarCliente(Cliente cliente) {
		if (! excluirCliente(cliente))
			return false;
		cadastrarCliente(cliente);
		return true;
	}
	
	public boolean excluirCliente(Cliente cliente) {
		if (!clientes.contains(cliente))
			return false;
		return clientes.remove(cliente);
	}
	
	public Cliente buscarCliente(String cpf) {
		ArrayList<Cliente> tmpClientes = new ArrayList<Cliente>(clientes);
		for(Cliente cliente: tmpClientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}
	
	public List<Cliente> buscarClientes(String nome){
		ArrayList<Cliente> tmpClientes = new ArrayList<Cliente>(clientes);
		ArrayList<Cliente> rspClientes = new ArrayList<Cliente>();
		for(Cliente cliente: tmpClientes) {
			if (cliente.getNome().contains(nome)) {
				rspClientes.add(cliente);
			}
		}
		return rspClientes;
	}
	
	public List<Cliente> listarClientes(){
		ArrayList<Cliente> tmpClientes = new ArrayList<Cliente>(clientes);		
		return tmpClientes;
	}
}
