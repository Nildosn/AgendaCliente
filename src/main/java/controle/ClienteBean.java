package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entidade.Cliente;
import fachada.Fachada;

@ManagedBean(name = "ClienteBean")
@RequestScoped
public class ClienteBean {
	
	private Cliente cliente;
	private Fachada fachada;
	private List<Cliente> listaPaciente;
	
	public ClienteBean() {
		this.fachada = new Fachada();
		this.cliente = new Cliente();
		this.listaPaciente = new ArrayList<Cliente>();
	}
	
	public void salvar() {
		//salvar ...
		
		if (this.fachada.inserirCliente(cliente)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso!", "Paciente cadastrado!"));
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro!", "Erro no cadastro!"));
		}

	}
	
	public void pesquisar() {
		this.listaPaciente = fachada.pesquisarCliente(this.cliente);
				                     
	}

	public Cliente getPaciente() {
		return cliente;
	}

	public void setPaciente(Cliente paciente) {
		this.cliente = paciente;
	}

	public List<Cliente> getListaPaciente() {
		return listaPaciente;
	}

	public void setListaPaciente(List<Cliente> listaPaciente) {
		this.listaPaciente = listaPaciente;
	}
	

}
