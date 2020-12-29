package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ClienteDAOImplementacao;
import entidade.Cliente;
import entidade.Contato;

@ManagedBean(name = "ClienteBean")
@RequestScoped
public class ClienteBean {

	private Cliente cliente = new Cliente();
	private Contato contato = new Contato();
	private ClienteDAOImplementacao clienteDao = new ClienteDAOImplementacao();

	public void adicionar() {
		this.clienteDao.inserirCliente(cliente);
	}

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

}
