package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.ClienteDAOImplementacao;
import entidade.Cliente;

@ManagedBean(name = "ClienteBean")
@RequestScoped
public class ClienteBean {

	private Cliente cliente;
	private ClienteDAOImplementacao clienteDao;

	public ClienteBean() {
		this.cliente = new Cliente();
		this.clienteDao = new ClienteDAOImplementacao();
	}

	public void cadastrar() {

		if (this.clienteDao.inserirCliente(cliente)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Paciente cadastrado!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro no cadastro!"));
		}

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDAOImplementacao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDAOImplementacao clienteDao) {
		this.clienteDao = clienteDao;
	}

	
	

}
