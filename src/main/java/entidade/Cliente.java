package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
	@Id
	@Column(name = "ID_CLIENTE", nullable = false)
	@GeneratedValue(generator = "S_ID_CLIENTE")
	@SequenceGenerator(name = "S_ID_CLIENTE", sequenceName = "S_ID_CLIENTE", allocationSize = 1)
	private int idCliente;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "SEXO", nullable = false)
	private String sexo;
	@Column(name = "INTERESSES", nullable = false)
	private String interesses;
	@Column(name = "CPF", nullable = false)
	private String cpf ;
	@Column(name = "IDADE", nullable = false)
	private int idade;

	@ManyToOne
	@JoinColumn(name = "ID_CONTATO", referencedColumnName = "ID_CONTATO", nullable = false)
	private Contato contato;
	
	
//get set 	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getInteresses() {
		return interesses;
	}

	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
}
