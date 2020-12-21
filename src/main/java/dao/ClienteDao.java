package dao;

import java.util.List;

import entidade.Cliente;

public interface ClienteDao {

	public boolean inserirCliente (Cliente cliente);
	public boolean alterarCliente (Cliente cliente);
	public boolean removerCliente (Cliente cliente);
	public Cliente pesquisarCliente(String cpf);
	public List<Cliente> pesquisarClientes(Cliente cliente);
	public List<Cliente> listarCliente();

}