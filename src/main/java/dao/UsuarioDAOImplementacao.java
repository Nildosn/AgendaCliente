package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Usuario;
import util.JpaUtil;

public class UsuarioDAOImplementacao implements UsuarioDao{

	@Override
	public boolean inserirUsuario(Usuario usuario) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		ent.merge(usuario);

		tx.commit();
		ent.close();

		return true;
	}

	@Override
	public boolean alterarUsuario(Usuario usuario) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		Usuario existe = ent.find(Usuario.class, usuario.getUsuario());

		if (existe != null) {
			existe.setUsuario(usuario.getUsuario());
			existe.setSenha(usuario.getSenha());


			ent.merge(usuario);

			tx.commit();
			ent.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removerUsuario(Usuario usuario) {
			EntityManager ent = JpaUtil.getEntityManager();
			EntityTransaction tx = ent.getTransaction();

			Usuario existe = ent.find(Usuario.class, usuario.getUsuario());

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
	public Usuario pesquisarUsuario(String usuario) {
		String sql = "from Usuario u where u.usuario = ?";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);
		query.setParameter(1, usuario);

		List<Usuario> lista = query.getResultList();

		ent.close();

		if (lista != null && lista.size() > 0) {
			return lista.get(0);
		} else {
			return null;
		}
	}
	// String montarWhere
	private String montarWhere(Usuario usuario) {
		String where = " ";
		
		if (usuario.getUsuario() !=null && !usuario.getUsuario().isEmpty()) {
			where = where + "and u.usuario LIKE'%" + usuario.getUsuario() +"%'";
		}
		if(usuario.getSenha() !=null && !usuario.getSenha().isEmpty()){
			where = where + "and u.senha LIKE'%" + usuario.getUsuario() +"%'";
		}
		
		return where;
	}
}
