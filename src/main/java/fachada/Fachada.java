package fachada;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.ClienteDAOImplementacao;
import dao.ClienteDao;
import entidade.Cliente;
import util.JpaUtil;

public class Fachada {

	private ClienteDao clienteDao;

	public Fachada() {
		this.clienteDao = new ClienteDAOImplementacao();
	}

//Inserir 
	public boolean inserirCliente(Cliente cliente) {
		Cliente existeClinte = this.clienteDao.pesquisarCliente(cliente.getCpf());

		if (existeClinte != null) {
			return false;
		} else {
			return this.clienteDao.inserirCliente(cliente);
		}
	}

//Alterar
	public boolean alterarCliente(Cliente cliente) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Cliente existe = ent.find(Cliente.class, cliente.getIdCliente());

		if (existe != null) {
			existe.setNome(cliente.getNome());
			existe.setCpf(cliente.getCpf());
			existe.setIdade(cliente.getIdade());
			existe.setSexo(cliente.getSexo());
			existe.setContato(cliente.getContato());
			existe.setInteresses(cliente.getInteresses());

			ent.merge(cliente);

			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}
	}

//Remover
	public boolean removerCliente(Cliente cliente) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Cliente existe = ent.find(Cliente.class, cliente.getIdCliente());

		if (existe != null) {

			ent.remove(existe);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}
	}

// Pesquisar
	public Cliente pesquisarCliente(String cpf) {
		return this.clienteDao.pesquisarCliente(cpf);
	}

	public List<Cliente> pesquisarCliente(Cliente cliente) {
		return this.clienteDao.pesquisarClientes(cliente);
	}

	public List<Cliente> listarCliente() {
		return this.clienteDao.listarCliente();
	}

//String montarWhere
		private String montarWhere(Cliente cliente) {
			String where = "1";

			if (cliente.getCpf() != null && !cliente.getNome().isEmpty()) {
				where += "and p.cpf = " + cliente.getCpf() + "'";
			} else {
				if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
					where += "and p.nome like '%" + cliente.getNome() + "%'";
				}
				if (cliente.getIdade() > 0) {
					where += "and p.idade = " + cliente.getIdade();
				}
				if (cliente.getSexo() != null && !cliente.getSexo().isEmpty()) {
					where += "and p.sexo like '%" + cliente.getSexo() + "'";
				}
			}
			return null;
		}
}
