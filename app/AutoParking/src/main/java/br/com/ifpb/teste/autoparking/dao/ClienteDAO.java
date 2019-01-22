package br.com.ifpb.teste.autoparking.dao;

import java.util.List;

import br.com.ifpb.teste.autoparking.model.Cliente;

public interface ClienteDAO {	
	boolean clienteExiste(Cliente cliente);
	boolean cadastrarCliente(Cliente cliente);
	boolean editarCliente(Cliente cliente);
	boolean excluirCliente(Cliente cliente);
	Cliente buscarCliente(String cpf);
	List<Cliente> buscarClientes(String nome);
	List<Cliente> listarClientes();
}
