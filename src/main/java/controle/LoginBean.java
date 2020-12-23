package controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import dao.UsuarioDAOImplementacao;
import dao.UsuarioDao;
import entidade.Usuario;


@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	private String usuarioTela;
	private String senhaTela;

	private UsuarioDao usuarioDao;

	public LoginBean() {
		this.usuarioDao = new UsuarioDAOImplementacao();
	}

    public void loginTeste() {
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(usuarioTela != null && usuarioTela.equals("admin") && senhaTela != null && senhaTela.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", usuarioTela);
            System.out.println("pricipal.xhtml");
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
    }
    
	public String logar() {

		
		FacesMessage message = null;
		boolean logado = false;

		Usuario usuarioPesquisa = new Usuario();
		usuarioPesquisa.setUsuario(this.usuarioTela);// rescebe usuário da tela

		Usuario usuarioBanco = this.usuarioDao.pesquisarUsuario(this.usuarioTela);

		if (usuarioBanco != null) {
			Usuario usuarioBase = usuarioBanco;
			if (usuarioBase.getSenha().equals(this.senhaTela)) {
				return "pages/pricipal.xhtml";
			} else {
				logado = false;
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Errado", "Senha invalido");
			}
		} else {
			logado = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Errado", "Usuário Não Cadastrado");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		PrimeFaces.current().ajax().addCallbackParam("Logado", logado);

		return "";

	}

	public String getusuarioTela() {
		return usuarioTela;
	}

	public void setusuarioTela(String usuarioTela) {
		this.usuarioTela = usuarioTela;
	}

	public String getSenhaTela() {
		return senhaTela;
	}

	public void setSenhaTela(String senhaTela) {
		this.senhaTela = senhaTela;
	}

}
