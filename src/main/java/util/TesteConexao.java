package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Cliente;
import entidade.Contato;
import entidade.Login;

public class TesteConexao {

	public static void main(String[] args) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction t = ent.getTransaction();
		t.begin();

		Login log = new Login();
		log.setUsuario("admin");
		log.setSenha("admin");
		
		ent.persist(log);
		
		Contato cont = new Contato();
		cont.setEmail("teste@teste.com");
		cont.setTelefone("(81) 98877-6655");

		ent.persist(cont);
		
		Cliente c = new Cliente(); 
		c.setNome("Testador");
		c.setCpf("789.789.789-01");
		c.setIdade(99);
		c.setSexo("Masculino");
		c.setInteresses("Compara um Carro");
		c.setContato(cont);
				
		ent.persist(c);

		
		t.commit();
		ent.close();

	}

}
