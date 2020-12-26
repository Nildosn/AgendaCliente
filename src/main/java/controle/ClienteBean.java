package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidade.Cliente;
import entidade.Contato;

@ManagedBean(name = "ClienteBean")
@SessionScoped
public class ClienteBean {
	
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ArrayList<>();
	private Contato contato = new Contato();
	private List<Contato> contatos = new ArrayList<>();

	public void adicionar() {
		
		clientes.add(cliente);
		cliente = new Cliente(); 
		contatos.add(contato);
		contato = new Contato(); 
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

}
