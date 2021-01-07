package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ClienteDAOImplementacao;
import entidade.Cliente;
import entidade.Contato;

@ManagedBean(name = "ClienteBean")
@RequestScoped
public class ClienteBean {

	private Cliente cliente;
	private Contato contato;
	private ClienteDAOImplementacao clienteDao;
	private List<Cliente> listarCliente;

	public ClienteBean() {
		this.cliente = new Cliente();
		this.contato = new Contato();
		this.clienteDao = new ClienteDAOImplementacao();
		this.listarCliente = new ArrayList<Cliente>();
	}

//metodos
	public void adicionar() {
		this.clienteDao.inserirCliente(cliente);
	}

	public void pesquisar() {
		this.listarCliente = clienteDao.pesquisarClientes(this.cliente);
	}

	public void editar() {
		this.clienteDao.alterarCliente(this.cliente);
	}

	public void remover() {
		this.clienteDao.removerCliente(this.cliente);
	}
	
//get set 
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public ClienteDAOImplementacao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDAOImplementacao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public List<Cliente> getListarCliente() {
		return listarCliente;
	}

	public void setListarCliente(List<Cliente> listarCliente) {
		this.listarCliente = listarCliente;
	}
}
