package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Cliente;
import util.JpaUtil;

public class ClienteDAOImplementacao implements ClienteDao {

	@Override
	public boolean inserirCliente(Cliente cliente) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		ent.merge(cliente);

		tx.commit();
		ent.close();

		return true;
	}

	@Override
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

	@Override
	public boolean removerCliente(Cliente cliente) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		Cliente existe = ent.find(Cliente.class, cliente.getIdCliente());

		tx.begin();

		if (existe != null) {
			ent.remove(existe);
			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Cliente pesquisarCliente(String cpf) {
		String sql = "from Profissional p where p.cpf = ?";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);
		query.setParameter(1, cpf);

		List<Cliente> lista = query.getResultList();

		ent.close();

		if (lista != null && lista.size() > 0) {
			return lista.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Cliente> pesquisarClientes(Cliente cliente) {
		String sql = "from Profissional p where 1=1 " + montarWhere(cliente);

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);

		List<Cliente> listaClientes = query.getResultList();

		ent.close();

		return listaClientes;
	}

	// String montarWhere
	private String montarWhere(Cliente cliente) {
		String where = " ";

		if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
			where += " and p.nome LIKE '%" + cliente.getNome() + "%'";
		}
		if (cliente.getCpf() != null && !cliente.getCpf().isEmpty()) {
			where += " and p.cpf = '" + cliente.getCpf() + "'";
		}
		if (cliente.getIdCliente() > 0) {
			where += " and p.ID_CLIENTE = " + cliente.getIdCliente();
		}

		return where;
	}

	@Override
	public List<Cliente> listarCliente() {

		String sql = "from Profissional p";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);

		List<Cliente> listaCliente = query.getResultList();

		ent.close();

		return listaCliente;
	}

}
