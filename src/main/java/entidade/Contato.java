package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CONTATO")
public class Contato {
//atributos
	@Id
	@Column(name = "ID_CONTATO", nullable = false)
	@GeneratedValue(generator = "S_ID_CONTATO")
	@SequenceGenerator(name = "S_ID_CONTATO", sequenceName = "S_ID_CONTATO", allocationSize = 1)
	private int idContato;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "TELEFONE", nullable = false)
	private String telefone;
	
	@OneToOne
	@Column(name = "ID_CLIENTE")
	private Cliente cliente;

//get set				
	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
