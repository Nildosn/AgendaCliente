package dao;

import entidade.Usuario;

public interface UsuarioDao {
	public boolean inserirUsuario (Usuario usuario);
	public boolean alterarUsuario (Usuario usuario);
	public boolean removerUsuario (Usuario usuario);
	public Usuario pesquisarUsuario(String usuario);
}
