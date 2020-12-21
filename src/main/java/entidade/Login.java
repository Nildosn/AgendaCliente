package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "LOGIN")
public class Login {
	@Id
	@Column (name = "USUARIO", nullable = false)
	private String usuario;
	@Column (name = "SENHA", nullable = false)
	private String senha;
//get set
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
